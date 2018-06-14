package com.jdqm.rvadapter.adapter;


import com.jdqm.adapterlib.base.ItemViewDelegate;
import com.jdqm.adapterlib.base.ViewHolder;
import com.jdqm.rvadapter.R;
import com.jdqm.rvadapter.model.BaseModel;

/**
 * Created by yangsheng on 2018-6-14.
 */
public class RecommendMusicDelegate implements ItemViewDelegate<BaseModel> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.single_view_type;
    }

    @Override
    public boolean isForViewType(BaseModel item, int position) {
        return item.getViewType() == 0;
    }

    @Override
    public void convert(ViewHolder holder, BaseModel baseModel, int position) {
        holder.setText(R.id.tvTitle, "个性电台" + position);
    }
}
