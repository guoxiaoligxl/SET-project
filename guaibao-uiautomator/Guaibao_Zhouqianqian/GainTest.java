package com.example.lenovo.maandroid.Guaibao_Zhouqianqian;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import org.junit.Assert;
import org.junit.Test;

public class GainTest extends BaseTestUiautomator {
    @Test
    public  void  testGain1() throws UiObjectNotFoundException {
//        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/image").index(0)).click();
        Assert.assertTrue(mdevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/image").index(0)).isChecked());
    }
    @Test
    public  void  testGain2() throws UiObjectNotFoundException {
//        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/image").index(1)).click();
        Assert.assertTrue(mdevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/image").index(1)).isChecked());
    }
    @Test
    public  void  testGain3() throws UiObjectNotFoundException {
//        mdevice.findObject(By.res("com.example.lenovo.maandroid:id/img_2")).click();
        mdevice.findObject(By.text("成长记录")).click();
        mdevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/image").index(2)).click();
        Assert.assertTrue(mdevice.findObject(new UiSelector().resourceId("com.example.lenovo.maandroid:id/image").index(2)).isChecked());
    }
}
