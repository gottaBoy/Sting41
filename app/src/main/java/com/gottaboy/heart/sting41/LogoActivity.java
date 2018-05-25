package com.gottaboy.heart.sting41;


import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.gottaboy.heart.base.baseclass.AppActivity;
import com.gottaboy.heart.base.remote.CfgConstant;
import com.gottaboy.heart.sting41.bean.DeliverBeanAuto;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

public class LogoActivity extends AppActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.app_activity_logo);
//    }

    @Override
    protected int getContentViewId() {
        return R.layout.app_activity_logo;
    }

    @Override
    protected void initData() {
        checkauto();
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
                        Toast.makeText(LogoActivity.this, "网络异常", Toast.LENGTH_SHORT).show();

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
                            startActivity(LoginActivity.class);
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
}
