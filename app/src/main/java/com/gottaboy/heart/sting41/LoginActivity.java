package com.gottaboy.heart.sting41;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.gottaboy.heart.base.baseclass.AppActivity;
import com.gottaboy.heart.base.baseclass.ToastUtil;
import com.gottaboy.heart.base.remote.CfgConstant;
import com.gottaboy.heart.base.utils.SharedPerferenceUtil;
import com.gottaboy.heart.sting41.bean.DeliverBeanAuto;
import com.gottaboy.heart.sting41.bean.LoginBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

public class LoginActivity extends AppActivity implements View.OnClickListener {

//    private String urlcode = "https://check.cargocn.cn/cargocn-cloud-server/fapi/msgcode";
//    private String urllogin = "https://check.cargocn.cn/cargocn-cloud-server/fapi/login";
//    private String urlauto = "https://check.cargocn.cn/cargocn-cloud-server/fapi/autoLogin";

    private Button btnlogin;
    private EditText etUserNo;
    private EditText authcode;
    private String brand;
    private boolean isPassword = true;
    private Button btnSendMsg;
    private TextView buttonchange;

    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }


    public void initView() {
        btnlogin = (Button) findViewById(R.id.btn_login);
        btnlogin.setOnClickListener(this);
        etUserNo = (EditText) findViewById(R.id.et_userNo);
        String name = SharedPerferenceUtil.getName(LoginActivity.this);

        if (!TextUtils.isEmpty(name)) {
            etUserNo.setText(name);
        }

        authcode = (EditText) findViewById(R.id.et_auth_code);
        buttonchange = (TextView) findViewById(R.id.btn_change);
        btnSendMsg = (Button) findViewById(R.id.btn_send_sms);
        btnSendMsg.setOnClickListener(this);
        brand = android.os.Build.BRAND;
        buttonchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPassword = !isPassword;
                if (isPassword) {
                    etUserNo.setHint("请输入用户名");
                    authcode.setHint("请输入密码");
                    buttonchange.setText("用户名密码登录");
                    btnSendMsg.setVisibility(View.GONE);

                } else {
                    etUserNo.setHint("请输入手机号");
                    authcode.setHint("请输入验证码");
                    buttonchange.setText("手机号验证码登录");
                    btnSendMsg.setVisibility(View.VISIBLE);

                }
            }
        });

        //checkauto();
    }

    private void checkauto() {


//        if(BaseApplication.isCookie){
//            startActivity(MainActivity.class);
//        }
        OkHttpUtils
                .post()
                .url(CfgConstant.ORDER_LIST)
                //    .addParams("sessionID",sessionID)
                .addParams("pageSize", "")
                .addParams("appType", "Android")
                .addParams("pageNum", "")
                //.addParams("password", "123")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        DeliverBeanAuto deliverbean = null;
                        try {
                            deliverbean = JSON.parseObject(response, DeliverBeanAuto.class);
                            if (deliverbean.getCode() == 100) {
                                startActivity(MainActivity.class);
                                finish();
                            }
//                            List<DeliverBean.DataBean.ListBean> listdeliver = deliverbean.getData().getList();
//                            DeliverGoodsFragment.ListgoodsAdapter listgoodsAdapter = new DeliverGoodsFragment.ListgoodsAdapter(listdeliver);
//                            lv_goods.setAdapter(listgoodsAdapter);
                            System.out.print(deliverbean);
                            System.out.print(id);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });

//            OkHttpUtils
//                    .post()
//                    .url(urlauto)
//                    .addParams("sessionID", sessionID)
//                    //.addParams("password", "123")
//                    .build()
//                    .execute(new StringCallback() {
//                        @Override
//                        public void onError(Call call, Exception e, int id) {
//
//                        }
//
//                        @Override
//                        public void onResponse(String response, int id) {
//                            AutoCode autoCode = JSON.parseObject(response, AutoCode.class);
//                            if (autoCode.getCode().equals("100")) {
//                                startActivity(MainActivity.class);
//                            }
//                            System.out.print(response);
//                            System.out.print(id);
//                        }
//                    });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                longin();
                break;
            case R.id.btn_send_sms:
                //todo
                if (checkPhone()) {
                    sendMsgNet();
                }
                break;

        }
    }

    private void longin() {
        if (TextUtils.isEmpty(authcode.getText())) {
            Toast.makeText(LoginActivity.this, "验证码或密码不能为空", Toast.LENGTH_SHORT).show();
        } else {

            if (isPassword) {
                //CookieJarImpl cookieJar = new CookieJarImpl(new PersistentCookieStore(getApplicationContext()));
                showLoadingProgress("");
                OkHttpUtils
                        .post()
                        .url(CfgConstant.FAPI_ULOGIN)
//                username , password
                        .addParams("username", etUserNo.getText().toString().trim())
                        .addParams("password", authcode.getText().toString().trim())
                        .addParams("appVersion", "1")
                        .addParams("fromApp", brand)
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Call call, Exception e, int id) {
                                e.printStackTrace();
                                hideLoadingProgress();
                                ToastUtil.show(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT);
                            }

                            @Override
                            public void onResponse(String response, int id) {
                                hideLoadingProgress();
                                LoginBean loginbean = null;
                                try {
                                    loginbean = JSON.parseObject(response, LoginBean.class);
//                                    ToastUtil.show(LoginActivity.this,loginbean.getMsg(),Toast.LENGTH_SHORT);
                                    ToastUtil.show(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT);
                                    String userid = loginbean.getData().getUser().getId() + "";
                                    String username = loginbean.getData().getUser().getReally_name();
                                    String username1 = loginbean.getData().getUser().getUsername();
                                    String usertel = loginbean.getData().getUser().getUserTel();
                                    String companyName = loginbean.getData().getUser().getCompanyName();
                                    SharedPerferenceUtil.saveName(LoginActivity.this, etUserNo.getText().toString().trim());
                                    //String sessionID = loginbean.getData().getSessionID();
                                    SharedPerferenceUtil.saveuserID(LoginActivity.this, userid);
                                    //保存公司名
                                    SharedPerferenceUtil.saveCompanyName(LoginActivity.this, companyName);
                                    if (!TextUtils.isEmpty(username)) {
                                        SharedPerferenceUtil.saveuserName(LoginActivity.this, username);

                                    }else {
                                        SharedPerferenceUtil.saveuserName(LoginActivity.this, username1);

                                    }
                                    SharedPerferenceUtil.saveuserTel(LoginActivity.this, usertel);
                                    System.out.print(loginbean);
                                    System.out.print(id);
                                    if (loginbean.getCode().equals("100")) {
                                        startActivity(MainActivity.class);
                                        finish();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });


            } else {
                //CookieJarImpl cookieJar = new CookieJarImpl(new PersistentCookieStore(getApplicationContext()));
                showLoadingProgress("");
                OkHttpUtils
                        .post()
                        .url(CfgConstant.FAPI_LOGIN)
                        .addParams("username", etUserNo.getText().toString().trim())
                        .addParams("code", authcode.getText().toString().trim())
                        .addParams("appVersion", "1")
                        .addParams("fromApp", brand)
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Call call, Exception e, int id) {
                                hideLoadingProgress();
                                e.printStackTrace();
                                ToastUtil.show(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT);
                            }

                            @Override
                            public void onResponse(String response, int id) {
                                hideLoadingProgress();
                                LoginBean loginbean = null;
                                try {
                                    loginbean = JSON.parseObject(response, LoginBean.class);
//                                    ToastUtil.show(LoginActivity.this,loginbean.getMsg(),Toast.LENGTH_SHORT);
                                    ToastUtil.show(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT);
                                    String userid = loginbean.getData().getUser().getId() + "";
                                    String username = loginbean.getData().getUser().getReally_name();
                                    String usertel = loginbean.getData().getUser().getUsername();
                                    String companyName = loginbean.getData().getUser().getCompanyName();
                                    //String sessionID = loginbean.getData().getSessionID();
                                    SharedPerferenceUtil.saveuserID(LoginActivity.this, userid);
                                    SharedPerferenceUtil.saveuserName(LoginActivity.this, username);
                                    SharedPerferenceUtil.saveuserTel(LoginActivity.this, usertel);
                                    //保存公司名
                                    SharedPerferenceUtil.saveCompanyName(LoginActivity.this, companyName);
                                    System.out.print(loginbean);
                                    System.out.print(id);
                                    if (loginbean.getCode().equals("100")) {
                                        startActivity(MainActivity.class);
                                        finish();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });

            }
        }

    }

    private boolean checkPhone() {
        if (etUserNo.getText().toString().trim().matches("^1\\d{10}$")) {
            return true;
        } else {
            Toast.makeText(LoginActivity.this, R.string.longin_phonenum, Toast.LENGTH_SHORT).show();
            return false;
        }


    }


    private void sendMsgNet() {
        OkHttpUtils
                .post()
                .url(CfgConstant.FAPI_MSGCODE)
                .addParams("username", etUserNo.getText().toString().trim())
                //.addParams("password", "123")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        System.out.print(response);
                        System.out.print(id);

                    }
                });

//        Map<String, String> params = new HashMap<String, String>();
//        params.put("name", etUserNo.getText().toString().trim());
//        //String url = mBaseUrl + "user!getUsers";
//        OkHttpUtils//
//                .post()//
//                .url(urlcode)//
//                .params(params)//
//                .build()//
//                .execute(new ListUserCallback()//
//                {
//                    @Override
//                    public void onError(Call call, Exception e, int id)
//                    {
//                        mTv.setText("onError:" + e.getMessage());
//                    }
//
//                    @Override
//                    public void onResponse(List<User> response, int id)
//                    {
//                        mTv.setText("onResponse:" + response);
//                    }
//                });


        // Toast.makeText(LoginActivity.this, "导航图标被点击了", Toast.LENGTH_SHORT).show();
        // OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象。

        // ClearableCookieJar cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(LoginActivity.this));
//        OkHttpClient client = new OkHttpClient();
//
//        showLoadingProgress("");
//        FormBody.Builder formBody = new FormBody.Builder();//创建表单请求体
//        formBody.add("username", etUserNo.getText().toString().trim())
//                .add("appVersion", "1")
//                .add("fromApp", brand)
//                .add("appType", "android");
//        Request request = new Request.Builder()//创建Request 对象。
//                .url(urlcode)
//                .post(formBody.build())//传递请求体
//                .build();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                //Toast.makeText(BaseApplication.getAppContext(), "网络异常", Toast.LENGTH_SHORT).show();
//                hideLoadingProgress();
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                hideLoadingProgress();
//                //   Toast.makeText(BaseApplication.getAppContext(), "导航图标被点击了", Toast.LENGTH_SHORT).show();
//                if (response.isSuccessful()) {
//                    int code = response.code();
//                    String message = response.message();
//                    String body = response.body().string();
//                    ShipCodeBean codeBean = JSON.parseObject(body, ShipCodeBean.class);
//                    String data = codeBean.getData();
//                    System.out.print(data);
//
//                    //ShipCodeBean codeBean = JSON.parseObject(response.body().string(), ShipCodeBean.class);
////                    response
////                    Log.d("kwwl", "获取数据成功了");
////                    Log.d("kwwl", "response.code()==" + response.code());
////                    Log.d("kwwl", "response.body().string()==" + response.body().string());
//                }
//            }
//        });

    }

    @Override
    protected void initData() {
        initView();
    }

//    public class MyStringCallback extends StringCallback
//    {
//        @Override
//        public void onBefore(Request request, int id)
//        {
//            setTitle("loading...");
//        }
//
//        @Override
//        public void onAfter(int id)
//        {
//            setTitle("Sample-okHttp");
//        }
//
//        @Override
//        public void onError(Call call, Exception e, int id)
//        {
//            e.printStackTrace();
//           // mTv.setText("onError:" + e.getMessage());
//        }
//
//        @Override
//        public void onResponse(String response, int id)
//        {
////            Log.e(TAG, "onResponse：complete");
////            mTv.setText("onResponse:" + response);
//
//            switch (id)
//            {
//                case 100:
//                    //Toast.makeText(MainActivity.this, "http", Toast.LENGTH_SHORT).show();
//                    break;
//                case 101:
//                    //Toast.makeText(MainActivity.this, "https", Toast.LENGTH_SHORT).show();
//                    break;
//            }
//        }
//
//        @Override
//        public void inProgress(float progress, long total, int id)
//        {
//            //Log.e(TAG, "inProgress:" + progress);
//           // mProgressBar.setProgress((int) (100 * progress));
//        }
//    }
}
