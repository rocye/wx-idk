package org.wx.pay;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wx.pay.base.HttpsRequestTools;
import org.wx.pay.base.Request;
import org.wx.pay.base.Response;
import org.wx.pay.common.WxPayUtil;
import org.wx.sdk.common.Dom4jUtil;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信公众平台接口调用客户端
 * @author Rocye
 * @version 2017.11.14
 */
public class WxPayClient {
	private final static Logger logger = LoggerFactory.getLogger(WxPayClient.class.getName());

	/**
	 * 商户API密钥
	 */
	private String paternerKey;
	/**
	 * 微信证书路径
	 */
	private String certPath;
	/**
	 * 微信证书密码
	 */
	private String certPass;

	/**
	 * 构建微信接口客户端
	 * @param paternerKey 商户API密钥
	 * @author Rocye
	 */
	public WxPayClient(String paternerKey) {
		this.paternerKey = paternerKey;
	}

	/**
	 * 构建微信接口客户端
	 * @param paternerKey 商户API密钥
	 * @param certPath    微信证书路径
	 * @param certPass    微信证书密码
	 * @author Rocye
	 */
	public WxPayClient(String paternerKey, String certPath, String certPass) {
		this.paternerKey = paternerKey;
		this.certPath = certPath;
		this.certPass = certPass;
	}

	/**
	 * 执行接口请求
	 * @param <T> {@link Request}实现类或{@link Response}实现类
	 * @param request 消息请求对象 {@link Request}
	 * @return 消息返回 {@link Response}
	 * @author Rocye
	 * @version 2017.11.14
	 */
	public <T extends Response> T excute(Request<T> request) {
		String requestRes = null;
		try {
			if (request.getReqType() == 1) {
				requestRes = HttpsRequestTools.getInstance().sendGet(request.getApiUrl(), request.getUseCert(), this.certPath, this.certPass);
			} else if (request.getReqType() == 3) {
				String param = null;
				if (request.getParamFormat().equals("xml")) {
					Map<String, Object> paraMap = request.getWxHashMap();
					paraMap.put("sign", WxPayUtil.CreateSign(paraMap, this.paternerKey, paraMap.get("sign_type").toString()));
					param = Dom4jUtil.getXmlStrByMap(paraMap);
				} else {
					logger.warn("[" + request.getResponseClass() + "]参数格式不正确...");
				}
				if (param != null) {
					requestRes = HttpsRequestTools.getInstance().sendPost(request.getApiUrl(), request.getUseCert(), param, this.certPath, this.certPass);
				} else {
					requestRes = getReturnXml("FAIL", "参数不能为空.");
				}
			} else if(request.getReqType() == 4){
				String param = null;
				if(request.getParamFormat().equals("json")){
					param = JSON.toJSONString(request.getWxHashMap());
				}else if(request.getParamFormat().equals("xml")){
					Map<String, Object> paraMap = new HashMap<String, Object>();
					paraMap.putAll(request.getWxHashMap());
					paraMap.remove("filePath");
					paraMap.remove("fileName");
					paraMap.put("sign", WxPayUtil.CreateSign(paraMap, this.paternerKey, paraMap.get("sign_type").toString()));
					param = Dom4jUtil.getXmlStrByMap(paraMap);
				}else{
					logger.warn("["+ request.getResponseClass() +"]参数格式不正确...");
				}

				System.out.println(param);
				if(param != null){
					if(request.getWxHashMap().containsKey("filePath")){
						String filePath = request.getWxHashMap().get("filePath").toString();
						String fileName = request.getWxHashMap().get("fileName").toString();
						requestRes = HttpsRequestTools.getInstance().downPost(request.getApiUrl(), param, filePath, fileName, request.getUseCert(), this.certPath, this.certPass);
					}else{
						requestRes = HttpsRequestTools.getInstance().sendPost(request.getApiUrl(), request.getUseCert(), param, this.certPath, this.certPass);
					}
				}else{
					requestRes = getReturnXml("FAIL", "参数不能为空.");
				}
			}

			if (StringUtils.isEmpty(requestRes)) {
				logger.warn("[" + request.getResponseClass() + "]请求接口返回结果为空...");
				requestRes = getReturnXml("FAIL", "接口返回结果为空.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("[" + request.getResponseClass() + "]请求接口时发生异常:" + e.toString());
			requestRes = getReturnXml("FAIL", "请求接口时发生异常.");
		}

		String jsonRes = "{}";
		Map<String, Object> resultMap = null;
		if(request.getReqType() != 4){
			resultMap = Dom4jUtil.getMapByXmlStr(requestRes);
			jsonRes = JSON.toJSONString(resultMap);
		}
		T response = JSON.parseObject(jsonRes, request.getResponseClass());
		response.setBody(requestRes);
		response.setResultMap(resultMap);
		return response;
	}

	/**
	 * 返回XML字符串
	 * @param returnCode	返回状态码
	 * @param returnMsg		返回信息
	 * @return 返回XML串
	 */
	private String getReturnXml (String returnCode, String returnMsg) {
		return "<xml><return_code><![CDATA["+ returnCode +"]]></return_code><return_msg><![CDATA["+ returnMsg +"]]></return_msg></xml>";
	}

}
