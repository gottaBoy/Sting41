package com.gottaboy.heart.base.baseclass;


import com.gottaboy.heart.base.baseclass.event.Event;

import org.greenrobot.eventbus.EventBus;

/**
 * @author wj
 * @date 2017/7/27
 * @discription EventBus订阅、取消订阅、发布等方法
 */

public class EventBusUtil {

    public static void register(Object subscriber) {
        EventBus.getDefault().register(subscriber);
    }

    public static void unregister(Object subscriber) {
        EventBus.getDefault().unregister(subscriber);
    }

    public static void sendEvent(Event event) {
        EventBus.getDefault().post(event);
    }

    public static void sendStickyEvent(Event event) {
        EventBus.getDefault().postSticky(event);
    }

    // 其他

}
