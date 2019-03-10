package com.jiyun.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/10 0010.
 */

public class RlvAdapter extends RecyclerView.Adapter {
    private final MainActivity mMainActivity;
    public ArrayList<Bean.NewslistBean> mList;

    public RlvAdapter(MainActivity mainActivity, ArrayList<Bean.NewslistBean> list) {

        mMainActivity = mainActivity;
        mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mMainActivity).inflate(R.layout.item, null, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        holder1.mTv.setText(mList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addData(List<Bean.NewslistBean> list) {
        mList.addAll(list);
        notifyDataSetChanged();
    }

    class MyViewHolder extends  RecyclerView.ViewHolder {

        private final TextView mTv;

        public MyViewHolder(android.view.View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.tv);
        }
    }
}
