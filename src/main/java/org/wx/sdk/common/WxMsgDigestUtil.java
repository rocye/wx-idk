package org.wx.sdk.common;

import java.security.*;

/**
 * SHA1 水印算法工具类
 */
public final class WxMsgDigestUtil {
	/** 单例对象 */
    private static final WxMsgDigestUtil _instance = new WxMsgDigestUtil();
    /** 算法对象 */
    private MessageDigest alga;
    
    /**
     * 私有构造函数
     * @author Rocye
     */
    private WxMsgDigestUtil() {
        try {
            alga = MessageDigest.getInstance("SHA-1");
        } catch(Exception e) {
            throw new InternalError("init MessageDigest error:" + e.getMessage());
        }
    }

    /**
     * 获取单例对象
     * @return 单例对象
     */
    public static WxMsgDigestUtil getInstance() {
        return _instance;
    }

    /**
	 * 二进制转十六进制字符串
	 * @param b 二进制数据
	 * @return 十六进制串
	 */
    public static String byte2hex(byte[] b) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < b.length; i++) {
            tmp = (Integer.toHexString(b[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }
    
    /**
     * 算法编码
     * @param strSrc 编码字符串
     * @return 编码后的字串
     */
    public String encipher(String strSrc) {
        String strDes = null;
        byte[] bt = strSrc.getBytes();
        alga.update(bt);
        strDes = byte2hex(alga.digest()); //to HexString
        return strDes;
    }

    /*
    public static void main(String[] args) {
        String signature="75d7cabf1e2e86170d01649eb62c05418e4a05a7";
        String timestamp="1382327000";
        String nonce="1382912165";
        
        String[] ArrTmp = { "WXMedia", timestamp, nonce };
        Arrays.sort(ArrTmp);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ArrTmp.length; i++) {
            sb.append(ArrTmp[i]);
        }
        String pwd = WxMsgDigestUtil.getInstance().encipher(sb.toString());
        System.out.println(pwd);
        if (signature.equals(pwd)) {
            System.out.println("token 验证成功~!");
        }else {
            System.out.println("token 验证失败~!");
        }
    }
    */

}
