package com.gottaboy.heart.sting41;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.gottaboy.heart.base.baseclass.AppActivity;
import com.gottaboy.heart.sting41.adapter.MainAdapter;
import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.gottaboy.heart.sting41.fragment.SampleFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppActivity implements BottomNavigationBar.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    private final static String TAG = "MainActivity";
    private ViewPager viewPager;
    private BottomNavigationBar bottomNavigationBar;
    private BadgeItem badgeItem; //添加角标
    private List<Fragment> fragments; //ViewPager的数据源
    private MainAdapter mainAdapter;


    @Override
    protected void initData() {
        initViewPager();
        initBottomNavigationBar();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    //    private Fragment[] fragments = new Fragment[3];
//    private FragmentManager fragmentManager;
//    private FragmentTransaction transaction;
//
//    private HomeFragment homeFragment;
//    private MineFragment mineFragment;
//    private OtherFragment otherFragment;
//
//    private Button btnHome;
//    private Button btnMine;
//    private Button btnOther;
//
//
//
//    public void initView() {
//        btnHome = (Button) findViewById(R.id.btn_home);
//        btnMine = (Button) findViewById(R.id.btn_mine);
//        btnOther = (Button) findViewById(R.id.btn_other);
//
//        homeFragment = new HomeFragment();
//        mineFragment = new MineFragment();
//        otherFragment = new OtherFragment();
//
//        fragmentManager = getSupportFragmentManager();
//        fragments = new Fragment[]{homeFragment, mineFragment, otherFragment};
//        selectTab(0);
//        initListener();
//    }
//
//
//    protected void initListener() {
//        btnHome.setOnClickListener(this);
//        btnMine.setOnClickListener(this);
//        btnOther.setOnClickListener(this);
//    }
//
//    private void selectTab(int i) {
//        transaction = fragmentManager.beginTransaction();
//        hideAllFragment(transaction);
//        //展示需要展示的Tab
//        if (fragments[i].isAdded()) {
//            transaction.show(fragments[i]);
//        } else {
//            transaction.add(R.id.frame_layout, fragments[i]);
//            transaction.show(fragments[i]);
//        }
//        transaction.commit();
//
//    }
//
//    private void hideAllFragment(FragmentTransaction transaction) {
//        for (int i = 0; i < fragments.length; i++) {
//            transaction.hide(fragments[i]);
//        }
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn_home:
//                selectTab(0);
//                break;
//            case R.id.btn_mine:
//                selectTab(1);
//                break;
//            case R.id.btn_other:
//                selectTab(2);
//                break;
//        }
//    }
//
//    @Override
//    protected void initData() {
//        initView();
//
//    }
//    @Override
//    protected int getContentViewId() {
//        return R.layout.activity_main;
//    }
//
    private void initBottomNavigationBar() {
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setTabSelectedListener(this);
        bottomNavigationBar.clearAll();
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.app_goods_two, "发货")
                .setInactiveIconResource(R.mipmap.app_goods_one)
                .setActiveColorResource(R.color.common_color_text_blue))
                .addItem(new BottomNavigationItem(R.mipmap.app_waybill_two, "运单")
                        .setInactiveIconResource(R.mipmap.app_waybill_one)
                        .setActiveColorResource(R.color.common_color_text_blue))
                .addItem(new BottomNavigationItem(R.mipmap.app_waybill_two, "结算单")
                        .setInactiveIconResource(R.mipmap.app_waybill_one)
                        .setActiveColorResource(R.color.common_color_text_blue))
                .addItem(new BottomNavigationItem(R.mipmap.app_my_self_two, "我的")
                        .setInactiveIconResource(R.mipmap.app_my_self_one)
                        .setActiveColorResource(R.color.common_color_text_blue))
                .initialise();
    }

    //初始化ViewPager
    private void initViewPager() {
//        mList = new ArrayList<>();
//
//        mList.add(new HomeFragment());
//        mList.add(new MineFragment());
//        mList.add(new OtherFragment());
//
//
//        viewPager = (ViewPager) findViewById(R.id.home_vp);
//        viewPager.setOnPageChangeListener(this);
//        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager(), mList);
//        viewPager.setAdapter(mainAdapter); //视图加载适配器

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        if (fragments == null) {
            fragments = new ArrayList<Fragment>();
//            fragments.add(new DeliverGoodsFragment());
//            fragments.add(new HomeFragment());
//            fragments.add(new StateListFragment());
//            fragments.add(new MineFragment());
//            Fragment fragment = ContentFragment.newInstance("tab: " + 0);
            fragments.add(SampleFragment.newInstance("tab: " + 1));
            fragments.add(SampleFragment.newInstance("tab: " + 2));
            fragments.add(SampleFragment.newInstance("tab: " + 3));
            fragments.add(SampleFragment.newInstance("tab: " + 4));
        }
        mainAdapter = new MainAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(mainAdapter);
        viewPager.addOnPageChangeListener(this);
        viewPager.setCurrentItem(0);
    }

    @Override
    public void onTabSelected(int position) { //未选中 -> 选中

        System.out.println("MainActivity" + "onTabSelected"+position);
        //tab被选中
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) { //选中 -> 未选中

    }

    @Override
    public void onTabReselected(int position) { //选中 -> 选中

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        System.out.println("MainActivity" + "onPageSelected"+position);
        //ViewPager滑动
        bottomNavigationBar.selectTab(position);
//                if (fragments!=null) {
//                    if (position==0) {
//                        DeliverGoodsFragment fragment =(DeliverGoodsFragment) fragments.get(0);
//                        fragment.initData(true);
//                    }
//
//
//        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        System.out.println("MainActivity" + "......onResart");
////        if (fragments!=null) {
//////            DeliverGoodsFragment fragment =(DeliverGoodsFragment) fragments.get(0);
//////            fragment.initData(true);
//////
////        }
//   }
//
//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        System.out.println("MainActivity" + "......onWindowFocusChanged");
//    }
}
