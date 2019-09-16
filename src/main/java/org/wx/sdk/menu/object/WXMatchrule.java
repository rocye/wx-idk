package org.wx.sdk.menu.object;

import com.alibaba.fastjson.JSON;

/**
 * 个性化菜单匹配规则实体类
 * @author Rocye
 * @version 2016-08-16
 */
public class WXMatchrule {
    /** 用户分组id，可通过用户分组管理接口获取 */
    private Integer group_id;
    /** 性别：男（1）女（2），不填则不做匹配 */
    private Integer sex;     
    /** 国家信息，是用户在微信中设置的地区，具体请参考地区信息表 */
    private String country;  
    /** 省份信息，是用户在微信中设置的地区，具体请参考地区信息表 */
    private String province; 
    /** 城市信息，是用户在微信中设置的地区，具体请参考地区信息表 */
    private String city;     
    /** 客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)，不填则不做匹配 */
    private Integer client_platform_type;
    /** 语言信息，是用户在微信中设置的语言 1、简体中文 "zh_CN" 2、繁体中文TW "zh_TW" 3、繁体中文HK "zh_HK" 4、英文 "en" ...21、法语 "fr" */
    private String language; 
    
    /**
     * 构造器
     */
    public WXMatchrule(){
    }
    
    /**
     * 构造器
     * @param groupId               用户分组id，可通过用户分组管理接口获取
     * @param sex                   性别：男（1）女（2），不填则不做匹配
     * @param country               国家信息，是用户在微信中设置的地区，具体请参考地区信息表
     * @param province              省份信息，是用户在微信中设置的地区，具体请参考地区信息表
     * @param city                  城市信息，是用户在微信中设置的地区，具体请参考地区信息表
     * @param clientPlatformType    客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)，不填则不做匹配
     * @param language              语言信息，是用户在微信中设置的语言 1、简体中文 "zh_CN" 2、繁体中文TW "zh_TW" 3、繁体中文HK "zh_HK" 4、英文 "en" ...21、法语 "fr"
     */
    public WXMatchrule(Integer groupId, Integer sex, String country,
            String province, String city, Integer clientPlatformType,
            String language) {
        this.group_id = groupId;
        this.sex = sex;
        this.country = country;
        this.province = province;
        this.city = city;
        this.client_platform_type = clientPlatformType;
        this.language = language;
    }
    
    public Integer getGroup_id() {
        return group_id;
    }
    public void setGroup_id(Integer groupId) {
        group_id = groupId;
    }
    
    public Integer getSex() {
        return sex;
    }
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    
    public Integer getClient_platform_type() {
        return client_platform_type;
    }
    public void setClient_platform_type(Integer clientPlatformType) {
        client_platform_type = clientPlatformType;
    }
    
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
    
}
