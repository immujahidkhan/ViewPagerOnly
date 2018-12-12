package com.justclack.viewpageronly;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class PageViewActivity extends FragmentActivity {

    MyPageAdapter pageAdapter;
    ArrayList<String> test;
    int position;

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_page_view);
        test = getIntent().getStringArrayListExtra("test");
        position = getIntent().getIntExtra("position", 0);
        List<Fragment> fragments = getFragments();

        pageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragments);

        ViewPager pager = findViewById(R.id.viewpager);
        pager.setAdapter(pageAdapter);
        pager.setCurrentItem(position);

    }

    private List<Fragment> getFragments() {

        List<Fragment> fList = new ArrayList<Fragment>();
        for (int i = 0; i < test.size(); i++) {
            String data = test.get(i);
            fList.add(MyFragment.newInstance(data));
        }
        return fList;
    }
}