package com.ourproject.ui.lh.fragment;

import android.app.LoaderManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ourproject.R;

/**
 * Created by Administrator on 2017/4/10 0010.
 */

public class HealthFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View health = inflater.inflate(R.layout.fragment_health, container, false);
        return health;
    }
}
