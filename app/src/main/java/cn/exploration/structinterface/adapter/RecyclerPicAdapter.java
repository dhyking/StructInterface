package cn.exploration.structinterface.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.exploration.structinterface.R;
import cn.exploration.structinterface.bean.PicBean;

/**
 * Created by JackDeng on 2017/12/27.
 */

public class RecyclerPicAdapter extends RecyclerView.Adapter<RecyclerPicAdapter.MyPicViewHolder>{
    List<PicBean> picList = new ArrayList<>();

    private Context context;

    public RecyclerPicAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyPicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout_pic,null,false);
        MyPicViewHolder myPicViewHolder = new MyPicViewHolder(view);
        return myPicViewHolder;
    }

    @Override
    public void onBindViewHolder(MyPicViewHolder holder, int position) {
        holder.title.setText(picList.get(position).getTitle());
        holder.img.setImageResource(picList.get(position).getImgId());
    }

    @Override
    public int getItemCount() {
        return picList.size();
    }

    class MyPicViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView img;
        public MyPicViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            img = itemView.findViewById(R.id.img);
        }
    }

    public void addNewData(List<PicBean> list){
        picList.addAll(list);
        notifyDataSetChanged();
    }
}
