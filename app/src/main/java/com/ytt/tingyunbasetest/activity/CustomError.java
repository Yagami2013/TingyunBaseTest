package com.ytt.tingyunbasetest.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ytt.tingyunbasetest.R;
import com.ytt.tingyunbasetest.util.Tingyun;

import java.util.HashMap;
import java.util.Map;

public class CustomError extends AppCompatActivity {
    private int ERROR_TYPE_CUSTOM_EVENT=0;
    private int ERROR_TYPE_CUSTOM_ERROR=1;
    private int ERROR_TYPE_CATCHE_EXCEPTION=2;
    Map<String,Object> meta=new HashMap<String, Object>();
    Exception e=new Exception("1234");
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);

        Button test1=(Button)findViewById(R.id.bt1);
        Button test2=(Button)findViewById(R.id.bt2);
        Button test3=(Button)findViewById(R.id.bt3);
        Button test4=(Button)findViewById(R.id.bt4);
        Button test5=(Button)findViewById(R.id.bt5);
        Button test6=(Button)findViewById(R.id.bt6);
        Button test7=(Button)findViewById(R.id.bt7);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meta.put("timestamp",System.currentTimeMillis());
                switch (v.getId()){
                    case R.id.bt1:
                        Tingyun.reportError("button1",meta);
                        break;
                    case R.id.bt2:
                        Tingyun.reportException("button2",e,meta);
                        break;
                    case R.id.bt3:
                        Tingyun.reportErrorType("button3",ERROR_TYPE_CUSTOM_EVENT,meta);
                        break;
                    case R.id.bt4:
                        Tingyun.reportErrorType("button4",ERROR_TYPE_CUSTOM_ERROR,meta);
                        break;
                    case R.id.bt5:
                        Tingyun.reportExceptionType("button5",ERROR_TYPE_CATCHE_EXCEPTION,e,meta);
                        break;
                    case R.id.bt6:
                        Tingyun.reportExceptionType("button6",ERROR_TYPE_CUSTOM_EVENT,e,meta);
                        break;
                    case R.id.bt7:
                        Tingyun.reportExceptionType("button7",ERROR_TYPE_CUSTOM_ERROR,e,meta);
                        break;
                }

            }
        };
        test1.setOnClickListener(listener);
        test2.setOnClickListener(listener);
        test3.setOnClickListener(listener);
        test4.setOnClickListener(listener);
        test5.setOnClickListener(listener);
        test6.setOnClickListener(listener);
        test7.setOnClickListener(listener);

    }
}
