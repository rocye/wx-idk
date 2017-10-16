package org.wx.sdk.poi.object;

/**
 * 门店业务数据
 * @author Rocye
 * @version 2017.10.16
 */
public class Business {
    private Poi base_info;

    public Business(Poi base_info) {
        this.base_info = base_info;
    }

    public Poi getBase_info() {
        return base_info;
    }
    public void setBase_info(Poi base_info) {
        this.base_info = base_info;
    }
}
