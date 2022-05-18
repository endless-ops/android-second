package cn.dreamchase.android.second.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import cn.dreamchase.android.second.R;

/**
 * Activity 与 Activity 传值
 */
public class MainActivity_ChuanZhi extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chuanzhi);

        findViewById(R.id.chuan_zhi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_ChuanZhi.this, AcceptActivity.class);

                intent.putExtra("parameter","AcceptActivity");

                startActivity(intent);
            }
        });
    }


}