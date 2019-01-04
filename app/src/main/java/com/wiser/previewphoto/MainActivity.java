package com.wiser.previewphoto;

import com.wiser.library.base.WISERActivity;
import com.wiser.library.base.WISERBuilder;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;

/**
 * @author Wiser
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends WISERActivity<MBiz> {

	@Override protected WISERBuilder build(WISERBuilder wiserBuilder) {
		wiserBuilder.layoutId(R.layout.activity_main);
		wiserBuilder.recycleView().recycleAdapter(new MAdapter(this));
		wiserBuilder.recycleView().recycleViewGridManager(2, LinearLayoutManager.VERTICAL, null);
		wiserBuilder.recycleView().recycleViewId(R.id.rlv_photo);
		return wiserBuilder;
	}

	@Override protected void initData(Intent intent) {
		biz().loadData();
	}
}
