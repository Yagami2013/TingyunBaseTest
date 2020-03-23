package com.ytt.tingyunbasetest.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.ytt.tingyunbasetest.R;
import com.ytt.tingyunbasetest.adapter.YttListAdapter;
import com.ytt.tingyunbasetest.databuilder.JSONBuilder;
import com.ytt.tingyunbasetest.databuilder.Trace;

import java.io.File;

public class TestPage extends AppCompatActivity {
    private AdapterView.OnItemClickListener listItemListener;
    private ListAdapter adapter;
    private String[] data;
    private void setData(){
        data=new String[]{
               "测试JSON",
               "测试SQL",
                "测试retrofit"
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
