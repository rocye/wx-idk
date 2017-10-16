package org.wx.sdk.user.response;

import org.wx.sdk.base.Response;
import org.wx.sdk.user.object.OpenidList;

/**
 * 获取用户列表返回对象
 * @author Rocye
 * @version 2016-10-27
 */
public class UserListGetRespone extends Response {

    /** 关注该公众账号的总用户数 */
    private Integer total;
    /** 拉取的OPENID个数，最大值为10000 */
    private Integer count;
    /** 列表数据，OPENID的列表 */
    private OpenidList data;
    /** 拉取列表的最后一个用户的OPENID */
    private String next_openid;
    
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
    
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    
    public OpenidList getData() {
        return data;
    }
    public void setData(OpenidList data) {
        this.data = data;
    }
    
    public String getNext_openid() {
        return next_openid;
    }
    public void setNext_openid(String nextOpenid) {
        next_openid = nextOpenid;
    }
    
}
