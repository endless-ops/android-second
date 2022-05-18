package cn.dreamchase.android.second.activity;

import android.os.Bundle;
import android.view.Gravity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import cn.dreamchase.android.second.R;

public class ThreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        CustomToast.getInstance().showToastCustom(ThreeActivity.this,"显示中间", Gravity.BOTTOM);
    }
}
