package com.example.myapplication;

import static androidx.cardview.R.color.cardview_shadow_end_color;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> demoList= new ArrayList<>();
    public ArrayList<Integer> getDemoList() {
        return demoList;
    }

    public void setDemoList() {
        this.demoList.add(5);
        this.demoList.add(50);
        this.demoList.add(15);
        this.demoList.add(2);
        this.demoList.add(10);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView sum_tv = findViewById(R.id.sumList_tv);
        setDemoList();
        sum_tv.setText(getResources().getString(R.string.list_text, getDemoList().toString()));
    }

    public void sumList(View view){
        int sum = 0;
        for (Integer number:demoList) {
            sum += number;
        }
        TextView sum_tv = findViewById(R.id.sumList_tv);
        sum_tv.setText(getResources().getString(R.string.sum_text, sum));
        Button btn = findViewById(R.id.btn);
        btn.setClickable(false);
        btn.setText(getResources().getString(R.string.disabled));
        btn.setBackgroundColor(0xFF666666);
    }
}