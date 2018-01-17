package org.wx.sdk.card.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.card.object.BaseInfo;
import org.wx.sdk.card.respone.CardUpdateRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>更改卡券信息请求对象
 * <p>支持更新所有卡券类型的部分通用字段及特殊卡券（会员卡、飞机票、电影票、会议门票）中特定字段的信息。
 * <p>开发者注意事项：
 * <p>1.请开发者注意需要重新提审的字段，开发者调用更新接口时，若传入了提审字段则卡券需要重新进入审核状态；
 * <p>2.接口更新方式为覆盖更新：即开发者只需传入需要更改的字段，其他字段无需填入，否则可能导致卡券重新提审；
 * <p>3.若开发者置空某些字段，可直接在更新时传“”（空）；
 * <p>4.调用该接口后更改卡券信息后，请务必调用查看卡券详情接口验证是否已成功更改；
 * <p>5.未列出的字段不支持修改更新。
 * @author Rocye
 * @version 2017.12.29
 */
public class CardUpdateRequest implements Request<CardUpdateRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 卡券ID*/
    private String card_id;
	/** 卡券基础信息字段 */
    private BaseInfo base_info;

    /** 卡券类型。 团购券：groupon; 折扣券：discount; 礼品券：gift; 代金券：cash; 通用券：general_coupon; 会员卡：member_card;
	 * 景点门票：scenic_ticket; 电影票：movie_ticket; 飞机票：boarding_pass；会议门票：meeting_ticket; 汽车票：bus_ticket; */
    private String cardType;

    /** 积分清零规则，会员卡专用 */
    private String bonus_cleared;
	/** 积分规则， 会员卡专用 */
    private String bonus_rules;
	/** 储值说明， 会员卡专用 */
    private String balance_rules;
	/** 特权说明， 会员卡专用 */
    private String prerogative;
	/** 自定义会员信息类目，会员卡激活后显示， 会员卡专用 */
    private String custom_field1;
	/** 自定义会员信息类目，会员卡激活后显示， 会员卡专用 */
    private String custom_field2;
	/** 自定义会员信息类目，会员卡激活后显示， 会员卡专用 */
    private String custom_field3;
	/** 会员信息类目名称。FIELD_NAME_TYPE_LEVEL等级；FIELD_NAME_TYPE_COUPON优惠券；FIELD_NAME_TYPE_STAMP印花；
	 * FIELD_NAME_TYPE_DISCOUNT折扣；FIELD_NAME_TYPE_ACHIEVEMEN成就；FIELD_NAME_TYPE_MILEAGE里程。 */
    private String name_type;
	/** 点击类目跳转外链url */
    private String url;
	/** 自定义会员信息类目，会员卡激活后显示 */
    private String custom_cell1;
	/** 电影票详情 */
    private String detail;
	/** 起飞时间 */
    private Long departure_time;
	/** 降落时间 */
    private Long landing_time;
	/** 登机口。如发生登机口变更，建议商家实时调用该接口变更 */
    private String gate;
	/** 登机时间，只显示“时分”不显示日期，按Unix时间戳格式填写。如发生登机时间变更，建议商家实时调用该接口变更 */
    private Long boarding_time;
	/** 景区门票的导览图URL */
    private String guide_url;
	/** 会场导览图 */
    private String map_url;

    /**
     * 构造器
     * @param cardId  	卡券ID
     * @param baseInfo  卡券基础信息
	 * @param cardType  卡券类型，团购券：groupon; 折扣券：discount; 礼品券：gift; 代金券：cash; 通用券：general_coupon;
	 *                  会员卡：member_card; 景点门票：scenic_ticket; 电影票：movie_ticket; 飞机票：boarding_pass；
	 *                  会议门票：meeting_ticket; 汽车票：bus_ticket。
     */
    public CardUpdateRequest(String cardId, BaseInfo baseInfo, String cardType) {
        this.card_id = cardId;
        this.base_info = baseInfo;
        this.cardType = cardType;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/card/update?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<CardUpdateRespone> getResponseClass(){
        return CardUpdateRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("card_id", this.card_id);
		Map<String, Object> cardMap = new HashMap<String, Object>();
		cardMap.put("base_info", this.base_info);
		if(this.bonus_cleared != null){
			cardMap.put("bonus_cleared", this.bonus_cleared);
		}
		if(this.bonus_rules != null){
			cardMap.put("bonus_rules", this.bonus_rules);
		}
		if(this.balance_rules != null){
			cardMap.put("balance_rules", this.balance_rules);
		}
		if(this.prerogative != null){
			cardMap.put("prerogative", this.prerogative);
		}
		if(this.custom_field1 != null){
			cardMap.put("custom_field1", this.custom_field1);
		}
		if(this.custom_field2 != null){
			cardMap.put("custom_field2", this.custom_field2);
		}
		if(this.custom_field3 != null){
			cardMap.put("custom_field3", this.custom_field3);
		}
		if(this.name_type != null){
			cardMap.put("name_type", this.name_type);
		}
		if(this.url != null){
			cardMap.put("url", this.url);
		}
		if(this.custom_cell1 != null){
			cardMap.put("custom_cell1", this.custom_cell1);
		}
		if(this.detail != null){
			cardMap.put("detail", this.detail);
		}
		if(this.departure_time != null){
			cardMap.put("departure_time", this.departure_time);
		}
		if(this.landing_time != null){
			cardMap.put("landing_time", this.landing_time);
		}
		if(this.gate != null){
			cardMap.put("gate", this.gate);
		}
		if(this.boarding_time != null){
			cardMap.put("boarding_time", this.boarding_time);
		}
		if(this.guide_url != null){
			cardMap.put("guide_url", this.guide_url);
		}
		if(this.map_url != null){
			cardMap.put("map_url", this.map_url);
		}
		wxHashMap.put(this.cardType, cardMap);
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

	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public BaseInfo getBase_info() {
		return base_info;
	}
	public void setBase_info(BaseInfo base_info) {
		this.base_info = base_info;
	}

	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getBonus_cleared() {
		return bonus_cleared;
	}
	public void setBonus_cleared(String bonus_cleared) {
		this.bonus_cleared = bonus_cleared;
	}

	public String getBonus_rules() {
		return bonus_rules;
	}
	public void setBonus_rules(String bonus_rules) {
		this.bonus_rules = bonus_rules;
	}

	public String getBalance_rules() {
		return balance_rules;
	}
	public void setBalance_rules(String balance_rules) {
		this.balance_rules = balance_rules;
	}

	public String getPrerogative() {
		return prerogative;
	}
	public void setPrerogative(String prerogative) {
		this.prerogative = prerogative;
	}

	public String getCustom_field1() {
		return custom_field1;
	}
	public void setCustom_field1(String custom_field1) {
		this.custom_field1 = custom_field1;
	}

	public String getCustom_field2() {
		return custom_field2;
	}
	public void setCustom_field2(String custom_field2) {
		this.custom_field2 = custom_field2;
	}

	public String getCustom_field3() {
		return custom_field3;
	}
	public void setCustom_field3(String custom_field3) {
		this.custom_field3 = custom_field3;
	}

	public String getName_type() {
		return name_type;
	}
	public void setName_type(String name_type) {
		this.name_type = name_type;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getCustom_cell1() {
		return custom_cell1;
	}
	public void setCustom_cell1(String custom_cell1) {
		this.custom_cell1 = custom_cell1;
	}

	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Long getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(Long departure_time) {
		this.departure_time = departure_time;
	}

	public Long getLanding_time() {
		return landing_time;
	}
	public void setLanding_time(Long landing_time) {
		this.landing_time = landing_time;
	}

	public String getGate() {
		return gate;
	}
	public void setGate(String gate) {
		this.gate = gate;
	}

	public Long getBoarding_time() {
		return boarding_time;
	}
	public void setBoarding_time(Long boarding_time) {
		this.boarding_time = boarding_time;
	}

	public String getGuide_url() {
		return guide_url;
	}
	public void setGuide_url(String guide_url) {
		this.guide_url = guide_url;
	}

	public String getMap_url() {
		return map_url;
	}
	public void setMap_url(String map_url) {
		this.map_url = map_url;
	}

}
