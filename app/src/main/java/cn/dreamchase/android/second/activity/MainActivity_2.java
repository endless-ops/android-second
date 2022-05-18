package cn.dreamchase.android.second.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import cn.dreamchase.android.second.R;

public class MainActivity_2 extends AppCompatActivity {

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
                Intent intent = new Intent(MainActivity_2.this, FourActivity.class);
                startActivity(intent);

                // Activity 启动与退出动画
                // overridePendingTransition(enterAnim，exitAnim)
                // 参数 enterAnim 表示的是从ActivityA跳转到ActivityB，进入B时的动画效果
                // 参数 exitAnim 表示的是从ActivityA跳转到ActivityB，离开B时的动画效果
                // 注意：
                //     overridePendingTransition 方法需要在 startActivity方法或者 finish方法调用之后立即执行。
                //      若进入B或者离开A时，不需要动画效果，则可以传值 0
                // overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_in_left);
                overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
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