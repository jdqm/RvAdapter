package com.jdqm.adapterlib.base;

/**
 * Created by Jdqm on 2018-6-13.
 */
public interface ItemViewDelegate<T> {

    int getItemViewLayoutId();

    boolean isForViewType(T item, int position);

    void convert(ViewHolder holder, T t, int position);

}
