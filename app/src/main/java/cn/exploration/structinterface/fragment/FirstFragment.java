package cn.exploration.structinterface.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cn.exploration.structinterface.MainActivity;
import cn.exploration.structinterface.R;

/**
 * Created by JackDeng on 2017/12/25.
 */

public class FirstFragment extends BaseFragment {
    private View fragmentView;
    public static final String INTERFACE = FirstFragment.class.getSimpleName()+"NONR";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_first,null,false);
        setClick();
        return fragmentView;
    }



    private void setClick() {
        fragmentView.findViewById(R.id.btn_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                functionManager.invokeFunction(INTERFACE);
            }
        });
    }
}
