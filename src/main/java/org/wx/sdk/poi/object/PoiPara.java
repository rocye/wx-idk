package org.wx.sdk.poi.object;

import java.util.List;

/**
 * 更新门店参数数据
 * @author Rocye
 * @version 2017.10.16
 */
public class PoiPara {
    /** 门店ID */
    private String poi_id ;
    /** 商户自己的id，用于后续审核通过收到poi_id 的通知时，做对应关系 */
    private String sid;
    /** 门店的电话（纯数字，区号、分机号均由“-”隔开） */
    private String telephone;
    /** 图片列表，url 形式，可以有多张图片，尺寸为640*340px。必须为上一接口生成的url */
    private List<Photo> photo_list;
    /** <p>推荐品，餐厅可为推荐菜；酒店为推荐套房；景点为推荐游玩景点等，针对自己行业的推荐内容 */
    private String recommend;
    /** 特色服务，如免费wifi，免费停车，送货上门等商户能提供的特色功能或服务 */
    private String special;
    /** 商户简介，主要介绍商户信息等 */
    private String introduction;
    /** 营业时间，24 小时制表示，用“-”连接，如8:00-20:00 */
    private String open_time;
    /** 人均价格，大于0的整数 */
    private Integer avg_price;

    /**
     * 构造函数
     */
    public PoiPara() {

    }

    /**
     * 构造函数
     * @param poiId         门店id
     * @param sid           商户自己的id
     * @param telephone     门店的电话
     */
    public PoiPara(String poiId, String sid, String telephone) {
        this.poi_id = poiId;
        this.sid = sid;
        this.telephone = telephone;
    }

    /**
     * 构造函数
     * @param poiId         门店id
     * @param sid           商户自己的id
     * @param telephone     门店的电话
     * @param photoList     图片列表
     * @param recommend     推荐品
     * @param special       特色服务
     * @param introduction  商户简介
     * @param openTime      营业时间
     * @param avgPrice      人均价格
     */
    public PoiPara(String poiId, String sid, String telephone, List<Photo> photoList, String recommend, String special, String introduction, String openTime, Integer avgPrice) {
        this.poi_id = poiId;
        this.sid = sid;
        this.telephone = telephone;
        this.photo_list = photoList;
        this.recommend = recommend;
        this.special = special;
        this.introduction = introduction;
        this.open_time = openTime;
        this.avg_price = avgPrice;
    }

    public String getPoi_id() {
        return poi_id;
    }
    public void setPoi_id(String poi_id) {
        this.poi_id = poi_id;
    }

    public String getSid() {
        return sid;
    }
    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Photo> getPhoto_list() {
        return photo_list;
    }
    public void setPhoto_list(List<Photo> photo_list) {
        this.photo_list = photo_list;
    }

    public String getRecommend() {
        return recommend;
    }
    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getSpecial() {
        return special;
    }
    public void setSpecial(String special) {
        this.special = special;
    }

    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getOpen_time() {
        return open_time;
    }
    public void setOpen_time(String open_time) {
        this.open_time = open_time;
    }

    public Integer getAvg_price() {
        return avg_price;
    }
    public void setAvg_price(Integer avg_price) {
        this.avg_price = avg_price;
    }

}
