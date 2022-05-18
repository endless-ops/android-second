package cn.dreamchase.android.second.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import cn.dreamchase.android.second.R;

public class MainActivity_DynamicBroadcast extends AppCompatActivity {

    public static final String ACTION_DYNAMIC_BROADCAST = "android.intent.action.DYNAMIC_BROADCAST";
    private DynamicBroadcast dynamicBroadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_broadcast);
        Log.i("MainActivity","onCreate Thread : " + android.os.Process.myTid() );

        findViewById(R.id.btn_dynamic_broadcast_send_message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ACTION_DYNAMIC_BROADCAST);
                intent.putExtra("data","Dynamic Broadcast Parameter");
                sendBroadcast(intent); // 发送广播消息
            }
        });

        // 动态注册广播
        dynamicBroadcast = new DynamicBroadcast();
        IntentFilter intentFilter = new IntentFilter(ACTION_DYNAMIC_BROADCAST);
        registerReceiver(dynamicBroadcast,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity","onDestroy");

        unregisterReceiver(dynamicBroadcast);
    }
}