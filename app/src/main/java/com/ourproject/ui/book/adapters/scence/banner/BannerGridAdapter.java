package com.ourproject.ui.book.adapters.scence.banner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.ourproject.R;
import com.ourproject.ui.book.bean.secondary.scencehome.banner.videohome.DataBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YC on 2017/4/12.
 */

public class BannerGridAdapter extends BaseAdapter {
    public static final String TAG = BannerGridAdapter.class.getSimpleName();
    private Context context;
    private List<DataBean> data;
    private LayoutInflater inflater;
    private int checkPosition = -1;

    public BannerGridAdapter(Context context, List<DataBean> data) {
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
            convertView = inflater.inflate(R.layout.item_text_layout,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (checkPosition == position) {
           holder.mText.setBackgroundColor(context.getResources().getColor(R.color.bcolorTextBg));
        }else {
            holder.mText.setBackgroundColor(context.getResources().getColor(R.color.colorBg));
        }
        holder.mText.setText(data.get(position).getEpisode()+"");

        return convertView;
    }

    public static class ViewHolder{
        private TextView mText;
        public ViewHolder(View itemView){
            mText = (TextView) itemView.findViewById(R.id.text_grid);
        }
    }
}
