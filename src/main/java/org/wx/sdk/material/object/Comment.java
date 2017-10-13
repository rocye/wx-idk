package org.wx.sdk.material.object;

/**
 * 文章评论数据
 * @author Rocye
 * @version 2017.10.10
 */
public class Comment {
	/** 用户评论id */
	private Integer user_comment_id;
	/** openid */
	private String openid;
	/** 评论时间 */
	private String create_time;
	/** 评论内容 */
	private String content;
	/** 是否精选评论，0为即非精选，1为true，即精选 */
	private Short comment_type;
	/** 作者回复 */
	private Reply reply;
	
	public Integer getUser_comment_id() {
		return user_comment_id;
	}
	public void setUser_comment_id(Integer user_comment_id) {
		this.user_comment_id = user_comment_id;
	}
	
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Short getComment_type() {
		return comment_type;
	}
	public void setComment_type(Short comment_type) {
		this.comment_type = comment_type;
	}
	
	public Reply getReply() {
		return reply;
	}
	public void setReply(Reply reply) {
		this.reply = reply;
	}

}
