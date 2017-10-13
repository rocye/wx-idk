package org.wx.sdk.user.response;

import org.wx.sdk.base.Response;
import org.wx.sdk.user.object.OpenidList;

/**
 * <p>获取标签下粉丝列表返回对象
 * <p><b>ErrorCode:</b>
 * <p>40003	传入非法的openid
 * <p>45159	非法的tag_id
 * @author Rocye
 * @version 2017-02-14
 */
public class TagUserListGetRespone extends Response {
	private static final long serialVersionUID = -4454688818730130307L;
	
	/** 获取的粉丝数量 */
    private Integer count;
    /** 列表数据，OPENID的列表 */
    private OpenidList data;
    /** 拉取列表的最后一个用户的OPENID */
    private String next_openid;
    
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
