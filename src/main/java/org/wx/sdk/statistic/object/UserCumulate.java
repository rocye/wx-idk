package org.wx.sdk.statistic.object;

/**
 * 累计用户数据实体类
 * @author Rocye
 * @version 2017-09-25
 */
public class UserCumulate {
	
	/** 数据的日期 */
    private String ref_date;
    /** 总用户量 */
    private Long cumulate_user;
    
	public String getRef_date() {
		return ref_date;
	}
	public void setRef_date(String ref_date) {
		this.ref_date = ref_date;
	}
	
	public Long getCumulate_user() {
		return cumulate_user;
	}
	public void setCumulate_user(Long cumulate_user) {
		this.cumulate_user = cumulate_user;
	}

}
