package org.wx.sdk.sendmsg.object;

/**
 * 用于设定按分组群发接口的接收者
 * @author Rocye
 * @version 2016-09-21
 */
public class FilterObj {
	/** 用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据group_id发送给指定群组的用户 */
    private Boolean is_to_all;
    /** 群发到的分组的group_id，参加用户管理中用户分组接口，若is_to_all值为true，可不填写group_id */
    private Integer group_id;
    
    /**
     * 构造函数
     */
    public FilterObj() {
    }

    /**
     * 构造函数
     * @param isToAll   用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据group_id发送给指定群组的用户
     * @param groupId   群发到的分组的group_id，参加用户管理中用户分组接口，若is_to_all值为true，可不填写group_id
     */
    public FilterObj(Boolean isToAll, Integer groupId) {
        is_to_all = isToAll;
        group_id = groupId;
    }
    
    public Boolean getIs_to_all() {
        return is_to_all;
    }
    public void setIs_to_all(Boolean isToAll) {
        is_to_all = isToAll;
    }
    
    public Integer getGroup_id() {
        return group_id;
    }
    public void setGroup_id(Integer groupId) {
        group_id = groupId;
    }
    
}
