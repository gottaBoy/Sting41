package com.gottaboy.heart.sting41;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gottaboy.heart.base.utils.SharedPerferenceUtil;

import java.util.Timer;


public class FirstActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private int[] objects;
    private Timer timer;
    private int timecount = 3;
//    private int count;
    //private ArrayList<Integer> objects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        int count = SharedPerferenceUtil.getCount(this);
        if (count>1) {
            startActivity(new Intent(FirstActivity.this,LogoActivity.class));
        }else {
            initView();
        }

    }

//    Handler timeHandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case 0:
//            }
//        }
//    };

    private void initView() {

        viewPager = (ViewPager) findViewById(R.id.first_vp);
        objects = new int[]{R.mipmap.guideone,R.mipmap.guidetwo,R.mipmap.guidethree};

        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view==object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                View view = LayoutInflater.from(FirstActivity.this).inflate(R.layout.first_item, null);
                ImageView viewById = (ImageView)view.findViewById(R.id.first_iv);
                viewById.setBackgroundResource(objects[position]);
                container.addView(view);
                return view;
            }


            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View)object);
            }
        });
       viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {

               if (position==2) {

                   handler.sendEmptyMessageDelayed(0,1500);

               }

           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });

    }
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case 0:
                    SharedPerferenceUtil.saveCount(FirstActivity.this,2);
                    startActivity(new Intent(FirstActivity.this,LogoActivity.class));
                    break;
            }

        }
    };
}
