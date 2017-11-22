package org.wx.pay.mode.response;

import org.wx.pay.base.Response;

/**
 * 下载对账单返回对象
 * @author Rocye
 * @version 2017.11.20
 */
public class DownloadBillRespone extends Response {
	/** 下载的文件名 */
	private String fileName;

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
