package cn.watson.ticketsystem.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import cn.watson.ticketsystem.bean.Bean;

/**
 * Created by edz on 2018/2/12.
 */

public class LeadActivity extends AppCompatActivity {
    private String testId = "1315209639";
    private String id = "540622134";
    private  final String URL = "https://appid-apkk.xx-app.com/frontApi/getAboutUs?appid="+id;
//    private  final String URL = "http://www.27305.com/frontApi/getAboutUs?appid=1801191453";

    private final Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                Intent intent = new Intent();
                intent.setClass(LeadActivity.this, WebActivity.class);
                intent.putExtra("url", mBody.getWapurl());
                startActivity(intent);

            } else {
                Intent intent = new Intent(LeadActivity.this, MainActivity.class);
                startActivity(intent);

            }
            finish();
        }
    };


    private Bean mBody;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        OkGo.<Bean>get(URL).execute(new JsonCallback<Bean>(Bean.class) {
            @Override
            public void onSuccess(Response<Bean> response) {

                mBody = response.body();
                if ("1".equals(mBody.getIsshowwap())) {
                    mHandler.sendEmptyMessageDelayed(1, 2000);
                } else {
                    mHandler.sendEmptyMessageDelayed(0, 2000);
                }
            }
        });

    }

}
