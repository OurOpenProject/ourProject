package com.ourproject.ui.sq.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.ui.sq.bean.FSBean;
import com.ourproject.util.GlideCircleTransform;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/4/10.
 */

public class FsAdapter extends RecyclerView.Adapter<FsAdapter.FsViewHolder> {
    private List<FSBean.DataBeanX.DataBean> data;
    private Context context;

    public FsAdapter(List<FSBean.DataBeanX.DataBean> data, Context context) {
        if (data == null) {
            this.data = new ArrayList<>();
        } else {
            this.data = data;
        }
        this.context = context;
    }

    public void addRes(List<FSBean.DataBeanX.DataBean> data) {
        if (data != null) {
            this.data = data;
            notifyDataSetChanged();
        }
    }

    @Override
    public FsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.daren_fs_detail, parent, false);
        return new FsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FsViewHolder holder, int position) {
        Glide.with(context).load(data.get(position).getHead_img()).transform(new GlideCircleTransform(context)).into(holder.img);
        holder.nick.setText(data.get(position).getNick());
        holder.count_fs.setText("粉丝:"+String.valueOf(data.get(position).getCount_fensi()));
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    class FsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.img)
        ImageView img;
        @BindView(R2.id.nick)
        TextView nick;
        @BindView(R2.id.count_fs)
        TextView count_fs;

        public FsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
