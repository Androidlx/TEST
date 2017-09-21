package com.example.lixin.yuekaotest;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lixin.yuekaotest.fragment.Fragment1;
import com.example.lixin.yuekaotest.fragment.Fragment2;
import com.example.lixin.yuekaotest.fragment.Fragment3;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private RadioGroup mRadiogroup;
    private ArrayList<Fragment> list;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                RadioButton mRadioButton = (RadioButton) mRadiogroup.getChildAt(position);
                for (int i = 0; i<list.size();i++){
                    mRadioButton.setChecked(true);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        mRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {

                for (int i = 0; i<mRadiogroup.getChildCount(); i++){
                    RadioButton mRadioButton = (RadioButton) mRadiogroup.getChildAt(i);
                    if (mRadioButton.isChecked()){
                        mViewPager.setCurrentItem(i);
                    }
                }

            }
        });
        mViewPager.setCurrentItem(index);
        RadioButton mRadioButton = (RadioButton) mRadiogroup.getChildAt(index);
        mRadioButton.setChecked(true);
    }

    private void initData() {
        list = new ArrayList<>();
        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragment3 fragment3 = new Fragment3();
        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);



    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mRadiogroup = (RadioGroup) findViewById(R.id.radiogroup);
    }
}
