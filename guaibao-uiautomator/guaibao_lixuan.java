package com.example.myapplication;

import android.app.Instrumentation;
import android.os.RemoteException;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class guaibao_lixuan {
    Instrumentation mInstrumentation;
    UiDevice mDevice;
    public void login() throws InterruptedException{
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/et_userPhone")).setText("18831187221");
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/et_userPassword")).setText("chenmeng520");
        UiObject2 loginButton = mDevice.findObject(By.text("Login"));
        loginButton.click();
    }
    @Before
    public void startUp() throws RemoteException, InterruptedException {
        mInstrumentation = InstrumentationRegistry.getInstrumentation();
        //获得连接设备
        mDevice = UiDevice.getInstance(mInstrumentation);
        //按键home
        mDevice.pressHome();
        //判断是否锁屏
        boolean status = mDevice.isScreenOn();
        if(!status){
            mDevice.wakeUp();
        }
        //打开app
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        login();
    }
    @After
    public void tearDown()throws UiObjectNotFoundException{
        mDevice.findObject(By.text("设置")).click();
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/tuichu")).click();
    }
    @Test
    //修改昵称1
    public void testeditname() throws UiObjectNotFoundException, InterruptedException {
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/img_4")).click();
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/edit_m")).click();
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/edit_username")).clear();
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/edit_username")).setText("小猛猛");
        Assert.assertTrue(mDevice.findObject(new UiSelector().text("修改失败")).exists());
        mDevice.findObject(By.text("完成")).click();
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/return0")).click();
    }
    //查看消息通知2
    @Test
    public void invitationItem_test() throws UiObjectNotFoundException, InterruptedException {
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/img_4")).click();
        mDevice.findObject(By.text("消息通知")).click();
        Thread.sleep(3000);
        //滚动查看
        UiScrollable scrollable= new UiScrollable(new UiSelector().className("android.widget.ScrollView"));
        scrollable.flingForward();
        scrollable.flingBackward();
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/return0")).click();
    }
    //查看帖子管理和帖子详细3、4
    @Test
    public void invitation_test() throws UiObjectNotFoundException, InterruptedException{
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/img_4")).click();
        //查看帖子管理
        mDevice.findObject(By.text("帖子管理")).click();
        Thread.sleep(2000);
        //查看帖子详细
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/community_content")).click();
        Thread.sleep(2000);
        //返回
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/detail_back")).click();
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/return2")).click();
    }
    //帖子管理界面评论（数据驱动）5、6、7、8
    public void invitationcomment(String text) throws UiObjectNotFoundException, InterruptedException{
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/img_4")).click();
        mDevice.findObject(By.text("帖子管理")).click();
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/community_commenting")).click();
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/et_input_message")).setText(text);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/confrim_btn")).click();
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/return2")).click();
    }
    @Test
    public void invitation_comment() throws UiObjectNotFoundException, InterruptedException{
        invitationcomment("没有乱码了");
        invitationcomment("helloworld");
        invitationcomment("123&(((&^");
        invitationcomment("124&(^hell你好");
    }
    //帖子详细界面评论（数据驱动）9、10、11、12
    public void invitationcomment1(String text) throws UiObjectNotFoundException, InterruptedException{
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/img_4")).click();
        mDevice.findObject(By.text("帖子管理")).click();
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/community_content")).click();
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/community_commenting")).click();
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/et_input_message")).setText(text);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/confrim_btn")).click();
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/detail_back")).click();
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/return2")).click();
    }
    @Test
    public void invitation_comment1() throws UiObjectNotFoundException, InterruptedException{
        invitationcomment1("没有乱码了");
        invitationcomment1("helloworld");
        invitationcomment1("123&(((&^");
        invitationcomment1("124&(^hell你好");
    }
    //添加孩子（数据驱动）13、14、15、16、17、18、19、20
    public void addchidrensuccess(String name,String year,String month,String day) throws UiObjectNotFoundException, InterruptedException{
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/img_4")).click();
        mDevice.findObject(By.text("孩子管理")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.text("添加孩子")).click();
        Thread.sleep(2000);
        //昵称
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/child_nickname")).setText(name);
        //年
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/child_years")).setText(year);
        //月
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/child_month")).setText(month);
        //日
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/child_day")).setText(day);
        Thread.sleep(2000);
        mDevice.findObject(By.text("完成")).click();
        Thread.sleep(2000);
        //mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/child_fanhui")).click();
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/return0")).click();
    }
    @Test
    public void addchidrensuccess1() throws UiObjectNotFoundException, InterruptedException{
        addchidrensuccess("陈小猛","1998","4","10");
        addchidrensuccess("chenmeng","1998","4","10");
        addchidrensuccess(",!@%","1998","4","10");
        addchidrensuccess("陈12@#me","1998","4","10");
    }
    public void addchidrenfail(String name,String year,String month,String day) throws UiObjectNotFoundException, InterruptedException{
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/img_4")).click();
        mDevice.findObject(By.text("孩子管理")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.text("添加孩子")).click();
        Thread.sleep(2000);
        //昵称
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/child_nickname")).setText(name);
        //年
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/child_years")).setText(year);
        //月
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/child_month")).setText(month);
        //日
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/child_day")).setText(day);
        Thread.sleep(2000);
        mDevice.findObject(By.text("完成")).click();
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/child_fanhui")).click();
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/return0")).click();
    }
    @Test
    public void addchidrenfail1() throws UiObjectNotFoundException, InterruptedException{
        addchidrenfail("1234567890","1998","4","10");
        addchidrenfail("陈小猛","2999","4","10");
        addchidrenfail("陈小猛","1998","40","10");
        addchidrenfail("陈小猛","1998","4","40");
    }
    //修改昵称21
    @Test
    public void edit_childnickname() throws UiObjectNotFoundException, InterruptedException {
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/img_4")).click();
        mDevice.findObject(By.text("孩子管理")).click();
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/child_item_i")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/child_nickname")).clear();
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/child_nickname")).setText("李璇");
        mDevice.findObject(By.text("完成")).click();
        Thread.sleep(2000);
        //mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/child_fanhui")).click();
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/return0")).click();
    }
    //修改生日22
    @Test
    public void edit_childbirthday() throws UiObjectNotFoundException, InterruptedException {
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/img_4")).click();
        mDevice.findObject(By.text("孩子管理")).click();
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/child_item_i")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/child_years")).clear();
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/child_years")).setText("1975");
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/child_month")).clear();
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/child_month")).setText("4");
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/child_day")).clear();
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/child_day")).setText("7");
        mDevice.findObject(By.text("完成")).click();
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/return0")).click();
    }
    //删除孩子-确定删除23
    @Test
    public void deletechildren_ok() throws UiObjectNotFoundException, InterruptedException{
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/img_4")).click();
        mDevice.findObject(By.text("孩子管理")).click();
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/child_item_i")).click();
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/btn_de")).click();
        mDevice.findObject(By.text("确定")).click();
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/return0")).click();
    }
    //删除孩子-取消删除24
    @Test
    public void deletechildren_no() throws UiObjectNotFoundException, InterruptedException{
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/img_4")).click();
        mDevice.findObject(By.text("孩子管理")).click();
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/child_item_i")).click();
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/btn_de")).click();
        mDevice.findObject(By.text("取消")).click();
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/child_fanhui")).click();
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/return0")).click();
    }
    //删除孩子-删除所有孩子
    @Test
    public void deletechildren_all() throws UiObjectNotFoundException, InterruptedException{
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/img_4")).click();
        mDevice.findObject(By.text("孩子管理")).click();
        Thread.sleep(2000);
        UiObject2 listview = mDevice.findObject(By.clazz("android.widget.ListView"));
        int count = listview.getChildCount();
        Log.i("共有",count+"子元素");
        while(count>0) {
            mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/child_item_i")).click();
            Thread.sleep(2000);
            mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/btn_de")).click();
            mDevice.findObject(By.text("确定")).click();
            Thread.sleep(3000);
            count--;
        }
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/return0")).click();
    }
}
