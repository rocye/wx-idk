package org.wx.pay.base;

import org.apache.log4j.Logger;
import org.wx.sdk.common.FileIo;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;

/**
 * Https(带证书)请求工具类(高并发下的延迟加载单例模式)
 * @author Rocye
 * @version 2017.11.14
 */
public class HttpsRequestTools {
	/** 日志对象 */
    private final static Logger logger = Logger.getLogger(HttpsRequestTools.class.getName());
    /** 连接超时时间(单位毫秒) */
    private int connectTimeout = 5000;
    /** 读取超时时间(单位毫秒) */
    private int readTimeout = 5000;

    /**
     * 私用构造函数
     */
    private HttpsRequestTools(){
    }
    /**
     * 私有静态类用于构建主类的单例对象
     * @author Rocye
     * @version 2016-11-24
     */
    private static class HttpsRequestToolHolder{
        private static HttpsRequestTools instance = new HttpsRequestTools();
    }
    /**
     * 得到主类的单例对象
     * @return 主类对象
     */
    public static HttpsRequestTools getInstance(){
        return HttpsRequestToolHolder.instance;
    }

    /**
     * 创建新的主类对象
     * @return 主类对象
     */
    public static HttpsRequestTools getNewInstance(){
        return new HttpsRequestTools();
    }

    /**
     * 创建Http/Https请求对象
     * @author Rocye
     * @param url 请求地址
     * @param method 请求方式：GET/POST
     * @param certPath 证书路径
     * @param certPass 证书密码
	 * @param useCert 是否需要证书
     * @return Https连接
     * @throws Exception 任何异常
     * @version 2017.11.14
     */
    private HttpsURLConnection createRequest(String url, String method, String certPath, String certPass, boolean useCert) throws Exception{
        URL realUrl = new URL(url);
        HttpsURLConnection connection = (HttpsURLConnection)realUrl.openConnection();

        //设置证书
		if(useCert){
			KeyStore clientStore = KeyStore.getInstance("PKCS12");
			InputStream inputStream = new FileInputStream(certPath);
			clientStore.load(inputStream, certPass.toCharArray());
			KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			kmf.init(clientStore, certPass.toCharArray());
			KeyManager[] kms = kmf.getKeyManagers();
			SSLContext sslContext = SSLContext.getInstance("TLSv1");
			sslContext.init(kms, null, new SecureRandom());
			connection.setSSLSocketFactory(sslContext.getSocketFactory());
		}

        // 设置通用的请求属性
        connection.setRequestProperty("Accept", "*/*");
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setConnectTimeout(this.connectTimeout);
        connection.setReadTimeout(this.readTimeout);
        if("POST".equals(method)){
            // 发送POST请求必须设置如下两行
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);   // 忽略缓存
            connection.setRequestMethod("POST");
        }
        return connection;
    }

    /**
     * 向指定URL发送GET方法的请求
     * @author Rocye
     * @param url 发送请求的URL
     * @param useCert 是否需要证书
	 * @param certPath 证书路径
	 * @param certPass 证书密码
     * @return 远程资源的响应结果
     * @version 2017.11.14
     */
    public String sendGet(String url, boolean useCert, String certPath, String certPass) {
        String result = "";
        BufferedReader in = null;
        try {
            HttpURLConnection connection = createRequest(url, "GET", certPath, certPass, useCert);
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        }catch (Exception e) {
            logger.error("发送普通GET请求出现异常: " + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * @author Rocye
     * @param url 发送请求的 URL
	 * @param useCert 是否需要证书
     * @param param 请求参数，微信接口一般是XML或JSON
     * @param certPath 证书路径
	 * @param certPass 证书密码
     * @return 所代表远程资源的响应结果
     * @version 2017.11.14
     */
    public String sendPost(String url, boolean useCert, String param, String certPath, String certPass) {
        OutputStream out = null;
        BufferedReader in = null;
        String result = "";
        try {
            HttpURLConnection connection = createRequest(url, "POST", certPath, certPass, useCert);
            // 获取URLConnection对象对应的输出流
            out = connection.getOutputStream();
            // 发送请求参数
            out.write(param.getBytes("UTF-8"));
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += (line + "\r\n");
            }
        } catch (Exception e) {
            logger.error("发送POST请求出现异常: " + e);
            System.out.println(e.toString());
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

	/**
	 * 向指定URL发送下载POST方法的请求，并保存文件到指定路径
	 * @author Rocye
	 * @param url 发送请求的URL
	 * @param param 请求参数，微信接口一般是XML或JSON
	 * @param filePath 下载文件路径
	 * @param fileName 下载文件名
	 * @param useCert 是否需要证书
	 * @param certPath 证书路径
	 * @param certPass 证书密码
	 * @return 返回文件名
	 * @version 2017.11.20
	 */
	public String downPost(String url, String param, String filePath, String fileName, boolean useCert, String certPath, String certPass) {
		OutputStream out = null;
		String result = "";
		try {
			HttpURLConnection connection = createRequest(url, "POST", certPath, certPass, useCert);
			// 获取URLConnection对象对应的输出流
			out = connection.getOutputStream();
			// 发送请求参数
			out.write(param.getBytes("UTF-8"));
			// flush输出流的缓冲
			out.flush();
			//写文件
			result = FileIo.writeFile(connection.getInputStream(), filePath + fileName);
			if(!result.equals("")){
				String fileBody = FileIo.readText(filePath + fileName, "UTF-8");
				if(fileBody.contains("return_code")){
					result = fileBody;
				}else{
					result = "<xml><return_code><![CDATA[SUCCESS]]></return_code><result_code><![CDATA[SUCCESS]]></result_code><fileName><![CDATA["+ result +"]]></fileName></xml>";
				}
			}
		} catch (Exception e) {
			logger.error("发送下载POST请求出现异常: " + e);
			e.printStackTrace();
		}
		//使用finally块来关闭输出流、输入流
		finally{
			try{
				if(out != null){
					out.close();
				}
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
		return result;
	}

}
