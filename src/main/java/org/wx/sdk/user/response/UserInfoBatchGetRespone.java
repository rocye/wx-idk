package org.wx.sdk.user.response;

import java.util.List;

import org.wx.sdk.base.Response;
import org.wx.sdk.user.object.UserInfo;

/**
 * 批量获取用户基本信息返回对象
 * @author Rocye
 * @version 2016-10-27
 */
public class UserInfoBatchGetRespone extends Response {
    private static final long serialVersionUID = 3361752629075008055L;
    
    /** 用户信息列表 */
    private List<UserInfo> user_info_list;

    public List<UserInfo> getUser_info_list() {
        return user_info_list;
    }
    public void setUser_info_list(List<UserInfo> userInfoList) {
        user_info_list = userInfoList;
    }
    
}
