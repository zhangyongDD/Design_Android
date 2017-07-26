/**
 * Copyright (C) 2015. Keegan小钢（http://keeganlee.me）
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kczd.api.net;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Http引擎处理类
 *
 * @author Keegan小钢
 * @date 15/6/21
 * @version 1.0
 */
public class HttpEngine {
    private final static String TAG = "HttpEngine";
    private final static String SERVER_URL = "login/login";
    private static final String BASE_URL = "http://www.weiantang.com/index.php/api/login/login";//请求接口根地址
    private static HttpEngine instance = null;

    private HttpEngine() {

    }

    public static HttpEngine getInstance() {
        if (instance == null) {
            instance = new HttpEngine();
        }
        return instance;
    }

    public <T> T postHandle(Map<String, String> paramsMap, final Type typeOfT) throws IOException {

        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody=new FormBody.Builder()
                .add("mobile","17629047878")
                .add("password","123456")
                .build();
        Request request=new Request.Builder()
                .url(BASE_URL)
                .post(requestBody)
                .build();
        try {
            Response response=client.newCall(request).execute();
            String strResult=response.body().string();
            Gson gson = new Gson();
            return gson.fromJson(strResult,typeOfT);
        } catch (IOException e) {
            e.printStackTrace();
        }
          return null;
    }
}
