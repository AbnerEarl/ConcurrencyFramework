package com.frank.ycj520.networkrequest.http;

public class Volley {
    public static<T,M> void sendJSONRequest(T requestInfo,String url,Class<M> response,IDataListener<M> dataListener){
        IHttpService httpService=new JsonHttpService();
        IHttpListener httpListener=new JsonHttpListener(response,dataListener);
        HttpTask<T> httpTask=new HttpTask<T>(requestInfo,url,httpService,httpListener);
        ThreadPoolManage.getInstance().execute(httpTask);
    }
}
