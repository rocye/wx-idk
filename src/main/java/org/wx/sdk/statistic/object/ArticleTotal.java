package org.wx.sdk.statistic.object;

import java.util.List;

/**
 * 图文群发总数据实体类
 * @author Rocye
 * @version 2017-09-29
 */
public class ArticleTotal {
	
	/** 数据的日期 */
    private String ref_date;
    /** 注意：这里的msgid实际上是由msgid（图文消息id，这也就是群发接口调用后返回的msg_data_id）和index（消息次序索引）组成， 例如12003_3， 
     *  其中12003是msgid，即一次群发的消息的id； 3为index，假设该次群发的图文消息共5个文章（因为可能为多图文），3表示5个中的第3个 */
    private String msgid;
    /** 图文消息的标题 */
    private String title;
    /** 图文页（点击群发图文卡片进入的页面）的阅读人数 */
    private List<ArticleDetails> details;
    
	public String getRef_date() {
		return ref_date;
	}
	public void setRef_date(String ref_date) {
		this.ref_date = ref_date;
	}
	
	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<ArticleDetails> getDetails() {
		return details;
	}
	public void setDetails(List<ArticleDetails> details) {
		this.details = details;
	}

}
