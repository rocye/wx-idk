package org.wx.sdk.sendmsg.response;

import org.wx.sdk.base.Response;

/**
 * 获取群发速度接口返回对象
 * @author Rocye
 * @version 2017.10.20
 */
public class MassSpeedGetRespone extends Response {

	/** 群发速度的级别 */
	private Integer speed;
	/** 群发速度的真实值(单位：万/分钟) */
	private Integer realspeed;

	public Integer getSpeed() {
		return speed;
	}
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public Integer getRealspeed() {
		return realspeed;
	}
	public void setRealspeed(Integer realspeed) {
		this.realspeed = realspeed;
	}

}
