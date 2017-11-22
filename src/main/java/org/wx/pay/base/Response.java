package org.wx.pay.base;

import org.wx.sdk.common.Dom4jUtil;
import java.util.Map;

/**
 * 支付公共返回对象
 * @author Rocye
 * @version 2017.11.14
 */
public abstract class Response {

    /** 接口原始返回字串 */
	private String body;
	/** 接口原始返回HashMap */
	private Map<String, Object> resultMap;

	/** 返回状态码 */
	protected String return_code;
	/** 返回信息 */
	protected String return_msg;
	/** 业务结果 */
	protected String result_code;
	/** 错误代码 */
	protected String err_code;
	/** 错误代码描述 */
	protected String err_code_des;

	/**
	 * @return 原始返回字串
	 */
	public String getBody() {
		return this.body;
	}
	public void setBody(String body) {
		this.body = body;
	}

	public String getReturn_code() {
		return return_code;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getErr_code() {
		return err_code;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public String getErr_code_des() {
		return err_code_des;
	}
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}

	public Map<String, Object> getResultMap() {
        return resultMap;
    }
    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }
    
}
