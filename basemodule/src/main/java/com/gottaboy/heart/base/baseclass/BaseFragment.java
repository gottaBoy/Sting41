package com.gottaboy.heart.base.baseclass;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public abstract class BaseFragment extends Fragment {

    protected BaseActivity mContext;

    protected Unbinder unbinder;

    protected ProgressDialog mLoadingProgress = null;

    @Override
    public void onAttach(Context context) {
        if (context instanceof BaseActivity) {
            mContext = (BaseActivity) context;
        }
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isRegisterEventBus()) {
            EventBusUtil.register(this);
        }
    }

    public View onCreateView(LayoutInflater mInflater, ViewGroup container, Bundle savedInstanceState) {
        View view = mInflater.inflate(getLayoutId(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        if (null != getArguments()) {
            handleArguments(getArguments());
        }
        initView(view, savedInstanceState);
    }

    public void handleArguments(Bundle arguments) {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();  //解除持有对象
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (isRegisterEventBus()) {
            EventBusUtil.unregister(this);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.mContext = null;
    }

    /**
     * 是否注册事件分发
     *
     * @return true绑定EventBus事件分发，默认不绑定，子类需要绑定的话复写此方法返回true.
     */
    protected boolean isRegisterEventBus() {
        return false;
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

    protected abstract void initView(View view, Bundle savedInstanceState);

    //获取fragment布局Id
    protected abstract int getLayoutId();

    //获取宿主Activity
    protected BaseActivity getHoldingActivity() {
        return mContext;
    }

    //添加fragment
    protected void addFragment(BaseFragment fragment) {
        if (null != fragment) {
            getHoldingActivity().addFragment(fragment);
        }
    }



    //移除fragment
    protected void removeFragment() {
        getHoldingActivity().removeFragment();
    }

    /**
     * 替换fragment 不添加堆
     */
    protected void replFragment(BaseFragment fragment) {

        getHoldingActivity().replFragment(fragment);
    }

    /**
     * 收起软键盘
     */
    protected void hideSoftInput() {
        getHoldingActivity().hideSoftInput();
    }

    /**
     * 提示
     *
     * @param msg
     */
    protected void showToast(String msg) {
        getHoldingActivity().showToast(msg);
    }

    protected void showLogToast(String msg) {
        getHoldingActivity().showLongToast(msg);
    }

    /**
     * 进度条
     *
     * @param msg
     */
    protected void loadingProgress(String msg) {

        getHoldingActivity().showLoadingProgress(msg);

    }

    /**
     * 点击不消失进度条
     *
     * @param msg
     */
    protected void touchLoadingProgress(String msg) {

        getHoldingActivity().showLoadingTouchProgress(msg);

    }

    protected void closedLoadingProgress() {

        getHoldingActivity().hideLoadingProgress();

    }

}
