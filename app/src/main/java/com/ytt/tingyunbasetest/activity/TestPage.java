package com.ytt.tingyunbasetest.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.ytt.tingyunbasetest.R;
import com.ytt.tingyunbasetest.databuilder.Trace;
import com.ytt.tingyunbasetest.service.NetRequest;
import com.ytt.tingyunbasetest.util.CommonTools;
import com.ytt.tingyunbasetest.util.Tingyun;

import java.util.HashMap;
import java.util.Map;

public class TestPage extends AppCompatActivity {
    private AdapterView.OnItemClickListener listItemListener;
    private ListAdapter adapter;
    private String[] data;
    private void setData(){
        data=new String[]{
               "测试JSON",
               "测试SQL",
                "测试retrofit",
                "测试X5",
                "start NetService",
                "ANR test",
                "自定义错误",
                "Crash",
                "测试OkHttp"
        };
    }
    private void setListItemListener(){
        listItemListener=new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Trace.getJSON();
                        break;
                    case 1:
                        Trace.getSQL();
                        break;
                    case 2:
                        Trace.getNet();
                        break;
                    case 3:
                        startActivity(new Intent(TestPage.this, X5Demo.class));
                        break;
                    case 4:
                        startService(new Intent(TestPage.this, NetRequest.class));
                        break;
                    case 5:
                        Trace.all();
                        CommonTools.wait(5);
                        CommonTools.alert(getApplicationContext(),"action response finish");
                        break;
                    case 6:
                        startActivity(new Intent(TestPage.this,CustomError.class));
//                        Map<String,Object> meta=new HashMap<String, Object>();
//                        try {
//                            meta.put("class",this);
//                            throw new Exception();
//                        }catch (Exception e){
//                            Tingyun.reportException("error message",e,meta);
//                        }
                        break;
                    case 7:
                        Trace.getCrash();
                        break;
                    case 8:
                        startActivity(new Intent(TestPage.this, NewWorkPage.class));
                        break;
                        default:
                            Trace.all();
                            break;
                }
            }
        };
    }
    private void setAdapter(){
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testpage);

        ListView listView=(ListView)findViewById(R.id.list_testcase);
        setData();
        setAdapter();
        setListItemListener();
        listView.setOnItemClickListener(listItemListener);
        listView.setAdapter(adapter);

    }
}
