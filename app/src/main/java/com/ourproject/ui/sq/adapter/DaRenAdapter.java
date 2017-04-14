package com.ourproject.ui.sq.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.ui.sq.activity.DaRenActivity;
import com.ourproject.ui.sq.bean.SqBean;
import com.ourproject.util.GlideCircleTransform;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/4/10.
 */

public class DaRenAdapter extends RecyclerView.Adapter<DaRenAdapter.DaRenViewHolder> {
    private List<SqBean.DataBeanX.ShequTalentBean> data;
    private Context context;

    public DaRenAdapter(List<SqBean.DataBeanX.ShequTalentBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public DaRenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.fragment_dr_detail, parent, false);
        return new DaRenViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DaRenViewHolder holder, final int position) {
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DaRenActivity.class);
                intent.putExtra("userId", data.get(position).getUser_id());
                context.startActivity(intent);
            }
        });
        Glide.with(context).load(data.get(position).getHead_img()).placeholder(R.mipmap.default_head_icon).transform(new GlideCircleTransform(context)).into(holder.img);
        holder.name.setText(data.get(position).getNick());
        holder.fs_num.setText("粉丝" + data.get(position).getTongji_be_follow());
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    class DaRenViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.img_dr)
        ImageView img;
        @BindView(R2.id.name)
        TextView name;
        @BindView(R2.id.fs_num)
        TextView fs_num;

        public DaRenViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
