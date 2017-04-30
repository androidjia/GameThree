package com.zexh.gamethree;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.zexh.gamethree.adapter.MainFragmentPagerAdapter;
import com.zexh.gamethree.fragment.ArticleFragment;
import com.zexh.gamethree.fragment.ForumFragment;
import com.zexh.gamethree.fragment.GameFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener,ViewPager.OnPageChangeListener{
    HorizontalScrollView horizontalScrollView;
    RadioGroup radioGroup_top, radioGroup_bottom;
    RadioButton rb_top_01,rb_top_02,rb_top_03,
            rb_top_04,rb_top_05,rb_top_06,rb_top_07,
            rb_top_08,rb_top_09,rb_top_010,rb_bottom_01,
    rb_bottom_02,rb_bottom_03;
    ViewPager viewPager;
    List<Fragment> fragments;
    GameFragment gameFragment;
    ForumFragment forumFragment;
    FragmentManager fragmentManager;
    MainFragmentPagerAdapter mainFragmentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameFragment = new GameFragment(getApplicationContext());
        forumFragment = new ForumFragment();
        initView();
        initData();
        initListener();
    }
    private void initListener() {
        radioGroup_top.setOnCheckedChangeListener(this);
        radioGroup_bottom.setOnCheckedChangeListener(this);
        viewPager.addOnPageChangeListener(this);
    }

    private void initData() {
        fragments = new ArrayList<>();
        ArticleFragment f1 = new ArticleFragment(1,getApplicationContext());
        ArticleFragment f2 = new ArticleFragment(2,getApplicationContext());
        ArticleFragment f3 = new ArticleFragment(3,getApplicationContext());
        ArticleFragment f4 = new ArticleFragment(4,getApplicationContext());
        ArticleFragment f5 = new ArticleFragment(5,getApplicationContext());
        ArticleFragment f6 = new ArticleFragment(6,getApplicationContext());
        ArticleFragment f7 = new ArticleFragment(7,getApplicationContext());
        ArticleFragment f8 = new ArticleFragment(8,getApplicationContext());
        ArticleFragment f9 = new ArticleFragment(9,getApplicationContext());
        ArticleFragment f10 = new ArticleFragment(10,getApplicationContext());
        fragments.add(f1);
        fragments.add(f2);
        fragments.add(f3);
        fragments.add(f4);
        fragments.add(f5);
        fragments.add(f6);
        fragments.add(f7);
        fragments.add(f8);
        fragments.add(f9);
        fragments.add(f10);
        mainFragmentAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(mainFragmentAdapter);
    }

    private void initView() {
        horizontalScrollView = (HorizontalScrollView) findViewById(R.id.main_top_hsv);
        radioGroup_top = (RadioGroup) findViewById(R.id.main_top_rg);
        viewPager = (ViewPager) findViewById(R.id.main_center_vp);
        radioGroup_bottom = (RadioGroup) findViewById(R.id.main_buttom_rg);
        rb_bottom_01 = (RadioButton) findViewById(R.id.main_buttom_rb01);
        rb_bottom_02 = (RadioButton) findViewById(R.id.main_buttom_rb02);
        rb_bottom_03 = (RadioButton) findViewById(R.id.main_buttom_rb03);

        rb_top_01 = (RadioButton) findViewById(R.id.main_top_rb1);
        rb_top_02 = (RadioButton) findViewById(R.id.main_top_rb2);
        rb_top_03 = (RadioButton) findViewById(R.id.main_top_rb3);
        rb_top_04 = (RadioButton) findViewById(R.id.main_top_rb4);
        rb_top_05 = (RadioButton) findViewById(R.id.main_top_rb5);
        rb_top_06 = (RadioButton) findViewById(R.id.main_top_rb6);
        rb_top_07 = (RadioButton) findViewById(R.id.main_top_rb7);
        rb_top_08 = (RadioButton) findViewById(R.id.main_top_rb8);
        rb_top_09 = (RadioButton) findViewById(R.id.main_top_rb9);
        rb_top_010 = (RadioButton) findViewById(R.id.main_top_rb10);
        rb_bottom_01.setEnabled(false);
    }
    private void initColor() {
        rb_bottom_01.setEnabled(true);
        rb_bottom_02.setEnabled(true);
        rb_bottom_03.setEnabled(true);
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (i){
            case R.id.main_top_rb1:
                viewPager.setCurrentItem(0);
                Toast.makeText(MainActivity.this,"top rb01",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb2:
                viewPager.setCurrentItem(1);
                Toast.makeText(MainActivity.this,"top rb02",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb3:
                viewPager.setCurrentItem(2);
                Toast.makeText(MainActivity.this,"top rb03",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb4:
                viewPager.setCurrentItem(3);
                Toast.makeText(MainActivity.this,"top rb04",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb5:
                viewPager.setCurrentItem(4);
                Toast.makeText(MainActivity.this,"top rb05",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb6:
                viewPager.setCurrentItem(5);
                Toast.makeText(MainActivity.this,"top rb06",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb7:
                viewPager.setCurrentItem(6);
                Toast.makeText(MainActivity.this,"top rb07",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb8:
                viewPager.setCurrentItem(7);
                Toast.makeText(MainActivity.this,"top rb08",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb9:
                viewPager.setCurrentItem(8);
                Toast.makeText(MainActivity.this,"top rb09",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb10:
                viewPager.setCurrentItem(9);
                Toast.makeText(MainActivity.this,"top rb10",Toast.LENGTH_SHORT).show();
                break;

            case R.id.main_buttom_rb01:
                initColor();
                rb_bottom_01.setEnabled(false);
                transaction.remove(gameFragment);
                transaction.remove(forumFragment);
                transaction.commit();
                viewPager.setCurrentItem(0);
                horizontalScrollView.smoothScrollBy(0,0);
                break;
            case R.id.main_buttom_rb02:
                initColor();
                rb_bottom_02.setEnabled(false);
                transaction.replace(R.id.activity_main_fragment1,forumFragment);
                transaction.commit();
                break;
            case R.id.main_buttom_rb03:
               initColor();
                rb_bottom_03.setEnabled(false);
                transaction.replace(R.id.activity_main_fragment1,gameFragment);
                transaction.commit();
                break;

        }
    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }
    @Override
    public void onPageSelected(int position) {
        horizontalScrollView.setVisibility(View.VISIBLE);
        radioGroup_top.setVisibility(View.VISIBLE);
        RadioButton radioButton = (RadioButton) radioGroup_top.getChildAt(position);
        radioButton.setChecked(true);
        int left = radioButton.getLeft();
        horizontalScrollView.smoothScrollTo(left,0);
    }
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
