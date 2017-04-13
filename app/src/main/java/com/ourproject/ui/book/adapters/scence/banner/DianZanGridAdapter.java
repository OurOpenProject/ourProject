package com.ourproject.ui.book.adapters.scence.banner;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.ourproject.R;
import com.ourproject.ui.book.bean.secondary.scencehome.banner.dianzan.DataBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YC on 2017/4/12.
 */

public class DianZanGridAdapter extends BaseAdapter {
    public static final String TAG = DianZanGridAdapter.class.getSimpleName();
    private Context context;
    private List<DataBean> data;
    private LayoutInflater inflater;
    private int checkPosition = -1;

    public DianZanGridAdapter(Context context, List<DataBean> data) {
        this.context = context;
        if (data != null) {
            this.data = data;
        }else {
            this.data = new ArrayList<>();
        }
        inflater = LayoutInflater.from(context);
    }
    public void updataRes(List<DataBean> data){
        if (data!=null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }
    public void savaPosition(int checkPosition){
        this.checkPosition = checkPosition;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (data!=null) {
            if (data.size()<=6) {
                return data.size();
            }else {
                return 7;
            }
        }
        return data!=null ? data.size() : 0;
    }

    @Override
    public DataBean getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_image_layout,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (position < 6){
            String dishesImage = data.get(position).getHead_img();

            final ViewHolder finalHolder = holder;
            Glide.with(context)
                    .load(dishesImage)
                    .asBitmap()
                    .centerCrop()
                    .into(new BitmapImageViewTarget(finalHolder.mImage){
                        @Override
                        protected void setResource(Bitmap resource) {
                            super.setResource(resource);
                            RoundedBitmapDrawable circularBitmapDrawable =
                                    RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                            circularBitmapDrawable.setCircular(true);
                            finalHolder.mImage.setImageDrawable(circularBitmapDrawable);
                        }
                    });
        }else {
            holder.mImage.setImageResource(R.mipmap.ic_more);
        }

        return convertView;
    }

    public static class ViewHolder{
        private ImageView mImage;
        public ViewHolder(View itemView){
            mImage = (ImageView) itemView.findViewById(R.id.text_grid);
        }
    }
}
