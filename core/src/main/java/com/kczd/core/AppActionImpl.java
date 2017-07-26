package com.kczd.core;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;

import com.kczd.api.Api;
import com.kczd.api.ApiImpl;
import com.kczd.api.ApiResponse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * zhangy
 * Created by Administrator on 2017/7/20.
 *
 * AppAction接口的实现类
 */

public class AppActionImpl implements AppAction{

    private Context context;
    private Api api;

    public AppActionImpl(Context context) {
        this.context = context;
        this.api = new ApiImpl();
    }

    @Override
    public void register(final String mobile, final String password, final String password2, final String user_type, final ActionCallbackListener<Void> listener) {
        // 参数检查
        if (TextUtils.isEmpty(mobile)) {
            if (listener != null) {
                listener.onFailure(ErrorEvent.PARAM_NULL, "手机号为空");
            }
            return;
        }
        if (TextUtils.isEmpty(password)) {
            if (listener != null) {
                listener.onFailure(ErrorEvent.PARAM_NULL, "密码为空");
            }
            return;
        }
        Pattern pattern = Pattern.compile("1\\d{10}");
        Matcher matcher = pattern.matcher(mobile);
        if (!matcher.matches()) {
            if (listener != null) {
                listener.onFailure(ErrorEvent.PARAM_ILLEGAL, "手机号不正确");
            }
            return;
        }

        // 请求Api
        new AsyncTask<Void, Void, ApiResponse<Void>>() {
            @Override
            protected ApiResponse<Void> doInBackground(Void... voids) {
                return api.registerByPhone(mobile, password, password2,user_type);
            }

            @Override
            protected void onPostExecute(ApiResponse<Void> response) {
                if (listener != null && response != null) {
                    if (response.isSuccess()) {
                        listener.onSuccess(null);
                    } else {
                        listener.onFailure(response.getCode(), response.getMsg());
                    }
                }
            }
        }.execute();
    }

    @Override
    public void login(final String moblie, final String password, final ActionCallbackListener<Void> listener) {
        // 参数检查
        if (TextUtils.isEmpty(moblie)) {
            if (listener != null) {
                listener.onFailure(ErrorEvent.PARAM_NULL, "登录名为空");
            }
            return;
        }
        if (TextUtils.isEmpty(password)) {
            if (listener != null) {
                listener.onFailure(ErrorEvent.PARAM_NULL, "密码为空");
            }
            return;
        }
        // 请求Api
        new AsyncTask<Void, Void, ApiResponse<Void>>() {
            @Override
            protected ApiResponse<Void> doInBackground(Void... voids) {
                return api.loginByPhone(moblie, password);
            }

            @Override
            protected void onPostExecute(ApiResponse<Void> response) {
                if (listener != null && response != null) {
                    if (response.isSuccess()) {
                        listener.onSuccess(null);
                    } else {
                        listener.onFailure(response.getCode(), response.getMsg());
                    }
                }
            }
        }.execute();
    }
}
