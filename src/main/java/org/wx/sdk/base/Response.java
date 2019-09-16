package org.wx.sdk.base;

import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * 公共返回对象
 * @author Rocye
 * @version 2016-03-24
 */
public abstract class Response {

    /** 接口原始返回字串 */
	private String body;
	/** 接口原始返回HashMap */
	private Map<String, Object> resultMap;
	/** 错误码 */
	protected Integer errcode = 0;
	/** 错误信息 */
	protected String errmsg;

	/**
	 * @return 原始返回字串
	 */
	public String getBody() {
		return this.body;
	}
	public void setBody(String body) {
		this.body = body;
		this.resultMap = JSON.parseObject(body, new TypeReference<Map<String, Object>>(){});
	}
	
    public Integer getErrcode() {
        return errcode;
    }
    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }
    
    public String getErrmsg() {
        return errmsg;
    }
    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
    
    public Map<String, Object> getResultMap() {
        return resultMap;
    }
    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }
    
}
