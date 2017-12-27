package cn.exploration.structinterface;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.exploration.structinterface.adapter.RecyclerPicAdapter;
import cn.exploration.structinterface.bean.PicBean;
import cn.exploration.structinterface.fragment.BaseFragment;
import cn.exploration.structinterface.fragment.FirstFragment;
import cn.exploration.structinterface.fragment.SecondFragment;
import cn.exploration.structinterface.fragment.ThirdtFragment;
import cn.exploration.structinterface.presenter.PicPresenter;
import cn.exploration.structinterface.struct.FunctionManager;
import cn.exploration.structinterface.struct.FunctionNoParamNoResult;
import cn.exploration.structinterface.struct.FunctionWithResultOnly;
import cn.exploration.structinterface.view.IView;

public class MainActivity extends BaseActivity<IView,PicPresenter<IView>> implements View.OnClickListener,IView{

    private ArrayList<Fragment> fragmentList;
    private int currentIndex;
    private RecyclerView recyclerView;
    private RecyclerPicAdapter recyclerPicAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_show);
//        initView();
//        setData();
//        initClick();
//        initFragment();
        presenter.fetch();
    }

    @Override
    protected PicPresenter<IView> createPresenter() {
        return new PicPresenter<>();
    }


    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerPicAdapter = new RecyclerPicAdapter(this);
        recyclerView.setAdapter(recyclerPicAdapter);

    }

    private void initClick() {
        findViewById(R.id.btn_home).setOnClickListener(this);
        findViewById(R.id.btn_me).setOnClickListener(this);
        findViewById(R.id.btn_message).setOnClickListener(this);
    }



    private void initFragment() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new FirstFragment());
        fragmentList.add(new SecondFragment());
        fragmentList.add(new ThirdtFragment());
        changeTab(0);
    }

    private void changeTab(int index) {
        currentIndex = index;
        Fragment fragment = fragmentList.get(index);
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (fragment != null ) {
            transaction.replace(R.id.ll_container,fragmentList.get(index),fragmentList.get(index).getClass().getName()).commit();
        } else {
            transaction.add(R.id.ll_container,fragmentList.get(index),fragmentList.get(index).getClass().getName()).commit();
        }
    }

    public void setFunctionForFragment(String tag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        BaseFragment baseFragment = (BaseFragment) fragmentManager.findFragmentByTag(tag);
        FunctionManager functionManager = FunctionManager.getInstance();
        baseFragment.setFunctionManager(
                functionManager.addFunction(new FunctionNoParamNoResult(FirstFragment.INTERFACE) {
            @Override
            public void function() {
                Toast.makeText(MainActivity.this,"调用无参无结果接口",Toast.LENGTH_SHORT).show();
            }
        }).addFunction(new FunctionWithResultOnly<String>(SecondFragment.INTERFACE_RESULT_ONLY) {
                    @Override
                    public String function() {
                        return "有结果的无参返回接口！！";
                    }
                })
        );
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_home:
                currentIndex = 0;
                break;
            case R.id.btn_message:
                currentIndex = 1;
                break;
            case R.id.btn_me:
                currentIndex = 2;
                break;
        }
        changeTab(currentIndex);
    }

    @Override
    public void showLoading() {
        Toast.makeText(MainActivity.this,"loading...",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPic(List<PicBean> list) {
        initView();
        recyclerPicAdapter.addNewData(list);
    }


}
