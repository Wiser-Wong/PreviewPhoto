package com.wiser.preview;

import com.wiser.library.base.WISERActivity;
import com.wiser.library.base.WISERBuilder;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * 图片预览
 */
public class PreviewActivity extends WISERActivity implements View.OnClickListener {

	private ImageView photo;

	@Override protected WISERBuilder build(WISERBuilder wiserBuilder) {
		photo = createView();
		wiserBuilder.layoutView(photo);
		return wiserBuilder;
	}

	@Override protected void initData(Intent intent) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			if (photo != null) {
				if (intent != null) {
					photo.setTransitionName(intent.getStringExtra(Preview.TRANSITION_NAME));
					photo.setId(intent.getIntExtra(Preview.PHOTO_ID, 0));
					byte[] bytes = intent.getByteArrayExtra(Preview.BITMAP);
					int defaultId = intent.getIntExtra(Preview.DEFAULT_PHOTO, 0);
					if (bytes != null) {
						photo.setImageBitmap(BitmapFactory.decodeByteArray(bytes, 0, bytes.length));
					} else {
						photo.setImageResource(defaultId);
					}
				}
			}
		}
		if (photo != null) {
			photo.setOnClickListener(this);
		}
	}

	private ImageView createView() {
		ImageView photo = new ImageView(this);
		photo.setAdjustViewBounds(true);
		photo.setScaleType(ImageView.ScaleType.FIT_CENTER);
		photo.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
		return photo;
	}

	@Override public void onClick(View v) {
		super.onBackPressed();
		Preview.get().detach();
	}
}
