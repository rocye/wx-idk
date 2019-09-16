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
        
        int typ = 2;
        String type = "image";
        String filePath = "D:/Rocye/Pictures/11.png";		//ISemATOOWToykrBF8ULKuxZSPpyeaBi-AE3JTQPpa9-Ju-7KFTPezoJ1W80ls99i
        if(typ == 2){
            type = "voice";
            filePath = "D:/Rocye/Pictures/1444288195077.mp3";	//zOOspCfpsKgyUOi-WprcC9bicFkuSCk7ZNn7euyy4h3Zi2mfyq26LvPtkyxuxKNd
        }else if(typ == 3){
            type = "video";
            filePath = "D:/Rocye/Pictures/20140423162603.mp4";
        }else if(typ == 4){
            type = "thumb";
            filePath = "D:/Rocye/Pictures/3.JPG";
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
        String mediaId = "zOOspCfpsKgyUOi-WprcC9bicFkuSCk7ZNn7euyy4h3Zi2mfyq26LvPtkyxuxKNd";
        String filePath = "D:/Rocye/Pictures/"+ System.currentTimeMillis() +".mp3";
        TempMaterialGetRequest tempMaterialGetReq = new TempMaterialGetRequest(mediaId, filePath);
        TempMaterialGetRespone tempMaterialGetRes = wxClient.excute(tempMaterialGetReq);
        System.out.println(tempMaterialGetRes.getBody());
    }

}
