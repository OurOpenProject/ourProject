package com.ourproject.ui.book.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.ui.book.adapters.category.CategoryDataAdapter;
import com.ourproject.ui.book.bean.category.DataBean;
import com.ourproject.ui.book.bean.category.DataBeanX;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by YC on 2017/4/11.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{
    private Context context;
    private List<DataBeanX> dataX;
    private LayoutInflater inflater;

    public CategoryAdapter(Context context, List<DataBeanX> dataX) {
        this.context = context;
        if (dataX != null) {
            this.dataX = dataX;
        }else {
            this.dataX = new ArrayList<>();
        }
        inflater = LayoutInflater.from(context);
    }
    public void updataRes(List<DataBeanX> dataX){
        if (dataX != null) {
            this.dataX.clear();
            this.dataX.addAll(dataX);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = inflater.inflate(R.layout.book_material_datax, parent, false);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        DataBeanX dataBeanX = dataX.get(position);
        holder.mText.setText(dataBeanX.getText());

        String image = dataBeanX.getImage();
        List<DataBean> data = dataBeanX.getData();
        CategoryDataAdapter adapter = new CategoryDataAdapter(context, data, image);
        StaggeredGridLayoutManager layoutManager =
                new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.VERTICAL);

        holder.mRecycler.setLayoutManager(layoutManager);
        holder.mRecycler.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return dataX!=null ? dataX.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.datax_text)
        TextView mText;
        @BindView(R2.id.datax_recycler)
        RecyclerView mRecycler;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
