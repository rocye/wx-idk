package org.wx.sdk.material;

import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.token.RedisAccessToken;
import org.wx.sdk.material.request.TempMaterialAddRequest;
import org.wx.sdk.material.request.TempMaterialGetRequest;
import org.wx.sdk.material.response.TempMaterialAddRespone;
import org.wx.sdk.material.response.TempMaterialGetRespone;

public class TempMaterialReqTest {

    /**
     * 测试添加媒体临时素材
     */
    @Test
    public void testTempMediaAddReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        
        int typ = 1;
        String type = "image";
        String filePath = "D:\\Rocye\\Pictures\\325ac5f7da3c46652e5398f4cb223292.jpg";
        if(typ == 2){
            type = "voice";
            filePath = "D:\\Rocye\\Pictures\\1444288195077.mp3";
        }else if(typ == 3){
            type = "video";
            filePath = "D:\\Rocye\\Pictures\\20140423162603.mp4";
        }else if(typ == 4){
            type = "thumb";
            filePath = "D:\\Rocye\\Pictures\\3.JPG";
        }
        TempMaterialAddRequest tempMaterialAddReq = new TempMaterialAddRequest(type, filePath);
        TempMaterialAddRespone tempMaterialAddRes = wxClient.excute(tempMaterialAddReq);
        System.out.println(tempMaterialAddRes.getBody());
    }
    
    /**
     * 测试获取媒体临时素材
     */
    @Test
    public void testTempMediaGetReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        String mediaId = "8t5P8l6ZTyJGm8qi89B-fZF385G_SApB2dF4i_uDLJry8f3BPnJggSYWwjQ0-M6s";
        String filePath = "C:\\Pictures\\"+ System.currentTimeMillis() +".mp3";
        TempMaterialGetRequest tempMaterialGetReq = new TempMaterialGetRequest(mediaId, filePath);
        TempMaterialGetRespone tempMaterialGetRes = wxClient.excute(tempMaterialGetReq);
        System.out.println(tempMaterialGetRes.getBody());
    }

}
