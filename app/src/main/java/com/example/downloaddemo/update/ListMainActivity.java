package com.example.downloaddemo.update;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.downloaddemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by：赖上罗小贱 on 2016/10/31
 * 邮箱：ljq@luojunquan.top
 * 个人博客：www.luojunquan.top
 * CSDN:http://blog.csdn.net/u012990171
 */
public class ListMainActivity extends Activity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private MyListItem listItem;
    private DataAdapter dataAdapter;
    private List<MyListItem> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_activity);
        initView();
        initData();
    }

    private void initData() {
        list = new ArrayList<MyListItem>();
        for (int i = 0;i < 40;i++){
            listItem = new MyListItem();
            listItem.setPosition(i);
            listItem.setChooseType(-1);
            listItem.setData("item" + (i + 1));
            list.add(listItem);
        }
        dataAdapter = new DataAdapter(listView,list,this);
        listView.setAdapter(dataAdapter);
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.listview);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MyListItem item = list.get(position);
        //改变选择状态
        item.setChooseType(list.get(position).getChooseType() * (-1));
        //调用已经在Adapter中封装好的给该更新数据的方法
        dataAdapter.updataItemData(position,item);
    }
}
