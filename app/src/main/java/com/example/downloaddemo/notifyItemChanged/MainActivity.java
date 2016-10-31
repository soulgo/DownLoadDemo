package com.example.downloaddemo.notifyItemChanged;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.downloaddemo.R;

public class MainActivity extends AppCompatActivity {
    private Button btnMain;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_main);
        String[] data = new String[20];
        for (int i = 0;i < 20;i++){
            data[i] = "item" + i;
        }
        myAdapter = new MyAdapter(this,data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
        btnMain = (Button) findViewById(R.id.btn_main);
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAdapter.data[0] = "aaaaaa";
                myAdapter.data[5] = "bbbbbbb";
               myAdapter.notifyItemChanged(0);
               myAdapter.notifyItemChanged(5);
            }
        });
    }
}
