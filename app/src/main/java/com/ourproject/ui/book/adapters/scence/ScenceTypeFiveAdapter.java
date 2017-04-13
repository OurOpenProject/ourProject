package com.ourproject.ui.book.adapters.scence;

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
import com.ourproject.ui.book.bean.scencehome.WidgetDataBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by YC on 2017/4/11.
 */

public class ScenceTypeFiveAdapter extends RecyclerView.Adapter<ScenceTypeFiveAdapter.ViewHolder> {
    private Context context;
    private List<WidgetDataBean> data;
    private LayoutInflater inflater;

    public ScenceTypeFiveAdapter(Context context, List<WidgetDataBean> data) {
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
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = inflater.inflate(R.layout.book_scence_widget_type5_item, parent, false);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //position*4 + 1  ----> 1 , 5 , 9 ...   image
        //position*4 + 2  ----> 2 , 6 , 10 ...  video
        //position*4 + 3  ----> 3 , 7 , 11 ...  text
        //position*4 + 4  ----> 4 , 8 , 12 ...  content
        Glide.with(context)
                .load(data.get(position*4).getContent())
                .into(holder.mImage);
        String video = data.get((position * 4 + 1)).getContent();
        holder.mText.setText(data.get((position * 4 + 2)).getContent());
        holder.mContent.setText(data.get((position * 4 + 3)).getContent());
    }

    @Override
    public int getItemCount() {
        return data!=null ? data.size()/4 : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.type5_item_image)
        ImageView mImage;
        @BindView(R2.id.type5_item_video)
        ImageView mVideo;
        @BindView(R2.id.type5_item_text)
        TextView mText;
        @BindView(R2.id.type5_item_content)
        TextView mContent;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
