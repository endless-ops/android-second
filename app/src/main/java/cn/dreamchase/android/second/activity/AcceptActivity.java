package cn.dreamchase.android.second.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import cn.dreamchase.android.second.R;

public class AcceptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept);

        String value = getIntent().getStringExtra("parameter");
        Log.i("值",value);
        TextView textView = findViewById(R.id.accept);
        textView.setText(value);
    }
}
