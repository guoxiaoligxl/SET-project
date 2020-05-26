package com.example.lenovo.maandroid.Guaibao_Zhouqianqian;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiSelector;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SendTest extends  BaseTestUiautomator {
    public String content = "hello world";
    @Test
//    直接点击上传（失败）
    public  void  testSend1(){
//        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add")).click();
        mdevice.findObject(By.text("上传")).click();
        Assert.assertFalse( mdevice.findObject(new UiSelector().text("各位看官，还可以进行搜索和添加喔")).exists());
    }
    @Test
//    选择一个标签点击上传（失败）
    public  void  testSend2(){
//        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add")).click();
        mdevice.findObject(By.text("生日")).click();
        mdevice.findObject(By.text("上传")).click();
        Assert.assertFalse( mdevice.findObject(new UiSelector().text("各位看官，还可以进行搜索和添加喔")).exists());
    }
    @Test
//    选择全部标签点击上传（失败）
    public  void  testSend3(){
//        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add")).click();
        mdevice.findObject(By.text("生日")).click();
        mdevice.findObject(By.text("比赛")).click();
        mdevice.findObject(By.text("游戏")).click();
        mdevice.findObject(By.text("旅游")).click();
        mdevice.findObject(By.text("互动")).click();
        mdevice.findObject(By.text("成长")).click();
        mdevice.findObject(By.text("捣蛋")).click();
        mdevice.findObject(By.text("陪伴")).click();
        mdevice.findObject(By.text("日常")).click();

        mdevice.findObject(By.text("上传")).click();
        Assert.assertFalse( mdevice.findObject(new UiSelector().text("各位看官，还可以进行搜索和添加喔")).exists());
    }
//    ************************success   15********************************************************************************************
    @Test
//    只输入文字
    public  void  testSendSuccess1(String content){
//       mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add")).click();
//        com.example.lenovo.maandroid:id/et_content
        mdevice.findObject(By.clazz("android.widget.EditText")).setText(content);
//        com.example.lenovo.maandroid:id/add_upload
        mdevice.findObject(By.text("上传")).click();
        Assert.assertFalse( mdevice.findObject(new UiSelector().text("各位看官，还可以进行搜索和添加喔")).exists());
    }
    @Test
//    上传文字+一个标签
    public  void  testSendSuccess2(String content){
//       mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add")).click();

//        com.example.lenovo.maandroid:id/et_content
        mdevice.findObject(By.clazz("android.widget.EditText")).setText(content);
        mdevice.findObject(By.text("日常")).click();

//       com.example.lenovo.maandroid:id/add_upload
        mdevice.findObject(By.text("上传")).click();
        Assert.assertFalse( mdevice.findObject(new UiSelector().text("各位看官，还可以进行搜索和添加喔")).exists());
    }
    @Test
//    输入文字 + 全部标签
    public  void  testSendSuccess3(String content){
        //        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add")).click();
//        com.example.lenovo.maandroid:id/et_content
        mdevice.findObject(By.clazz("android.widget.EditText")).setText(content);

        mdevice.findObject(By.text("生日")).click();
        mdevice.findObject(By.text("比赛")).click();
        mdevice.findObject(By.text("游戏")).click();
        mdevice.findObject(By.text("旅游")).click();
        mdevice.findObject(By.text("互动")).click();
        mdevice.findObject(By.text("成长")).click();
        mdevice.findObject(By.text("捣蛋")).click();
        mdevice.findObject(By.text("陪伴")).click();
        mdevice.findObject(By.text("日常")).click();

//        com.example.lenovo.maandroid:id/add_upload
        mdevice.findObject(By.text("上传")).click();
        Assert.assertFalse( mdevice.findObject(new UiSelector().text("各位看官，还可以进行搜索和添加喔")).exists());
    }
    @Test
//    只上传一张图片
    public  void  testSendSuccess4() throws InterruptedException {
//       mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add")).click();

        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add_picture")).click();
        Thread.sleep(2000);
//        com.example.lenovo.maandroid:id/rvImageList
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/ivPhotoCheaked")).click();
        mdevice.findObject(By.text("确定")).click();
        mdevice.findObject(By.text("上传")).click();
        Assert.assertFalse( mdevice.findObject(new UiSelector().text("各位看官，还可以进行搜索和添加喔")).exists());
    }
    @Test
//    上传6张图片
    public  void  testSendSuccess5() throws InterruptedException {
//       mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add_picture")).click();
        Thread.sleep(2000);
//        List<UiObject2> ret = new ArrayList<UiObject2>();
//        ret = mdevice.findObjects(By.res("com.example.lenovo.maandroid:id/rvImageList"));
        List<UiObject2> ret = mdevice.findObjects(By.res("com.example.lenovo.maandroid:id/ivPhotoCheaked"));
        for(int i=1;i<7;i++){
            ret.get(i).click();
        }
        mdevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/ivPhotoCheaked"));
        mdevice.findObject(By.text("确定")).click();
//        com.example.lenovo.maandroid:id/add_upload
        mdevice.findObject(By.text("上传")).click();
        Assert.assertFalse( mdevice.findObject(new UiSelector().text("各位看官，还可以进行搜索和添加喔")).exists());
    }
    @Test
//    上传一张图片 +一个标签
    public  void  testSendSuccess6() throws InterruptedException {
//       mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add_picture")).click();
        Thread.sleep(2000);
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/ivPhotoCheaked")).click();
        mdevice.findObject(By.text("确定")).click();

        mdevice.findObject(By.text("生日")).click();

        mdevice.findObject(By.text("上传")).click();
        Assert.assertFalse( mdevice.findObject(new UiSelector().text("各位看官，还可以进行搜索和添加喔")).exists());
    }
    @Test
//    上传6张图片 +一个标签
    public  void  testSendSuccess7() throws InterruptedException {
//       mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add")).click();

        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add_picture")).click();
        Thread.sleep(2000);
//        List<UiObject2> ret = new ArrayList<UiObject2>();
//        ret = mdevice.findObjects(By.res("com.example.lenovo.maandroid:id/rvImageList"));
        List<UiObject2> ret = mdevice.findObjects(By.res("com.example.lenovo.maandroid:id/ivPhotoCheaked"));
        for(int i=1;i<7;i++){
            ret.get(i).click();
        }
        mdevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/ivPhotoCheaked"));
        mdevice.findObject(By.text("确定")).click();
        mdevice.findObject(By.text("生日")).click();
        mdevice.findObject(By.text("上传")).click();
        Assert.assertFalse( mdevice.findObject(new UiSelector().text("各位看官，还可以进行搜索和添加喔")).exists());
    }
    @Test
//    上传一张图片 + 6个标签
    public  void  testSendSuccess8() throws InterruptedException {
//       mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add_picture")).click();
        Thread.sleep(2000);
        mdevice.findObject(By.text("生日")).click();
        mdevice.findObject(By.text("比赛")).click();
        mdevice.findObject(By.text("游戏")).click();
        mdevice.findObject(By.text("旅游")).click();
        mdevice.findObject(By.text("互动")).click();
        mdevice.findObject(By.text("成长")).click();
        mdevice.findObject(By.text("捣蛋")).click();
        mdevice.findObject(By.text("陪伴")).click();
        mdevice.findObject(By.text("日常")).click();

        mdevice.findObject(By.text("上传")).click();

        Assert.assertFalse( mdevice.findObject(new UiSelector().text("各位看官，还可以进行搜索和添加喔")).exists());
    }
    @Test
//    上传6张图片+6个标签
    public  void  testSendSuccess9() throws InterruptedException {
//       mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add_picture")).click();
        Thread.sleep(2000);
//        List<UiObject2> ret = new ArrayList<UiObject2>();
//        ret = mdevice.findObjects(By.res("com.example.lenovo.maandroid:id/rvImageList"));
        List<UiObject2> ret = mdevice.findObjects(By.res("com.example.lenovo.maandroid:id/ivPhotoCheaked"));
        for(int i=1;i<7;i++){
            ret.get(i).click();
        }
        mdevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/ivPhotoCheaked"));
        mdevice.findObject(By.text("确定")).click();
        mdevice.findObject(By.text("生日")).click();
        mdevice.findObject(By.text("比赛")).click();
        mdevice.findObject(By.text("游戏")).click();
        mdevice.findObject(By.text("旅游")).click();
        mdevice.findObject(By.text("互动")).click();
        mdevice.findObject(By.text("成长")).click();
        mdevice.findObject(By.text("捣蛋")).click();
        mdevice.findObject(By.text("陪伴")).click();
        mdevice.findObject(By.text("日常")).click();
        mdevice.findObject(By.text("上传")).click();
//        com.example.lenovo.maandroid:id/add_upload
        mdevice.findObject(By.text("上传")).click();
        Assert.assertFalse( mdevice.findObject(new UiSelector().text("各位看官，还可以进行搜索和添加喔")).exists());
    }
    @Test
//    上传一张图片 + 文字
    public  void  testSendSuccess10() throws InterruptedException {
//       mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add")).click();
        //        com.example.lenovo.maandroid:id/et_content
        mdevice.findObject(By.clazz("android.widget.EditText")).setText(content);
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add_picture")).click();
        Thread.sleep(2000);
//        com.example.lenovo.maandroid:id/rvImageList
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/ivPhotoCheaked")).click();
        mdevice.findObject(By.text("确定")).click();
        mdevice.findObject(By.text("上传")).click();
        Assert.assertFalse( mdevice.findObject(new UiSelector().text("各位看官，还可以进行搜索和添加喔")).exists());
    }
    @Test
//    上传6张图片 + 文字
    public  void  testSendSuccess11() throws InterruptedException {
//       mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add")).click();
//       com.example.lenovo.maandroid:id/et_content
        mdevice.findObject(By.clazz("android.widget.EditText")).setText(content);
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add_picture")).click();
        Thread.sleep(2000);
//        List<UiObject2> ret = new ArrayList<UiObject2>();
//        ret = mdevice.findObjects(By.res("com.example.lenovo.maandroid:id/rvImageList"));
        List<UiObject2> ret = mdevice.findObjects(By.res("com.example.lenovo.maandroid:id/ivPhotoCheaked"));
        for(int i=1;i<7;i++){
            ret.get(i).click();
        }
        mdevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/ivPhotoCheaked"));
        mdevice.findObject(By.text("确定")).click();
//        com.example.lenovo.maandroid:id/add_upload
        mdevice.findObject(By.text("上传")).click();
        Assert.assertFalse( mdevice.findObject(new UiSelector().text("各位看官，还可以进行搜索和添加喔")).exists());
    }
    @Test
//    上传一张图片 +一个标签 + 文字
    public  void  testSendSuccess12() throws InterruptedException {
//       mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add")).click();
        //        com.example.lenovo.maandroid:id/et_content
        mdevice.findObject(By.clazz("android.widget.EditText")).setText(content);
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add_picture")).click();
        Thread.sleep(2000);
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/ivPhotoCheaked")).click();
        mdevice.findObject(By.text("确定")).click();

        mdevice.findObject(By.text("生日")).click();

        mdevice.findObject(By.text("上传")).click();
        Assert.assertFalse( mdevice.findObject(new UiSelector().text("各位看官，还可以进行搜索和添加喔")).exists());
    }
    @Test
//    上传6张图片 +一个标签 +文字
    public  void  testSendSuccess13() throws InterruptedException {
//       mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add")).click();
        //        com.example.lenovo.maandroid:id/et_content
        mdevice.findObject(By.clazz("android.widget.EditText")).setText(content);
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add_picture")).click();
        Thread.sleep(2000);
//        List<UiObject2> ret = new ArrayList<UiObject2>();
//        ret = mdevice.findObjects(By.res("com.example.lenovo.maandroid:id/rvImageList"));
        List<UiObject2> ret = mdevice.findObjects(By.res("com.example.lenovo.maandroid:id/ivPhotoCheaked"));
        for(int i=1;i<7;i++){
            ret.get(i).click();
        }
        mdevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/ivPhotoCheaked"));
        mdevice.findObject(By.text("确定")).click();
        mdevice.findObject(By.text("生日")).click();
        mdevice.findObject(By.text("上传")).click();
        Assert.assertFalse( mdevice.findObject(new UiSelector().text("各位看官，还可以进行搜索和添加喔")).exists());
    }
    @Test
//    上传一张图片 + 6个标签 +文字
    public  void  testSendSuccess14() throws InterruptedException {
//       mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add")).click();
        //        com.example.lenovo.maandroid:id/et_content
        mdevice.findObject(By.clazz("android.widget.EditText")).setText(content);
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add_picture")).click();
        Thread.sleep(2000);
        mdevice.findObject(By.text("生日")).click();
        mdevice.findObject(By.text("比赛")).click();
        mdevice.findObject(By.text("游戏")).click();
        mdevice.findObject(By.text("旅游")).click();
        mdevice.findObject(By.text("互动")).click();
        mdevice.findObject(By.text("成长")).click();
        mdevice.findObject(By.text("捣蛋")).click();
        mdevice.findObject(By.text("陪伴")).click();
        mdevice.findObject(By.text("日常")).click();

        mdevice.findObject(By.text("上传")).click();

        Assert.assertFalse( mdevice.findObject(new UiSelector().text("各位看官，还可以进行搜索和添加喔")).exists());
    }
    @Test
//    上传6张图片+6个标签+文字
    public  void  testSendSuccess15() throws InterruptedException {
//       mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add")).click();
        //        com.example.lenovo.maandroid:id/et_content
        mdevice.findObject(By.clazz("android.widget.EditText")).setText(content);
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/add_picture")).click();
        Thread.sleep(2000);
//        List<UiObject2> ret = new ArrayList<UiObject2>();
//        ret = mdevice.findObjects(By.res("com.example.lenovo.maandroid:id/rvImageList"));
        List<UiObject2> ret = mdevice.findObjects(By.res("com.example.lenovo.maandroid:id/ivPhotoCheaked"));
        for(int i=1;i<7;i++){
            ret.get(i).click();
        }
        mdevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/ivPhotoCheaked"));
        mdevice.findObject(By.text("确定")).click();
        mdevice.findObject(By.text("生日")).click();
        mdevice.findObject(By.text("比赛")).click();
        mdevice.findObject(By.text("游戏")).click();
        mdevice.findObject(By.text("旅游")).click();
        mdevice.findObject(By.text("互动")).click();
        mdevice.findObject(By.text("成长")).click();
        mdevice.findObject(By.text("捣蛋")).click();
        mdevice.findObject(By.text("陪伴")).click();
        mdevice.findObject(By.text("日常")).click();
        mdevice.findObject(By.text("上传")).click();
//        com.example.lenovo.maandroid:id/add_upload
        mdevice.findObject(By.text("上传")).click();
        Assert.assertFalse( mdevice.findObject(new UiSelector().text("各位看官，还可以进行搜索和添加喔")).exists());
    }
}
