package com.ourproject.ui.sq.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.ui.sq.activity.DaRenActivity;
import com.ourproject.ui.sq.activity.TuiJanDetailActivity;
import com.ourproject.ui.sq.bean.ZXBean;
import com.ourproject.util.GlideCircleTransform;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/4/11.
 */

public class ZXAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ZXBean.DataBeanX.DataBean> list;
    private Context context;
    private boolean loadMore;
    private boolean haveMore = true;
    public static final int TYPE_FOOTER = 100;
    public static final int TYPE_NOMAL = 101;

    public boolean isLoadMore() {
        return loadMore;
    }

    public void setLoadMore(boolean loadMore) {
        this.loadMore = loadMore;
    }

    public boolean isHaveMore() {
        return haveMore;
    }

    public void setHaveMore(boolean haveMore) {
        this.haveMore = haveMore;
    }

    public ZXAdapter(List<ZXBean.DataBeanX.DataBean> list, Context context) {
        if (list == null) {
            this.list = new ArrayList<>();
        } else {
            this.list = list;
        }
        this.context = context;
    }

    public void addRes(List<ZXBean.DataBeanX.DataBean> data) {
        if (data != null && data.size() > 0) {
            this.list.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void updateRes(List<ZXBean.DataBeanX.DataBean> data) {
        if (data != null && data.size() > 0) {
            this.list.clear();
            this.list.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return (list != null && list.size() > 0) ? list.size() + 1 : 0;
    }

    @Override
    public int getItemViewType(int position) {
        int itemCount = list.size();
        if (position >= itemCount) {
            return TYPE_FOOTER;
        }
        return TYPE_NOMAL;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        switch (viewType) {
            case TYPE_NOMAL:
                itemView = LayoutInflater.from(context).inflate(R.layout.fragment_zx_detail, parent, false);
                return new ZXViewHolder(itemView);
            case TYPE_FOOTER:
                itemView = LayoutInflater.from(context).inflate(R.layout.load_more, parent, false);
                return new FooterViewHolder(itemView);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        int type = getItemViewType(position);
        switch (type) {
            case TYPE_NOMAL:
                if (holder instanceof ZXViewHolder) {
                    ZXViewHolder zxViewHolder = (ZXViewHolder) holder;
                    zxViewHolder.detail_img.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(context, TuiJanDetailActivity.class);
                            intent.putExtra("postId", list.get(position).getId());
                            context.startActivity(intent);
                        }
                    });
                    zxViewHolder.head_image.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(context, DaRenActivity.class);
                            intent.putExtra("userId", list.get(position).getUser_id());
                            context.startActivity(intent);
                        }
                    });
                    Glide.with(context).load(list.get(position).getImage()).into(zxViewHolder.detail_img);
                    Glide.with(context).load(list.get(position).getHead_img()).transform(new GlideCircleTransform(context)).into(zxViewHolder.head_image);
                    zxViewHolder.nick_name.setText(list.get(position).getNick());
                    zxViewHolder.create_time.setText(list.get(position).getCreate_time());
                    zxViewHolder.agree_num.setText(list.get(position).getAgree_count());
                }
                break;
            case TYPE_FOOTER:
                if (holder instanceof FooterViewHolder) {
                    FooterViewHolder footerViewHolder = (FooterViewHolder) holder;
                    if (haveMore) {
                        footerViewHolder.loadMore.setVisibility(View.VISIBLE);
                        footerViewHolder.loadEnd.setVisibility(View.GONE);
                    } else {
                        footerViewHolder.loadMore.setVisibility(View.GONE);
                        footerViewHolder.loadEnd.setVisibility(View.VISIBLE);
                    }
                }
                break;
        }
    }

    class ZXViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.detail_img)
        ImageView detail_img;
        @BindView(R2.id.head_image)
        ImageView head_image;
        @BindView(R2.id.nick_name)
        TextView nick_name;
        @BindView(R2.id.create_time)
        TextView create_time;
        @BindView(R2.id.agree_num)
        TextView agree_num;

        public ZXViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class FooterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R2.id.load_more)
        LinearLayout loadMore;

        @BindView(R2.id.load_end)
        TextView loadEnd;

        public FooterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
