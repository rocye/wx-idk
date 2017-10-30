package org.wx.sdk.mutikf.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.mutikf.response.KfMsgrecordListRespone;
import org.wx.sdk.mutikf.response.KfSessionCreateRespone;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>获取聊天记录请求对象
 * <p>此接口返回的聊天记录中，对于图片、语音、视频，分别展示成文本格式的[image]、[voice]、[video]。
 * @author Rocye
 * @version 2017.10.27
 */
public class KfMsgrecordListRequest implements Request<KfMsgrecordListRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
	/** 起始时间，unix时间戳 */
	private Long starttime;
	/** 结束时间，unix时间戳，每次查询时段不能超过24小时 */
	private Long endtime;
	/** 消息id顺序从小到大，从1开始 */
	private Integer msgid;
	/** 每次获取条数，最多10000条 */
    private Integer number;

	/**
	 * 构造器
	 * @param starttime 起始时间，unix时间戳
	 * @param endtime	结束时间，unix时间戳，每次查询时段不能超过24小时
	 * @param msgid		消息id顺序从小到大，从1开始
	 * @param number	每次获取条数，最多10000条
	 */
	public KfMsgrecordListRequest(Long starttime, Long endtime, Integer msgid, Integer number) {
		this.starttime = starttime;
		this.endtime = endtime;
		this.msgid = msgid;
		this.number = number;
	}

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/customservice/msgrecord/getmsglist?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<KfMsgrecordListRespone> getResponseClass(){
        return KfMsgrecordListRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("starttime", this.starttime);
        wxHashMap.put("endtime", this.endtime);
        wxHashMap.put("msgid", this.msgid);
        wxHashMap.put("number", this.number);
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

	public Long getStarttime() {
		return starttime;
	}
	public void setStarttime(Long starttime) {
		this.starttime = starttime;
	}

	public Long getEndtime() {
		return endtime;
	}
	public void setEndtime(Long endtime) {
		this.endtime = endtime;
	}

	public Integer getMsgid() {
		return msgid;
	}
	public void setMsgid(Integer msgid) {
		this.msgid = msgid;
	}

	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}

}
