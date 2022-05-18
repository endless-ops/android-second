package cn.dreamchase.android.second.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import cn.dreamchase.android.second.R;

/**
 * Activity 销毁
 * 关闭 当前的 Activity ，直接调用 finish()
 *
 *
 * 若打开了多个 Activity ， 想退出，有以下两种方案：
 *      System.exit(0);  强制退出，终止程序
 *      android.os.Process.killProcess(android.os.Process.myPid());  直接终止当前进程
 */
public class MainActivity_DetoryActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void finishAllActivity() {
        super.finishAllActivity();
    }
}