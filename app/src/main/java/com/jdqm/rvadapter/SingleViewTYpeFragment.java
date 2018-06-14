package com.jdqm.rvadapter;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jdqm.adapterlib.CommonAdapter;
import com.jdqm.adapterlib.base.ViewHolder;
import com.jdqm.rvadapter.model.BaseModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jdqm on 2018-6-14.
 */
public class SingleViewTYpeFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sigle_view_type, container, false);
        List<BaseModel> data = new ArrayList<>();
        data.add(new BaseModel(0));
        data.add(new BaseModel(0));
        data.add(new BaseModel(0));
        data.add(new BaseModel(0));
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.top = DisplayUtil.dpToPixel(10);
            }
        });
        recyclerView.setAdapter(new CommonAdapter<BaseModel>(getContext(), R.layout.single_view_type, data) {

            @Override
            protected void convert(ViewHolder holder, BaseModel baseModel, final int position) {
                holder.setText(R.id.tvTitle, String.valueOf("个性电台" + (position + 1)));
                holder.setOnClickListener(R.id.itemView, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(), String.valueOf("个性电台" + (position + 1)), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return view;
    }
}
