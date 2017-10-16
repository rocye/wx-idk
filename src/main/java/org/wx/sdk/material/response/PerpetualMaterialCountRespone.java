package org.wx.sdk.material.response;

import org.wx.sdk.base.Response;

/**
 * 获取永久素材的总数返回对象
 * @author Rocye
 * @version 2016-06-27
 */
public class PerpetualMaterialCountRespone extends Response {

    /** 语音总数量 */
    private Integer voice_count;
    /** 视频总数量 */
    private Integer video_count;
    /** 图片总数量 */
    private Integer image_count;
    /** 图文总数量 */
    private Integer news_count;
    
    public Integer getVoice_count() {
        return voice_count;
    }
    public void setVoice_count(Integer voiceCount) {
        voice_count = voiceCount;
    }
    
    public Integer getVideo_count() {
        return video_count;
    }
    public void setVideo_count(Integer videoCount) {
        video_count = videoCount;
    }
    
    public Integer getImage_count() {
        return image_count;
    }
    public void setImage_count(Integer imageCount) {
        image_count = imageCount;
    }
    
    public Integer getNews_count() {
        return news_count;
    }
    public void setNews_count(Integer newsCount) {
        news_count = newsCount;
    }
    
}
