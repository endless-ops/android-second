package cn.dreamchase.android.second.activity;

import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import cn.dreamchase.android.second.R;

public class SlideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH) {
            Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.slide);

            getWindow().setEnterTransition(transition);
        }

        setContentView(R.layout.activity_slide);

        findViewById(R.id.ll_root).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
