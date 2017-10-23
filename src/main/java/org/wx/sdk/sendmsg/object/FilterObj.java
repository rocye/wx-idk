package org.wx.sdk.sendmsg.object;

/**
 * 用于设定按标签群发接口的接收者
 * @author Rocye
 * @version 2017.10.20
 */
public class FilterObj {
	/** 用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据tag_id发送给指定群组的用户 */
    private Boolean is_to_all;
    /** 群发到的标签的tag_id，参加用户管理中用户分组接口，若is_to_all值为true，可不填写tag_id */
    private Integer tag_id;
    
    /**
     * 构造函数
     */
    public FilterObj() {
    }

    /**
     * 构造函数
     * @param isToAll	用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据tag_id发送给指定群组的用户
     * @param tagId		群发到的标签的tag_id，参加用户管理中用户分组接口，若is_to_all值为true，可不填写tag_id
     */
    public FilterObj(Boolean isToAll, Integer tagId) {
        this.is_to_all = isToAll;
        this.tag_id = tagId;
    }
    
    public Boolean getIs_to_all() {
        return is_to_all;
    }
    public void setIs_to_all(Boolean isToAll) {
        is_to_all = isToAll;
    }

    public Integer getTag_id() {
        return tag_id;
    }
    public void setTag_id(Integer tag_id) {
        this.tag_id = tag_id;
    }

}
