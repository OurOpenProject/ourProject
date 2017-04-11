package com.ourproject.ui.lh.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.ui.lh.bean.FoodBean;
import com.ourproject.ui.lh.callback.OnRecClickListener;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/10 0010.
 */

public class FoodAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private List<FoodBean.DataBeanX.DataBean> data;
    private Context context;
    private LayoutInflater inflater;
    private OnRecClickListener onRecClickListener;
    private RecyclerView mRecyclerView;
    public static final int TYPE_OTHER = 1;   //数据的布局
    public static final int TYPE_BOTTOM = 2;  //底部加载更多的布局


    public void setOnRecClickListener(OnRecClickListener onRecClickListener) {
        this.onRecClickListener = onRecClickListener;
    }

    public FoodAdapter(List<FoodBean.DataBeanX.DataBean> data, Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
    }

    public void addData(List<FoodBean.DataBeanX.DataBean> data) {
        Log.e("FoodAdapter", "addData: " + data.size());
        if (data != null) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void updateRes(List<FoodBean.DataBeanX.DataBean> data) {
        Log.e("FoodAdapter", "updateRes: " + data.size());
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public FoodBean.DataBeanX.DataBean getItem(int position) {
        return data.get(position);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        mRecyclerView = null;
    }

    @Override
    public void onClick(View v) {
        int position = mRecyclerView.getChildAdapterPosition(v);
        onRecClickListener.onItemClick(mRecyclerView, position);
    }

    @Override
    public int getItemViewType(int position) {

        return TYPE_OTHER;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View itemView = null;
        switch (viewType) {
            case  TYPE_OTHER :
                itemView = inflater.inflate(R.layout.fragment_food_item, parent, false);
                holder = new ViewHolder(itemView);
                break;
//            case TYPE_BOTTOM:
//                itemView = inflater.inflate(R.layout.fragment_food_loading, parent, false);
//                holder = new ViewHolder1(itemView);
//                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(this);
        switch (getItemViewType(position)) {
            case 1:
                ViewHolder holder1 = (ViewHolder) holder;
                holder1.album.setText(data.get(position).getAlbum());
                holder1.episode.setText("更新至" + data.get(position).getEpisode() + "集");
                Glide.with(context).load(data.get(position).getImage()).into(holder1.image);
                Glide.with(context).load(data.get(position).getAlbum_logo()).into(holder1.logo);
                holder1.name.setText(data.get(position).getSeries_name());
                holder1.play.setText("上课人数" + data.get(position).getPlay());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.fragment_food_item_image)
        ImageView image;
        @BindView(R2.id.fragment_food_item_album)
        TextView album;
        @BindView(R2.id.fragment_food_item_episode)
        TextView episode;
        @BindView(R2.id.fragment_food_item_logo)
        ImageView logo;
        @BindView(R2.id.fragment_food_item_name)
        TextView name;
        @BindView(R2.id.fragment_food_item_play)
        TextView play;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

//    public static class ViewHolder1 extends RecyclerView.ViewHolder {
//        @BindView(R2.id.fragment_food_loading_text)
//        TextView text;
//        public ViewHolder1(View itemView) {
//            super(itemView);
//            ButterKnife.bind(this,itemView);
//        }
//    }
}
