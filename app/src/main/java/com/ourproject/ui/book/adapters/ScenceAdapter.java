package com.ourproject.ui.book.adapters;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.ui.book.adapters.scence.ScenceTypeEightAdapter;
import com.ourproject.ui.book.adapters.scence.ScenceTypeFiveAdapter;
import com.ourproject.ui.book.adapters.scence.ScenceTypeFourAdapter;
import com.ourproject.ui.book.adapters.scence.ScenceTypeOneAdapter;
import com.ourproject.ui.book.adapters.scence.ScenceTypeSevenAdapter;
import com.ourproject.ui.book.adapters.scence.ScenceTypeTwoAdapter;
import com.ourproject.ui.book.bean.scencehome.DataBean;
import com.ourproject.ui.book.bean.scencehome.WidgetDataBean;
import com.ourproject.ui.book.bean.scencehome.WidgetListBean;
import com.ourproject.util.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by YC on 2017/4/10.
 */

public class ScenceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = ScenceAdapter.class.getSimpleName();
    private Context context;
    private DataBean dataBean;
    private LayoutInflater inflater;

    public ScenceAdapter(Context context, DataBean dataBean) {
        this.context = context;
        if (dataBean != null) {
            this.dataBean = dataBean;
        }
        inflater = LayoutInflater.from(context);
    }

    public void updataRes(DataBean dataBean){
        if (dataBean != null) {
            this.dataBean = dataBean;
            notifyDataSetChanged();
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 10://banner
                View layout = inflater.inflate(R.layout.book_scence_banner, parent, false);

                return new BannerViewHolder(layout);
            case 1:
                View layout1 = inflater.inflate(R.layout.book_scence_widget_type1, parent, false);

                return new OneViewHolder(layout1);
            case 2:
                View layout2 = inflater.inflate(R.layout.book_scence_widget_type2, parent, false);

                return new TwoViewHolder(layout2);
            case 3:
                View layout3 = inflater.inflate(R.layout.book_scence_widget_type3, parent, false);

                return new ThreeViewHolder(layout3);
            case 4:
                View layout4 = inflater.inflate(R.layout.book_scence_widget_type4, parent, false);

                return new FourViewHolder(layout4);
            case 5:
                View layout5 = inflater.inflate(R.layout.book_scence_widget_type5, parent, false);

                return new FiveViewHolder(layout5);
            case 6:
                View layout6 = inflater.inflate(R.layout.book_scence_widget_type6, parent, false);

                return new SixViewHolder(layout6);
            case 7:
                View layout7 = inflater.inflate(R.layout.book_scence_widget_type7, parent, false);

                return new SevenViewHolder(layout7);
            case 8:
                View layout8 = inflater.inflate(R.layout.book_scence_widget_type8, parent, false);

                return new EightViewHolder(layout8);
            case 9:
                View layout9 = inflater.inflate(R.layout.book_scence_widget_type9, parent, false);

                return new NineViewHolder(layout9);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        switch (type) {
            case 10:
                if (holder instanceof BannerViewHolder) {
                    BannerViewHolder holder10 = (BannerViewHolder) holder;
                    List<String> bannerLists = new ArrayList<>();
                    for (int i = 0; i < dataBean.getBanner().size(); i++) {
                        bannerLists.add(dataBean.getBanner().get(i).getBanner_picture());
                    }

                    holder10.mBanner.setImages(bannerLists)
                                    .setImageLoader(new GlideImageLoader())
                                    .setDelayTime(3*1000)
                            .start();
                }
                break;
            case 1:
                if (holder instanceof OneViewHolder) {
                    OneViewHolder holder1 = (OneViewHolder) holder;
                    List<WidgetDataBean> widgetData = dataBean.getWidgetList().get(position - 1).getWidget_data();
                    ScenceTypeOneAdapter adapter = new ScenceTypeOneAdapter(context, widgetData);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(context);
                    layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    holder1.mRecycler.setLayoutManager(layoutManager);
                    holder1.mRecycler.setAdapter(adapter);
                }
                break;
            case 2:
                if (holder instanceof TwoViewHolder) {
                    TwoViewHolder holder2 = (TwoViewHolder) holder;
                    List<WidgetDataBean> widgetData = dataBean.getWidgetList().get(position - 1).getWidget_data();
                    ScenceTypeTwoAdapter adapter = new ScenceTypeTwoAdapter(context, widgetData);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(context);
                    layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    holder2.mRecycler.setLayoutManager(layoutManager);
                    holder2.mRecycler.setAdapter(adapter);
                }

                break;
            case 3:
                if (holder instanceof ThreeViewHolder) {
                    ThreeViewHolder holder3 = (ThreeViewHolder) holder;
                    WidgetListBean data = dataBean.getWidgetList().get(position - 1);
                    setType3DataToView(holder3,data);
                }

                break;
            case 4:
                if (holder instanceof FourViewHolder) {
                    FourViewHolder holder4 = (FourViewHolder) holder;
                    holder4.mTitle.setText(dataBean.getWidgetList().get(position-1).getTitle());

                    List<WidgetDataBean> data = dataBean.getWidgetList().get(position - 1).getWidget_data();
                    ScenceTypeFourAdapter adapter = new ScenceTypeFourAdapter(context, data);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(context);
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    holder4.mRecycler.setLayoutManager(layoutManager);
                    holder4.mRecycler.setAdapter(adapter);
                }

                break;
            case 5:
                if (holder instanceof FiveViewHolder) {
                    FiveViewHolder holder5 = (FiveViewHolder) holder;
                    WidgetListBean data = dataBean.getWidgetList().get(position - 1);

                    holder5.mTitle.setText(data.getTitle());
                    ScenceTypeFiveAdapter adapter = new ScenceTypeFiveAdapter(context, data.getWidget_data());
                    LinearLayoutManager layoutManager = new LinearLayoutManager(context);
                    layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    holder5.mRecycler.setLayoutManager(layoutManager);
                    holder5.mRecycler.setAdapter(adapter);

                    holder5.mTitleContainer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
                }

                break;
            case 6:

                break;
            case 7:
                if (holder instanceof SevenViewHolder) {
                    SevenViewHolder holder7 = (SevenViewHolder) holder;
                    WidgetListBean data = dataBean.getWidgetList().get(position - 1);

                    holder7.mTitle.setText(data.getTitle());
                    ScenceTypeSevenAdapter adapter = new ScenceTypeSevenAdapter(context, data.getWidget_data());
                    LinearLayoutManager layoutManager = new LinearLayoutManager(context);
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    holder7.mRecycler.setLayoutManager(layoutManager);
                    holder7.mRecycler.setAdapter(adapter);

                    holder7.mTitleContainer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
                }

                break;
            case 8:
                if (holder instanceof EightViewHolder) {
                    EightViewHolder holder8 = (EightViewHolder) holder;
                    WidgetListBean widgetListBean = dataBean.getWidgetList().get(position - 1);
                    holder8.mTitle.setText(widgetListBean.getTitle());
                    holder8.mDesc.setText(widgetListBean.getDesc());

                    List<WidgetDataBean> data = widgetListBean.getWidget_data();
                    ScenceTypeEightAdapter adapter = new ScenceTypeEightAdapter(context, data);
                    GridLayoutManager layoutManager = new GridLayoutManager(context, 3);
                    holder8.mRecycler.setLayoutManager(layoutManager);
                    holder8.mRecycler.setAdapter(adapter);
                }
                break;
            case 9:
                if (holder instanceof NineViewHolder) {
                    NineViewHolder holder9 = (NineViewHolder) holder;
                    WidgetListBean widgetListBean = dataBean.getWidgetList().get(position - 1);
                    holder9.mTitlt.setText(widgetListBean.getTitle());

                }

                break;
        }
    }

    @Override
    public int getItemCount() {
        if (dataBean!=null) {

            return dataBean.getWidgetList().size()+1;

        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) { // banner
            return 10;
        }else {
            int widget_type = dataBean.getWidgetList().get(position-1).getWidget_type();
            return widget_type;
        }
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.banner_banner)
        Banner mBanner;
        @BindView(R2.id.banner_search)
        LinearLayout mSeacher;
        public BannerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public class OneViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.type1_recycler)
        RecyclerView mRecycler;
        public OneViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    public class TwoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.type2_recycler)
        RecyclerView mRecycler;
        public TwoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public class ThreeViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.type3_title)
        TextView mTitle;
        @BindView(R2.id.type3_title_container)
        LinearLayout mTitltContainer;
        @BindView(R2.id.type3_desc)
        TextView mDesc;
        @BindView(R2.id.type3_image1)
        ImageView mImage1;
        @BindView(R2.id.type3_image1_text1)
        TextView mImage1Text1;
        @BindView(R2.id.type3_image1_text2)
        TextView mImage1Text2;

        @BindView(R2.id.type3_image2)
        ImageView mImage2;
        @BindView(R2.id.type3_image2_video)
        ImageView mImage2Video;

        @BindView(R2.id.type3_image3)
        ImageView mImage3;
        @BindView(R2.id.type3_image3_video)
        ImageView mImage3Video;

        @BindView(R2.id.type3_image4)
        ImageView mImage4;
        @BindView(R2.id.type3_image4_video)
        ImageView mImage4Video;

        @BindView(R2.id.type3_image5)
        ImageView mImage5;
        @BindView(R2.id.type3_image5_video)
        ImageView mImage5Video;

        public ThreeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    public class FourViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.type4_title_container)
        LinearLayout mTitleContainer;
        @BindView(R2.id.type4_title)
        TextView mTitle;
        @BindView(R2.id.type4_recycler)
        RecyclerView mRecycler;
        public FourViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public class FiveViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.type5_title_container)
        LinearLayout mTitleContainer;
        @BindView(R2.id.type5_title)
        TextView mTitle;
        @BindView(R2.id.type5_recycler)
        RecyclerView mRecycler;
        public FiveViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public class SixViewHolder extends RecyclerView.ViewHolder {

        public SixViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public class SevenViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.type7_title_container)
        LinearLayout mTitleContainer;
        @BindView(R2.id.type7_title)
        TextView mTitle;
        @BindView(R2.id.type7_recycler)
        RecyclerView mRecycler;
        public SevenViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public class EightViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.type8_title_container)
        LinearLayout mTitleContainer;
        @BindView(R2.id.type8_title)
        TextView mTitle;
        @BindView(R2.id.type8_recycler)
        RecyclerView mRecycler;
        @BindView(R2.id.type8_desc)
        TextView mDesc;
        public EightViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public class NineViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.type9_title)
        TextView mTitlt;
        public NineViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    //===========================================


    private void setType3DataToView(ThreeViewHolder holder3, WidgetListBean data) {
        holder3.mTitle.setText(data.getTitle());
        holder3.mDesc.setText(data.getDesc());
        Glide.with(context)
                .load(data.getWidget_data().get(0).getContent())
                .into(holder3.mImage1);
        holder3.mImage1Text1.setText(data.getWidget_data().get(1).getContent());
        holder3.mImage1Text2.setText(data.getWidget_data().get(2).getContent());

        Glide.with(context)
                .load(data.getWidget_data().get(3).getContent())
                .into(holder3.mImage2);
        String video1 = data.getWidget_data().get(4).getContent();

        Glide.with(context)
                .load(data.getWidget_data().get(5).getContent())
                .into(holder3.mImage3);
        String video2 = data.getWidget_data().get(6).getContent();

        Glide.with(context)
                .load(data.getWidget_data().get(7).getContent())
                .into(holder3.mImage4);
        String video3 = data.getWidget_data().get(8).getContent();

        Glide.with(context)
                .load(data.getWidget_data().get(9).getContent())
                .into(holder3.mImage5);
        String video4 = data.getWidget_data().get(10).getContent();
    }

}
