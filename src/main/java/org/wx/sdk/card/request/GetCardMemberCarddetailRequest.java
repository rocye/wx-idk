package org.wx.sdk.card.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.card.respone.GetCardMemberCarddetailRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>拉取单张会员卡数据请求对象
 * <p>支持开发者调用该接口拉取API创建的会员卡数据情况。
 * @author Rocye
 * @version 2018.01.16
 */
public class GetCardMemberCarddetailRequest implements Request<GetCardMemberCarddetailRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 查询数据的起始时间 */
    private String begin_date;
	/** 查询数据的截至时间 */
	private String end_date;
	/** 卡券id */
	private String card_id;

	/**
	 * 构造器
	 * @param beginDate		查询数据的起始时间
	 * @param endDate		查询数据的截至时间
	 * @param cardId    	卡券id
	 */
	public GetCardMemberCarddetailRequest(String beginDate, String endDate, String cardId) {
		this.begin_date = beginDate;
		this.end_date = endDate;
		this.card_id = cardId;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/datacube/getcardmembercarddetail?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<GetCardMemberCarddetailRespone> getResponseClass(){
        return GetCardMemberCarddetailRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("begin_date", this.begin_date);
		wxHashMap.put("end_date", this.end_date);
		wxHashMap.put("card_id", this.card_id);
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

	public String getBegin_date() {
		return begin_date;
	}
	public void setBegin_date(String begin_date) {
		this.begin_date = begin_date;
	}

	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
}
