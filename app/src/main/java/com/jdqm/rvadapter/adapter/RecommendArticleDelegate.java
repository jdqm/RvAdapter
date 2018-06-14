package com.jdqm.rvadapter.adapter;


import com.jdqm.adapterlib.base.ItemViewDelegate;
import com.jdqm.adapterlib.base.ViewHolder;
import com.jdqm.rvadapter.R;
import com.jdqm.rvadapter.model.BaseModel;

/**
 * Created by yangsheng on 2018-6-14.
 */
public class RecommendArticleDelegate implements ItemViewDelegate<BaseModel> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.article_item;
    }

    @Override
    public boolean isForViewType(BaseModel item, int position) {
        return item.getViewType() == 1;
    }

    @Override
    public void convert(ViewHolder holder, BaseModel baseModel, int position) {

    }
}
