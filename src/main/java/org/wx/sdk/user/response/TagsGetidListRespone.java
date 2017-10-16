package org.wx.sdk.user.response;

import java.util.List;

import org.wx.sdk.base.Response;

/**
 * <p>获取用户身上的标签列表返回对象
 * <p><b>ErrorCode:</b>
 * <p>40003	传入非法的openid
 * <p>49003	传入的openid不属于此AppID
 * @author Rocye
 * @version 2017-02-14
 */
public class TagsGetidListRespone extends Response {

	/** 标签ID列表 */
	private List<Integer> tagid_list;

	public List<Integer> getTagid_list() {
		return tagid_list;
	}
	public void setTagid_list(List<Integer> tagid_list) {
		this.tagid_list = tagid_list;
	}
    
}
