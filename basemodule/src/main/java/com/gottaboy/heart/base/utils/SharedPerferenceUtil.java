package com.gottaboy.heart.base.utils;

import android.content.Context;

/**
 * Created by Administrator on 2017/3/29.
 */

public class SharedPerferenceUtil {

    //获取当前用户ID
    public static String getpersonId(Context context) {
        return context.getSharedPreferences("info", context.MODE_PRIVATE).getString("personId", "");
    }

    //存储当前用户ID
    public static void savepersonId(Context context, String personId) {
        context.getSharedPreferences("info", context.MODE_PRIVATE).edit().putString("personId", personId).commit();
    }


    public static void savesessionID(Context context, String sessionID) {
        context.getSharedPreferences("info", context.MODE_PRIVATE).edit().putString("sessionID", sessionID).commit();

    }
    public static String getsessionID(Context context) {
        return context.getSharedPreferences("info", context.MODE_PRIVATE).getString("sessionID", "");
    }

    public static void saveuserID(Context context, String sessionID) {
        context.getSharedPreferences("info", context.MODE_PRIVATE).edit().putString("userID", sessionID).commit();

    }
    public static String getuserID(Context context) {
        return context.getSharedPreferences("info", context.MODE_PRIVATE).getString("userID", "");
    }

    public static void saveuserName(Context context, String sessionID) {
        context.getSharedPreferences("info", context.MODE_PRIVATE).edit().putString("userName", sessionID).commit();

    }
    public static String getuserName(Context context) {
        return context.getSharedPreferences("info", context.MODE_PRIVATE).getString("userName", "");
    }

    public static void saveuserTel(Context context, String sessionID) {
        context.getSharedPreferences("info", context.MODE_PRIVATE).edit().putString("userTel", sessionID).commit();

    }
    public static String getuserTel(Context context) {
        return context.getSharedPreferences("info", context.MODE_PRIVATE).getString("userTel", "");
    }

    public static void saveName(Context context, String userid) {
        context.getSharedPreferences("info", context.MODE_PRIVATE).edit().putString("name", userid).commit();
    }

    public static String getName(Context context) {
        return context.getSharedPreferences("info", context.MODE_PRIVATE).getString("name", "");
    }

    public static void saveCompanyName(Context context, String companyName) {
        context.getSharedPreferences("info", context.MODE_PRIVATE).edit().putString("companyName", companyName).commit();
    }
    public static String getCompanyName(Context context) {
        return context.getSharedPreferences("info", context.MODE_PRIVATE).getString("companyName", "");
    }

    public static void saveCount(Context context, int userid) {
        context.getSharedPreferences("info", context.MODE_PRIVATE).edit().putInt("count", userid).commit();
    }

    public static int getCount(Context context) {
        return context.getSharedPreferences("info", context.MODE_PRIVATE).getInt("count", 1);
    }
}
