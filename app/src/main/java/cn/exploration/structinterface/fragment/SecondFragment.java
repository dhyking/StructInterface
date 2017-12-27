package cn.exploration.structinterface.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import cn.exploration.structinterface.MainActivity;
import cn.exploration.structinterface.R;

/**
 * Created by JackDeng on 2017/12/25.
 */

public class SecondFragment extends BaseFragment {
    public static final String INTERFACE_RESULT_ONLY = SecondFragment.class.getSimpleName()+"withResult";

    private View fragmentView;
    public static final String INTERFACE = FirstFragment.class.getSimpleName()+"NONR";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_first,null,false);
        setClick();
        return fragmentView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void setClick() {
        fragmentView.findViewById(R.id.btn_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = functionManager.invokeFunction(INTERFACE_RESULT_ONLY,String.class);
                Toast.makeText(getContext(),"来自fragment的toast:"+string,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
