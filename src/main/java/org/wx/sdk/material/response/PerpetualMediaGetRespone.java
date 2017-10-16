package org.wx.sdk.material.response;

import org.wx.sdk.base.Response;

/**
 * 获取永久图片、缩略图、音频素材返回对象
 * @author Rocye
 * @version 2016-04-12
 */
public class PerpetualMediaGetRespone extends Response {

    /** 下载的文件名 */
    private String fileName;

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
}
