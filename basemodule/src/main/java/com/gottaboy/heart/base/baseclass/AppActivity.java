package com.gottaboy.heart.base.baseclass;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.gottaboy.heart.base.baseclass.event.Event;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author wj
 * @date 2017/7/12
 * @discription
 */

public abstract class AppActivity extends BaseActivity {

    protected Unbinder unbinder;

    public OnEventListener onEventListener;

    public OnEventListener getOnEventListener() {
        return onEventListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        unbinder = ButterKnife.bind(this);

        if (isRegisterEventBus()) {
            EventBusUtil.register(this);
        }

        if (null != getIntent()) {
            handleIntent(getIntent());
        }

        if (getFragmentContentId() != 0 && (null == getSupportFragmentManager().getFragments()
                || getSupportFragmentManager().getFragments().size() == 0)) {
            BaseFragment firstFragment = getFirstFragment();
            if (null != firstFragment) {
                addFragment(firstFragment);
            }
        }
        initData();
        ActivityManager.getInstance().addActivity(this) ;
    }

    /**
     * 是否注册事件分发
     *
     * @return true绑定EventBus事件分发，默认不绑定，子类需要绑定的话复写此方法返回true.
     */
    protected boolean isRegisterEventBus() {
        return false;
    }

    protected BaseFragment getFirstFragment() {
        return null;
    }

    @Override
    protected void onDestroy() {
        hideLoadingProgress();
        super.onDestroy();
//        Glide.with(this).pauseRequests();
        if (isRegisterEventBus()) {
            EventBusUtil.unregister(this);
        }
        unbinder.unbind();
    }

    //获取Intent  有传参时，可以重写这个方法
    protected void handleIntent(Intent intent) {
    }

    protected abstract void initData();

    @Override
    protected int getContentViewId() {
        return 0;
    }

    @Override
    protected int getFragmentContentId() {
        return 0;
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBusCome(Event event) {
        if (event != null) {
            receiveEvent(event);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onStickyEventBusCome(Event event) {
        if (event != null) {
            receiveStickyEvent(event);
        }
    }

    /**
     * 接收到分发到事件
     *
     * @param event 事件
     */
    protected void receiveEvent(Event event) {

    }

    /**
     * 接受到分发的粘性事件
     *
     * @param event 粘性事件
     */
    protected void receiveStickyEvent(Event event) {

    }


    public interface OnEventListener {
        void OnEvent();
    }

    /**
     * 进度条
     *
     * @param msg
     */
    protected void LoadingProgress(String msg) {
        showLoadingProgress(msg);
    }

    /**
     * 点击不消失进度条
     *
     * @param msg
     */
    protected void TouchLoadingProgress(String msg) {
        showLoadingTouchProgress(msg);
    }

    protected void closedLoadingProgress() {
        hideLoadingProgress();
    }

    /**
     * 设置添加屏幕的背景透明度
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha)
    {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);
    }
}
