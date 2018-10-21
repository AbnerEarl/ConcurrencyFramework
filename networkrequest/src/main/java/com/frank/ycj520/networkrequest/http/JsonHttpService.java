package com.frank.ycj520.networkrequest.http;

import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonHttpService implements IHttpService {
    private String url;
    private byte[]requestData;
    private IHttpListener httpListener;
    @Override
    public void setUrl(String url) {

        this.url=url;
    }

    @Override
    public void setRequestData(byte[] requestData) {

        this.requestData=requestData;
    }

    //真实的网络操作在这里实现
    @Override
    public void execute() {
        httpUrlConnPost();
    }

    @Override
    public void setHttpCallBack(IHttpListener httpListener) {

        this.httpListener=httpListener;
    }
    HttpURLConnection httpURLConnection=null;
    public void httpUrlConnPost(){
        URL urls=null;
        try{
            urls=new URL(url);
            httpURLConnection= (HttpURLConnection) urls.openConnection();
            httpURLConnection.setConnectTimeout(6000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type","application/json;charset=UTF-8");
            httpURLConnection.connect();

            OutputStream outputStream=httpURLConnection.getOutputStream();
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(outputStream);
            if (requestData!=null){
                bufferedOutputStream.write(requestData);
            }
            bufferedOutputStream.flush();
            outputStream.close();
            bufferedOutputStream.close();

            if (httpURLConnection.getResponseCode()==HttpURLConnection.HTTP_OK){
                InputStream inputStream=httpURLConnection.getInputStream();
                httpListener.onSuccess(inputStream);
            }
            /*InputStream inputStream=httpURLConnection.getInputStream();
            httpListener.onSuccess(inputStream);*/

        }catch (Exception e) {
            e.printStackTrace();
            httpListener.onFailure();
        } finally {
            if (httpURLConnection!=null){
                httpURLConnection.disconnect();
            }

        }
    }
}
