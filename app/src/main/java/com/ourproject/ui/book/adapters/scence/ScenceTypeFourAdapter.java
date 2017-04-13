package com.ourproject.ui.book.adapters.scence;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
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

public class ScenceTypeFourAdapter extends RecyclerView.Adapter<ScenceTypeFourAdapter.ViewHolder> {
    private Context context;
    private List<WidgetDataBean> data;
    private LayoutInflater inflater;

    public ScenceTypeFourAdapter(Context context, List<WidgetDataBean> data) {
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
        View layout = inflater.inflate(R.layout.book_scence_widget_type4_item, parent, false);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //(position*4) + 1  ---->id: 1, 5 ,9 ...    image  --->data的position ：(position*4)
        //(position*4) + 2  ---->id: 2, 6 ,10 ...   text1  --->data的position ：(position*4) + 1
        //(position*4) + 3  ---->id: 3, 7 ,11 ...   text2  --->data的position ：(position*4) + 2
        //(position*4) + 4  ---->id: 4, 8 ,12 ...   text3  --->data的position ：(position*4) + 3
        String imageUrl = data.get(((position * 4))).getContent();
        Glide.with(context)
                .load(imageUrl)
                .asBitmap()
                .centerCrop()
                .into(new BitmapImageViewTarget(holder.mImage){
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        holder.mImage.setImageDrawable(circularBitmapDrawable);
                    }
                });
        holder.mText1.setText(data.get((position*4)+1).getContent());
        holder.mText2.setText(data.get((position*4)+2).getContent());
        holder.mText3.setText(data.get((position*4)+3).getContent());

    }

    @Override
    public int getItemCount() {
        return data!=null ? 3 : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.type4_item_image)
        ImageView mImage;
        @BindView(R2.id.type4_item_text1)
        TextView mText1;
        @BindView(R2.id.type4_item_text2)
        TextView mText2;
        @BindView(R2.id.type4_item_text3)
        TextView mText3;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
