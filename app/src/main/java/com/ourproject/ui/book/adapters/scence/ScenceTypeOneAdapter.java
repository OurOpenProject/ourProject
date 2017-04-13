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

public class ScenceTypeOneAdapter extends RecyclerView.Adapter<ScenceTypeOneAdapter.ViewHolder> {
    private Context context;
    private List<WidgetDataBean> data;
    private LayoutInflater inflater;

    public ScenceTypeOneAdapter(Context context, List<WidgetDataBean> data) {
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
        View layout = inflater.inflate(R.layout.book_scence_widget_type1_item, parent, false);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //(position * 2) + 1     ---> 1 , 3 , 5 , 7 ... type:image
        //(position * 2) * 2     ---> 2 , 4 , 6 , 8 ... type:text
        int imagePosition = (position * 2) ;
        int textPosition = (position * 2) + 1;
        Glide.with(context)
                .load(data.get(imagePosition).getContent())
                .into(holder.mImage);
        holder.mText.setText(data.get(textPosition).getContent());
    }

    @Override
    public int getItemCount() {
        return data!=null ? 4 : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.type1_image)
        ImageView mImage;
        @BindView(R2.id.type1_text)
        TextView mText;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
