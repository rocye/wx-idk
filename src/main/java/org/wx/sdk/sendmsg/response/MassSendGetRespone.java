package org.wx.sdk.sendmsg.response;

import org.wx.sdk.base.Response;

/**
 * 群发删除接口返回对象
 * @author Rocye
 * @version 2016-09-29
 */
public class MassSendGetRespone extends Response {
    private static final long serialVersionUID = -8980059094306938253L;
    
    /** 群发消息后返回的消息id */
    private Long msg_id;
    /** 消息发送后的状态，SEND_SUCCESS表示发送成功 */
    private String msg_status;
    
    public Long getMsg_id() {
        return msg_id;
    }
    public void setMsg_id(Long msgId) {
        msg_id = msgId;
    }
    
    public String getMsg_status() {
        return msg_status;
    }
    public void setMsg_status(String msgStatus) {
        msg_status = msgStatus;
    }
    
}
