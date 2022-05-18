package cn.dreamchase.android.second.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import cn.dreamchase.android.second.R;

/**
 * -应用内广播 LocalBroadcastManager
 */
public class MainActivity_LocalBroadcast extends AppCompatActivity {

    private LocalBroadcastManager localBroadcastManager;
    private LocalBroadcastReceiver localBroadcastReceiver;

    public static final String ACTION_LOCAL_BROADCAST = "android.intent.action.LOCAL_BROADCAST";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_broadcast);
        Log.i("MainActivity","onCreate Thread : " + android.os.Process.myTid() );

        findViewById(R.id.btn_local_broadcast_send_message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ACTION_LOCAL_BROADCAST);
                intent.putExtra("data","Local Broadcast Parameter");
                LocalBroadcastManager.getInstance(MainActivity_LocalBroadcast.this).sendBroadcast(intent); // 发送广播消息
            }
        });

        // 应用内广播
        // LocalBroadcastManager 的使用方法 与 动态注册广播类似，首先 需要获取 其对象，通过 getInstance方法（单例模式）获取，然后调用 registerReceiver
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcastReceiver = new LocalBroadcastReceiver();
        localBroadcastManager.registerReceiver(localBroadcastReceiver,new IntentFilter(ACTION_LOCAL_BROADCAST));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity","onDestroy");

        localBroadcastManager.unregisterReceiver(localBroadcastReceiver);
    }
}