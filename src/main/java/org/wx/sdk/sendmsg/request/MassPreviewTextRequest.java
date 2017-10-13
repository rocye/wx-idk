package org.wx.sdk.sendmsg.request;

import java.util.Map;

import org.wx.sdk.sendmsg.object.TextMsg;

/**
 * 预览群发文本内容的请求对象
 * @author Rocye
 * @version 2016-09-30
 */
public class MassPreviewTextRequest extends MassPreviewRequest {
	/** 预览的文本内容 */
    private TextMsg text;
    
    /**
     * 构造器代替构造方法
     * @author Rocye
     */
    public static class Builder {
    	/** 消息类型，text,image,voice,video,music,news */
        private final String msgType;
        /** 发送内容 */
        private final String content;
        /** 预览用户OpenId */
        private String touser;
        /** 预览用户微信号 */
        private String towxname;
        
        /**
         * 构造函数
         * @param content 发送内容
         */
        public Builder(String content){
            this.msgType = "text";
            this.content = content;
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
         * @return 构建对象{@link MassPreviewTextRequest}
         */
        public MassPreviewTextRequest build(){
            return new MassPreviewTextRequest(this);
        }
    }
    
    /**
     * 构造方法
     * @param builder   构造器
     */
    public MassPreviewTextRequest(Builder builder) {
        super(builder.touser, builder.towxname, builder.msgType);
        this.text = new TextMsg(builder.content);
    }
    
    
    @Override
    public Map<String, Object> getWxHashMap() {
        Map<String, Object> wxHashMap = super.getWxHashMap();
        wxHashMap.put("text", text);
        return wxHashMap;
    }

}
