package org.wx.sdk.webdev.response;

import org.wx.sdk.base.Response;

/**
 * 第四步：拉取用户信息(需scope为 snsapi_userinfo) 返回对象
 * @author Rocye
 * @version 2017.10.24
 */
public class UserInfoRespone extends Response {

	/** 用户的唯一标识 */
	private String openid;
	/** 用户的昵称 */
	private String nickname;
	/** 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知 */
	private Integer sex;
	/** 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效 */
	private String headimgurl;
	/** 用户所在国家 */
	private String country;
	/** 用户个人资料填写的省份 */
	private String province;
	/** 普通用户个人资料填写的城市 */
	private String city;
	/** 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom） */
	private String[] privilege;
	/** 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段 */
	private String unionid;

	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public String[] getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String[] privilege) {
		this.privilege = privilege;
	}
    
}
