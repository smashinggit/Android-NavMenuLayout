package com.chensen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.git.navmenu.NavMenuLayout;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ViewPager mViewPager;
    NavMenuLayout mNavMenuLayout;
    ArrayList<Fragment> listFragment;

    private int[] iconRes = {R.mipmap.ic_home_normal, R.mipmap.ic_managemoney_normal, R.mipmap.ic_me_normal};
    private int[] iconResSelected = {R.mipmap.ic_home_selected, R.mipmap.ic_managemoney_select, R.mipmap.ic_me_select};
    private String[] textRes = {"首页", "理财", "个人中心"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNavMenuLayout = (NavMenuLayout) findViewById(R.id.nav_layout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        mNavMenuLayout.setIconRes(iconRes)//设置未选中图标
                .setIconResSelected(iconResSelected)//设置选中图标
                .setTextRes(textRes)//设置文字
//                .setIconSize(60, 60)//设置图标大小
//                .setIconSize(0, 60,60)//设置指定位置的图标
//                .setTextSize(20)//设置文字大小
//                .setTextSize(0, 20)//指定位置的文字大小
//                .setTextColor(Color.GRAY)//未选中状态下文字颜色
//                .setTextColorSelected(Color.RED)//选中状态下文字颜色
//                .setTextColor(0, Color.YELLOW)//设置指定位置下文字颜色
//                .setTextColorSelected(0, Color.BLUE)//设置指定位置下选中状态文字颜色
//                .setMarginTop(PixelUtil.dpToPx(MainActivity.this, 5))//
//                .setMarginTop(1, PixelUtil.dpToPx(MainActivity.this, 10))
                .setMsg(0, "99+")//设置显示消息
                .setMsg(1, "NEW")//设置显示消息
                .showRedPoint(2)//设置显示红点
                .hideMsg(0)//隐藏消息
                .hideMsg(1)//隐藏消息
                .hideRedPoint(2)//隐藏红点
                .setSelected(0);//设置选中的位置

        //选中的点击事件
        mNavMenuLayout.setOnItemSelectedListener(new NavMenuLayout.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int position) {
                mViewPager.setCurrentItem(position);//选中后切换viwepager
                Toast.makeText(MainActivity.this, "选中了-> " + textRes[position], Toast.LENGTH_SHORT).show();
            }
        });
        //已选中状态下的点击事件
        mNavMenuLayout.setOnItemReSelectedListener(new NavMenuLayout.OnItemReSelectedListener() {
            @Override
            public void onItemReSelected(int position) {
                Toast.makeText(MainActivity.this, "重复选中了-> " + textRes[position], Toast.LENGTH_SHORT).show();
            }
        });


        listFragment = new ArrayList<>();
        listFragment.add(MyFragment.getInstance(0));
        listFragment.add(MyFragment.getInstance(1));
        listFragment.add(MyFragment.getInstance(2));

        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mNavMenuLayout.setSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return listFragment.get(position);
        }

        @Override
        public int getCount() {
            return listFragment.size();
        }
    }
}
