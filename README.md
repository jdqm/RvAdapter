# RvAdapter
万能 Adapter for RecyclerView.

# Download

```
implementation 'com.jdqm.adapterlib:adapterlib:1.0.0'
```

# 1.只有一种item viewType，使用 CommonAdapter，只需要实现 convert() 方法即可

example

```
RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
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
```

## 2. 多种item viewType，只需要为每种viewType实现一个 ItemViewDelegate 即可。

example

```
public class MyMultiItemViewAdapter extends MultiItemTypeAdapter<BaseModel> {

    public MyMultiItemViewAdapter(Context context, List<BaseModel> datas) {
        super(context, datas);
        addItemViewDelegate(new RecommendMusicDelegate());
        addItemViewDelegate(new RecommendArticleDelegate());
    }
}
```

## ItemViewDelegate 1

```
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
```

## ItemViewDelegate 2

```
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
```