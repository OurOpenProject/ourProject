package com.ourproject.ui.book.adapters.scence.banner;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.ui.book.bean.secondary.scencehome.banner.course_relate.DataBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by YC on 2017/4/13.
 */

public class CourseRelateAdapter extends RecyclerView.Adapter<CourseRelateAdapter.ViewHolder> {
    public static final String TAG = CourseRelateAdapter.class.getSimpleName();
    private Context context;
    private List<DataBean> data;
    private LayoutInflater inflater;

    public CourseRelateAdapter(Context context, List<DataBean> data) {
        this.context = context;
        if (data != null) {
            this.data = data;
        }else {
            this.data = new ArrayList<>();
        }
        inflater = LayoutInflater.from(context);
    }
    public void updataRes(List<DataBean> data){
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public CourseRelateAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = inflater.inflate(R.layout.item_video_course_relate, parent, false);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(CourseRelateAdapter.ViewHolder holder, final int position) {
        Glide.with(context)
                .load(data.get(position).getRelation().getDishes_image())
                .into(holder.mImage);
        holder.mTitlt.setText(data.get(position).getRelation().getDishes_title());
        holder.mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String videoUrl = data.get(position).getRelation().getMaterial_video();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String videoUrl = data.get(position).getRelation().getProcess_video();
                String dishesId = data.get(position).getRelation().getDishes_id();

            }
        });
    }

    @Override
    public int getItemCount() {
        return data!=null ? data.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.dishes_image)
        ImageView mImage;
        @BindView(R2.id.dishes_play)
        ImageView mPlay;
        @BindView(R2.id.dishes_title)
        TextView mTitlt;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
