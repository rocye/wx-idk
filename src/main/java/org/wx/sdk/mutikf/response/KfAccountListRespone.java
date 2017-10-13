package org.wx.sdk.mutikf.response;

import java.util.List;

import org.wx.sdk.base.Response;
import org.wx.sdk.mutikf.object.KfObj;

/**
 * 获取客服基本信息列表的返回对象
 * @author Rocye
 * @version 2016-08-02
 */
public class KfAccountListRespone extends Response {
    private static final long serialVersionUID = 1652292105261769833L;
    
    /** 客服基本信息列表 */
    private List<KfObj> kf_list;

    public List<KfObj> getKf_list() {
        return kf_list;
    }
    public void setKf_list(List<KfObj> kfList) {
        kf_list = kfList;
    }
    
    
}
