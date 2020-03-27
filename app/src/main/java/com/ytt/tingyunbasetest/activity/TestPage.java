package com.ytt.tingyunbasetest.activity;

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
                "start NetService"
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
