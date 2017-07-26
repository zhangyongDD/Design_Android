package com.kczd.core;

/**
 * zhangy
 * Created by Administrator on 2017/7/20.
 *
 * 接收app层的各种Action
 */

public interface AppAction {

    /**
     * 注册
     *
     * @param mobile     手机号
     * @param password   密码
     * @param password2  重复密码
     * @param user_type  用户类型
     * @param listener   回调监听器
     */
    public void register(String mobile,String password,String password2,String user_type,ActionCallbackListener<Void> listener);

    /**
     *
     * @param moblie    登录名
     * @param password  密码\
     * @param listener   回调监听器
     */
    public void login(String moblie,String password,ActionCallbackListener<Void> listener);

}
