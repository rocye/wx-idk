package org.wx.sdk.statistic.response;

import java.util.List;
import org.wx.sdk.base.Response;
import org.wx.sdk.statistic.object.ArticleTotal;

/**
 * 获取图文群发总数据返回对象
 * @author Rocye
 * @version 2017-09-29
 */
public class GetArticleTotalRespone extends Response {
	private static final long serialVersionUID = -789410012914879208L;
	
	private List<ArticleTotal> list;

	public List<ArticleTotal> getList() {
		return list;
	}
	public void setList(List<ArticleTotal> list) {
		this.list = list;
	}
    
}
