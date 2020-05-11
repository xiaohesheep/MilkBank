package com.android.androiddemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.androiddemo.model.MyModel;
import com.android.androiddemo.recycleview.MultipleAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private MultipleAdapter adapter;
    private TextView tvRefresh;
    private List<MyModel> myModels = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        tvRefresh = findViewById(R.id.tv_refresh);
        tvRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myModels.clear();
                myModels.add(new MyModel("离阿基","dafda", "好好学习，天天向上"));
                myModels.add(new MyModel("离阿基","dafda", "好好学习，天天向上"));
                myModels.add(new MyModel("离阿基","dafda", "好好学习，天天向上"));
                myModels.add(new MyModel("离阿基","dafda", "好好学习，天天向上"));
                myModels.add(new MyModel("离阿基","dafda", "好好学习，天天向上"));
                adapter.notifyDataSetChanged();
            }
        });
        myModels.add(new MyModel("离阿基","dafda", "回复就好发"));
        myModels.add(new MyModel("离阿基","麻烦打打", "交给后台与"));
        myModels.add(new MyModel("离阿基","法大大放大", "交换机附近"));
        myModels.add(new MyModel("离阿基","拉拉队就发啦激动啊", "发短发的发热我悄悄"));
        adapter = new MultipleAdapter(myModels);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
    }
}
