package cn.dreamchase.android.second.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import cn.dreamchase.android.second.R;

/**
 * Activity的传值与回传值
 */
public class MainActivity_Service extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_service);
        Log.i("MainActivity","onCreate Thread : " + android.os.Process.myTid() );

        findViewById(R.id.btn_start_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_Service.this, LocalService.class);
                startService(intent);
            }
        });


        findViewById(R.id.btn_stop_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_Service.this, LocalService.class);
                stopService(intent);
            }
        });

        findViewById(R.id.btn_bind_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_Service.this, LocalService.class);
                bindService(intent,serviceConnection,BIND_AUTO_CREATE);
            }
        });

        findViewById(R.id.btn_unbind_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService();
            }
        });
    }

    private void unbindService(){
        if (isBound) {
            unbindService(serviceConnection);
            isBound = false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService();
    }

    private LocalService localService;
    private boolean isBound;


    ServiceConnection serviceConnection = new ServiceConnection() {
        /**
         * Activity 与 Service 绑定时调用
         */
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            localService = ((LocalService.LocalBinder)service).getService();
            localService.downMusic();
            isBound = true;
        }

        /**
         * Activity 与 Service 解绑时调用
         */
        @Override
        public void onServiceDisconnected(ComponentName name) {
            localService = null;
        }
    };
}