package com.jdqm.rvadapter.adapter;

import android.content.Context;

import com.jdqm.adapterlib.MultiItemTypeAdapter;
import com.jdqm.rvadapter.model.BaseModel;

import java.util.List;

/**
 * Created by Jdqm on 2018-6-14.
 */
public class MyMultiItemViewAdapter extends MultiItemTypeAdapter<BaseModel> {

    public MyMultiItemViewAdapter(Context context, List<BaseModel> datas) {
        super(context, datas);
        addItemViewDelegate(new RecommendMusicDelegate());
        addItemViewDelegate(new RecommendArticleDelegate());
    }
}
