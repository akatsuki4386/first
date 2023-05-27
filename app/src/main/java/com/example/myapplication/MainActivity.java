package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;

//import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    ArrayList<Integer> demoList= new ArrayList<>();
//    public ArrayList<Integer> getDemoList() {
//        return demoList;
//    }
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.android.myapplication.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;
    EditText mMessageEditText;
//    public void setDemoList() {
//        this.demoList.add(5);
//        this.demoList.add(50);
//        this.demoList.add(15);
//        this.demoList.add(2);
//        this.demoList.add(10);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText);
        mReplyHeadTextView = findViewById(R.id.text_main);
        mReplyTextView = findViewById(R.id.text_message_one);
//        TextView sum_tv = findViewById(R.id.sumList_tv);
//        setDemoList();
//        sum_tv.setText(getResources().getString(R.string.list_text, getDemoList().toString()));
    }

//    public void sumList(View view){
//        int sum = 0;
//        for (Integer number:demoList) {
//            sum += number;
//        }
//        Toast.makeText(this,"Calculating",Toast.LENGTH_SHORT).show();
//        TextView sum_tv = findViewById(R.id.sumList_tv);
//        sum_tv.setText(getResources().getString(R.string.sum_text, sum));
//        Button btn = findViewById(R.id.btn);
//        btn.setClickable(false);
//        btn.setText(getResources().getString(R.string.disabled));
//        btn.setBackgroundColor(0xFF666666);
//    }

    public void launchSecondActivity(View view) {

        Log.d(LOG_TAG,"Button clicked!");
        String message = mMessageEditText.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        assert data != null;
        String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
        if (requestCode == TEXT_REQUEST){
            if (resultCode == RESULT_OK){
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}