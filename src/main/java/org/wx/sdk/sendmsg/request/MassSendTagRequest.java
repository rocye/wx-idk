package org.wx.sdk.sendmsg.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.sendmsg.object.FilterObj;
import org.wx.sdk.sendmsg.response.MassSendRespone;

/**
 * <p>高级群发接口请求对象,根据标签进行群发【订阅号与服务号认证后均可用】
 * <p>1、对于认证订阅号，群发接口每天可成功调用1次，此次群发可选择发送给全部用户或某个标签；
 * <p>2、对于认证服务号虽然开发者使用高级群发接口的每日调用限制为100次，但是用户每月只能接收4条，无论在公众平台网站上，还是使用接口群发，用户每月只能接收4条群发消息，多于4条的群发将对该用户发送失败；
 * <p>3、开发者可以使用预览接口校对消息样式和排版，通过预览接口可发送编辑好的消息给指定用户校验效果；
 * <p>4、群发过程中，微信后台会自动进行图文消息原创校验，请提前设置好相关参数(send_ignore等)；
 * <p>5、开发者可以主动设置 clientmsgid 来避免重复推送。
 * <p>6、群发接口每分钟限制请求60次，超过限制的请求会被拒绝。
 * <p>7、图文消息正文中插入自己帐号和其他公众号已群发文章链接的能力。
 *
 * <p>群发图文消息的过程如下：
 * <p>1、首先，预先将图文消息中需要用到的图片，使用上传图文消息内图片接口，上传成功并获得图片 URL；
 * <p>2、上传图文消息素材，需要用到图片时，请使用上一步获取的图片 URL；
 * <p>3、使用对用户标签的群发，或对 OpenID 列表的群发，将图文消息群发出去，群发时微信会进行原创校验，并返回群发操作结果；
 * <p>4、在上述过程中，如果需要，还可以预览图文消息、查询群发状态，或删除已群发的消息等。
 * @author Rocye
 * @version 2017.10.20
 */
public class MassSendTagRequest implements Request<MassSendRespone> {
	/** 调用接口凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 用于设定图文消息的接收者 */
    private FilterObj filter;
    /** 消息类型，text,image,voice,video,music,news */
    private String msgtype;
    
    /**
     * 构造器
     * @param filter    接收者
     * @param msgtype   群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard
     */
    public MassSendTagRequest(FilterObj filter, String msgtype) {
        this.filter = filter;
        this.msgtype = msgtype;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token="+ this.accessToken;
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
        wxHashMap.put("filter", this.filter);
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

    public FilterObj getFilter() {
        return filter;
    }
    public void setFilter(FilterObj filter) {
        this.filter = filter;
    }

    public String getMsgtype() {
        return msgtype;
    }
    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
    
}
