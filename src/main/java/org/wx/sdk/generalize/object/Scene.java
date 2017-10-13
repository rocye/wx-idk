package org.wx.sdk.generalize.object;

/**
 * 生成场景二维码的参数对象
 * @author Rocye
 * @version 2017.08.23
 */
public class Scene {
	/** 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64 */
	private String scene_str;
	/** 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000） */
	private Integer scene_id;

	/**
	 * 构造器
	 */
	public Scene() {
	}
	
	/**
	 * 构造器
	 * @param sceneStr 场景值字符串
	 */
	public Scene(String sceneStr) {
		this.scene_str = sceneStr;
	}

	/**
	 * 构造器
	 * @param sceneId	场景值ID
	 */
	public Scene(Integer sceneId) {
		this.scene_id = sceneId;
	}

	public String getScene_str() {
		return scene_str;
	}
	public void setScene_str(String scene_str) {
		this.scene_str = scene_str;
	}

	public Integer getScene_id() {
		return scene_id;
	}
	public void setScene_id(Integer scene_id) {
		this.scene_id = scene_id;
	}
	
}
