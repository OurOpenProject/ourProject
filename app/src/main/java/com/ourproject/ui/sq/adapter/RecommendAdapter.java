package com.ourproject.ui.sq.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.ui.sq.bean.SqBean;
import com.ourproject.util.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/4/10.
 */

public class RecommendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private SqBean bean;

    public RecommendAdapter(Context context, SqBean bean) {
        this.context = context;
        this.bean=bean;
    }

    public void addRes(SqBean bean) {
        if (bean != null) {
            this.bean = bean;
            notifyDataSetChanged();
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View itemView = LayoutInflater.from(context).inflate(R.layout.fragment_re_banner, parent, false);
            return new BannerViewHolder(itemView);
        } else if (viewType == 1) {
            View itemView = LayoutInflater.from(context).inflate(R.layout.fragment_dr, parent, false);
            return new DaRenViewHolder(itemView);
        } else if (viewType == 2) {
            View itemView = LayoutInflater.from(context).inflate(R.layout.fragment_jx, parent, false);
            return new JxViewHolder(itemView);
        } else {
            View itemView = LayoutInflater.from(context).inflate(R.layout.fragment_topic, parent, false);
            return new TopicViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == 0) {
            if (holder instanceof BannerViewHolder) {
                BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
                List<String> images = new ArrayList<>();
                for (int i = 0; i < bean.getData().getBanner().size(); i++) {
                    images.add(bean.getData().getBanner().get(i).getBanner_picture());
                }
                bannerViewHolder.banner.setImages(images).setImageLoader(new GlideImageLoader()).setDelayTime(4000).start();
            }

        } else if (type == 1) {
            if (holder instanceof DaRenViewHolder) {
                DaRenViewHolder daRenViewHolder = (DaRenViewHolder) holder;
                LinearLayoutManager manager = new LinearLayoutManager(context);
                manager.setOrientation(LinearLayoutManager.HORIZONTAL);
                daRenViewHolder.recycler_dr.setLayoutManager(manager);
                daRenViewHolder.recycler_dr.setAdapter(new DaRenAdapter(bean.getData().getShequ_talent(), context));
            }
        } else if (type == 2) {
            if (holder instanceof JxViewHolder) {
                JxViewHolder jxViewHolder = (JxViewHolder) holder;
                LinearLayoutManager manager = new LinearLayoutManager(context);
                manager.setOrientation(LinearLayoutManager.HORIZONTAL);
                jxViewHolder.recycler_jx.setLayoutManager(manager);
                jxViewHolder.recycler_jx.setAdapter(new JxAdapter(bean.getData().getShequ_marrow(), context));
            }
        } else if (type == 3) {
            if (holder instanceof TopicViewHolder) {
                TopicViewHolder topicViewHolder = (TopicViewHolder) holder;
                topicViewHolder.topic_tag.setText(bean.getData().getShequ_topics().get(position - 3).getTopic_name());
                LinearLayoutManager manager = new LinearLayoutManager(context);
                manager.setOrientation(LinearLayoutManager.HORIZONTAL);
                topicViewHolder.recycler_topic.setLayoutManager(manager);
                topicViewHolder.recycler_topic.setAdapter(new TopicAdapter(bean.getData().getShequ_topics().get(position - 3).getData(), context));
            }
        }
    }

    @Override
    public int getItemCount() {
        return bean != null ? bean.getData().getShequ_topics().size() + 3 : 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        } else {
            return 3;
        }
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.recommend_banner)
        Banner banner;

        public BannerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class DaRenViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.recycler_dr)
        RecyclerView recycler_dr;

        public DaRenViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class JxViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.recycler_jx)
        RecyclerView recycler_jx;

        public JxViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class TopicViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.topic_tag)
        TextView topic_tag;
        @BindView(R2.id.recycler_topic)
        RecyclerView recycler_topic;

        public TopicViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
