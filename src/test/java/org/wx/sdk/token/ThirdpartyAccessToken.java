package org.wx.sdk.token;

import java.util.Map;
import org.apache.log4j.Logger;
import org.wx.common.RedisConnectionFactory;
import org.wx.sdk.base.WxToken;
import org.wx.sdk.base.request.HttpRequestTools;
import redis.clients.jedis.Jedis;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * <p>【默认例子实现类，不会生成到jar包去】
 * <p>微信接口调用凭证请求第三方接口实现
 * @author Rocye
 * @version 2016-11-24
 */
public class ThirdpartyAccessToken extends WxToken {
    /** 日志对象 */
    private final static Logger logger = Logger.getLogger(ThirdpartyAccessToken.class.getName());
    
    /** 第三方接口地址 */
    private String thirdApiUrl;
    
    /**
     * 构造方法
     * @param appId			公众号AppId
     * @param appSecret		公众号AppSecret
     * @param thirdApiUrl   第三方接口地址
     */
    public ThirdpartyAccessToken(String appId, String appSecret, String thirdApiUrl) {
        super(appId, appSecret);
        this.thirdApiUrl = thirdApiUrl;
    }
    
    /**
     * 构造方法
     * @param appId			公众号AppId
     * @param thirdApiUrl   第三方接口地址
     */
    public ThirdpartyAccessToken(String appId, String thirdApiUrl) {
        super(appId, null);
        this.thirdApiUrl = thirdApiUrl;
    }

    /**
     * 获取微信Token
     * @return Token数据键值对
     */
    public Map<String, Object> getWxToken() {
        Jedis jedis = null;
        try{
            jedis = RedisConnectionFactory.getJedisInstance();
            String jsonString = jedis.get("token:" + this.appId);
            if(jsonString == null){
                return getNewWxToken();
            }else{
                Map<String, Object> tokenMap = JSON.parseObject(jsonString, new TypeReference<Map<String, Object>>(){});
                long nowTime = System.currentTimeMillis();
                if(nowTime < (Long.parseLong(tokenMap.get("time").toString())-5000)){
                    return tokenMap;
                }else{
                    return getNewWxToken();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("从Redis中取AccessToken时：" + e.toString());
            return null;
        }finally{
			if(jedis != null){
				jedis.close();
			}
        }
    }

    /**
     * 保存微信Token
     * @param tokenMap 接口返回Token数据键值对
     */
    public void setWxToken(Map<String, Object> tokenMap) {
        Jedis jedis = null;
        try{
            jedis = RedisConnectionFactory.getJedisInstance();
            String jsonString = JSON.toJSONString(tokenMap);
            jedis.set("token:" + this.appId, jsonString);
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("往Redis中写AccessToken串时：" + e.toString());
        }finally{
			if(jedis != null){
				jedis.close();
			}
        }
    }
    
    /**
     * 重新通过第三方接口获取AccessToken
     * @return Token数据键值对
     */
    public Map<String, Object> getNewWxToken() {
        try{
            String jsonString = HttpRequestTools.getInstance().sendGet(this.thirdApiUrl, false);
            Map<String, Object> tokenMap = JSON.parseObject(jsonString, new TypeReference<Map<String, Object>>(){});
            long expiresIn = Long.parseLong(tokenMap.get("expires_in").toString());
            tokenMap.put("time", System.currentTimeMillis() + expiresIn*1000);      //当前服务器时间 + 有效时间 = 过期时间
            this.setWxToken(tokenMap);
            return tokenMap;
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("从第三方接口重新取AccessToken时：" + e.toString());
            return null;
        }
    }

    public String getThirdApiUrl() {
        return thirdApiUrl;
    }

    public void setThirdApiUrl(String thirdApiUrl) {
        this.thirdApiUrl = thirdApiUrl;
    }

}
