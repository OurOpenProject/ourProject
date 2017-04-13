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
 * Created by YC on 2017/4/10.
 */

public class ScenceTypeSevenAdapter extends RecyclerView.Adapter<ScenceTypeSevenAdapter.ViewHolder> {
    private Context context;
    private List<WidgetDataBean> data;
    private LayoutInflater inflater;

    public ScenceTypeSevenAdapter(Context context, List<WidgetDataBean> data) {
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
        View layout = inflater.inflate(R.layout.book_scence_widget_type7_item, parent, false);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //(position*3) + 1  ---->id: 1, 4 ,7 ...   image  --->data的position ：(position*3)
        //(position*3) + 2  ---->id: 2, 5 ,8 ...   text1  --->data的position ：(position*3) + 1
        //(position*3) + 3  ---->id: 3, 6 ,9 ...   text2  --->data的position ：(position*3) + 2

        String imageUrl = data.get(((position * 3))).getContent();
        Glide.with(context)
                .load(imageUrl)
                .into(holder.mImage);
        holder.mText1.setText(data.get((position * 3)+1).getContent());
        holder.mText2.setText(data.get((position * 3)+2).getContent());

    }

    @Override
    public int getItemCount() {
        return data!=null ? (data.size()+1)/3 : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.type7_item_image)
        ImageView mImage;
        @BindView(R2.id.type7_item_text1)
        TextView mText1;
        @BindView(R2.id.type7_item_text2)
        TextView mText2;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
