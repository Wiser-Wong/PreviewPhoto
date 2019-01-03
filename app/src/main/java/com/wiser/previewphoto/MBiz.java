package com.wiser.previewphoto;

import com.wiser.library.base.WISERBiz;

import java.util.ArrayList;
import java.util.List;

public class MBiz extends WISERBiz<MainActivity> {

    public void loadData(){
        List<PhotoModel> photoModelList = new ArrayList<>();
        PhotoModel photoModel = new PhotoModel();
        photoModel.photoUrl = "http://img.zcool.cn/community/015da9554971170000019ae9f43459.jpg@2o.jpg";
        PhotoModel photoModel1 = new PhotoModel();
        photoModel1.photoUrl = "http://img.zcool.cn/community/01f9ea56e282836ac72531cbe0233b.jpg@2o.jpg";
        PhotoModel photoModel2 = new PhotoModel();
        photoModel2.photoUrl = "http://pic33.photophoto.cn/20141022/0019032438899352_b.jpg";
        PhotoModel photoModel3 = new PhotoModel();
        photoModel3.photoUrl = "http://img.zcool.cn/community/014565554b3814000001bf7232251d.jpg@1280w_1l_2o_100sh.png";
        PhotoModel photoModel4 = new PhotoModel();
        photoModel4.photoUrl = "http://pic31.nipic.com/20130722/9252150_095713523386_2.jpg";
        photoModelList.add(photoModel);
        photoModelList.add(photoModel1);
        photoModelList.add(photoModel2);
        photoModelList.add(photoModel3);
        photoModelList.add(photoModel4);
        ui().setItems(photoModelList);
    }

}
