package org.wx.sdk.mutikf.response;

import java.util.List;
import org.wx.sdk.base.Response;
import org.wx.sdk.mutikf.object.KfOnline;

/**
 * 获取客服基本信息列表的返回对象
 * @author Rocye
 * @version 2016-08-09
 */
public class KfAccountOnlineListRespone extends Response {

    /** 在线客服基本信息列表 */
    private List<KfOnline> kf_online_list;

    public List<KfOnline> getKf_online_list() {
        return kf_online_list;
    }
    public void setKf_online_list(List<KfOnline> kfOnlineList) {
        kf_online_list = kfOnlineList;
    }
    
}
