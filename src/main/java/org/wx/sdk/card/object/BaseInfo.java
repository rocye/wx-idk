package org.wx.sdk.card.object;

/**
 * 卡券基础信息字段
 * @author Rocye
 * @version 2017.12.19
 */
public class BaseInfo {
	//必填字段
	/** 卡券的商户logo，建议像素为300*300。*/
	private String logo_url;
	/** 码型：
	 * CODE_TYPE_TEXT 文本；
	 * CODE_TYPE_BARCODE 一维码；
	 * CODE_TYPE_QRCODE 二维码；
	 * CODE_TYPE_ONLY_QRCODE 二维码无code显示；
	 * CODE_TYPE_ONLY_BARCODE 一维码无code显示；
	 * CODE_TYPE_NONE 不显示code和条形码类型；*/
	private String code_type;
	/** 商户名字,字数上限为12个汉字。*/
	private String brand_name;
	/** 卡券名，字数上限为9个汉字。(建议涵盖卡券属性、服务及金额)。*/
	private String title;
	/** 券颜色。按色彩规范标注填写Color010-Color100。*/
	private String color;
	/** 卡券使用提醒，字数上限为16个汉字。*/
	private String notice;
	/** 卡券使用说明，字数上限为1024个汉字。*/
	private String description;
	/** 商品信息。 */
	private Sku sku;
	/** 使用日期，有效期的信息。 */
	private DateInfo date_info;

	//非必填字段
	/** 是否自定义Code码 。填写true或false，默认为false。 */
	private Boolean use_custom_code;
	/** 填入 GET_CUSTOM_CODE_MODE_DEPOSIT 表示该卡券为预存code模式卡券，须导入超过库存数目的自定义code后方可投放，
	 * 填入该字段后，quantity字段须为0,须导入code 后再增加库存 */
	private String get_custom_code_mode;
	/** 是否指定用户领取，填写true或false。默认为false。通常指定特殊用户群体 投放卡券或防止刷券时选择指定用户领取。 */
	private Boolean bind_openid;
	/** 客服电话。 */
	private String service_phone;
	/** 门店位置poiid。调用POI门店管理接口获取门店位置poiid。具备线下门店 的商户为必填。 */
	private String[] location_id_list;
	/** 设置本卡券支持全部门店，与location_id_list互斥 */
	private Boolean use_all_locations;
	/** 卡券顶部居中的按钮，仅在卡券状 态正常(可以核销)时显示 */
	private String center_title;
	/** 显示在入口下方的提示语 ，仅在卡券状态正常(可以核销)时显示。 */
	private String center_sub_title;
	/** 顶部居中的url ，仅在卡券状态正常(可以核销)时显示。 */
	private String center_url;
	/** 卡券跳转的小程序的user_name，仅可跳转该 公众号绑定的小程序。*/
	private String center_app_brand_user_name;
	/** 卡券跳转的小程序的path */
	private String center_app_brand_pass;
	/** 自定义跳转外链的入口名字。 */
	private String custom_url_name;
	/** 自定义跳转的URL。 */
	private String custom_url;
	/** 显示在入口右侧的提示语。 */
	private String custom_url_sub_title;
	/** 卡券跳转的小程序的user_name，仅可跳转该 公众号绑定的小程序。 */
	private String custom_app_brand_user_name;
	/** 卡券跳转的小程序的path */
	private String custom_app_brand_pass;
	/** 营销场景的自定义入口名称。 */
	private String promotion_url_name;
	/** 入口跳转外链的地址链接。 */
	private String promotion_url;
	/** 显示在营销入口右侧的提示语。 */
	private String promotion_url_sub_title;
	/** 卡券跳转的小程序的user_name，仅可跳转该 公众号绑定的小程序。 */
	private String promotion_app_brand_user_name;
	/** 卡券跳转的小程序的path */
	private String promotion_app_brand_pass;
	/** 每人可领券的数量限制,不填写默认为50。 */
	private String get_limit;
	/** 每人可核销的数量限制,不填写默认为50。 */
	private String use_limit;
	/** 卡券领取页面是否可分享。 */
	private String can_share;
	/** 卡券是否可转赠。 */
	private String can_give_friend;

	/**
	 * 无造构造器
	 */
	public BaseInfo() {
	}

	/**
	 * 构造器
	 * @param logo_url		卡券的商户logo，建议像素为300*300
	 * @param code_type		码型： "CODE_TYPE_TEXT"文本 "CODE_TYPE_BARCODE"一维码 "CODE_TYPE_QRCODE"二维码 "CODE_TYPE_ONLY_QRCODE",二维码无code显示； "CODE_TYPE_ONLY_BARCODE",一维码无code显示；CODE_TYPE_NONE， 不显示code和条形码类型
	 * @param brand_name	商户名字,字数上限为12个汉字
	 * @param title			卡券名，字数上限为9个汉字
	 * @param color			券颜色，按色彩规范标注填写Color010-Color100
	 * @param notice		卡券使用提醒，字数上限为16个汉字
	 * @param description	券使用说明，字数上限为1024个汉字
	 * @param sku			商品信息
	 * @param date_info		使用日期，有效期的信息
	 */
	public BaseInfo(String logo_url, String code_type, String brand_name, String title, String color, String notice,
					String description, Sku sku, DateInfo date_info) {
		this.logo_url = logo_url;
		this.code_type = code_type;
		this.brand_name = brand_name;
		this.title = title;
		this.color = color;
		this.notice = notice;
		this.description = description;
		this.sku = sku;
		this.date_info = date_info;
	}

	public String getLogo_url() {
		return logo_url;
	}
	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}

	public String getCode_type() {
		return code_type;
	}
	public void setCode_type(String code_type) {
		this.code_type = code_type;
	}

	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Sku getSku() {
		return sku;
	}
	public void setSku(Sku sku) {
		this.sku = sku;
	}

	public DateInfo getDate_info() {
		return date_info;
	}
	public void setDate_info(DateInfo date_info) {
		this.date_info = date_info;
	}

	public Boolean getUse_custom_code() {
		return use_custom_code;
	}
	public void setUse_custom_code(Boolean use_custom_code) {
		this.use_custom_code = use_custom_code;
	}

	public String getGet_custom_code_mode() {
		return get_custom_code_mode;
	}
	public void setGet_custom_code_mode(String get_custom_code_mode) {
		this.get_custom_code_mode = get_custom_code_mode;
	}

	public Boolean getBind_openid() {
		return bind_openid;
	}
	public void setBind_openid(Boolean bind_openid) {
		this.bind_openid = bind_openid;
	}

	public String getService_phone() {
		return service_phone;
	}
	public void setService_phone(String service_phone) {
		this.service_phone = service_phone;
	}

	public String[] getLocation_id_list() {
		return location_id_list;
	}
	public void setLocation_id_list(String[] location_id_list) {
		this.location_id_list = location_id_list;
	}

	public Boolean getUse_all_locations() {
		return use_all_locations;
	}
	public void setUse_all_locations(Boolean use_all_locations) {
		this.use_all_locations = use_all_locations;
	}

	public String getCenter_title() {
		return center_title;
	}
	public void setCenter_title(String center_title) {
		this.center_title = center_title;
	}

	public String getCenter_sub_title() {
		return center_sub_title;
	}
	public void setCenter_sub_title(String center_sub_title) {
		this.center_sub_title = center_sub_title;
	}

	public String getCenter_url() {
		return center_url;
	}
	public void setCenter_url(String center_url) {
		this.center_url = center_url;
	}

	public String getCenter_app_brand_user_name() {
		return center_app_brand_user_name;
	}
	public void setCenter_app_brand_user_name(String center_app_brand_user_name) {
		this.center_app_brand_user_name = center_app_brand_user_name;
	}

	public String getCenter_app_brand_pass() {
		return center_app_brand_pass;
	}
	public void setCenter_app_brand_pass(String center_app_brand_pass) {
		this.center_app_brand_pass = center_app_brand_pass;
	}

	public String getCustom_url_name() {
		return custom_url_name;
	}
	public void setCustom_url_name(String custom_url_name) {
		this.custom_url_name = custom_url_name;
	}

	public String getCustom_url() {
		return custom_url;
	}
	public void setCustom_url(String custom_url) {
		this.custom_url = custom_url;
	}

	public String getCustom_url_sub_title() {
		return custom_url_sub_title;
	}
	public void setCustom_url_sub_title(String custom_url_sub_title) {
		this.custom_url_sub_title = custom_url_sub_title;
	}

	public String getCustom_app_brand_user_name() {
		return custom_app_brand_user_name;
	}
	public void setCustom_app_brand_user_name(String custom_app_brand_user_name) {
		this.custom_app_brand_user_name = custom_app_brand_user_name;
	}

	public String getCustom_app_brand_pass() {
		return custom_app_brand_pass;
	}

	public void setCustom_app_brand_pass(String custom_app_brand_pass) {
		this.custom_app_brand_pass = custom_app_brand_pass;
	}
	public String getPromotion_url_name() {
		return promotion_url_name;
	}

	public void setPromotion_url_name(String promotion_url_name) {
		this.promotion_url_name = promotion_url_name;
	}
	public String getPromotion_url() {
		return promotion_url;
	}

	public void setPromotion_url(String promotion_url) {
		this.promotion_url = promotion_url;
	}
	public String getPromotion_url_sub_title() {
		return promotion_url_sub_title;
	}

	public void setPromotion_url_sub_title(String promotion_url_sub_title) {
		this.promotion_url_sub_title = promotion_url_sub_title;
	}
	public String getPromotion_app_brand_user_name() {
		return promotion_app_brand_user_name;
	}

	public void setPromotion_app_brand_user_name(String promotion_app_brand_user_name) {
		this.promotion_app_brand_user_name = promotion_app_brand_user_name;
	}
	public String getPromotion_app_brand_pass() {
		return promotion_app_brand_pass;
	}

	public void setPromotion_app_brand_pass(String promotion_app_brand_pass) {
		this.promotion_app_brand_pass = promotion_app_brand_pass;
	}

	public String getGet_limit() {
		return get_limit;
	}
	public void setGet_limit(String get_limit) {
		this.get_limit = get_limit;
	}

	public String getUse_limit() {
		return use_limit;
	}
	public void setUse_limit(String use_limit) {
		this.use_limit = use_limit;
	}

	public String getCan_share() {
		return can_share;
	}
	public void setCan_share(String can_share) {
		this.can_share = can_share;
	}

	public String getCan_give_friend() {
		return can_give_friend;
	}
	public void setCan_give_friend(String can_give_friend) {
		this.can_give_friend = can_give_friend;
	}

}
