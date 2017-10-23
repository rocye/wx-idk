package org.wx.sdk.sendmsg.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.sendmsg.response.KfSendRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>客服输入状态请求对象
 *
 * <p>此接口需要客服消息接口权限：
 * <p>1. 如果不满足发送客服消息的触发条件，则无法下发输入状态。
 * <p>2. 下发输入状态，需要客服之前30秒内跟用户有过消息交互。
 * <p>3. 在输入状态中（持续15s），不可重复下发输入态。
 * <p>4. 在输入状态中，如果向用户下发消息，会同时取消输入状态。
 *
 * @author Rocye
 * @version 2017-10-19
 */
public class KfTypingRequest implements Request<KfSendRespone> {

	/**
	 * 调用接口凭证
	 */
	private String accessToken;
	/**
	 * 请求参数
	 */
	private Map<String, Object> wxHashMap = new HashMap<String, Object>();
	/**
	 * 普通用户openid
	 */
	private String touser;
	/**
	 * "Typing"：对用户下发“正在输入”状态 	"CancelTyping"：取消对用户的“正在输入”状态
	 */
	private String command;

	/**
	 * 构造器
	 * @param touser  接收者openid
	 * @param command "Typing"：对用户下发“正在输入”状态		"CancelTyping"：取消对用户的“正在输入”状态
	 */
	public KfTypingRequest(String touser, String command) {
		this.touser = touser;
		this.command = command;
	}

	/**
	 * 获取接口请求地址
	 */
	public String getApiUrl() {
		String url = "https://api.weixin.qq.com/cgi-bin/message/custom/typing?access_token=" + this.accessToken;
		return url;
	}

	/**
	 * 获取返回对象类
	 */
	public Class<KfSendRespone> getResponseClass() {
		return KfSendRespone.class;
	}

	/**
	 * 获取请求参数的HashMap
	 */
	public Map<String, Object> getWxHashMap() {
		wxHashMap.put("touser", touser);
		wxHashMap.put("command", command);
		return wxHashMap;
	}

	/**
	 * 获取请求是否是Https
	 */
	public boolean getUseHttps() {
		return true;
	}

	/**
	 * 请求类型：1-普通Get 2-下载GET 3-普通POST 4-下载POST 5-无参上传   6-有参上传
	 */
	public int getReqType() {
		return 3;
	}

	/**
	 * 请求参数格式(kv,json,xml)
	 */
	public String getParamFormat() {
		return "json";
	}

	/**
	 * 设置AccessToken
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
}
