package org.wx.sdk.material.response;

import org.wx.sdk.base.Response;

/**
 * 新增临时素材返回对象
 * @author Rocye
 * @version 2016-04-08
 */
public class TempMaterialGetRespone extends Response {

    /** 下载的文件名 */
    private String fileName;

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
}
