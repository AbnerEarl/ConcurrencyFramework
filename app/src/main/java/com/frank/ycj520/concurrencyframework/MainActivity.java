package com.frank.ycj520.concurrencyframework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.frank.ycj520.networkrequest.http.IDataListener;
import com.frank.ycj520.networkrequest.http.Volley;


public class MainActivity extends AppCompatActivity {

    //String url="http://v.juhe.cn/weather/index?&cityname=长沙&key=206960462f70fafc55bcf82117168617";
    //String url="http://v.juhe.cn/historyWeather/citys?key=206960462f70fafc55bcf82117168617&province_id=16";
    String url="http://v.juhe.cn/historyWeather/citys?key=206960462f70fafc55bcf82117168617&province_id=16";
    //String url="htt://www.baidu.com/";
    private TextView showResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showResult= (TextView)this.findViewById(R.id.tv_show);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"请求开始",Toast.LENGTH_LONG).show();

                Volley.sendJSONRequest(null, url, String.class, new IDataListener<String>() {
                    @Override
                    public void onSuccess(String s) {
                       // Toast.makeText(MainActivity.this,"结果："+s,Toast.LENGTH_LONG).show();
                        showResult.setText(""+s);
                    }

                    @Override
                    public void onFailure() {
                        Toast.makeText(MainActivity.this,"请求错误",Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
    }
}
