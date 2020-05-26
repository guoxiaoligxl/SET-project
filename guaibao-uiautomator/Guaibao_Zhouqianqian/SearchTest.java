package com.example.lenovo.maandroid.Guaibao_Zhouqianqian;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import org.junit.Assert;
import org.junit.Test;

public class SearchTest extends BaseTestUiautomator {
    @Test
    public  void  testGain1() throws UiObjectNotFoundException {
//        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/look")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/btn_search")).click();
        Assert.assertFalse( mdevice.findObject(new UiSelector().text("暂无相关数据哦")).exists());
    }
    @Test
    public  void  testGain2() throws UiObjectNotFoundException {
//        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/look")).click();
        mdevice.findObject(By.text("生日")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/btn_search")).click();
        Assert.assertFalse( mdevice.findObject(new UiSelector().text("暂无相关数据哦")).exists());
    }
    @Test
    public  void  testGain3() throws UiObjectNotFoundException {
//        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/look")).click();
        mdevice.findObject(By.text("生日")).click();
        mdevice.findObject(By.text("比赛")).click();
        mdevice.findObject(By.text("游戏")).click();
        mdevice.findObject(By.text("旅游")).click();
        mdevice.findObject(By.text("互动")).click();
        mdevice.findObject(By.text("成长")).click();
        mdevice.findObject(By.text("捣蛋")).click();
        mdevice.findObject(By.text("陪伴")).click();
        mdevice.findObject(By.text("日常")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/btn_search")).click();
        Assert.assertFalse( mdevice.findObject(new UiSelector().text("暂无相关数据哦")).exists());
    }
    @Test
    public  void  testGain4() throws UiObjectNotFoundException {
//        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/look")).click();
        mdevice.findObject(By.text("生日")).click();
        mdevice.findObject(By.text("捣蛋")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/btn_search")).click();
        Assert.assertFalse( mdevice.findObject(new UiSelector().text("暂无相关数据哦")).exists());
    }
    @Test
    public  void  testGain5() throws UiObjectNotFoundException {
//        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/look")).click();
        mdevice.findObject(By.text("生日")).click();
        mdevice.findObject(By.text("比赛")).click();
        mdevice.findObject(By.text("互动")).click();
        mdevice.findObject(By.text("日常")).click();
        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/btn_search")).click();
        Assert.assertFalse( mdevice.findObject(new UiSelector().text("暂无相关数据哦")).exists());
    }




}
