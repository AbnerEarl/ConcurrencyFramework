package com.frank.ycj520.networkrequest.http;

public interface IHttpService {
    void setUrl(String url);
    void setRequestData(byte[] requestData);
    void execute();
    void setHttpCallBack(IHttpListener httpListener);
}
