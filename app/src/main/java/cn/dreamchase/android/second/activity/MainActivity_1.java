package cn.dreamchase.android.second.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import cn.dreamchase.android.second.R;

public class MainActivity_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("cn.dreamchase.android","onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("cn.dreamchase.android","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("cn.dreamchase.android","onResume");

        // 此为显示启动
        // 在MainActivity中启动我们刚创建的SecondActivity
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("cn.dreamchase.android","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("cn.dreamchase.android","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("cn.dreamchase.android","onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("cn.dreamchase.android","onRestart");
    }
}