package org.wx.pay.base;

import java.util.Map;

/**
 * 支付公共请求对象
 * @author Rocye
 * @version 2017.11.14
 */
public abstract interface Request<T extends Response> {
	
	/**
	 * 获取接口请求地址
	 * @return 公众平台接口地址
	 */
	public String getApiUrl();

	/**
	 * 获取返回对象类
	 * @return 返回对象的类
	 */
	public Class<T> getResponseClass();
	
	/**
     * 获取请求参数的HashMap
     * @return 请求参数键值对
     */
	public Map<String, Object> getWxHashMap();
	
    /**
     * 请求类型：1-普通Get 2-下载GET 3-普通POST 4-下载POST 5-无参上传  6-有参上传
     * @return 请求类型
     */
    public int getReqType();
    
    /**
     * 请求参数格式(kv,json,xml)
     * @return 请求参数的数据格式
     */
    public String getParamFormat();
    
}