package org.wx.sdk.user.object;

/**
 * 用户分组实体类
 * @author Rocye
 * @version 2016-10-27
 */
public class Group {
	/** 分组id，由微信分配 */
    private Integer id;
    /** 分组名字，UTF8编码 */
    private String name;
    /** 分组内用户数量 */
    private Integer count;
    
    /**
     * 构造函数
     */
    public Group() {
    }
    
    /**
     * 构造函数
     * @param id    分组id，由微信分配
     */
    public Group(Integer id) {
        this(id, null, null);
    }

    /**
     * 构造函数
     * @param name  分组名字，UTF8编码
     */
    public Group(String name) {
        this(null, name, null);
    }
    
    /**
     * 构造函数
     * @param id    分组id，由微信分配
     * @param name  分组名字，UTF8编码
     */
    public Group(Integer id, String name) {
        this(id, name, null);
    }
    
    /**
     * 构造函数
     * @param id    分组id，由微信分配
     * @param name  分组名字，UTF8编码
     * @param count  分组内用户数量
     */
    public Group(Integer id, String name, Integer count) {
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
