package org.wx.sdk.generalize.response;

import org.wx.sdk.base.Response;

/**
 * 通过ticket换取二维码返回对象
 * @author Rocye
 * @version 2017-08-23
 */
public class ShowQrcodeRespone extends Response {

	/** 下载的文件名 */
    private String fileName;

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
}
