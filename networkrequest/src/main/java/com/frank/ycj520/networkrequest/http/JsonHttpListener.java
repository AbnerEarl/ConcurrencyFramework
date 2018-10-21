package com.frank.ycj520.networkrequest.http;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonHttpListener<M> implements IHttpListener {
    private Class<M> responseClass;
    private IDataListener<M> dataListener;

    //切换线程
    private Handler handler=new Handler(Looper.getMainLooper());

    public JsonHttpListener(Class<M> responseClass, IDataListener<M> dataListener) {
        this.responseClass = responseClass;
        this.dataListener = dataListener;
    }

    @Override
    public void onSuccess(InputStream inputStream) {
        //获取相应结果，把byte数据转换为string数据
        Log.e("inputStream",inputStream.toString());
        String content=getContent(inputStream);
        Log.e("response",content);
        final M response=JSON.parseObject(content,responseClass);

        //传到主线程
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (dataListener!=null){
                    dataListener.onSuccess(response);
                }
            }
        });


    }

    private String getContent(InputStream inputStream) {

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder=new StringBuilder();
        String line=null;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            /*try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }
        return stringBuilder.toString();
    }

    @Override
    public void onFailure() {

        handler.post(new Runnable() {
            @Override
            public void run() {
                if (dataListener!=null){
                    dataListener.onFailure();
                }
            }
        });
    }
}
