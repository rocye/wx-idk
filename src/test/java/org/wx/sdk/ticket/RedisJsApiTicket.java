package org.wx.sdk.ticket;

import java.util.Arrays;
import java.util.Map;
import org.apache.log4j.Logger;
import org.wx.common.RedisConnectionFactory;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.WxConfig;
import org.wx.sdk.base.WxTicket;
import org.wx.sdk.base.request.JsApiTicketGetRequest;
import org.wx.sdk.base.response.JsApiTicketGetRespone;
import org.wx.sdk.token.RedisAccessToken;
import org.wx.sdk.common.WxMsgDigestUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import redis.clients.jedis.Jedis;

/**
 * <p>【默认例子实现类，不会生成到jar包去】
 * <p>微信公众号调用微信JS接口的临时票据Redis缓存实现（单例模式）
 * @author Rocye
 * @version 2017-02-21
 */
public class RedisJsApiTicket extends WxTicket{
    private final static Logger logger = Logger.getLogger(RedisJsApiTicket.class.getName());

    /**
     * 私用构造函数
     */
    private RedisJsApiTicket() {
    }
    /**
     * 私有静态类用于构建主类的单例对象
     * @author Rocye
     * @version 2017-02-21
     */
    private static class SingletonHolder {
    	private static RedisJsApiTicket instance = new RedisJsApiTicket();
    }
    /**
     * 得到主类的单例对象
     * @return 主类对象
     */
    public static RedisJsApiTicket getInstance(){
    	return SingletonHolder.instance;
    }

    /**
     * 获取微信Ticket
     * @author Rocye
     * @param appId		公众号AppId
     * @param appSecret	公众号AppSecret
     * @version 2017-02-21
     * @return 接口票据
     */
    public String getWxTicket(String appId, String appSecret) {
        Jedis jedis = null;
        try{
            jedis = RedisConnectionFactory.getJedisInstance();
            String jsonString = jedis.get("jsapi_ticket:" + appId);
            if(jsonString != null){
                Map<String, Object> ticketMap = JSON.parseObject(jsonString, new TypeReference<Map<String, Object>>(){});
                long nowTime = System.currentTimeMillis();
                if(nowTime < (Long.parseLong(ticketMap.get("time").toString())-5000)){
                	return ticketMap.get("ticket").toString();
                }
            }
            //获取新的Ticket
            Map<String, Object> ticketMap = refreshTicket(appId, appSecret);
            if(ticketMap != null){
            	jsonString = JSON.toJSONString(ticketMap);
                jedis.set("jsapi_ticket:" + appId, jsonString);
                return ticketMap.get("ticket").toString();
            }else{
            	return null;
            }
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("从Redis中取JsApiTicket时：" + e.toString());
            return null;
        }finally{
            jedis.close();
        }
    }
    
    /**
     * 刷新ticket
     * @author Rocye
     * @param appId		公众号AppId
     * @param appSecret	公众号AppSecret
     * @return 接口返回票据键值对
     * @version 2017-02-21
     */
    public Map<String, Object> refreshTicket(String appId, String appSecret) {
    	WxClient wxClient = new WxClient(new RedisAccessToken(appId, appSecret));
        JsApiTicketGetRequest jsApiTicketGetReq = new JsApiTicketGetRequest();
        JsApiTicketGetRespone jsApiTicketGetRes = wxClient.excute(jsApiTicketGetReq);
        if(jsApiTicketGetRes.getErrcode() == 0){
        	Map<String, Object> ticketMap = jsApiTicketGetRes.getResultMap();
        	ticketMap.put("time", System.currentTimeMillis() + jsApiTicketGetRes.getExpires_in() * 1000);      //当前服务器时间 + 有效时间 = 过期时间
        	ticketMap.remove("errcode");
            ticketMap.remove("errmsg");
        	return ticketMap;
        }else{
        	logger.error("获取新的Ticket时：" + jsApiTicketGetRes.getBody());
        	return null;
        }
    }

    /**
     * 获取签名signature的配置接口
     * @author Rocye
     * @param appId		公众号AppId
     * @param appSecret	公众号AppSecret
     * @param url		需要JsApi的链接
     * @version 2017-02-21
     * @return {@link WxConfig}
     */
    public WxConfig getWxConfig(String appId, String appSecret, String url) {
        String jsTicket = getWxTicket(appId, appSecret);
        if(jsTicket == null){
        	return null;
        }
        String nonce_str = create_nonce_str();          //随机串
        String timestamp = create_timestamp();          //时间串
        
        String[] ArrTmp = {"jsapi_ticket="+jsTicket, "noncestr="+nonce_str, "timestamp="+timestamp, "url="+url};
        Arrays.sort(ArrTmp);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ArrTmp.length; i++) {
            if(i > 0){
                sb.append("&");
            }
            sb.append(ArrTmp[i]);
        }
        String signature = WxMsgDigestUtil.getInstance().encipher(sb.toString());
        
        WxConfig wxConfig = new WxConfig(appId, timestamp, nonce_str, signature);
        return wxConfig;
    }

}
