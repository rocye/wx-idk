package org.wx.sdk.card.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.card.respone.GetCardCardinfoRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>获取免费券数据请求对象
 * <p>支持开发者调用该接口拉取免费券（优惠券、团购券、折扣券、礼品券）在固定时间区间内的相关数据。
 * <p>特别注意：
 * <p>1.该接口目前仅支持拉取免费券（优惠券、团购券、折扣券、礼品券）的卡券相关数据，暂不支持特殊票券（电影票、会议门票、景区门票、飞机票）数据。
 * <p>2.查询时间区间需&lt;=62天，否则报错{"errcode:" 61501，errmsg: "date range error"}；
 * <p>3.传入时间格式需严格参照示例填写如”2015-06-15”，否则报错｛"errcode":"date format error"｝
 * <p>4.该接口只能拉取非当天的数据，不能拉取当天的卡券数据，否则报错。
 * @author Rocye
 * @version 2018.01.15
 */
public class GetCardCardinfoRequest implements Request<GetCardCardinfoRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 查询数据的起始时间 */
    private String begin_date;
	/** 查询数据的截至时间 */
	private String end_date;
	/** 卡券来源，0为公众平台创建的卡券数据 、1是API创建的卡券数据 */
	private Integer cond_source;
	/** 卡券ID。填写后，指定拉出该卡券的相关数据。 */
	private String card_id;

	/**
	 * 构造器
	 * @param beginDate		查询数据的起始时间
	 * @param endDate		查询数据的截至时间
	 * @param condSource    卡券来源，0为公众平台创建的卡券数据 、1是API创建的卡券数据
	 */
	public GetCardCardinfoRequest(String beginDate, String endDate, Integer condSource) {
		this.begin_date = beginDate;
		this.end_date = endDate;
		this.cond_source = condSource;
	}

	/**
	 * 构造器
	 * @param beginDate		查询数据的起始时间
	 * @param endDate		查询数据的截至时间
	 * @param condSource    卡券来源，0为公众平台创建的卡券数据 、1是API创建的卡券数据
	 * @param cardId    	卡券ID。填写后，指定拉出该卡券的相关数据。
	 */
	public GetCardCardinfoRequest(String beginDate, String endDate, Integer condSource, String cardId) {
		this.begin_date = beginDate;
		this.end_date = endDate;
		this.cond_source = condSource;
		this.card_id = cardId;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/datacube/getcardcardinfo?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<GetCardCardinfoRespone> getResponseClass(){
        return GetCardCardinfoRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("begin_date", this.begin_date);
		wxHashMap.put("end_date", this.end_date);
		wxHashMap.put("cond_source", this.cond_source);
		if(this.card_id != null){
			wxHashMap.put("card_id", this.card_id);
		}
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

	public Integer getCond_source() {
		return cond_source;
	}
	public void setCond_source(Integer cond_source) {
		this.cond_source = cond_source;
	}

	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
}
