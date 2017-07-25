package com.quangtd95.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quangtd95.databinding.databinding.FragmentDemoBinding;

/**
 * Quang_TD on 7/25/2017.
 */

public class DemoFragment extends Fragment {
    private FragmentDemoBinding binding;

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_demo, container, false);
        binding.setBinding(this);
        return binding.getRoot();
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //
    }
}
