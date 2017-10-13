package org.wx.sdk.statistic.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.statistic.response.GetArticleTotalRespone;

/**
 * <p>获取图文群发总数据(最大时间跨度:1)
 * <p>获取的是，某天群发的文章，从群发日起到接口调用日（但最多统计发表日后7天数据），每天的到当天的总等数据。
 * 例如某篇文章是12月1日发出的，发出后在1日、2日、3日的阅读次数分别为1万，则getarticletotal获取到的数据为，
 * 距发出到12月1日24时的总阅读量为1万，距发出到12月2日24时的总阅读量为2万，距发出到12月1日24时的总阅读量为3万。
 * 
 * <p>1、接口侧的公众号数据的数据库中仅存储了2014年12月1日之后的数据，将查询不到在此之前的日期，即使有查到，也是不可信的脏数据；
 * <p>2、请开发者在调用接口获取数据后，将数据保存在自身数据库中，即加快下次用户的访问速度，也降低了微信侧接口调用的不必要损耗。
 * <p>3、额外注意，获取图文群发每日数据接口的结果中，只有中间页阅读人数+原文页阅读人数+分享转发人数+分享转发次数+收藏次数 大于等于3 的结果才会得到统计，过小的阅读量的图文消息无法统计。
 * @author Rocye
 * @version 2017-09-29
 */
public class GetArticleTotalRequest implements Request<GetArticleTotalRespone> {
    
	/** 调用接口凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    
    /** 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”
     * （比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），
     *  否则会报错
     */
    private String begin_date;
    /** 获取数据的结束日期，end_date允许设置的最大值为昨日 */
    private String end_date;
    
    /**
     * 构造函数
     */
    public GetArticleTotalRequest() {
    	
    }
    
    /**
     * 构造函数
     * @param beginDate	 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”，否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     */
    public GetArticleTotalRequest(String beginDate, String endDate) {
        this.begin_date = beginDate;
        this.end_date = endDate;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/datacube/getarticletotal?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<GetArticleTotalRespone> getResponseClass(){
        return GetArticleTotalRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
    	wxHashMap.put("begin_date", this.begin_date);
    	wxHashMap.put("end_date", this.end_date);
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

}
