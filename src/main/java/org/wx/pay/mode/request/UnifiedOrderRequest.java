package org.wx.pay.mode.request;

import org.wx.pay.base.Request;
import org.wx.pay.mode.response.UnifiedOrderRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>统一下单请求对象
 * <p>除被扫支付场景以外，商户系统先调用该接口在微信支付服务后台生成预支付交易单，
 * 返回正确的预支付交易回话标识后再按扫码、JSAPI、APP等不同场景生成交易串调起支付。
 * <p>不需要证书
 * @author Rocye
 * @version 2017.11.16
 */
public class UnifiedOrderRequest implements Request<UnifiedOrderRespone> {
    /** 请求参数的Map */
	private Map<String, Object> wxHashMap = new HashMap<String, Object>();

	/** 公众账号appid */
	private String appid;
	/** 微信支付分配的商户号 */
	private String mch_id;
	/** 可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB" (否) */
	private String device_info;
	/** 随机字符串，不长于32位 */
    private String nonce_str;
	/** 签名类型，默认为MD5，支持HMAC-SHA256和MD5 (否) */
	private String sign_type="MD5";
	/** 商品描述 */
	private String body;
	/** 商品详细描述，对于使用单品优惠的商户，该字段必须按照规范上传 (否) */
	private String detail;
	/** 附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用 (否) */
	private String attach;
	/** 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一 */
	private String out_trade_no;
	/** 货币类型 (否) */
	private String fee_type = "CNY";
	/** 订单总金额，单位为分 */
	private Integer total_fee;
	/** APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP */
	private String spbill_create_ip;
	/** 交易起始时间，格式为yyyyMMddHHmmss (否) */
	private String time_start;
	/** 交易结束时间，格式为yyyyMMddHHmmss (否) */
	private String time_expire;
	/** 订单优惠标记，使用代金券或立减优惠功能时需要的参数 (否) */
	private String goods_tag;
	/** 异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数 */
	private String notify_url;
	/** 交易类型：JSAPI，NATIVE，APP */
	private String trade_type;
	/** 商品ID：trade_type=NATIVE时（即扫码支付），此参数必传。此参数为二维码中包含的商品ID，商户自行定义 (否) */
	private String product_id;
	/** 指定支付方式：上传此参数no_credit--可限制用户不能使用信用卡支付 (否) */
	private String limit_pay;
	/** 用户标识：trade_type=JSAPI时（即公众号支付），此参数必传，此参数为微信用户在商户对应appid下的唯一标识 (否) */
	private String openid;
	/** 场景信息：目前支持上报实际门店信息。该字段为JSON对象数据 (否) */
	private String scene_info;

	/**
	 * 全参构造器
	 * @param appid			公众账号appid
	 * @param mch_id		微信支付分配的商户号
	 * @param nonce_str		随机字符串，不长于32位
	 * @param body			商品描述
	 * @param out_trade_no	商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一
	 * @param total_fee		订单总金额，单位为分
	 * @param spbill_create_ip	APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP
	 * @param notify_url	异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数
	 * @param trade_type	交易类型：JSAPI，NATIVE，APP
	 * @param product_id	商品ID：trade_type=NATIVE时（即扫码支付），此参数必传。此参数为二维码中包含的商品ID，商户自行定义 (否)
	 */
	public UnifiedOrderRequest(String appid, String mch_id, String nonce_str, String body, String out_trade_no,
							   Integer total_fee, String spbill_create_ip, String notify_url, String trade_type, String product_id) {
		this.appid = appid;
		this.mch_id = mch_id;
		this.nonce_str = nonce_str;
		this.body = body;
		this.out_trade_no = out_trade_no;
		this.total_fee = total_fee;
		this.spbill_create_ip = spbill_create_ip;
		this.notify_url = notify_url;
		this.trade_type = trade_type;
		this.product_id = product_id;
	}

	/**
	 * 全参构造器
	 * @param appid			公众账号appid
	 * @param mch_id		微信支付分配的商户号
	 * @param device_info	可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB" (否)
	 * @param nonce_str		随机字符串，不长于32位
	 * @param sign_type		签名类型，默认为MD5，支持HMAC-SHA256和MD5 (否)
	 * @param body			商品描述
	 * @param detail		商品详细描述，对于使用单品优惠的商户，该字段必须按照规范上传 (否)
	 * @param attach		附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用 (否)
	 * @param out_trade_no	商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一
	 * @param fee_type		货币类型 (否)
	 * @param total_fee		订单总金额，单位为分
	 * @param spbill_create_ip	APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP
	 * @param time_start	交易起始时间，格式为yyyyMMddHHmmss (否)
	 * @param time_expire	交易结束时间，格式为yyyyMMddHHmmss (否)
	 * @param goods_tag		订单优惠标记，使用代金券或立减优惠功能时需要的参数 (否)
	 * @param notify_url	异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数
	 * @param trade_type	交易类型：JSAPI，NATIVE，APP
	 * @param product_id	商品ID：trade_type=NATIVE时（即扫码支付），此参数必传。此参数为二维码中包含的商品ID，商户自行定义 (否)
	 */
	public UnifiedOrderRequest(String appid, String mch_id, String device_info, String nonce_str, String sign_type,
							   String body, String detail, String attach, String out_trade_no, String fee_type,
							   Integer total_fee, String spbill_create_ip, String time_start, String time_expire,
							   String goods_tag, String notify_url, String trade_type, String product_id) {
		this.appid = appid;
		this.mch_id = mch_id;
		this.device_info = device_info;
		this.nonce_str = nonce_str;
		this.sign_type = sign_type;
		this.body = body;
		this.detail = detail;
		this.attach = attach;
		this.out_trade_no = out_trade_no;
		this.fee_type = fee_type;
		this.total_fee = total_fee;
		this.spbill_create_ip = spbill_create_ip;
		this.time_start = time_start;
		this.time_expire = time_expire;
		this.goods_tag = goods_tag;
		this.notify_url = notify_url;
		this.trade_type = trade_type;
		this.product_id = product_id;
	}

	/**
	 * 全参构造器
	 * @param appid			公众账号appid
	 * @param mch_id		微信支付分配的商户号
	 * @param device_info	可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB" (否)
	 * @param nonce_str		随机字符串，不长于32位
	 * @param sign_type		签名类型，默认为MD5，支持HMAC-SHA256和MD5 (否)
	 * @param body			商品描述
	 * @param detail		商品详细描述，对于使用单品优惠的商户，该字段必须按照规范上传 (否)
	 * @param attach		附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用 (否)
	 * @param out_trade_no	商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一
	 * @param fee_type		货币类型 (否)
	 * @param total_fee		订单总金额，单位为分
	 * @param spbill_create_ip	APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP
	 * @param time_start	交易起始时间，格式为yyyyMMddHHmmss (否)
	 * @param time_expire	交易结束时间，格式为yyyyMMddHHmmss (否)
	 * @param goods_tag		订单优惠标记，使用代金券或立减优惠功能时需要的参数 (否)
	 * @param notify_url	异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数
	 * @param trade_type	交易类型：JSAPI，NATIVE，APP
	 * @param product_id	商品ID：trade_type=NATIVE时（即扫码支付），此参数必传。此参数为二维码中包含的商品ID，商户自行定义 (否)
	 * @param limit_pay		指定支付方式：上传此参数no_credit--可限制用户不能使用信用卡支付 (否)
	 * @param openid		用户标识：trade_type=JSAPI时（即公众号支付），此参数必传，此参数为微信用户在商户对应appid下的唯一标识 (否)
	 * @param scene_info	场景信息：目前支持上报实际门店信息。该字段为JSON对象数据 (否)
	 */
	public UnifiedOrderRequest(String appid, String mch_id, String device_info, String nonce_str, String sign_type,
							   String body, String detail, String attach, String out_trade_no, String fee_type,
							   Integer total_fee, String spbill_create_ip, String time_start, String time_expire,
							   String goods_tag, String notify_url, String trade_type, String product_id,
							   String limit_pay, String openid, String scene_info) {
		this.appid = appid;
		this.mch_id = mch_id;
		this.device_info = device_info;
		this.nonce_str = nonce_str;
		this.sign_type = sign_type;
		this.body = body;
		this.detail = detail;
		this.attach = attach;
		this.out_trade_no = out_trade_no;
		this.fee_type = fee_type;
		this.total_fee = total_fee;
		this.spbill_create_ip = spbill_create_ip;
		this.time_start = time_start;
		this.time_expire = time_expire;
		this.goods_tag = goods_tag;
		this.notify_url = notify_url;
		this.trade_type = trade_type;
		this.product_id = product_id;
		this.limit_pay = limit_pay;
		this.openid = openid;
		this.scene_info = scene_info;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<UnifiedOrderRespone> getResponseClass(){
        return UnifiedOrderRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("appid", this.appid);
		wxHashMap.put("mch_id", this.mch_id);
		wxHashMap.put("nonce_str", this.nonce_str);
		wxHashMap.put("sign_type", this.sign_type);
		wxHashMap.put("body", this.body);
		wxHashMap.put("out_trade_no", this.out_trade_no);
		wxHashMap.put("total_fee", this.total_fee);
		wxHashMap.put("spbill_create_ip", this.spbill_create_ip);
		wxHashMap.put("notify_url", this.notify_url);
		wxHashMap.put("trade_type", this.trade_type);

		if(this.device_info != null){
			wxHashMap.put("device_info", this.device_info);
		}
		if(this.detail != null){
			wxHashMap.put("detail", this.detail);
		}
		if(this.attach != null){
			wxHashMap.put("attach", this.attach);
		}
		if(this.fee_type != null){
			wxHashMap.put("fee_type", this.fee_type);
		}
		if(this.time_start != null){
			wxHashMap.put("time_start", this.time_start);
		}
		if(this.time_expire != null){
			wxHashMap.put("time_expire", this.time_expire);
		}
		if(this.goods_tag != null){
			wxHashMap.put("goods_tag", this.goods_tag);
		}
		if(this.product_id != null){
			wxHashMap.put("product_id", this.product_id);
		}
		if(this.limit_pay != null){
			wxHashMap.put("limit_pay", this.limit_pay);
		}
		if(this.openid != null){
			wxHashMap.put("openid", this.openid);
		}
		if(this.scene_info != null){
			wxHashMap.put("scene_info", this.scene_info);
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
        return "xml";
    }

	/**
	 * 获取请求是否需要证书
	 * @return 是否证书请求
	 */
	public boolean getUseCert() {
		return false;
	}

	///////////////////////////////////////Get&Set////////////////////////////////////
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign_type() {
		return sign_type;
	}
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getFee_type() {
		return fee_type;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public Integer getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public String getTime_start() {
		return time_start;
	}
	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public String getTime_expire() {
		return time_expire;
	}
	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}

	public String getGoods_tag() {
		return goods_tag;
	}
	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}

	public String getNotify_url() {
		return notify_url;
	}
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getLimit_pay() {
		return limit_pay;
	}
	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}

	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getScene_info() {
		return scene_info;
	}
	public void setScene_info(String scene_info) {
		this.scene_info = scene_info;
	}

}
