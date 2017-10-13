package org.wx.sdk.statistic.response;

import java.util.List;
import org.wx.sdk.base.Response;
import org.wx.sdk.statistic.object.ArticleSummary;

/**
 * 获取图文群发每日数据返回对象
 * @author Rocye
 * @version 2017-09-29
 */
public class GetArticleSummaryRespone extends Response {
	private static final long serialVersionUID = 7129164811313755928L;
	
	private List<ArticleSummary> list;

	public List<ArticleSummary> getList() {
		return list;
	}
	public void setList(List<ArticleSummary> list) {
		this.list = list;
	}
    
}
