package org.wx.sdk.sendmsg.response;

import org.wx.sdk.base.Response;

/**
 * <p>高级群发接口返回对象
 * <p>请注意：在返回成功时，意味着群发任务提交成功，并不意味着此时群发已经结束，
 * 所以，仍有可能在后续的发送过程中出现异常情况导致用户未收到消息，如消息有时会进行审核、服务器不稳定等。
 * 此外，群发任务一般需要较长的时间才能全部发送完毕，请耐心等待。
 * @author Rocye
 * @version 2016-09-21
 */
public class MassSendRespone extends Response {

    /** 消息发送任务的ID */
    private Long msg_id;
    /** 消息的数据ID，该字段只有在群发图文消息时，才会出现。可以用于在图文分析数据接口中，获取到对应的图文消息的数据，是图文分析数据接口中的msgid字段中的前半部分，详见图文分析数据接口中的msgid字段的介绍。 */
    private Long msg_data_id;
    
    public Long getMsg_id() {
        return msg_id;
    }
    public void setMsg_id(Long msgId) {
        msg_id = msgId;
    }
    
    public Long getMsg_data_id() {
        return msg_data_id;
    }
    public void setMsg_data_id(Long msgDataId) {
        msg_data_id = msgDataId;
    }
    
}
