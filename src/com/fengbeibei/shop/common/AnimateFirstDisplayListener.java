package com.fengbeibei.shop.common;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class AnimateFirstDisplayListener implements ImageLoadingListener  {
	static final List<String> displayedImages = Collections.synchronizedList(new LinkedList<String>());
	@Override
	public void onLoadingCancelled(String arg0, View arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLoadingComplete(String imageUri, View arg1, Bitmap loadedImage) {
		// TODO Auto-generated method stub
		if (loadedImage != null) {
			ImageView imageView = (ImageView) arg1;
			// �Ƿ��һ����ʾ
			boolean firstDisplay = !displayedImages.contains(imageUri);
			if (firstDisplay) {
				// ͼƬ����Ч��
				FadeInBitmapDisplayer.animate(imageView, 500);
				displayedImages.add(imageUri);
			}
		}
	}

	@Override
	public void onLoadingFailed(String arg0, View arg1, FailReason arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLoadingStarted(String arg0, View arg1) {
		// TODO Auto-generated method stub
		
	}

}