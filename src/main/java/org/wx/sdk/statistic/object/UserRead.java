package org.wx.sdk.statistic.object;

/**
 * 图文统计数据实体类
 * @author Rocye
 * @version 2017-09-29
 */
public class UserRead {
	
	/** 数据的日期 */
    private String ref_date;
    /** 图文页（点击群发图文卡片进入的页面）的阅读人数 */
    private Integer int_page_read_user;
    /** 图文页的阅读次数 */
    private Integer int_page_read_count;
    /** 原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0 */
    private Integer ori_page_read_user;
    /** 原文页的阅读次数 */
    private Integer ori_page_read_count;
    /** 分享的场景 1代表好友转发 2代表朋友圈 3代表腾讯微博 255代表其他 */
    private Integer share_user;
    /** 分享的次数 */
    private Integer share_count;
    /** 收藏的人数 */
    private Integer add_to_fav_user;
    /** 收藏的次数 */
    private Integer add_to_fav_count;
    
	public String getRef_date() {
		return ref_date;
	}
	public void setRef_date(String ref_date) {
		this.ref_date = ref_date;
	}
	
	public Integer getInt_page_read_user() {
		return int_page_read_user;
	}
	public void setInt_page_read_user(Integer int_page_read_user) {
		this.int_page_read_user = int_page_read_user;
	}
	
	public Integer getInt_page_read_count() {
		return int_page_read_count;
	}
	public void setInt_page_read_count(Integer int_page_read_count) {
		this.int_page_read_count = int_page_read_count;
	}
	
	public Integer getOri_page_read_user() {
		return ori_page_read_user;
	}
	public void setOri_page_read_user(Integer ori_page_read_user) {
		this.ori_page_read_user = ori_page_read_user;
	}
	
	public Integer getOri_page_read_count() {
		return ori_page_read_count;
	}
	public void setOri_page_read_count(Integer ori_page_read_count) {
		this.ori_page_read_count = ori_page_read_count;
	}
	
	public Integer getShare_user() {
		return share_user;
	}
	public void setShare_user(Integer share_user) {
		this.share_user = share_user;
	}
	
	public Integer getShare_count() {
		return share_count;
	}
	public void setShare_count(Integer share_count) {
		this.share_count = share_count;
	}
	
	public Integer getAdd_to_fav_user() {
		return add_to_fav_user;
	}
	public void setAdd_to_fav_user(Integer add_to_fav_user) {
		this.add_to_fav_user = add_to_fav_user;
	}
	
	public Integer getAdd_to_fav_count() {
		return add_to_fav_count;
	}
	public void setAdd_to_fav_count(Integer add_to_fav_count) {
		this.add_to_fav_count = add_to_fav_count;
	}

}
