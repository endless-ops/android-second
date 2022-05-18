package cn.dreamchase.android.second.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import cn.dreamchase.android.second.R;

public class AcceptChuanZhiHuiChuanZhiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_chuanzhi_huichuanzhi);

        String value = getIntent().getStringExtra("parameter");
        Log.i("值",value);
        TextView textView = findViewById(R.id.accept);
        textView.setText(value);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            Intent intent = new Intent();
            intent.putExtra("result","这是回值");
            setResult(RESULT_OK,intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
