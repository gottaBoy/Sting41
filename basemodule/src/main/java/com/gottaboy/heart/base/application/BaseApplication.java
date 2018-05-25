package com.gottaboy.heart.base.application;

import android.app.Application;
import android.support.annotation.Nullable;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.cookie.CookieJarImpl;
import com.zhy.http.okhttp.cookie.store.PersistentCookieStore;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by my on 2018/5/12.
 */

public class BaseApplication extends Application {
    public static String dispatchid;

    private static BaseApplication mAppCotext;
//    public static PersistentCookieStore persistentCookieStore;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppCotext = this;

//        persistentCookieStore = new PersistentCookieStore(getApplicationContext());
        //ClearableCookieJar cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(mAppCotext));
        CookieJarImpl cookieJar = new CookieJarImpl(new PersistentCookieStore(getApplicationContext()));
//        if (cookieJar.getCookieStore()!=null&&cookieJar.getCookieStore()) {
//            isCookie=true;
//        }
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cookieJar(cookieJar)
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }

    @Nullable
    public static Application getAppContext() {
        return mAppCotext;
    }


}
