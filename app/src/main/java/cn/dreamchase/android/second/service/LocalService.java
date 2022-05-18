package cn.dreamchase.android.second.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class LocalService extends Service {

    public class LocalBinder extends Binder {
        public LocalService getService() {
            return LocalService.this;
        }
    }

    private IBinder iBinder = new LocalBinder();
    /**
     * -可以实现 Activity 与 Service 的通信
     * @param intent
     * @return
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("LocalService","onBind");

        return iBinder;
    }

    public void downMusic() {
        Log.i("LocalService","downMusic");
    }

    @Override
    public void onCreate() {
        Log.i("LocalService","onCreate Thread : " + android.os.Process.myTid() );

        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("cn.dreamchase.android","onStartCommand  :  " + startId);

        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("cn.dreamchase.android","onDestroy");
    }
}
