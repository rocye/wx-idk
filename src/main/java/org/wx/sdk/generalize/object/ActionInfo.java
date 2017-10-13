package org.wx.sdk.generalize.object;

/**
 * 二维码详细信息对象
 * @author Rocye
 * @version 2017.08.23
 */
public class ActionInfo {
	private Scene scene;

	/**
	 * 构造器
	 */
	public ActionInfo() {
	}
	
	/**
	 * 构造器
	 * @param sceneStr 场景值ID
	 */
	public ActionInfo(String sceneStr) {
		this.scene = new Scene(sceneStr);
	}

	/**
	 * 构造器
	 * @param sceneId	场景值ID
	 */
	public ActionInfo(Integer sceneId) {
		this.scene = new Scene(sceneId);
	}

	public Scene getScene() {
		return scene;
	}
	public void setScene(Scene scene) {
		this.scene = scene;
	}

}
