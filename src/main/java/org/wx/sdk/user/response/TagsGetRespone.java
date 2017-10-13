package org.wx.sdk.user.response;

import java.util.List;
import org.wx.sdk.base.Response;
import org.wx.sdk.user.object.Tag;

/**
 * 获取公众号已创建的标签返回对象
 * @author Rocye
 * @version 2017-02-14
 */
public class TagsGetRespone extends Response {
	private static final long serialVersionUID = 916177875771547835L;
	
	/** 标签对象列表 */
	private List<Tag> tags;

	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
    
}
