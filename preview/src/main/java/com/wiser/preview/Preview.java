package com.wiser.preview;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;

import com.wiser.library.helper.WISERHelper;
import com.wiser.library.util.WISERBitmap;

import java.util.List;

/**
 * 预览工具
 *
 * @author Wiser
 */
public class Preview implements IPreview {

	static final String		TRANSITION_NAME	= "TRANSITION_NAME";

	static final String		BITMAP			= "BITMAP";

	static final String		DEFAULT_PHOTO	= "DEFAULT_PHOTO";

	static final String		PHOTO_ID		= "PHOTO_ID";

	private static IPreview	instance;

	private Activity		activity;

	private Intent			intent;

	private ImageView		photo;

	private Preview(Activity activity) {
		this.activity = activity;
		intent = new Intent(activity, PreviewActivity.class);
	}

	/**
	 * 初始化
	 *
	 * @param activity
	 *            参数
	 * @return
	 */
	public static IPreview with(Activity activity) {
		if (instance == null) {
			synchronized (IPreview.class) {
				if (instance == null) {
					instance = new Preview(activity);
				}
			}
		}
		return instance;
	}

	/**
	 * 获取单例实例
	 *
	 * @return
	 */
	public static IPreview get() {
		if (instance != null) return instance;
		return with(WISERHelper.getActivityManage().getCurrentActivity());
	}

	/**
	 * 设置转场ID名字
	 *
	 * @param transitionName
	 *            转场ID名字
	 * @return
	 */
	@Override public Preview setTransitionName(String transitionName) {
		if (intent != null) {
			intent.putExtra(TRANSITION_NAME, transitionName);
		}
		return this;
	}

	/**
	 * 默认加载图片ID
	 *
	 * @param defaultPhoto
	 *            默认图片ID
	 * @return
	 */
	@Override public Preview defaultPhoto(int defaultPhoto) {
		if (intent != null) {
			intent.putExtra(DEFAULT_PHOTO, defaultPhoto);
		}
		return this;
	}

	/**
	 * 加载 图片ID
	 *
	 * @param photoId
	 *            图片ID
	 * @return
	 */
	@Override public Preview photoId(int photoId) {
		if (intent != null) {
			intent.putExtra(PHOTO_ID, photoId);
		}
		return this;
	}

	/**
	 * 加载Bitmap
	 *
	 * @param bitmap
	 *            参数
	 * @return
	 */
	@Override public Preview bitmap(Bitmap bitmap) {
		if (bitmap == null) return null;
		if (intent != null) {
			intent.putExtra(BITMAP, WISERBitmap.bitmap2Bytes(bitmap));
		}
		return this;
	}

	/**
	 * 加载控件
	 *
	 * @param photo
	 *            控件ImageView
	 * @return
	 */
	@Override public Preview info(ImageView photo) {
		this.photo = photo;
		return this;
	}

	/**
	 * 路由跳转执行
	 */
	@Override public void intent() {
		if (activity == null) return;
		if (photo == null) return;
		if (intent == null) return;
		if (isStackTop()) return;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
			activity.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(activity, Pair.create((View) photo, photo.getTransitionName())).toBundle());
		else activity.startActivity(intent);
	}

	/**
	 * 清除缓存
	 */
	public void detach() {
		this.intent = null;
		this.activity = null;
		this.photo = null;
		instance = null;
	}

	/**
	 * 是否该Activity处于栈顶
	 * 
	 * @return
	 */
	private boolean isStackTop() {
		String lockAppName = "com.wiser.preview.PreviewActivity";
		String topActivityName = "";
		ActivityManager am = (ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE);
		List<ActivityManager.RunningTaskInfo> runningTasks = am.getRunningTasks(1);
		if (runningTasks != null && !runningTasks.isEmpty()) {
			ActivityManager.RunningTaskInfo taskInfo = runningTasks.get(0);
			topActivityName = taskInfo.topActivity.getClassName();
		}
		return lockAppName.equals(topActivityName);
	}
}
