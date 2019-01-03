package com.wiser.previewphoto;

import android.app.Application;

import com.wiser.library.helper.WISERHelper;

public class MApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        WISERHelper.newBind().Inject(this, BuildConfig.DEBUG);
    }
}
