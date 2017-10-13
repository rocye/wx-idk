package org.wx.sdk.user.object;

/**
 * 用户标签实体类
 * @author Rocye
 * @version 2017-02-14
 */
public class Tag {
	/** 标签id，由微信分配 */
    private Integer id;
    /** 标签名，UTF8编码（30个字符以内） */
    private String name;
    /** 此标签下粉丝数 */
    private Integer count;
    
    /**
     * 构造函数
     */
    public Tag() {
    }
    
    /**
     * 构造函数
     * @param id	标签id，由微信分配
     */
    public Tag(Integer id) {
        this(id, null, null);
    }

    /**
     * 构造函数
     * @param name  标签名，UTF8编码（30个字符以内）
     */
    public Tag(String name) {
        this(null, name, null);
    }
    
    /**
     * 构造函数
     * @param id    标签id，由微信分配
     * @param name  标签名，UTF8编码（30个字符以内）
     */
    public Tag(Integer id, String name) {
        this(id, name, null);
    }
    
    /**
     * 构造函数
     * @param id     标签id，由微信分配
     * @param name   标签名，UTF8编码（30个字符以内）
     * @param count  此标签下粉丝数
     */
    public Tag(Integer id, String name, Integer count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    
}
