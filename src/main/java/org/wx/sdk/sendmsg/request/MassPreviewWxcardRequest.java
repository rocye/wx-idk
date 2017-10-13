package org.wx.sdk.sendmsg.request;

import java.util.Map;

import org.wx.sdk.sendmsg.object.CardExt;
import org.wx.sdk.sendmsg.object.WxcardExt;

/**
 * 预览群发卡券的请求对象
 * @author Rocye
 * @version 2016-09-30
 */
public class MassPreviewWxcardRequest extends MassPreviewRequest {
	/** 预览的卡券素材 */
    private WxcardExt wxcard;
    
    /**
     * 构造器代替构造方法
     * @author Rocye
     */
    public static class Builder {
    	/** 消息类型，text,image,voice,video,music,news */
        private final String msgType;
        /** 卡券ID */
        private final String cardId;
        /** 卡券扩展  {@link CardExt}*/
        private final CardExt cardExt;
        /** 预览用户OpenId */
        private String touser;
        /** 预览用户微信号 */
        private String towxname;
        
        /**
         * 构造函数
         * @author Rocye
         * @param cardId	卡券ID
         * @param cardExt	卡券扩展{@link CardExt}
         */
        public Builder(String cardId, CardExt cardExt){
            this.msgType = "wxcard";
            this.cardId = cardId;
            this.cardExt = cardExt;
        }
        /**
         * 发送给指定openId
         * @param openId 用户唯一标识
         * @return 返回自己{@link Builder}
         */
        public Builder touser(String openId){
            this.touser = openId;
            return this;
        }
        /**
         * 发送给指定微信号
         * @param wxname 用户微信号
         * @return 返回自己{@link Builder}
         */
        public Builder towxname(String wxname){
            this.towxname = wxname;
            return this;
        }
        
        /**
         * 构建模式构建方法
         * @return 构建对象{@link MassPreviewWxcardRequest}
         */
        public MassPreviewWxcardRequest build(){
            return new MassPreviewWxcardRequest(this);
        }
    }
    
    /**
     * 构造方法
     * @param builder   构造器
     */
    public MassPreviewWxcardRequest(Builder builder) {
        super(builder.touser, builder.towxname, builder.msgType);
        this.wxcard = new WxcardExt(builder.cardId, builder.cardExt);
    }
    
    
    @Override
    public Map<String, Object> getWxHashMap() {
        Map<String, Object> wxHashMap = super.getWxHashMap();
        wxHashMap.put("wxcard", wxcard);
        return wxHashMap;
    }

}
