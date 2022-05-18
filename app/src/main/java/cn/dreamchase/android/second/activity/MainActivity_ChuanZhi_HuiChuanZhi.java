package cn.dreamchase.android.second.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import cn.dreamchase.android.second.R;

/**
 * Activity的传值与回传值
 */
public class MainActivity_ChuanZhi_HuiChuanZhi extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chuanzhi_huichuanzhi);

        ActivityResultLauncher<Intent> intentActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Log.i("resultCode"," == > " + result.getResultCode());
                if(result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    TextView textView = findViewById(R.id.tv_view_xian);
                    textView.setText(data.getStringExtra("result"));
                }
            }
        });

        findViewById(R.id.chuan_zhi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_ChuanZhi_HuiChuanZhi.this, AcceptChuanZhiHuiChuanZhiActivity.class);

                intent.putExtra("parameter","AcceptActivity");

                // startActivityForResult(); 此方法以过时,新方案是使用 registerForActivityResult
                intentActivityResultLauncher.launch(intent);
            }
        });
    }


}