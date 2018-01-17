package com.bojue.homy.view.activity.land_register;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;

import org.w3c.dom.Text;

import retrofit2.http.PUT;

/**
 * Created by Xie on 2018/1/16.
 * 保存用户信息的管理类
 */

public class UserManage {

    private static UserManage instance;

    private UserManage(){

    }
    public static UserManage getInstance(){
        if(instance == null){
            instance = new UserManage();
        }
       return instance;
    }

    /**
     * 保存自动登录的用户信息
     * @param context
     * @param userPhone
     * @param passWord
     */
    public void saveUserInfo(Context context,String userPhone,String passWord){
        SharedPreferences sp = context.getSharedPreferences("userInfo",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("USER_PHONE",userPhone);
        editor.putString("PASS_WORD",passWord);
        editor.commit();
    }

    /**
     * 获取用户信息
     * @param context
     * @return
     */
    public UserInfo getUserInfo(Context context){
        SharedPreferences sp = context.getSharedPreferences("userInfo",Context.MODE_PRIVATE);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserPhone(sp.getString("USER_PHONE",""));
        userInfo.setPassword(sp.getString("PASS_WORD",""));
        return userInfo;
    }

    /**
     * 判断方法
     * 若手机号码和密码符合，则返回true，重新打开回到登陆界面
     * 否则重新打开回到主页界面
     * 实现注销功能
     * @param context
     * @return
     */
    public boolean hasUserInfo(Context context){
        UserInfo userInfo = getUserInfo(context);
        if(userInfo != null){
            if(userInfo.getUserPhone().equals("Homy") && userInfo.getPassword().equals("Homy")) {
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    /**
     * 用户手机号码和密码model
     * craeate by libin
     */
    public class UserInfo {

        /**
         * 手机号码
         */
        private String userPhone;

        /**
         * 密码
         */
        private String passWord;

        public String getPassword() {
            return passWord;
        }

        public void setPassword(String passWord) {
            this.passWord = passWord;
        }

        public String getUserPhone() {
            return userPhone;
        }

        public void setUserPhone(String userPhone) {
            this.userPhone = userPhone;
        }

    }
}
