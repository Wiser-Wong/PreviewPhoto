package com.wiser.previewphoto;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.wiser.library.adapter.WISERHolder;
import com.wiser.library.adapter.WISERRVAdapter;
import com.wiser.library.base.WISERActivity;
import com.wiser.library.util.WISERBitmap;
import com.wiser.preview.Preview;
import com.wiser.preview.PreviewActivity;

import butterknife.BindView;

/**
 * @author Wiser
 */
public class MAdapter extends WISERRVAdapter<PhotoModel, MAdapter.MHolder> {

	public MAdapter(WISERActivity mWiserActivity) {
		super(mWiserActivity);
	}

	@Override public MHolder newViewHolder(ViewGroup viewGroup, int i) {
		return new MHolder(inflate(viewGroup, R.layout.item_photo));
	}

	public class MHolder extends WISERHolder<PhotoModel> {

		@BindView(R.id.iv_photo) ImageView photo;

		MHolder(@NonNull View itemView) {
			super(itemView);
		}

		@Override public void bindData(final PhotoModel photoModel, final int i) {

			Glide.with(activity()).load(photoModel.photoUrl).asBitmap().into(new SimpleTarget<Bitmap>() {

				@Override public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
					PhotoModel photoModel1 = (PhotoModel) getItem(i);
					photoModel1.photoBitmap = resource;
					getItems().set(i, photoModel1);
					photo.setImageBitmap(resource);
				}
			});

			itemView.setOnClickListener(new View.OnClickListener() {

				@TargetApi(Build.VERSION_CODES.LOLLIPOP) @Override public void onClick(View v) {
					Preview.with(activity()).bitmap(((PhotoModel) getItem(i)).photoBitmap).defaultPhoto(R.mipmap.ic_launcher).photoId(R.id.iv_photo).setTransitionName(photo.getTransitionName())
							.info(photo).intent();
				}
			});
		}
	}

}
