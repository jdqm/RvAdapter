package com.jdqm.rvadapter.model;

/**
 * Created by Jdqm on 2018-6-14.
 */
public class BaseModel {
    private int viewType;

    public BaseModel(int viewType) {
        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
