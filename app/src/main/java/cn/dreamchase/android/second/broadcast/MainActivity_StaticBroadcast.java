package cn.dreamchase.android.second.broadcast;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import cn.dreamchase.android.second.R;

/**
 * -静态注册广播
 * - 是在AndroidManifest.xml 文件中注册的，无论这个程序是否启动，都会接收到这个广播
 */
public class MainActivity_StaticBroadcast extends AppCompatActivity {

    public static final String ACTION_STATIC_BROADCAST = "android.intent.action.STATIC_BROADCAST";
    private DynamicBroadcast dynamicBroadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_broadcast);
        Log.i("MainActivity","onCreate Thread : " + android.os.Process.myTid() );

        findViewById(R.id.btn_static_broadcast_send_message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ACTION_STATIC_BROADCAST);
                intent.putExtra("data","Dynamic Broadcast Parameter");
                sendBroadcast(intent); // 发送广播消息
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity","onDestroy");

        unregisterReceiver(dynamicBroadcast);
    }
}