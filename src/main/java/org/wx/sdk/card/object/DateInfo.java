package org.wx.sdk.card.object;

/**
 * 使用日期，有效期的信息
 * @author Rocye
 * @version 2017.12.19
 */
public class DateInfo {
	/** 使用时间的类型，DATE_TYPE_FIX_TIME_RANGE表示固定日期区间，DATE_TYPE_FIX_TERM表示固定时长（自领取后按天算）。*/
	private String type;
	/** type为DATE_TYPE_FIX_TIME_RANGE时专用，表示起用时间。从1970年1月1日00:00:00至起用时间的秒数。*/
	private Long begin_timestamp;
	/** 可用于DATE_TYPE_FIX_TERM时间类型，表示卡券统一过期时间，建议设置为截止日期的23:59:59过期，
	 * 设置了fixed_term卡券，当时间达到end_timestamp时卡券统一过期。*/
	private Long end_timestamp;
	/** type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天内有效，不支持填写0。*/
	private Integer fixed_term;
	/** type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天开始生效，领取后当天生效填写0。（单位为天）*/
	private Integer fixed_begin_term;

	/**
	 * 构造器
	 * @param type			使用时间的类型，DATE_TYPE_FIX_TIME_RANGE表示固定日期区间，DATE_TYPE_FIX_TERM表示固定时长（自领取后按天算）
	 * @param beginTime		type为DATE_TYPE_FIX_TIME_RANGE时专用，表示起用时间。从1970年1月1日00:00:00至起用时间的秒数
	 * @param endTime		可用于DATE_TYPE_FIX_TERM时间类型，表示卡券统一过期时间，建议设置为截止日期的23:59:59过期
	 */
	public DateInfo(String type, Long beginTime, Long endTime) {
		this.type = type;
		this.begin_timestamp = beginTime;
		this.end_timestamp = endTime;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Long getBegin_timestamp() {
		return begin_timestamp;
	}
	public void setBegin_timestamp(Long begin_timestamp) {
		this.begin_timestamp = begin_timestamp;
	}

	public Long getEnd_timestamp() {
		return end_timestamp;
	}
	public void setEnd_timestamp(Long end_timestamp) {
		this.end_timestamp = end_timestamp;
	}

	public Integer getFixed_term() {
		return fixed_term;
	}
	public void setFixed_term(Integer fixed_term) {
		this.fixed_term = fixed_term;
	}

	public Integer getFixed_begin_term() {
		return fixed_begin_term;
	}
	public void setFixed_begin_term(Integer fixed_begin_term) {
		this.fixed_begin_term = fixed_begin_term;
	}

}
