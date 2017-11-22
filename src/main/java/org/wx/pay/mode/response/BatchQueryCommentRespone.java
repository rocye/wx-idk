package org.wx.pay.mode.response;

import org.wx.pay.base.Response;

/**
 * 拉取订单评价数据返回对象
 * @author Rocye
 * @version 2017.11.21
 */
public class BatchQueryCommentRespone extends Response {
	/** 下载的文件名 */
	private String fileName;

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
