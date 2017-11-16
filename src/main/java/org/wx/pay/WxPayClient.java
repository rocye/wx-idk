package org.wx.pay;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.wx.pay.base.HttpsRequestTools;
import org.wx.pay.base.Request;
import org.wx.pay.base.Response;
import org.wx.sdk.common.Dom4jUtil;
import org.wx.sdk.common.MD5;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;

/**
 * 微信公众平台接口调用客户端
 * @author Rocye
 * @version 2017.11.14
 */
public class WxPayClient {
	private final static Logger logger = Logger.getLogger(WxPayClient.class.getName());

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
				requestRes = HttpsRequestTools.getInstance().sendGet(request.getApiUrl(), this.certPath, this.certPass);
			} else if (request.getReqType() == 3) {
				String param = null;
				if (request.getParamFormat().equals("xml")) {
					Map<String, Object> paraMap = request.getWxHashMap();
					paraMap.put("sign", createSign(paraMap, this.paternerKey));
					param = Dom4jUtil.getXmlStrByMap(paraMap);
				} else {
					logger.warn("[" + request.getResponseClass() + "]参数格式不正确...");
				}
				if (param != null) {
					requestRes = HttpsRequestTools.getInstance().sendPost(request.getApiUrl(), param, this.certPath, this.certPass);
				} else {
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

		String jsonRes = JSON.toJSONString(Dom4jUtil.getMapByXmlStr(requestRes));
		T response = JSON.parseObject(jsonRes, request.getResponseClass());
		response.setBody(requestRes);
		return response;
	}

	/**
	 * 组装签名的字段
	 * @param params     参数
	 * @param urlEncoder 是否urlEncoder
	 * @return String
	 */
	private String packageSign(Map<String, Object> params, boolean urlEncoder) {
		// 先将参数以其参数名的字典序升序进行排序
		Map<String, Object> sortedParams = new TreeMap<String, Object>(params);
		// 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (Map.Entry<String, Object> param : sortedParams.entrySet()) {
			String value = param.getValue().toString();
			if (StringUtils.isBlank(value)) {
				continue;
			}
			if (first) {
				first = false;
			} else {
				sb.append("&");
			}
			sb.append(param.getKey()).append("=");
			if (urlEncoder) {
				try {
					value = URLEncoder.encode(value, "UTF-8").replace("+", "%20");
				} catch (UnsupportedEncodingException e) {
					logger.error(e.toString());
				}
			}
			sb.append(value);
		}
		return sb.toString();
	}

	/**
	 * 生成签名
	 * @param params 参数
	 * @param paternerKey 支付密钥
	 * @return sign
	 */
	private String createSign(Map<String, Object> params, String paternerKey) {
		String stringA = packageSign(params, false);
		String stringSignTemp = stringA + "&key=" + paternerKey;
		return MD5.encode(stringSignTemp).toUpperCase();
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
