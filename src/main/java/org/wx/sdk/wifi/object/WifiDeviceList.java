package org.wx.sdk.wifi.object;

import java.util.List;

/**
 * WIFI设备列表数据
 * @author Rocye
 * @version 2017.11.01
 */
public class WifiDeviceList {
    /** 总数 */
    private Integer totalcount;
	/** 分页下标 */
    private Integer pageindex;
    /** 分页页数 */
    private Integer pagecount;
    /** 当前页列表数组 */
    private List<WifiDevice> records;

	public Integer getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(Integer totalcount) {
		this.totalcount = totalcount;
	}

	public Integer getPageindex() {
		return pageindex;
	}
	public void setPageindex(Integer pageindex) {
		this.pageindex = pageindex;
	}

	public Integer getPagecount() {
		return pagecount;
	}
	public void setPagecount(Integer pagecount) {
		this.pagecount = pagecount;
	}

	public List<WifiDevice> getRecords() {
		return records;
	}
	public void setRecords(List<WifiDevice> records) {
		this.records = records;
	}

}
