package org.wx.pay.common;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wx.sdk.common.MD5;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;

/**
 * 微信支付工具类
 * @author Rocye
 * @version 2017.11.21
 */
public class WxPayUtil {
	private final static Logger logger = LoggerFactory.getLogger(WxPayUtil.class.getName());

	/**
	 * 组装签名的字段
	 * @param params     参数
	 * @param urlEncoder 是否urlEncoder
	 * @return String
	 */
	public static String PackageSign(Map<String, Object> params, boolean urlEncoder) {
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
	 * @throws Exception
	 * if an error occurred
	 */
	public static String CreateSign(Map<String, Object> params, String paternerKey) throws Exception {
		return CreateSign(params, paternerKey, "MD5");
	}

	/**
	 * 生成签名
	 * @param params 参数
	 * @param paternerKey 支付密钥
	 * @param signType 签名类型，默认为MD5，支持HMAC-SHA256和MD5
	 * @return sign
	 * @throws Exception
	 * if an error occurred
	 */
	public static String CreateSign(Map<String, Object> params, String paternerKey, String signType) throws Exception {
		String stringA = PackageSign(params, false);
		String stringSignTemp = stringA + "&key=" + paternerKey;
		if("MD5".equals(signType)){
			return MD5.encode(stringSignTemp).toUpperCase();
		}else if("HMAC-SHA256".equals(signType)){
			return HMACSHA256(stringSignTemp, paternerKey);
		}else{
			throw new Exception(String.format("Invalid signType: %s", signType));
		}
	}

	/**
	 * 生成 HMACSHA256
	 * @param data 待处理数据
	 * @param key 密钥
	 * @return 加密结果
	 * @throws Exception
	 * if an error occurred
	 */
	public static String HMACSHA256(String data, String key) throws Exception {
		Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
		SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
		sha256_HMAC.init(secret_key);
		byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
		StringBuilder sb = new StringBuilder();
		for (byte item : array) {
			sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString().toUpperCase();
	}

}
