package org.wx.sdk.base.response;

import java.util.List;

import org.wx.sdk.base.Response;

/**
 * 微信服务器IP地址列表返回对象
 * @author Rocye
 * @version 2016-03-31
 */
public class IpListGetRespone extends Response {

    /** 微信服务器IP地址列表 */
    private List<String> ip_list;

    public List<String> getIp_list() {
        return ip_list;
    }
    public void setIp_list(List<String> ipList) {
        ip_list = ipList;
    }

}
