package org.wx.sdk.card.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.card.respone.CardBatchGetRespone;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>批量查询卡券列表请求对象
 * <p>注意事项：
 * <p>1.未传入筛选条件时，该接口默认传回该商户名下所有状态的卡券；
 * <p>2.开发者可以请求之后调用查看卡券详情接口确定卡券状态；
 * @author Rocye
 * @version 2017.12.29
 */
public class CardBatchGetRequest implements Request<CardBatchGetRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 查询卡列表的起始偏移量，从0开始，即offset: 5是指从从列表里的第六个开始读取 */
    private Integer offset;
    /** 需要查询的卡片的数量（数量最大50） */
    private Integer count;
	/** 支持开发者拉出指定状态的卡券列表： “CARD_STATUS_NOT_VERIFY”, 待审核 ； “CARD_STATUS_VERIFY_FAIL”, 审核失败；
	 * “CARD_STATUS_VERIFY_OK”， 通过审核； “CARD_STATUS_DELETE”， 卡券被商户删除； “CARD_STATUS_DISPATCH”， 在公众平台投放过的卡券； */
	private List<String> status_list;

	/**
	 * 构造器
	 * @param offset		查询卡列表的起始偏移量，从0开始，即offset: 5是指从从列表里的第六个开始读取
	 * @param count			需要查询的卡片的数量（数量最大50）
	 */
	public CardBatchGetRequest(Integer offset, Integer count) {
		this.offset = offset;
		this.count = count;
	}

	/**
	 * 构造器
	 * @param offset		查询卡列表的起始偏移量，从0开始，即offset: 5是指从从列表里的第六个开始读取
	 * @param count			需要查询的卡片的数量（数量最大50）
	 * @param status_list	支持开发者拉出指定状态的卡券列表
	 */
	public CardBatchGetRequest(Integer offset, Integer count, List<String> status_list) {
		this.offset = offset;
		this.count = count;
		this.status_list = status_list;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/card/batchget?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<CardBatchGetRespone> getResponseClass(){
        return CardBatchGetRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("offset", this.offset);
		wxHashMap.put("count", this.count);
		if(this.status_list != null){
			wxHashMap.put("status_list", this.status_list);
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

	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}

	public List<String> getStatus_list() {
		return status_list;
	}
	public void setStatus_list(List<String> status_list) {
		this.status_list = status_list;
	}

}
