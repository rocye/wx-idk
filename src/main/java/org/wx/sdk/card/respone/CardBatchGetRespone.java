package org.wx.sdk.card.respone;

import org.wx.sdk.base.Response;
import java.util.List;

/**
 * 批量查询卡券列表返回对象
 * @author Rocye
 * @version 2017.12.29
 */
public class CardBatchGetRespone extends Response {

	/** 卡券ID列表 */
	private List<String> card_id_list;
	/** 该商户名下卡券ID总数 */
	private Integer total_num;

	public List<String> getCard_id_list() {
		return card_id_list;
	}
	public void setCard_id_list(List<String> card_id_list) {
		this.card_id_list = card_id_list;
	}

	public Integer getTotal_num() {
		return total_num;
	}
	public void setTotal_num(Integer total_num) {
		this.total_num = total_num;
	}

}
