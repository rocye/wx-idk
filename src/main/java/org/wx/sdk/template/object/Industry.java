package org.wx.sdk.template.object;

/**
 * 模板行业信息实体类
 * @author Rocye
 * @version 2017-08-22
 */
public class Industry{
	/** 帐号设置的主营行业  */
    private String first_class;
    /** 帐号设置的副营行业  */
    private String second_class;
    
    /**
     * 构造器
     */
    public Industry() {
    	
	}

	/**
     * 构造器
     * @param firstClass	帐号设置的主营行业
     * @param secondClass	帐号设置的副营行业
     */
    public Industry(String firstClass, String secondClass) {
        this.first_class = firstClass;
        this.second_class = secondClass;
    }

	public String getFirst_class() {
		return first_class;
	}
	public void setFirst_class(String first_class) {
		this.first_class = first_class;
	}

	public String getSecond_class() {
		return second_class;
	}
	public void setSecond_class(String second_class) {
		this.second_class = second_class;
	}

}
