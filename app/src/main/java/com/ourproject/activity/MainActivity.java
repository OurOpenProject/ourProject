package com.ourproject.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.fragment.Fragment_food_book;
import com.ourproject.fragment.Fragment_food_class;
import com.ourproject.fragment.Fragment_food_owner;
import com.ourproject.fragment.Fragment_food_sq;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    @BindView(R2.id.my_group)
    RadioGroup group;
    private Fragment showFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        group.setOnCheckedChangeListener(this);
        ((RadioButton) group.getChildAt(0)).setChecked(true);
    }

    private void switchPager(Class cls) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (showFragment != null) {
            transaction.hide(showFragment);
        }
        showFragment = manager.findFragmentByTag(cls.getName());
        if (showFragment != null) {
            transaction.show(showFragment);
        } else {
            try {
                showFragment = (Fragment) cls.newInstance();
                transaction.add(R.id.container, showFragment, cls.getName());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        transaction.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb_foodBook:
                switchPager(Fragment_food_book.class);
                break;
            case R.id.rb_foodClass:
                switchPager(Fragment_food_class.class);
                break;
            case R.id.rb_foodSQ:
                switchPager(Fragment_food_sq.class);
                break;
            case R.id.rb_foodOwner:
                switchPager(Fragment_food_owner.class);
                break;
        }
    }
}
