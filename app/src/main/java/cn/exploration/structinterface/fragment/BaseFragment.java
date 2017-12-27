package cn.exploration.structinterface.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

import cn.exploration.structinterface.MainActivity;
import cn.exploration.structinterface.struct.FunctionManager;

/**
 * Created by JackDeng on 2017/12/25.
 */

public class BaseFragment extends Fragment {
    protected FunctionManager functionManager;

    public void setFunctionManager(FunctionManager functionManager) {
        this.functionManager = functionManager;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            MainActivity mainActivity = (MainActivity) context;
            System.out.println("tag:"+getTag());
            mainActivity.setFunctionForFragment(getTag());
        }
    }

}
