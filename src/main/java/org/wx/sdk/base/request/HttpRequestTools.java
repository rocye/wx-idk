package org.wx.sdk.base.request;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.wx.sdk.common.FileIo;

/**
 * Http/Https请求工具类(高并发下的延迟加载单例模式)
 * @author Rocye
 * @version 2019.09.16
 */
public class HttpRequestTools {
	/** 日志对象 */
    private final static Logger logger = Logger.getLogger(HttpRequestTools.class.getName());
    /** 连接超时时间 */
	public static final int CONNECTION_TIMEOUT = 5000;
	/** 请求超时时间 */
	public static final int CONNECTION_REQUEST_TIMEOUT = 5000;
	/** 数据读取等待超时 */
	public static final int SOCKET_TIMEOUT = 10000;
	/** http */
	public static final String HTTP = "http";
	/** https */
	public static final String HTTPS = "https"; 
	/** http端口 */
	public static final int DEFAULT_HTTP_PORT = 80;
	/** https端口 */
	public static final int DEFAULT_HTTPS_PORT = 443;
	/** 默认编码 */
	public static final String DEFAULT_ENCODING = "UTF-8";
    
    /**
     * 构建请求配置对象
     */
    private static RequestConfig GetReqConfig() {
    	return RequestConfig.custom()
                .setConnectTimeout(CONNECTION_TIMEOUT)   //设置连接超时时间
                .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT) 	//设置请求超时时间
                .setSocketTimeout(SOCKET_TIMEOUT)
                .setRedirectsEnabled(true)	//默认允许自动重定向
                .build();
    }
    
    /**
     * 私用构造函数
     */
    private HttpRequestTools(){
    }
    /**
     * 私有静态类用于构建主类的单例对象
     * @author Rocye
     * @version 2019.09.16
     */
    private static class HttpRequestToolHolder{
        private static HttpRequestTools instance = new HttpRequestTools();
    }
    /**
     * 得到主类的单例对象
     * @return 主类对象
     */
    public static HttpRequestTools getInstance(){
        return HttpRequestToolHolder.instance;
    }
    
    /**
     * 创建新的主类对象
     * @return 主类对象
     */
    public static HttpRequestTools getNewInstance(){
        return new HttpRequestTools();
    }
    
    
    /**
     * 向指定URL发送GET方法的请求
     * @author Rocye
     * @param url 发送请求的URL
     * @param encoding 编码
     * @return 远程资源的响应结果
     * @version 2019.09.16
     */
    public String sendGet(String url, String encoding) {
        String result = "";
        if (StringUtils.isBlank(url)) {
			logger.warn("----->url为空");
			return result;
		}
        HttpGet httpGet = null;
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
        	RequestConfig requestConfig = GetReqConfig();
        	if (url.startsWith(HTTPS)) {
        		httpClient = createSSLInsecureClient();
        	}else {
        		httpClient = HttpClients.createDefault();
        	}
        	httpGet = new HttpGet(url);
			httpGet.setConfig(requestConfig);
			response = httpClient.execute(httpGet);
			result = handleResponse(url, encoding, response);
        }catch (IOException e) {
			logger.error("-----> url:" + url +",get报文请求异常:" + e.getMessage());
			e.printStackTrace();
		} finally {
			closeResource(httpClient, response);
		}
		return result;
    }
    
    /**
     * 向指定URL发送下载GET方法的请求，并保存文件到指定路径
     * @author Rocye
     * @param url 发送请求的URL
     * @param filePath 下载文件路径
     * @param fileName 下载文件名
     * @param encoding 编码
     * @return 返回文件名
     * @version 2019.09.16
     */
    public String downGet(String url, String filePath, String fileName, String encoding) {
    	String result = "";
    	if (StringUtils.isBlank(url)) {
			logger.warn("----->url为空");
			return result;
		}
        HttpGet httpGet = null;
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
        	RequestConfig requestConfig = GetReqConfig();
        	if (url.startsWith(HTTPS)) {
        		httpClient = createSSLInsecureClient();
        	}else {
        		httpClient = HttpClients.createDefault();
        	}
        	httpGet = new HttpGet(url);
			httpGet.setConfig(requestConfig);
			response = httpClient.execute(httpGet);
			result = handleResponse(url, filePath, fileName, encoding, response);
        }catch (IOException e) {
			logger.error("-----> url:" + url +",get下载请求异常:" + e.getMessage());
			e.printStackTrace();
		} finally {
			closeResource(httpClient, response);
		}
		return result;
    }
    
    /**
     * 向指定 URL 发送POST方法的请求
     * @author Rocye
     * @param url 发送请求的 URL
     * @param param 请求参数，微信接口一般是XML或JSON
     * @param format 请求参数格式(json,xml)
     * @param encoding 编码
     * @return 所代表远程资源的响应结果
     * @version 2019.09.16
     */
    public String sendPost(String url, String param, String format, String encoding) {
		String result = "";
        if (StringUtils.isBlank(url)) {
			logger.warn("----->url为空");
			return result;
		}
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
        	HttpPost httpPost = new HttpPost(url);
        	RequestConfig requestConfig = GetReqConfig();
        	httpPost.setConfig(requestConfig);
        	if (url.startsWith(HTTPS)) {
        		httpClient = createSSLInsecureClient();
        	}else {
        		httpClient = HttpClients.createDefault();
        	}
        	if(format.equals("json")) {
        		httpPost.setHeader("Content-type", "application/json");
        	}else if(format.equals("xml")) {
        		httpPost.setHeader("Content-type", "text/xml");
        	}
        	StringEntity stringEntity = new StringEntity(param.toString(), encoding);
	        httpPost.setEntity(stringEntity);
			response = httpClient.execute(httpPost);
			result = handleResponse(url, encoding, response);
        }catch (IOException e) {
			logger.error("-----> url:" + url +",post报文请求异常:" + e.getMessage());
			e.printStackTrace();
		} finally {
			closeResource(httpClient, response);
		}
		return result;
    }
    
    /**
     * 向指定URL发送下载POST方法的请求，并保存文件到指定路径
     * @author Rocye
     * @param url 发送请求的URL
     * @param param 请求参数
     * @param format 请求参数格式(json,xml)
     * @param filePath 下载文件路径
     * @param fileName 下载文件名
     * @param encoding 编码
     * @return 返回文件名
     * @version 2019.09.16
     */
    public String downPost(String url, String param, String filePath, String fileName, String format, String encoding) {
    	String result = "";
        if (StringUtils.isBlank(url)) {
			logger.warn("----->url为空");
			return result;
		}
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
        	HttpPost httpPost = new HttpPost(url);
        	RequestConfig requestConfig = GetReqConfig();
        	httpPost.setConfig(requestConfig);
        	if (url.startsWith(HTTPS)) {
        		httpClient = createSSLInsecureClient();
        	}else {
        		httpClient = HttpClients.createDefault();
        	}
        	if(format.equals("json")) {
        		httpPost.setHeader("Content-type", "application/json");
        	}else if(format.equals("xml")) {
        		httpPost.setHeader("Content-type", "text/xml");
        	}
        	StringEntity stringEntity = new StringEntity(param.toString(), encoding);
	        httpPost.setEntity(stringEntity);
			response = httpClient.execute(httpPost);
			result = handleResponse(url, filePath, fileName, encoding, response);
        }catch (IOException e) {
			logger.error("-----> url:" + url +",post下载请求异常:" + e.getMessage());
			e.printStackTrace();
		} finally {
			closeResource(httpClient, response);
		}
		return result;
    }

	/**
	 * 向指定 URL 发送上传POST方法的请求，上传多媒体文件
	 * @author Rocye
	 * @param url 发送请求的 URL
	 * @param file 要上传的文件
	 * @param encoding 编码
	 * @return 远程资源的响应结果
	 * @version 2019.09.16
	 */
	public String uploadPost(String url, File file, String encoding) {
		return uploadPost(url, "media", file, encoding);
	}
    
    /**
     * 向指定 URL 发送上传POST方法的请求，上传多媒体文件
     * @author Rocye
     * @param url 发送请求的 URL
     * @param file 要上传的文件
     * @param name 上传文件名字
     * @param encoding 编码
     * @return 远程资源的响应结果
     * @version 2019.09.16
     */
    public String uploadPost(String url, String name, File file, String encoding) {
    	String result = "";
        if (StringUtils.isBlank(url)) {
			logger.warn("----->url为空");
			return result;
		}
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
        	HttpPost httpPost = new HttpPost(url);
        	RequestConfig requestConfig = GetReqConfig();
        	httpPost.setConfig(requestConfig);
        	if (url.startsWith(HTTPS)) {
        		httpClient = createSSLInsecureClient();
        	}else {
        		httpClient = HttpClients.createDefault();
        	}
        	//把文件转换成流对象FileBody
        	FileBody fileBody = new FileBody(file);
        	HttpEntity reqEntity = MultipartEntityBuilder.create().addPart(name, fileBody).build();
	        httpPost.setEntity(reqEntity);
			response = httpClient.execute(httpPost);
			result = handleResponse(url, encoding, response);
        }catch (IOException e) {
			logger.error("-----> url:" + url +",post上传请求异常:" + e.getMessage());
			e.printStackTrace();
		} finally {
			closeResource(httpClient, response);
		}
		return result;
    }
    
    /**
     * 向指定 URL 发送上传POST方法的请求，上传多媒体文件及文本数据
     * @author Rocye
     * @param url 发送请求的 URL
     * @param file 文件参数
     * @param textParams 文本参数
     * @param encoding 编码
     * @return 所代表远程资源的响应结果
     * @version 2019.09.16
     */
    public String uploadPost(String url, String name, File file, Map<String, Object> textParams, String encoding) {
    	String result = "";
        if (StringUtils.isBlank(url)) {
			logger.warn("----->url为空");
			return result;
		}
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
        	HttpPost httpPost = new HttpPost(url);
        	RequestConfig requestConfig = GetReqConfig();
        	httpPost.setConfig(requestConfig);
        	if (url.startsWith(HTTPS)) {
        		httpClient = createSSLInsecureClient();
        	}else {
        		httpClient = HttpClients.createDefault();
        	}
        	//把文件转换成流对象FileBody
        	FileBody fileBody = new FileBody(file);
        	MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        	builder.addPart(name, fileBody);
        	if(textParams != null){
                Set<String> keySet = textParams.keySet();  
                for (Iterator<String> it = keySet.iterator(); it.hasNext(); ) {  
                    String key = it.next();  
                    String value = textParams.get(key).toString();
                    builder.addTextBody(key, value);
                }
            }
        	HttpEntity reqEntity = builder.build();
	        httpPost.setEntity(reqEntity);
			response = httpClient.execute(httpPost);
			result = handleResponse(url, encoding, response);
        }catch (IOException e) {
			logger.error("-----> url:" + url +",post上传请求异常:" + e.getMessage());
			e.printStackTrace();
		} finally {
			closeResource(httpClient, response);
		}
		return result;
    }

    /**
	 * 创建一个SSL信任所有证书的httpClient对象
	 * @version 2019.09.06
	 */
	public static CloseableHttpClient createSSLInsecureClient() {
		try {
			SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
				// 默认信任所有证书
				public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					return true;
				}
			}).build();
			SSLConnectionSocketFactory sslcsf = new SSLConnectionSocketFactory(sslContext);
			return HttpClients.custom().setSSLSocketFactory(sslcsf).build();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
		return HttpClients.createDefault();
	}
	
	/**
	 * 处理响应，获取响应报文
	 * @param url	请求链接
	 * @param encoding	编码
	 * @param response	返回对象
	 * @version 2019.09.06
	 */
	private static String handleResponse(String url, String encoding, CloseableHttpResponse response) {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
			if (response != null) {
				if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					// 获取响应实体
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						br = new BufferedReader(new InputStreamReader(entity.getContent(), encoding));
						String s = null;
						while ((s = br.readLine()) != null) {
							sb.append(s);
						}
					}
					// 释放entity
					EntityUtils.consume(entity);
				}else if (response.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_FOUND) {
					logger.warn("-----> Http请求报文时404,未找到资源. url:" + url);
				}else if (response.getStatusLine().getStatusCode() == HttpStatus.SC_INTERNAL_SERVER_ERROR) {
					logger.warn("-----> Http请求报文时500,服务器端异常. url:" + url);
				}
			}
		} catch (Exception e) {
			logger.error("----->url:" + url + ",处理响应，获取响应报文异常：" + e.getMessage());
			e.printStackTrace();
		}finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * 处理响应，获取响应文件信息
	 * @param url	请求链接
	 * @param encoding	编码
	 * @param response	返回对象
	 * @version 2019.09.06
	 */
	private static String handleResponse(String url, String filePath, String fileName, String encoding, CloseableHttpResponse response) {
		String result = null;
		try {
			if (response != null) {
				if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					// 获取响应实体
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						//写文件
			            result = FileIo.writeFile(entity.getContent(), filePath + fileName);
			            if(!result.equals("")){
			                String fileBody = FileIo.readText(filePath + fileName, encoding);
			                if(fileBody.contains("errcode")){
			                    result = fileBody;
			                }else{
			                    result = "{\"fileName\":\""+ result +"\"}";
			                }
			            }
					}
					// 释放entity
					EntityUtils.consume(entity);
				}else if (response.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_FOUND) {
					logger.warn("-----> Http请求下载时404,未找到资源. url:" + url);
				}else if (response.getStatusLine().getStatusCode() == HttpStatus.SC_INTERNAL_SERVER_ERROR) {
					logger.warn("-----> Http请求下载时500,服务器端异常. url:" + url);
				}
			}
		} catch (Exception e) {
			logger.error("----->url:" + url + ",处理响应，获取响应报文异常：" + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 释放资源
	 * @param httpClient 实例
	 * @param response	返回对象
	 * @version 2019.09.06
	 */
	private static void closeResource(CloseableHttpClient httpClient, CloseableHttpResponse response) {
		if (response != null) {
			try {
				response.close();
			} catch (IOException e) {
				logger.error("-----> 释放response资源异常:" + e.getMessage());
				e.printStackTrace();
			}
		}
		if (httpClient != null) {
			try {
				httpClient.close();
			} catch (Exception e) {
				logger.error("-----> 释放httpclient资源异常:" + e.getMessage());
				e.printStackTrace();
			}
		}
	}
}
