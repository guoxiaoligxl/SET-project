package com.example.mydemo8;

import android.app.Instrumentation;
import android.os.RemoteException;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Test;

public class guaibao_zhangfan {
    Instrumentation mInstrumentation;
    UiDevice mDevice;
    @Before
    public void startup() throws RemoteException, InterruptedException {
        mInstrumentation = InstrumentationRegistry.getInstrumentation();
        mDevice = UiDevice.getInstance(mInstrumentation);
        Thread.sleep(3000);
        if (!mDevice.isScreenOn()) {
            mDevice.wakeUp();
        }
        mDevice.pressHome();
    }
    //登录
    @Test
    public void testLogin() throws InterruptedException, UiObjectNotFoundException {
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        // 输入手机号
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/et_userPhone")).setText("18812092925");
        Thread.sleep(3000);
        // 输入密码
        mDevice.findObject(By.text("密码")).setText("1234567890zf");
        Thread.sleep(3000);
        //点击登录
        mDevice.findObject(By.text("Login")).click();
        Thread.sleep(3000);
    }
    //添加帖子
    @Test
    public void testAddPost() throws InterruptedException, UiObjectNotFoundException {
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/img_3")).click();
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/community_add_post")).click();
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/et_content")).setText("真是开心的一天！");
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/btn_push_speak_push")).click();
        Thread.sleep(3000);
    }
    //添加带图片的帖子
    @Test
    public void testAddPostWithOnePicture()throws InterruptedException, UiObjectNotFoundException {
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/img_3")).click();
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/community_add_post")).click();
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/et_content")).setText("真是开心的一天！");
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/iv_push_speak_img_item")).click();
        Thread.sleep(3000);
        UiObject list = mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/fmImageList"));


    }
    //给帖子评论
    @Test
    public void testComment()throws InterruptedException, UiObjectNotFoundException{
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/img_3")).click();
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/community_commenting")).click();
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/et_input_message")).setText("真棒");
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/confrim_btn")).click();
        Thread.sleep(3000);
    }
    //给帖子点赞
    @Test
    public void testDianzan()throws InterruptedException, UiObjectNotFoundException{
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/img_3")).click();
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/community_praising")).click();
        Thread.sleep(3000);
    }
    //回复评论
    @Test
    public void testReplyToComment()throws InterruptedException, UiObjectNotFoundException{
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/img_3")).click();
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/community_comment1")).click();
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/comment_content")).click();
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/et_input_message")).setText("谢谢你的评论");
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/confrim_btn")).click();
        Thread.sleep(3000);

    }
}
