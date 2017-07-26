package com.kczd.api;

import com.google.gson.reflect.TypeToken;
import com.kczd.api.net.HttpEngine;
import com.kczd.model.User;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * zhangy
 * Created by Administrator on 2017/7/20.
 *
 * Api实现类,实现所有接口方法
 */

public class ApiImpl implements Api{
    private final static String TIME_OUT_EVENT = "CONNECT_TIME_OUT";
    private final static String TIME_OUT_EVENT_MSG = "连接服务器失败";

    private HttpEngine httpEngine;

    public ApiImpl() {
        httpEngine = HttpEngine.getInstance();
    }

    @Override
    public ApiResponse<Void> registerByPhone(String mobile, String password, String password2, String user_type) {
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("mobile", mobile);
        paramMap.put("password", password);
        paramMap.put("password2", password2);
        paramMap.put("user_type", user_type);

        Type type = new TypeToken<ApiResponse<User>>(){}.getType();
        try {
            return httpEngine.postHandle(paramMap, type);
        } catch (IOException e) {
            return new ApiResponse(TIME_OUT_EVENT, TIME_OUT_EVENT_MSG);
        }
    }

    @Override
    public ApiResponse<Void> loginByPhone(String moblie, String password) {
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("moblie", moblie);
        paramMap.put("password", password);

        Type type = new TypeToken<ApiResponse<User>>(){}.getType();
        try {
            return httpEngine.postHandle(paramMap, type);
        } catch (IOException e) {
            return new ApiResponse(TIME_OUT_EVENT, TIME_OUT_EVENT_MSG);
        }
    }
}
