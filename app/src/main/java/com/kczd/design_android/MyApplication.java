package com.kczd.design_android;

import android.app.Application;

import com.kczd.core.AppAction;
import com.kczd.core.AppActionImpl;

/**
 * zhangy
 * Created by Administrator on 2017/7/20.
 *
 * Application类，应用级别的操作都放这里
 */

public class MyApplication extends Application{

    private AppAction appAction;

    @Override
    public void onCreate() {
        super.onCreate();

        appAction=new AppActionImpl(this);
    }

    public AppAction getAppAction() {
        return appAction;
    }
}
