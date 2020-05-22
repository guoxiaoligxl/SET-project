package com.example.guaibao_guoxiaoli;

import android.app.Instrumentation;
import android.os.RemoteException;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Demo {
    Instrumentation minstrumentation;
    UiDevice mDevice;

    @Before
    public void startUp() throws RemoteException {
        minstrumentation = InstrumentationRegistry.getInstrumentation();
        mDevice=UiDevice.getInstance(minstrumentation);
//        mDevice.pressHome();
        if(!mDevice.isScreenOn()){
            mDevice.wakeUp();
        }
    }

    public void exit() throws InterruptedException {
        mDevice.findObject(By.text("我的")).click();
        mDevice.findObject(By.text("设置")).click();
        mDevice.findObject(By.text("退出登录")).click();
        Thread.sleep(3000);
    }

    public void login(String user_phone,String user_psd) throws InterruptedException {
//        mDevice.findObject(By.text("手机号")).click();
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/et_userPhone")).click();
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/et_userPhone")).setText(user_phone);
        Thread.sleep(2000);
//        mDevice.findObject(By.text("密码")).click();
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/et_userPassword")).click();
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/et_userPassword")).setText(user_psd);
        Thread.sleep(2000);
        mDevice.findObject(By.text("Login")).click();
        Thread.sleep(3000);
    }

    public void register(String phone,String yan,String psd,String repsd) throws InterruptedException {
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/fab")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/et_phone")).setText(phone);
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/et_yanzhengma")).setText(yan);
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/et_password")).setText(psd);
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/et_password1")).setText(repsd);
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/btn_submit")).click();
//        mDevice.findObject(By.text("确认提交")).click();
    }

    public void forget(String phone,String yan,String psd,String repsd) throws InterruptedException {
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/fab")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/et_phone")).setText(phone);
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/et_yanzhengma")).setText(yan);
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/et_password")).setText(psd);
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/et_password1")).setText(repsd);
        mDevice.findObject(By.res("com.example.lenovo.maandroid:id/btn_submit")).click();
        Thread.sleep(3000);
//        mDevice.findObject(By.text("确认提交")).click();
    }

    @Test
    public void testLoginSuccess() throws InterruptedException {
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        login("1573281241","123456gxl");
        exit();
    }

    @Test
    public void testLoginFailphone() throws InterruptedException {//手机格式错误
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        login("15732812","123456gxl");
    }

    @Test
    public void testLoginFailpsd() throws InterruptedException {//密码长度不够8位
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        login("1573281241","123456");
    }

    @Test
    public void testLoginFailpsd1() throws InterruptedException {//密码长度超出12位
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        login("1573281241","123456asdfghjkl");
    }

    @Test
    public void testLoginFailpsd2() throws InterruptedException {//密码为空
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        login("1573281241","");
    }

    @Test
    public void testLoginFail() throws InterruptedException {//用户名与密码不匹配
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        login("1573281241","123456");
    }

    @Test
    public void testRegisterSuccess() throws InterruptedException {
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        register("15233625101","6843","123456gxl","123456gxl");
    }

    @Test
    public void testRegisterPhone() throws InterruptedException {//用户名格式错误
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        register("1523362","6843","123456gxl","123456gxl");
    }

    @Test
    public void testRegisterPsd() throws InterruptedException {//密码长度不够8位
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        register("15233625101","6843","123456","123456");
    }

    @Test
    public void testRegisterPsd1() throws InterruptedException {//密码长度超出12位
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        register("15233625101","6843","123456asdfghjkl","123456asdfghjkl");
    }

    @Test
    public void testRegisterRepsd() throws InterruptedException {//密码不一致
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        register("15233625101","6843","123456gxl","123456gxk");
    }

    @Test
    public void testForget() throws InterruptedException{
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        forget("15233625101","6843","123456gxl","123456gxl");
    }

    @Test
    public void testForgetPhone() throws InterruptedException{//未注册用户
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        forget("15233625102","6843","123456gxl","123456gxl");
    }

    @Test
    public void testForgetPsd() throws InterruptedException{//用户名与密码不一致
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        forget("15233625101","6843","123456gxk","123456gxk");
    }

    @Test
    public void testForgetRepsd() throws InterruptedException{//两次密码不一致
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        forget("15233625101","6843","123456gxl","123456gxj");
    }

    @Test
    public void testForgetPhone1() throws InterruptedException{//用户名格式错误
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        forget("15233625","6843","123456gxl","123456gxl");
    }

    @Test
    public void testForgetPsd1() throws InterruptedException{//密码不足8位
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        forget("15233625101","6843","123456g","123456g");
    }

    @Test
    public void testForgetPsd2() throws InterruptedException{//密码超出12位
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        forget("15233625101","6843","123456gxlzxcvbn","123456gxlzxcvbn");
    }

    @Test
    public void testExit() throws InterruptedException {
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        login("1573281241","123456gxl");
        exit();
    }

    @Test
    public void testIntro() throws InterruptedException {
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        login("1573281241","123456gxl");
        mDevice.findObject(By.text("我的")).click();
        mDevice.findObject(By.text("设置")).click();
        mDevice.findObject(By.text("功能介绍")).click();
    }

    @Test
    public void testServe() throws InterruptedException {
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        login("1573281241","123456gxl");
        mDevice.findObject(By.text("我的")).click();
        mDevice.findObject(By.text("设置")).click();
        mDevice.findObject(By.text("设软件许可及服务协议置")).click();
    }

    @Test
    public void testVer() throws InterruptedException {
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        login("1573281241","123456gxl");
        mDevice.findObject(By.text("我的")).click();
        mDevice.findObject(By.text("设置")).click();
        mDevice.findObject(By.text("当前版本")).click();
    }

    @Test
    public void testHelp() throws InterruptedException {
        mDevice.findObject(By.text("乖宝")).click();
        Thread.sleep(3000);
        login("1573281241","123456gxl");
        mDevice.findObject(By.text("我的")).click();
        mDevice.findObject(By.text("设置")).click();
        mDevice.findObject(By.text("帮助")).click();
    }

//    @Test
//    public void test

    //    @After
//    public void tearDown() throws InterruptedException {
//
//    }

}
