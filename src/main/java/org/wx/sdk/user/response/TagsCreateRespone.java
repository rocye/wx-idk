package org.wx.sdk.user.response;
import org.wx.sdk.base.Response;
import org.wx.sdk.user.object.Tag;

/**
 * <p>创建标签返回对象
 * <p><b>ErrorCode:</b>
 * <p>45157	标签名非法，请注意不能和其他标签重名
 * <p>45158	标签名长度超过30个字节
 * <p>45056	创建的标签数过多，请注意不能超过100个
 * @author Rocye
 * @version 2017-02-14
 */
public class TagsCreateRespone extends Response {
	private static final long serialVersionUID = -1257230749046425127L;
	
	/** 标签对象 */
	private Tag tag;

	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
    
}
