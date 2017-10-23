package org.wx.sdk.sendmsg.response;

import org.wx.sdk.base.Response;

/**
 * <p>预览接口返回对象
 * <p>开发者可通过该接口发送消息给指定用户，在手机端查看消息的样式和排版。
 * <p>为了满足第三方平台开发者的需求，在保留对openID预览能力的同时，
 * 增加了对指定微信号发送预览的能力，但该能力每日调用次数有限制（100次），请勿滥用。
 * @author Rocye
 * @version 2016-09-30
 */
public class MassPreviewRespone extends Response {

    /** 消息发送任务的ID */
    private Long msg_id;
    
    public Long getMsg_id() {
        return msg_id;
    }
    public void setMsg_id(Long msgId) {
        msg_id = msgId;
    }
    
}
