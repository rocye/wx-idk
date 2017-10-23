package org.wx.sdk.sendmsg.request;

import java.util.Map;
import org.wx.sdk.sendmsg.object.FilterObj;
import org.wx.sdk.sendmsg.object.MpnewsMsg;

/**
 * 根据标签进行群发图文素材的请求对象
 *
 * <p>群发接口新增原创校验流程：
 * <p>1. 当前准备群发的文章，未命中原创库中的文章，则可以群发。
 * <p>2. 当前准备群发的文章，已命中原创库中的文章，则：
 * <p>2.1 若原创作者允许转载该文章，则可以进行群发。群发时，会自动替换成原文的样式，且会自动将文章注明为转载并显示来源。
 * <p>&nbsp;&nbsp;若希望修改原文内容或样式，或群发时不显示转载来源，可自行与原创公众号作者联系并获得授权之后再进行群发。
 * <p>2.2 若原创作者禁止转载该文章，则不能进行群发。
 * <p>&nbsp;&nbsp;若希望转载该篇文章，可自行与原创公众号作者联系并获得授权之后再进行群发。
 * @author Rocye
 * @version 2017.10.20
 */
public class MassSendTagMpnewsRequest extends MassSendTagRequest {
	/** 图文消息对象 */
    private MpnewsMsg mpnews;
	/**
	 * <p>当 send_ignore_reprint 参数设置为1时，文章被判定为转载时，且原创文允许转载时，将继续进行群发操作。
	 * <p>当 send_ignore_reprint 参数设置为0时，文章被判定为转载时，将停止群发操作。
	 */
    private Short send_ignore_reprint;

	/**
     * 构造器
     * @param isToAll   用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据tag_id发送给指定群组的用户
     * @param mediaId   发送的图文消息（点击跳转到图文消息页）的媒体ID
     */
    public MassSendTagMpnewsRequest(Boolean isToAll, String mediaId) {
        this(isToAll, null, mediaId, (short)0);
    }

	/**
	 * 构造器
	 * @param isToAll   用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据tag_id发送给指定群组的用户
	 * @param mediaId   发送的图文消息（点击跳转到图文消息页）的媒体ID
	 * @param sendIgnoreReprint	1为继续群发（转载），0为停止群发。该参数默认为0。
	 */
	public MassSendTagMpnewsRequest(Boolean isToAll, String mediaId, Short sendIgnoreReprint) {
		this(isToAll, null, mediaId, sendIgnoreReprint);
	}

	/**
	 * 构造器
	 * @param isToAll   用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据tag_id发送给指定群组的用户
	 * @param tagId		群发到的标签的tag_id，参加用户管理中用户分组接口，若is_to_all值为true，可不填写tag_id
	 * @param mediaId   发送的图文消息（点击跳转到图文消息页）的媒体ID
	 */
	public MassSendTagMpnewsRequest(Boolean isToAll, Integer tagId, String mediaId) {
		this(isToAll, tagId, mediaId, (short)0);
	}
    
    /**
     * 构造器
     * @param isToAll	用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据tag_id发送给指定群组的用户
     * @param tagId		群发到的标签的tag_id，参加用户管理中用户分组接口，若is_to_all值为true，可不填写tag_id
     * @param mediaId	发送的图文消息（点击跳转到图文消息页）的媒体ID
     * @param sendIgnoreReprint	1为继续群发（转载），0为停止群发。该参数默认为0。
     */
    public MassSendTagMpnewsRequest(Boolean isToAll, Integer tagId, String mediaId, Short sendIgnoreReprint) {
        super(new FilterObj(isToAll, tagId), "mpnews");
        this.mpnews = new MpnewsMsg(mediaId);
        this.send_ignore_reprint = sendIgnoreReprint;
    }
    
    @Override
    public Map<String, Object> getWxHashMap() {
        Map<String, Object> wxHashMap = super.getWxHashMap();
        wxHashMap.put("mpnews", mpnews);
        return wxHashMap;
    }

	public Short getSend_ignore_reprint() {
		return send_ignore_reprint;
	}
	public void setSend_ignore_reprint(Short send_ignore_reprint) {
		this.send_ignore_reprint = send_ignore_reprint;
	}
}
