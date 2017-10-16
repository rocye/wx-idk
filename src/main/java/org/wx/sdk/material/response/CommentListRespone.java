package org.wx.sdk.material.response;

import java.util.List;

import org.wx.sdk.base.Response;
import org.wx.sdk.material.object.Comment;

/**
 * 查看指定文章的评论数据返回对象
 * @author Rocye
 * @version 2017.10.10
 */
public class CommentListRespone extends Response {

	/** 总数，非comment的size */
	private Integer total;
	/** 文章的评论列表 */
	private List<Comment> comment;
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	public List<Comment> getComment() {
		return comment;
	}
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	
}
