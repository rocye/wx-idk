package org.wx.sdk.sendmsg.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.sendmsg.response.MassPreviewRespone;

/**
 * 预览接口请求对象【订阅号与服务号认证后均可用】
 * 开发者可通过该接口发送消息给指定用户，在手机端查看消息的样式和排版。
 * 为了满足第三方平台开发者的需求，在保留对openID预览能力的同时，
 * 增加了对指定微信号发送预览的能力，但该能力每日调用次数有限制（100次），请勿滥用。
 * @author Rocye
 * @version 2016-09-30
 */
public class MassPreviewRequest implements Request<MassPreviewRespone> {
    /** 微信公众平台唯一凭证 */
    private String accessToken; 
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 预览Openid */
    private String touser;
    /** 预览微信号 */
    private String towxname;
    /** 消息类型，text,image,voice,video,music,news */
    private String msgtype;
    
    /**
     * 构造器
     * @param touser    预览接收者OpenId
     * @param towxname  预览接收者微信号
     * @param msgtype   群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard
     */
    public MassPreviewRequest(String touser, String towxname, String msgtype) {
        this.touser = touser;
        this.towxname = towxname;
        this.msgtype = msgtype;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<MassPreviewRespone> getResponseClass(){
        return MassPreviewRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        if(this.touser != null){
            wxHashMap.put("touser", this.touser);
        }
        if(this.towxname != null){
            wxHashMap.put("towxname", this.towxname);
        }
        wxHashMap.put("msgtype", this.msgtype);
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

    public String getTouser() {
        return touser;
    }
    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }
    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getTowxname() {
        return towxname;
    }
    public void setTowxname(String towxname) {
        this.towxname = towxname;
    }
    
}
