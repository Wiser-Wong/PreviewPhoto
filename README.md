# PreviewPhoto
预览图片

### 使用方法
    Preview.with(activity())
           .bitmap(((PhotoModel) getItem(i)).photoBitmap)
           .defaultPhoto(R.mipmap.ic_launcher)
           .photoId(R.id.iv_photo)
           .setTransitionName(photo.getTransitionName())
           .info(photo)
           .intent();
### 截图

![images](https://github.com/Wiser-Wong/PreviewPhoto/blob/master/images/record.gif)
