package com.ytt.tingyunbasetest.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.ytt.tingyunbasetest.R;
import com.ytt.tingyunbasetest.data.Url;
import com.ytt.tingyunbasetest.databuilder.OkHttp3;

public class NewWorkPage extends AppCompatActivity {

    private AdapterView.OnItemClickListener listItemListener;
    private ListAdapter adapter;
    private String[] data;
    private void setData(){
        data=new String[]{
                "ka_virus_report",
                "png",
                "jpg",
                "ka_png",
                "apk_mt",
                "apk_bdwp"
        };
    }
    private void setListItemListener(){
        listItemListener=new AdapterView.OnItemClickListener() {
            String url="";
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        url= Url.ka_virus_report;
                        break;
                    case 1:
                        url= Url.png;
                        break;
                    case 2:
                        url= Url.jpg;
                        break;
                    case 3:
                        url= Url.ka_png;
                        break;
                    case 4:
                        url= Url.apk_mt;
                        break;
                    case 5:
                        url= Url.apk_bdwp;
                }
                OkHttp3 runner=new OkHttp3(url);
                runner.start();
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
