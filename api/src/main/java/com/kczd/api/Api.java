package com.kczd.api;

/**
 * zhangy
 * Created by Administrator on 2017/7/20.
 *
 * Api接口;定义所有接口方法
 */

public interface Api {

    /**
     * 注册
     *
     * @param mobile        手机号码
     * @param password      密码
     * @param password2     重复密码
     * @param user_type     注册类型  1、散户   2、商户
     * @return              成功时返回: {version:"V1.2R001T2S",code: "200",msg: "成功",data: {}}

     */
    public ApiResponse<Void> registerByPhone(String mobile,String password,String password2,String user_type);


    /**
     *登录
     *
     * @param moblie        手机号
     * @param password      密码
     * @return              成功时返回: {version:"V1.2R001T2S",code: "200",msg: "成功",data: {}}
     */
    public ApiResponse<Void> loginByPhone(String moblie,String password);
}
