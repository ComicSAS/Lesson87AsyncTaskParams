package com.example.lesson87asynctaskparams;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyTask mt;
    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvInfo = findViewById(R.id.tvInfo);
    }

    public void onclick(View v) {
        mt = new MyTask(tvInfo);
        mt.execute("file_path_1", "file_path_2", "file_path_3", "file_path_4");
    }
}
