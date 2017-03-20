package com.chensen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * author: chensen
 * date: 2017年03月18日18:10
 * desc:
 */

public class MyFragment extends Fragment {

    int page;
    TextView textView;
    private String[] textRes = {"首页", "理财", "个人中心"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        textView = (TextView) view.findViewById(R.id.text);
        switch (page) {
            case 0:
                textView.setText(textRes[page]);
                break;
            case 1:
                textView.setText(textRes[page]);
                break;
            case 2:
                textView.setText(textRes[page]);
                break;
        }
        return view;
    }


    public static MyFragment getInstance(int page) {
        MyFragment myFragment = new MyFragment();
        myFragment.page = page;
        return myFragment;
    }
}
