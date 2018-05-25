package com.gottaboy.heart.base.baseclass;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.gottaboy.heart.base.application.BaseApplication;


/**
 * @author wj
 * @date 2017/7/12
 * @discription activity 基类
 */

public abstract class BaseActivity extends AppCompatActivity {


    protected ProgressDialog mLoadingProgress = null;

    // 屏幕分辨率容器
    protected DisplayMetrics mDisplayMetrics = new DisplayMetrics();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);
        //设置状态栏颜色
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintColor(R.color.colorPrimaryDark);
        }*/
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        /**4.4系统上使底层导航bar 隐藏*/
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }



    /**添加fragment*/
    protected void addFragment(BaseFragment fragment){
        if (fragment != null){
            getSupportFragmentManager().beginTransaction()
                    .replace(getFragmentContentId(), fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commitAllowingStateLoss();
        }
    }

    /**替换fragment 不加入栈堆*/
    public void replFragment(BaseFragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(getFragmentContentId(), fragment)
                .commitAllowingStateLoss();
    }

    /**移除fragment*/
    protected void removeFragment(){
        if (getSupportFragmentManager().getBackStackEntryCount() > 1){
            getSupportFragmentManager().popBackStack();
        } else {
            ActivityManager.getInstance().finishActivity();
        }
    }


    /**
     * 打开指定activity
     *
     * @param targetActivityClass
     **/
    public void startActivity(Class<?> targetActivityClass) {
        startActivity(targetActivityClass, null);
    }

    /**
     * 打开指定activity(带参数)
     *
     * @param targetActivityClass
     * @param bundle
     */
    public void startActivity(Class<?> targetActivityClass, Bundle bundle) {
        Intent intent = new Intent(this, targetActivityClass);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 关闭当前activity打开新activity
     * @param targetActivityClass
     */
    public void startActivityAndCloseThis(Class<?> targetActivityClass) {
        startActivity(targetActivityClass);
        this.finish();
    }

    /**
     * 关闭当前activity打开新activity(带参数)
     */
    public void startActivityAndCloseThis(Class<?> targetActivityClass, Bundle bundle) {
        startActivity(targetActivityClass, bundle);
        this.finish();
    }

    /**
     * @param cls
     * @param bundle
     * @param requestCode  请求码
     */
    public void startActivityForResult(Class<?> cls, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    //获取布局id
    protected abstract int getContentViewId();

    //获取fragmen内容id
    protected abstract int getFragmentContentId();

    /**
     * 简化Toast
     */
    public void showToast(String msg) {
        ToastUtil.showShort(this, msg);
    }

    public void showLongToast(String msg) {
        ToastUtil.showLong(this, msg);
    }

    /**
     * 收起键盘
     */
    public void hideSoftInput(){
        InputMethodManager imm = (InputMethodManager) getSystemService(BaseApplication.getAppContext().INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(),
                    0);
        }
    }

    /**
     * 关闭加载框
     */
    public void hideLoadingProgress() {
        if (mLoadingProgress != null && mLoadingProgress.isShowing()) {
            mLoadingProgress.dismiss();
        }

        mLoadingProgress = null;
    }


    /**
     * 显示加载框
     */
    public void showLoadingProgress(String msg) {
        if (mLoadingProgress == null) {
            mLoadingProgress = new ProgressDialog(this);
        }

        if (!mLoadingProgress.isShowing()) {
            if (StringUtil.isBlank(msg)) {
                mLoadingProgress.setMessage("正在加载......");
            } else {
                mLoadingProgress.setMessage(msg);
            }

            mLoadingProgress.show();
        }
    }

    /**
     * 点击不消失加载框
     */
    public void showLoadingTouchProgress(String msg) {
        if (mLoadingProgress == null) {
            mLoadingProgress = new ProgressDialog(this);
        }

        if (!mLoadingProgress.isShowing()) {
            mLoadingProgress.setCanceledOnTouchOutside(false);
            if (StringUtil.isBlank(msg)) {
                mLoadingProgress.setMessage("正在加载......");
            } else {
                mLoadingProgress.setMessage(msg);
            }

            mLoadingProgress.show();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            //返回堆栈里fragment数量
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                ActivityManager.getInstance().finishActivity();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }



}
