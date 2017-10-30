package org.wx.sdk.wifi.object;

import java.util.List;

/**
 * WIFI门店列表数据
 * @author Rocye
 * @version 2017.10.28
 */
public class WifiShopList {
    /** 总数 */
    private Integer totalcount;
	/** 分页下标 */
    private Integer pageindex;
    /** 分页页数 */
    private Integer pagecount;
    /** 当前页列表数组 */
    private List<WifiShop> records;

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

	public List<WifiShop> getRecords() {
		return records;
	}
	public void setRecords(List<WifiShop> records) {
		this.records = records;
	}

}
