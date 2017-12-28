package org.wx.sdk;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.wx.sdk.base.Request;
import org.wx.sdk.base.Response;
import org.wx.sdk.base.WxToken;
import org.wx.sdk.base.request.AccessTokenGetRequest;
import org.wx.sdk.base.request.HttpRequestTools;
import org.wx.sdk.base.response.AccessTokenGetRespone;
import org.wx.sdk.common.Dom4jUtil;
import com.alibaba.fastjson.JSON;

/**
 * 微信公众平台接口调用客户端
 * @author Rocye
 * @version 2016-03-24
 */
public class WxClient {
    private final static Logger logger = Logger.getLogger(WxClient.class.getName());
    
    /** 微信接口请求凭证 {@link WxToken} */
    private WxToken wxToken;
    /** 接口凭证字符串 */
    private String accessToken;

    /**
     * 构建微信接口客户端
     * @author Rocye
     * @param wxToken	微信接口请求凭证 {@link WxToken}
     */
    public WxClient(WxToken wxToken) {
        this.wxToken = wxToken;
    }
    
    /**
     * 构建微信接口客户端
     * @author Rocye
     * @param accessToken 	接口凭证字符串
     */
    public WxClient(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * 获取凭证ACCESS_TOKEN
     * @author Rocye
     * @return 接口凭证字符串
     * @version 2016-04-05
     */
    public String getAccessToken() {
        if(this.accessToken != null){
            return this.accessToken;
        }
        
        Map<String, Object> tokenMap = this.wxToken.getWxToken();
        if(tokenMap != null){
            return tokenMap.get("access_token").toString();
        }else{
            AccessTokenGetRequest accessTokenGetReq = new AccessTokenGetRequest(this.wxToken.getAppId(), this.wxToken.getAppSecret());
            AccessTokenGetRespone accessTokenGetRes = this.excute(accessTokenGetReq);
            if(accessTokenGetRes.getErrcode() > 0){
                return null;
            }else{
                Map<String, Object> resultMap = accessTokenGetRes.getResultMap();
                long expiresIn = accessTokenGetRes.getExpires_in();
                resultMap.put("time", System.currentTimeMillis() + expiresIn*1000);      //当前服务器时间 + 有效时间 = 过期时间
                this.wxToken.setWxToken(resultMap);
                return accessTokenGetRes.getAccess_token();
            }
        }
    }

    /**
     * 执行接口请求
     * @author Rocye
     * @param <T> {@link Request}实现类或{@link Response}实现类
     * @param request 消息请求对象 {@link Request}
     * @return 消息返回 {@link Response}
     * @version 2016-03-31
     */
    public <T extends Response> T excute(Request<T> request) {
        String requestRes = null;
        try {
            if(!request.getResponseClass().getName().equals(AccessTokenGetRespone.class.getName())){
                request.setAccessToken(this.getAccessToken());
            }
            if(request.getReqType() == 1){
                requestRes = HttpRequestTools.getInstance().sendGet(request.getApiUrl(), request.getUseHttps());
            }else if(request.getReqType() == 2){
                String filePath = request.getWxHashMap().get("filePath").toString();
                String fileName = request.getWxHashMap().get("fileName").toString();
                requestRes = HttpRequestTools.getInstance().downGet(request.getApiUrl(), filePath, fileName, request.getUseHttps());
            }else if(request.getReqType() == 3){
                String param = null;
                if(request.getParamFormat().equals("json")){
                    param = JSON.toJSONString(request.getWxHashMap());
                }else if(request.getParamFormat().equals("xml")){
                    param = Dom4jUtil.getXmlStrByMap(request.getWxHashMap());
                }else{
                    logger.warn("["+ request.getResponseClass() +"]参数格式不正确...");
                }
                if(param != null){
                    requestRes = HttpRequestTools.getInstance().sendPost(request.getApiUrl(), param, request.getUseHttps());
                }else{
                    requestRes = "{\"errcode\":1,\"errmsg\":\"参数有误\"}";
                }
            }else if(request.getReqType() == 4){
                String param = null;
                String filePath = request.getWxHashMap().get("filePath").toString();
                String fileName = request.getWxHashMap().get("fileName").toString();
                if(request.getParamFormat().equals("json")){
                    param = JSON.toJSONString(request.getWxHashMap());
                }else if(request.getParamFormat().equals("xml")){
                    param = Dom4jUtil.getXmlStrByMap(request.getWxHashMap());
                }else{
                    logger.warn("["+ request.getResponseClass() +"]参数格式不正确...");
                }
                if(param != null){
                    requestRes = HttpRequestTools.getInstance().downPost(request.getApiUrl(), param, filePath, fileName, request.getUseHttps());
                }else{
                    requestRes = "{\"errcode\":1,\"errmsg\":\"参数有误\"}";
                }
            }else if(request.getReqType() == 5){
                String filePath = request.getWxHashMap().get("filePath").toString();
                String fileName = request.getWxHashMap().get("fileName").toString();
                File file = new File(filePath + fileName);
                if(request.getWxHashMap().containsKey("name")){
                	String name = request.getWxHashMap().get("name").toString();
					requestRes = HttpRequestTools.getInstance().uploadPost(request.getApiUrl(), name, file, request.getUseHttps());
				}else{
					requestRes = HttpRequestTools.getInstance().uploadPost(request.getApiUrl(), file, request.getUseHttps());
				}
            }else if(request.getReqType() == 6){
                String filePath = request.getWxHashMap().get("filePath").toString();
                String fileName = request.getWxHashMap().get("fileName").toString();
                File file = new File(filePath + fileName);
                Map<String, Object> paramMap = new HashMap<String, Object>();
                for(String tmpKey : request.getWxHashMap().keySet()){
                    if(!tmpKey.equals("filePath") && !tmpKey.equals("filePath")){
                        paramMap.put(tmpKey, request.getWxHashMap().get(tmpKey));
                    }
                }
                requestRes = HttpRequestTools.getInstance().uploadPost(request.getApiUrl(), file, paramMap, request.getUseHttps());
            }
            
            if (StringUtils.isEmpty(requestRes)) {
                logger.warn("["+ request.getResponseClass() +"]请求接口返回结果为空...");
                requestRes = "{\"errcode\":2,\"errmsg\":\"接口返回结果为空\"}";
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("["+ request.getResponseClass() +"]请求接口时发生异常:" + e.toString());
            requestRes = "{\"errcode\":3,\"errmsg\":\"请求接口时发生异常\"}";
        }
        T response = JSON.parseObject(requestRes, request.getResponseClass());
        response.setBody(requestRes);
        return response;
    }

}
