package com.ourproject.ui.book.adapters.scence;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.ui.book.bean.scencehome.WidgetDataBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by YC on 2017/4/11.
 */

public class ScenceTypeTwoAdapter extends RecyclerView.Adapter<ScenceTypeTwoAdapter.ViewHolder> {
    private Context context;
    private List<WidgetDataBean> data;
    private LayoutInflater inflater;

    public ScenceTypeTwoAdapter(Context context, List<WidgetDataBean> data) {
        this.context = context;
        if (data != null) {
            this.data = data;
        }else {
            this.data = new ArrayList<>();
        }
        inflater = LayoutInflater.from(context);
    }

    public void updataRes(List<WidgetDataBean> data){
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public ScenceTypeTwoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = inflater.inflate(R.layout.book_scence_widget_type2_item, parent, false);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(ScenceTypeTwoAdapter.ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Glide.with(context)
                .load(data.get(position).getContent())
                .into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return data!=null ? data.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.type2_item_image)
        ImageView mImage;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
