package com.frank.ycj520.networkrequest.http;

public interface IDataListener<M> {
    void onSuccess(M m);
    void onFailure();
}
