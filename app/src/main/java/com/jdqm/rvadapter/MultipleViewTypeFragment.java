package com.jdqm.rvadapter;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jdqm.adapterlib.wrapper.LoadMoreWrapper;
import com.jdqm.rvadapter.adapter.MyMultiItemViewAdapter;
import com.jdqm.rvadapter.model.BaseModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Jdqm on 2018-6-14.
 */
public class MultipleViewTypeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.multiple_view_type, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.bottom = DisplayUtil.dpToPixel(10);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        final List<BaseModel> data = new ArrayList<>();
        data.add(new BaseModel(0));
        data.add(new BaseModel(1));
        data.add(new BaseModel(1));
        data.add(new BaseModel(0));
        data.add(new BaseModel(0));
        MyMultiItemViewAdapter adapter = new MyMultiItemViewAdapter(getContext(), data);
        final LoadMoreWrapper loadMoreWrapper = new LoadMoreWrapper(adapter);
        loadMoreWrapper.setLoadMoreView(R.layout.default_loading);
        loadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Random random = new Random();
                        boolean flag = random.nextBoolean();
                        if (flag) {
                            data.add(new BaseModel(0));
                        } else {
                            data.add(new BaseModel(1));
                        }
                        loadMoreWrapper.notifyDataSetChanged();
                    }
                }, 3000);
            }
        });
        recyclerView.setAdapter(loadMoreWrapper);

        return view;
    }
}
