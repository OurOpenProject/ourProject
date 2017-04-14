package com.ourproject.ui.sq.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.ui.sq.bean.ZPBean;
import com.ourproject.util.GlideCircleTransform;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/4/10.
 */

public class ZPAdapter extends RecyclerView.Adapter<ZPAdapter.ZPViewHolder> {
    private ZPBean data;
    private Context context;

    public ZPAdapter(ZPBean data, Context context) {
        this.data = data;
        this.context = context;
    }

    public void addRes(ZPBean data) {
        if (data != null) {
            this.data = data;
            notifyDataSetChanged();
        }
    }

    @Override
    public ZPViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.zp_detail, parent, false);
        return new ZPViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ZPViewHolder holder, int position) {
        ZPBean.DataBeanX.DataBean dataBean = data.getData().getData().get(position);
        holder.time.setText(dataBean.getCreate_time());
        Glide.with(context).load(dataBean.getImage()).into(holder.img);
        holder.content.setText(dataBean.getContent());
        Glide.with(context).load(dataBean.getHead_img()).transform(new GlideCircleTransform(context)).into(holder.headImage);
        holder.nick.setText(dataBean.getNick());
        holder.create_time.setText(dataBean.getCreate_time());
        holder.like.setText(dataBean.getAgree_count());
        holder.ll_content.removeAllViews();
        if (dataBean.getLike().size() >= 6) {
            for (int i = 0; i <= 5; i++) {
                ImageView imageView = new ImageView(context);
                LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(120,120);
                mParams.setMargins(10, 10, 10, 10);
                imageView.setLayoutParams(mParams);
                Glide.with(context).load(dataBean.getLike().get(i).getHead_img()).transform(new GlideCircleTransform(context)).into(imageView);
                holder.ll_content.addView(imageView);
            }
        }
    }

    @Override
    public int getItemCount() {
        return data != null ? data.getData().getData().size() : 0;
    }

    class ZPViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.time)
        TextView time;
        @BindView(R2.id.img)
        ImageView img;
        @BindView(R2.id.content)
        TextView content;
        @BindView(R2.id.headImage)
        ImageView headImage;
        @BindView(R2.id.nick)
        TextView nick;
        @BindView(R2.id.create_time)
        TextView create_time;
        @BindView(R2.id.like)
        TextView like;
        @BindView(R2.id.ll_content)
        LinearLayout ll_content;

        public ZPViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
