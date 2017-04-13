package com.ourproject.ui.book.adapters.material;

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
import com.ourproject.ui.book.bean.material.DataBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by YC on 2017/4/11.
 */

public class MaterialDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<DataBean> data;
    private LayoutInflater inflater;
    private String FirstImage;

    public MaterialDataAdapter(Context context, List<DataBean> data,String image) {
        this.context = context;
        this.FirstImage = image;
        if (data!=null) {
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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                View layout = inflater.inflate(R.layout.book_material_datax_item_text, parent, false);

                return new TextView1Holder(layout);
            case 1:
                View layout1 = inflater.inflate(R.layout.book_material_datax_item_img, parent, false);

                return new ImageView1Holder(layout1);
            case 2:
                View layout2 = inflater.inflate(R.layout.book_material_datax_item_text, parent, false);

                return new TextView1Holder(layout2);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        switch (type) {
            case 0:
                if (holder instanceof TextView1Holder) {
                    TextView1Holder holder2 = (TextView1Holder) holder;
                    holder2.mText.setVisibility(View.INVISIBLE);
                }
                break;
            case 1:
                if (holder instanceof ImageView1Holder) {
                    ImageView1Holder holder1 = (ImageView1Holder) holder;
                    Glide.with(context)
                            .load(FirstImage)
                            .into(holder1.mImage);
                }
                break;
            case 2:
                if (holder instanceof TextView1Holder) {
                    TextView1Holder holder2 = (TextView1Holder) holder;
                    if (position < 5){
                        holder2.mText.setText(data.get(position-2).getText());
                    }else {

                        holder2.mText.setText(data.get(position-3).getText());
                    }
                }
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        }else if(position==1 || position==5){
            return 0;
        }else {
            return 2;
        }
    }

    @Override
    public int getItemCount() {
        if (data!=null) {
            if (data.size()<=3) {
                return data.size()+2;
            }else {
                return data.size()+3;
            }
        }
        return 0;
    }


    public class ImageView1Holder extends RecyclerView.ViewHolder {
        @BindView(R2.id.datax_item_image)
        ImageView mImage;
        public ImageView1Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    public class TextView1Holder extends RecyclerView.ViewHolder {
        @BindView(R2.id.datax_item_text)
        TextView mText;
        public TextView1Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
