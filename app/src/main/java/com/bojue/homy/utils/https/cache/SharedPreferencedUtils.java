package com.bojue.homy.utils.https.cache;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2018/1/25.
 */

public class SharedPreferencedUtils {
    private static final String SET_COOKIE="cookie";
    private static final String COOKIE_KEY="cookie_key";
    private static SharedPreferences cookieSharedPreferences;
    //保存cookie
    public static void saveCookie(Context context,String cookie){
        cookieSharedPreferences=context.getSharedPreferences(SET_COOKIE,
                Context.MODE_PRIVATE);

        SharedPreferences.Editor editor=cookieSharedPreferences.edit();
        editor.putString(COOKIE_KEY,cookie).commit();
    }
    //获取cookie
    public static String getCookie(Context context){
        if (cookieSharedPreferences==null){
            cookieSharedPreferences=context.getSharedPreferences(SET_COOKIE,
                    Context.MODE_PRIVATE);
        }
        String cookie=cookieSharedPreferences.getString(COOKIE_KEY,"");
        return cookie;
    }
    //清除cookie
    public static void clearCookie(Context context){
        if (cookieSharedPreferences==null){
            cookieSharedPreferences=context.getSharedPreferences(SET_COOKIE,
                    Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor=cookieSharedPreferences.edit();
        editor.clear().commit();
    }

}
