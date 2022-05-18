package cn.dreamchase.android.second.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import cn.dreamchase.android.second.R;

public class MainActivity_Slide extends AppCompatActivity {

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

        Button button = findViewById(R.id.slide);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 此为显示启动
                // 在MainActivity中启动我们刚创建的SecondActivity
                Intent intent = new Intent(MainActivity_Slide.this, SlideActivity.class);

                // 自Android5.0后的Activity之间的跳转动画
                // Google 提供了另一种Activity的过度动画-ActivityOptions，并且提供了
                // 兼容包 ActivityOptionsCompat，其是一个静态类，提供了相应的动画效果，
                // 内置的Activity 之间 切换动画有以下几种
                //  Explode 效果(爆炸)
                //  Slide   效果
                //  Fade    效果
                //  Shared Element 效果

                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity_Slide.this).toBundle());

            }
        });
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