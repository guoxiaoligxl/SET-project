package com.example.lenovo.maandroid.Guaibao_Zhouqianqian;

import android.app.Instrumentation;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.util.Log;

//import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;


public class BaseTestUiautomator {
    UiDevice mdevice;
    Instrumentation instrumentation;

//    @Before
    public void StartUp() throws RemoteException {
         instrumentation = InstrumentationRegistry.getInstrumentation();
//        获得连接设备
        mdevice = UiDevice.getInstance(instrumentation);
//        按home键
        mdevice.pressHome();
//        判断是否锁屏
        boolean status = mdevice.isScreenOn();
        if(!status){
            mdevice.wakeUp();
        }
        Log.i("naj ","ak");
    }

}
