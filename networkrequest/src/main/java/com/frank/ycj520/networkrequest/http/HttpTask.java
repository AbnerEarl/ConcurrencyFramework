package com.frank.ycj520.networkrequest.http;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;

public class HttpTask<T> implements Runnable {
    private IHttpService httpService;
    private IHttpListener httpListener;

    public <T> HttpTask(T requestInfo,String url,IHttpService iHttpService,IHttpListener iHttpListener){
        this.httpService=iHttpService;
        this.httpListener=iHttpListener;
        httpService.setUrl(url);
        httpService.setHttpCallBack(httpListener);
        if (requestInfo!=null){
            String requestContent=JSON.toJSONString(requestInfo);
            try {
                httpService.setRequestData(requestContent.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void run() {

        httpService.execute();
    }
}
