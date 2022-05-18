package cn.dreamchase.android.second.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private MyApplication myApplication;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (myApplication == null) {
            myApplication = (MyApplication) getApplication();
        }
        myApplication.addActivity(this);
    }

    public void finishAllActivity() {
        myApplication.finishAllActivity();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myApplication.removeActivity(this);
    }
}
