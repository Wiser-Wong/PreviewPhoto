package com.wiser.previewphoto;

import com.wiser.library.helper.WISERHelper;

import android.app.Application;

/**
 * @author Wiser
 */
public class MApplication extends Application {

	@Override public void onCreate() {
		super.onCreate();
		WISERHelper.newBind().Inject(this, BuildConfig.DEBUG);
	}
}
