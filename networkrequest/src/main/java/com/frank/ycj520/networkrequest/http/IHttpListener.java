package com.frank.ycj520.networkrequest.http;

import java.io.InputStream;

public interface IHttpListener {
    void onSuccess(InputStream inputStream);
    void onFailure();

}
