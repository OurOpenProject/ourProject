package com.ourproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.ui.book.activity.QR_codeActivity;
import com.ourproject.ui.book.activity.SearchActivity;
import com.ourproject.ui.book.adapters.BookPagerAdapter;
import com.ourproject.ui.book.fragments.CategoryFragment;
import com.ourproject.ui.book.fragments.MaterialFragment;
import com.ourproject.ui.book.fragments.ScenceFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/4/10.
 */

public class Fragment_food_book extends Fragment implements View.OnClickListener {
    public static final String TAG = Fragment_food_book.class.getSimpleName();
    @BindView(R2.id.book_search)
    ImageView mSearch;
    @BindView(R2.id.book_zxing)
    ImageView mZXing;
    @BindView(R2.id.book_tablayout)
    TabLayout mTabLayout;
    @BindView(R2.id.book_viewpager)
    ViewPager mPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_book, container, false);
        ButterKnife.bind(this,layout);

        List<String> titles = new ArrayList<>();
        titles.add("推荐");
        titles.add("食材");
        titles.add("分类");

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ScenceFragment());
        fragments.add(new MaterialFragment());
        fragments.add(new CategoryFragment());

        BookPagerAdapter adapter = new BookPagerAdapter(getChildFragmentManager(),fragments, titles);
        mPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mPager);

        mZXing.setOnClickListener(this);
        mSearch.setOnClickListener(this);

        return layout;
    }
    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.book_zxing:
                Intent intent = new Intent(getContext(), QR_codeActivity.class);
                getContext().startActivity(intent);
                break;
            case R.id.book_search:
                Intent intent1 = new Intent(getContext(), SearchActivity.class);
                getContext().startActivity(intent1);
                break;
        }
    }
}
