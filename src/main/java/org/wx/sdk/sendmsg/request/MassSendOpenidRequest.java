package org.wx.sdk.sendmsg.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.sendmsg.response.MassSendRespone;

/**
 * <p>高级群发接口请求对象,根据OpenID列表群发【订阅号不可用，服务号认证后可用】
 * <p>1、对于认证订阅号，群发接口每天可成功调用1次，此次群发可选择发送给全部用户或某个分组；
 * <p>2、对于认证服务号虽然开发者使用高级群发接口的每日调用限制为100次，但是用户每月只能接收4条，
 * <p>  无论在公众平台网站上，还是使用接口群发，用户每月只能接收4条群发消息，多于4条的群发将对该用户发送失败；
 * <p>3、具备微信支付权限的公众号，在使用群发接口上传、群发图文消息类型时，可使用a标签加入外链；
 * <p>4、开发者可以使用预览接口校对消息样式和排版，通过预览接口可发送编辑好的消息给指定用户校验效果。
 * @author Rocye
 * @version 2016-09-23
 */
public class MassSendOpenidRequest implements Request<MassSendRespone> {
    
	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    private List<String> touser;        //用于设定图文消息的接收者
    private String msgtype;             //消息类型，text,image,voice,video,music,news
    
    /**
     * 构造器
     * @param touser    接收者OpenId数组
     * @param msgtype   群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard
     */
    public MassSendOpenidRequest(List<String> touser, String msgtype) {
        this.touser = touser;
        this.msgtype = msgtype;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<MassSendRespone> getResponseClass(){
        return MassSendRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){  
        wxHashMap.put("touser", this.touser);
        wxHashMap.put("msgtype", this.msgtype);
        return wxHashMap;
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

    public List<String> getTouser() {
        return touser;
    }
    public void setTouser(List<String> touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }
    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
    
}
