package org.wx.sdk.token;

import java.util.Map;
import org.apache.log4j.Logger;
import org.wx.common.RedisConnectionFactory;
import org.wx.sdk.base.WxToken;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import redis.clients.jedis.Jedis;

/**
 * <p>【默认例子实现类，不会生成到jar包去】
 * <p>微信接口调用凭证Redis实现
 * @author Rocye
 * @version 2016-04-05
 */
public class RedisAccessToken extends WxToken {
    /** 日志对象 */
    private final static Logger logger = Logger.getLogger(RedisAccessToken.class.getName());

    /**
     * 构造函数
     * @author Rocye
     * @param appId		公众号AppID
     * @param appSecret	公众号AppSecret
     */
    public RedisAccessToken(String appId, String appSecret) {
        super(appId, appSecret);
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
                return null;
            }else{
                Map<String, Object> tokenMap = JSON.parseObject(jsonString, new TypeReference<Map<String, Object>>(){});
                long nowTime = System.currentTimeMillis();
                if(nowTime < (Long.parseLong(tokenMap.get("time").toString())-5000)){
                    return tokenMap;
                }else{
                    return null;
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

}
