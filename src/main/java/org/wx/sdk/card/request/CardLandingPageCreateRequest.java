package org.wx.sdk.card.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.card.object.MinCard;
import org.wx.sdk.card.respone.CardLandingPageCreateRespone;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>创建货架请求对象
 * <p>开发者需调用该接口创建货架链接，用于卡券投放。创建货架时需填写投放路径的场景字段。
 * @author Rocye
 * @version 2017.12.26
 */
public class CardLandingPageCreateRequest implements Request<CardLandingPageCreateRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 页面的banner图片链接，须调用，建议尺寸为640*300 */
    private String banner;
    /** 页面的title */
    private String page_title;
    /** 页面是否可以分享 */
    private Boolean can_share;
    /** 投放页面的场景值: SCENE_NEAR_BY 附近, SCENE_MENU 自定义菜单,
	 * SCENE_QRCODE 二维码, SCENE_ARTICLE 公众号文章, SCENE_H5 h5页面,
	 * SCENE_IVR 自动回复, SCENE_CARD_CUSTOM_CELL 卡券自定义cell */
    private String scene;
	/** 卡券列表，每个item有两个字段 */
	private List<MinCard> card_list;

	/**
	 * 构造器
	 * @param banner	 页面的banner图片链接，须调用，建议尺寸为640*300
	 * @param pageTitle	 页面的title
	 * @param canShare	 页面是否可以分享,填入true/false
	 * @param scene		 投放页面的场景值
	 * @param cardList	 卡券列表，每个item有两个字段
	 */
	public CardLandingPageCreateRequest(String banner, String pageTitle, Boolean canShare, String scene, List<MinCard> cardList) {
		this.banner = banner;
		this.page_title = page_title;
		this.can_share = can_share;
		this.scene = scene;
		this.card_list = card_list;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/card/landingpage/create?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<CardLandingPageCreateRespone> getResponseClass(){
        return CardLandingPageCreateRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
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

	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getPage_title() {
		return page_title;
	}
	public void setPage_title(String page_title) {
		this.page_title = page_title;
	}

	public Boolean getCan_share() {
		return can_share;
	}
	public void setCan_share(Boolean can_share) {
		this.can_share = can_share;
	}

	public String getScene() {
		return scene;
	}
	public void setScene(String scene) {
		this.scene = scene;
	}

	public List<MinCard> getCard_list() {
		return card_list;
	}
	public void setCard_list(List<MinCard> card_list) {
		this.card_list = card_list;
	}

}
