package com.sky31.gonggong.module.swzl;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 *
 * Created by wukunguang on 16-3-29.
 *
 */
public class SwzlViewPagerAdapter extends FragmentPagerAdapter{


    private List<Fragment> fragmentList;
    private FragmentManager manager;
    private List<String> titles;
    public SwzlViewPagerAdapter(FragmentManager manager,List<Fragment> fragmentList,List<String> titles) {
        super(manager);

        this.fragmentList = fragmentList;
        this.titles = titles;

    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }



    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);

    }


    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
