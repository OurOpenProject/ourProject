package com.ourproject.ui.sq.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.ui.sq.activity.TuiJanDetailActivity;
import com.ourproject.ui.sq.bean.SqBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/4/10.
 */

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder> {
    private List<SqBean.DataBeanX.ShequTopicsBean.DataBean> data;
    private Context context;

    public TopicAdapter(List<SqBean.DataBeanX.ShequTopicsBean.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public TopicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.fragment_jx_detail, parent, false);
        return new TopicViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TopicViewHolder holder, final int position) {
        holder.img_jx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TuiJanDetailActivity.class);
                intent.putExtra("postId", data.get(position).getId());
                context.startActivity(intent);
            }
        });
        Glide.with(context).load(data.get(position).getImage()).into(holder.img_jx);

    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    class TopicViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.img_jx)
        ImageView img_jx;

        public TopicViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
