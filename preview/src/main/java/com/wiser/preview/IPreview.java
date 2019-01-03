package com.wiser.preview;

import android.graphics.Bitmap;
import android.widget.ImageView;

public interface IPreview {

	/**
	 * 设置转场ID名字
	 *
	 * @param transitionName
	 *            转场ID名字
	 * @return
	 */
	Preview setTransitionName(String transitionName);

	/**
	 * 默认加载图片ID
	 *
	 * @param defaultPhoto
	 *            默认图片ID
	 * @return
	 */
	Preview defaultPhoto(int defaultPhoto);

	/**
	 * 加载 图片ID
	 *
	 * @param photoId
	 *            图片ID
	 * @return
	 */
	Preview photoId(int photoId);

	/**
	 * 加载Bitmap
	 *
	 * @param bitmap
	 *            参数
	 * @return
	 */
	Preview bitmap(Bitmap bitmap);

	/**
	 * 加载控件
	 *
	 * @param photo
	 *            控件ImageView
	 * @return
	 */
	Preview info(ImageView photo);

	/**
	 * 路由跳转执行
	 */
	void intent();

	/**
	 * 清除缓存
	 */
	void detach();
}
