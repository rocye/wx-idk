package org.wx.sdk.card.object;

/**
 * <p>使用门槛（条件）字段
 * <p>若不填写使用条件则在券面拼写 ：无最低消费限制，全场通用，不限品类；
 * <p>并在使用说明显示：可与其他优惠共享；
 * @author Rocye
 * @version 2017.12.19
 */
public class UseCondition {
	/** 指定可用的商品类目，仅用于代金券类型 ，填入后将在券面拼写适用于xxx */
	private String accept_category;
	/** 指定不可用的商品类目，仅用于代金券类型 ，填入后将在券面拼写不适用于xxxx */
	private String reject_category;
	/** 满减门槛字段，可用于兑换券和代金券 ，填入后将在全面拼写消费满xx元可用。*/
	private Integer least_cost;
	/** 购买xx可用类型门槛，仅用于兑换 ，填入后自动拼写购买xxx可用。*/
	private String object_use_for;
	/** 不可以与其他类型共享门槛 ，填写false时系统将在使用须知里 拼写“不可与其他优惠共享”，
	 * 填写true时系统将在使用须知里 拼写“可与其他优惠共享”， 默认为true */
	private Boolean can_use_with_other_discount;

	public String getAccept_category() {
		return accept_category;
	}
	public void setAccept_category(String accept_category) {
		this.accept_category = accept_category;
	}

	public String getReject_category() {
		return reject_category;
	}
	public void setReject_category(String reject_category) {
		this.reject_category = reject_category;
	}

	public Integer getLeast_cost() {
		return least_cost;
	}
	public void setLeast_cost(Integer least_cost) {
		this.least_cost = least_cost;
	}

	public String getObject_use_for() {
		return object_use_for;
	}
	public void setObject_use_for(String object_use_for) {
		this.object_use_for = object_use_for;
	}

	public Boolean getCan_use_with_other_discount() {
		return can_use_with_other_discount;
	}
	public void setCan_use_with_other_discount(Boolean can_use_with_other_discount) {
		this.can_use_with_other_discount = can_use_with_other_discount;
	}

}
