package org.wx.sdk.sendmsg.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.sendmsg.response.MassSendDeleteRespone;

/**
 * 删除群发接口请求对象【订阅号与服务号认证后均可用】
 * 1、只有已经发送成功的消息才能删除
 * 2、删除消息是将消息的图文详情页失效，已经收到的用户，还是能在其本地看到消息卡片。
 * 3、删除群发消息只能删除图文消息和视频消息，其他类型的消息一经发送，无法删除。
 * 4、如果多次群发发送的是一个图文消息，那么删除其中一次群发，就会删除掉这个图文消息也，导致所有群发都失效
 * @author Rocye
 * @version 2016-09-29
 */
public class MassSendDeleteRequest implements Request<MassSendDeleteRespone> {
    
	/** 调用接口凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 发送出去的消息ID */
    private Long msg_id;
    
    /**
     * 构造器
     * @param msgId   发送出去的消息ID
     */
    public MassSendDeleteRequest(Long msgId) {
        this.msg_id = msgId;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<MassSendDeleteRespone> getResponseClass(){
        return MassSendDeleteRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("msg_id", this.msg_id);
        return wxHashMap;
    }
    
    /**
     * 获取请求是否是Https
     */
    public boolean getUseHttps(){
        return true;
    }
    
    /**
     * 请求类型：1-普通Get 2-下载GET 3-普通POST 4-下载POST 5-无参上传   6-有参上传
     */
    public int getReqType(){
        return 3;
    }
    
    /**
     * 请求参数格式(kv,json,xml)
     */
    public String getParamFormat(){
        return "json";
    }
    
    /**
     * 设置AccessToken
     */
    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }

    public Long getMsg_id() {
        return msg_id;
    }
    public void setMsg_id(Long msgId) {
        msg_id = msgId;
    }

}
