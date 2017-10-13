package org.wx.sdk.base.request;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.apache.log4j.Logger;
import org.wx.sdk.common.FileIo;

/**
 * Http/Https请求工具类(高并发下的延迟加载单例模式)
 * @author Rocye
 * @version 2016-11-24
 */
public class HttpRequestTools {
	/** 日志对象 */
    private final static Logger logger = Logger.getLogger(HttpRequestTools.class.getName());
    /** 连接超时时间(单位毫秒) */
    private int connectTimeout = 5000;
    /** 读取超时时间(单位毫秒) */
    private int readTimeout = 5000;
    
    /**
     * 私用构造函数
     */
    private HttpRequestTools(){
    }
    /**
     * 私有静态类用于构建主类的单例对象
     * @author Rocye
     * @version 2016-11-24
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
     * 创建Http/Https请求对象
     * @author Rocye
     * @param url 请求地址
     * @param method 请求方式：GET/POST
     * @param useHttps 是否https请求
     * @return Http连接
     * @throws Exception 任何异常 
     * @version 2016-03-31
     */
    private HttpURLConnection createRequest(String url, String method, boolean useHttps) throws Exception{
        if(useHttps){
            trustAllHttpsCertificates();
            HttpsURLConnection.setDefaultHostnameVerifier(hv);
        }
        URL realUrl = new URL(url);
        // 打开和URL之间的连接
        HttpURLConnection connection = (HttpURLConnection)realUrl.openConnection();
        // 设置通用的请求属性
        connection.setRequestProperty("Accept", "*/*");
        connection.setRequestProperty("Accept-Encoding", "gzip,deflate");
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
     * @param useHttps 是否https请求
     * @return 远程资源的响应结果
     * @version 2016-03-31
     */
    public String sendGet(String url, boolean useHttps) {
        String result = "";
        BufferedReader in = null;
        try {
            HttpURLConnection connection = createRequest(url, "GET", useHttps);
            // 建立实际的连接
            connection.connect();
            /*
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            */
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
     * 向指定URL发送下载GET方法的请求，并保存文件到指定路径
     * @author Rocye
     * @param url 发送请求的URL
     * @param filePath 下载文件路径
     * @param fileName 下载文件名
     * @param useHttps 是否https请求
     * @return 返回文件名
     * @version 2016-03-31
     */
    public String downGet(String url, String filePath, String fileName, boolean useHttps) {
        String result = "";
        BufferedReader in = null;
        try {
            HttpURLConnection connection = createRequest(url, "GET", useHttps);
            // 建立实际的连接
            connection.connect();
            //写文件
            result = FileIo.writeFile(connection.getInputStream(), filePath + fileName);
            if(!result.equals("")){
                String fileBody = FileIo.readText(filePath + fileName, "UTF-8");
                if(fileBody.contains("errcode")){
                    result = fileBody;
                }else{
                    result = "{\"fileName\":\""+ result +"\"}";
                }
            }
        }catch (MalformedURLException e) {
            logger.error("发送下载GET请求出现异常: " + e);
            e.printStackTrace();
        } catch (Exception e) {
            logger.error("发送下载GET请求出现异常: " + e);
            e.printStackTrace();
        }
        //使用finally块来关闭输入流
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
     * @param param 请求参数，微信接口一般是XML或JSON
     * @param useHttps 是否https请求
     * @return 所代表远程资源的响应结果
     * @version 2016-03-31
     */
    public String sendPost(String url, String param, boolean useHttps) {
        OutputStream out = null;
        BufferedReader in = null;
        String result = "";
        try {
            HttpURLConnection connection = createRequest(url, "POST", useHttps);
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
                result += line;
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
     * @param param 请求参数，应该是 {@code name1=value1&name2=value2}的形式。
     * @param filePath 下载文件路径
     * @param fileName 下载文件名
     * @param useHttps 是否https请求
     * @return 返回文件名
     * @version 2016-03-31
     */
    public String downPost(String url, String param, String filePath, String fileName, boolean useHttps) {
        OutputStream out = null;
        String result = "";
        try {
            HttpURLConnection connection = createRequest(url, "POST", useHttps);
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
                if(fileBody.contains("errcode")){
                    result = fileBody;
                }else{
                    result = "{\"fileName\":\""+ result +"\"}";
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
    
    /**
     * 向指定 URL 发送上传POST方法的请求，上传多媒体文件
     * @author Rocye
     * @param url 发送请求的 URL
     * @param file 要上传的文件
     * @param useHttps 是否https请求
     * @return 远程资源的响应结果
     * @version 2016-03-31
     */
    public String uploadPost(String url, File file, boolean useHttps) {
        OutputStream out = null;
        DataInputStream in = null;
        String result = null;
        try {
            HttpURLConnection connection = createRequest(url, "POST", useHttps);
            // 设置边界
            String BOUNDARY = "----------" + System.currentTimeMillis();
            connection.setRequestProperty("content-type", "multipart/form-data; boundary=" + BOUNDARY);
            
            // 第一部分：
            StringBuilder sb = new StringBuilder();
            sb.append("--"); // ////////必须多两道线
            sb.append(BOUNDARY);
            sb.append("\r\n");
            sb.append("Content-Disposition: form-data;name=\"media\";filename=\"" + file.getName() + "\"\r\n");
            sb.append("Content-Type:application/octet-stream\r\n\r\n");
            byte[] head = sb.toString().getBytes("utf-8");
            // 获得输出流
            out = new DataOutputStream(connection.getOutputStream());
            out.write(head);
            
            // 文件正文部分
            in = new DataInputStream(new FileInputStream(file));
            int bytes = 0;
            byte[] bufferOut = new byte[1024];
            while ((bytes = in.read(bufferOut)) != -1) {
                out.write(bufferOut, 0, bytes);
            }
            in.close();
            // 结尾部分
            byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("UTF-8");   // 定义最后数据分隔线
            out.write(foot);
            out.flush();
            out.close();
            
            //读取服务器响应，必须读取,否则提交不成功
            //conn.getResponseCode();  或下面
            // 定义BufferedReader输入流来读取URL的响应
            StringBuffer buffer = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            result = buffer.toString();
        } catch (Exception e) {
            logger.error("发送上传POST请求出现异常: " + e);
            e.printStackTrace();
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
     * 向指定 URL 发送上传POST方法的请求，上传多媒体文件及文本数据
     * @author Rocye
     * @param url 发送请求的 URL
     * @param file 文件参数
     * @param textParams 文本参数
     * @param useHttps 是否https请求
     * @return 所代表远程资源的响应结果
     * @version 2016-03-31
     */
    public String uploadPost(String url, File file, Map<String, Object> textParams, boolean useHttps) {
        OutputStream out = null;
        DataInputStream in = null;
        String result = null;
        try {
            HttpURLConnection connection = createRequest(url, "POST", useHttps);
            
            // 设置边界
            String BOUNDARY = "----------" + System.currentTimeMillis();
            connection.setRequestProperty("content-type", "multipart/form-data; boundary=" + BOUNDARY);
            
            // 第一部分：
            StringBuilder sb = new StringBuilder();
            sb.append("--"); // ////////必须多两道线
            sb.append(BOUNDARY);
            sb.append("\r\n");
            sb.append("Content-Disposition: form-data;name=\"media\";filename=\"" + file.getName() + "\"\r\n");
            sb.append("Content-Type:application/octet-stream\r\n\r\n");
            byte[] head = sb.toString().getBytes("utf-8");
            // 获得输出流
            out = new DataOutputStream(connection.getOutputStream());
            out.write(head);
            
            // 文件正文部分
            in = new DataInputStream(new FileInputStream(file));
            int bytes = 0;
            byte[] bufferOut = new byte[1024];
            while ((bytes = in.read(bufferOut)) != -1) {
                out.write(bufferOut, 0, bytes);
            }
            in.close();
            
            // 第二部分：
            if(textParams != null){
                Set<String> keySet = textParams.keySet();  
                for (Iterator<String> it = keySet.iterator(); it.hasNext();) {  
                    String name = it.next();  
                    String value = textParams.get(name).toString();
                    out.write(("--" + BOUNDARY + "\r\n").getBytes());  
                    out.write(("Content-Disposition: form-data; name=\"" + name + "\"\r\n").getBytes("UTF-8"));  
                    out.write("\r\n".getBytes());  
                    out.write((value + "\r\n").getBytes("UTF-8"));  
                }
            }
            
            // 结尾部分
            byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("UTF-8");   // 定义最后数据分隔线
            out.write(foot);
            out.flush();
            out.close();
            
            //读取服务器响应，必须读取,否则提交不成功
            //conn.getResponseCode();  或下面 
            // 定义BufferedReader输入流来读取URL的响应
            StringBuffer buffer = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            result = buffer.toString();
        } catch (Exception e) {
            logger.error("发送上传POST请求出现异常: " + e);
            e.printStackTrace();
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

    ////////////////////////////////////////////HTTPS安全相关代码//////////////////////////////////////////////////////
    private static HostnameVerifier hv = new HostnameVerifier() {
        public boolean verify(String urlHostName, SSLSession session) {
            System.out.println("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
            return true;
        }
    };

    private static void trustAllHttpsCertificates() throws Exception {
        // Create a trust manager that does not validate certificate chains:
        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
        javax.net.ssl.TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }

    public static class miTM implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }
        public boolean isServerTrusted(java.security.cert.X509Certificate[] certs) {
            return true;
        }
        public boolean isClientTrusted(java.security.cert.X509Certificate[] certs) {
            return true;
        }
        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) throws java.security.cert.CertificateException {
            return;
        }
        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) throws java.security.cert.CertificateException {
            return;
        }
    }
    
    private static final int RADIX = 16;
    /**
     * Safe characters for x-www-form-urlencoded data, as per java.net.URLEncoder and browser behaviour,
     * i.e. alphanumeric plus {@code "-", "_", ".", "*"}
     */
    private static final BitSet URLENCODER   = new BitSet(256);
    
    private static String urlEncode(final String content, final Charset charset, final BitSet safechars, final boolean blankAsPlus) {
        if (content == null) {
            return null;
        }
        final StringBuilder buf = new StringBuilder();
        final ByteBuffer bb = charset.encode(content);
        while (bb.hasRemaining()) {
            final int b = bb.get() & 0xff;
            if (safechars.get(b)) {
                buf.append((char) b);
            } else if (blankAsPlus && b == ' ') {
                buf.append('+');
            } else {
                buf.append("%");
                final char hex1 = Character.toUpperCase(Character.forDigit((b >> 4) & 0xF, RADIX));
                final char hex2 = Character.toUpperCase(Character.forDigit(b & 0xF, RADIX));
                buf.append(hex1);
                buf.append(hex2);
            }
        }
        return buf.toString();
    }
    
    @SuppressWarnings("unused")
	private static String encodeFormFields(final String content, final String charset) {
        if (content == null) {
            return null;
        }
        return urlEncode(content, charset != null ? Charset.forName(charset) : Charset.forName("UTF-8"), URLENCODER, true);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
