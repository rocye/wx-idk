package org.wx.sdk.webdev;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.wx.sdk.base.request.HttpRequestTools;
import org.wx.sdk.webdev.request.OAuth2TokenGetRequest;
import org.wx.sdk.webdev.request.OAuth2TokenRefreshRequest;
import org.wx.sdk.webdev.response.OAuth2TokenGetRespone;

/**
 * <p>【默认例子实现类，不会生成到jar包去】
 * <p>微信网页授权实现（单例模式）
 * @author Rocye
 * @version 2017.10.24
 */
public class OAuth2AccessToken {
    /** 日志对象 */
    private final static Logger logger = Logger.getLogger(OAuth2AccessToken.class.getName());

	/**
	 * 私用构造函数
	 */
	private OAuth2AccessToken() {
	}
	/**
	 * 私有静态类用于构建主类的单例对象
	 * @author Rocye
	 * @version 2017.10.24
	 */
	private static class SingletonHolder {
		private static OAuth2AccessToken instance = new OAuth2AccessToken();
	}
	/**
	 * 得到主类的单例对象
	 * @return 主类对象
	 */
	public static OAuth2AccessToken getInstance(){
		return SingletonHolder.instance;
	}

    /**
     * 获取微信网页Token
	 * @param appId			公众号AppId
	 * @param appSecret		公众号AppSecret
	 * @param code   		第一步获取的code参数
     * @return				OAuth2Token数据对象
     */
    public OAuth2TokenGetRespone getWxToken(String appId, String appSecret, String code) {
		try{
			OAuth2TokenGetRequest tokenGetReq = new OAuth2TokenGetRequest(appId, appSecret, code);
			String requestRes = HttpRequestTools.getInstance().sendGet(tokenGetReq.getApiUrl(), tokenGetReq.getUseHttps());
			OAuth2TokenGetRespone tokenGetRes = JSON.parseObject(requestRes, tokenGetReq.getResponseClass());
			tokenGetRes.setBody(requestRes);

			//如果时间小于180秒就刷新请求
			if(tokenGetRes.getErrcode() != 0){
				logger.warn("获取微信网页Token时：" + tokenGetRes.getBody());
				return null;
			}else if(tokenGetRes.getExpires_in() < 180){
				return refreshWxToken(appId, tokenGetRes.getRefresh_token());
			}else{
				return tokenGetRes;
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("获取微信网页Token时：" + e.toString());
			return null;
		}
    }

    /**
     * 刷新access_token（如果需要）
	 * @param appId 		公众号AppId
	 * @param refreshToken 	刷新Token
     * @return 				OAuth2Token数据对象
     */
    public OAuth2TokenGetRespone refreshWxToken(String appId, String refreshToken) {
        try{
			OAuth2TokenRefreshRequest tokenRefreshReq = new OAuth2TokenRefreshRequest(appId, refreshToken);
			String requestRes = HttpRequestTools.getInstance().sendGet(tokenRefreshReq.getApiUrl(), tokenRefreshReq.getUseHttps());
			OAuth2TokenGetRespone tokenRefreshRes = JSON.parseObject(requestRes, tokenRefreshReq.getResponseClass());
			tokenRefreshRes.setBody(requestRes);

			//如果时间小于180秒就刷新请求
			if(tokenRefreshRes.getExpires_in() < 180){
				return null;
			}else{
				logger.warn("本次refreshToken有效时长是：" + tokenRefreshRes.getExpires_in() + "秒!");
				return tokenRefreshRes;
			}
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("刷新微信网页Token时：" + e.toString());
            return null;
        }
    }

}
