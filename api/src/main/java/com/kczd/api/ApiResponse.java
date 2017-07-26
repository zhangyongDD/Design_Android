package com.kczd.api;

/**
 * zhangy
 * Created by Administrator on 2017/7/20.
 *
 * Api响应结果的封装类,封装了Http请求返回的数据结构
 */

public class ApiResponse<T> {

    private String version;     //接口版本号
    private String code;        //返回码 200为成功
    private String msg;         //返回信息
    private T data;             //单个对象

    //构造函数,初始化code和msg
    public ApiResponse(String code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public boolean isSuccess() {
        return code.equals("200");
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
