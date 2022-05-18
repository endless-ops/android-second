package cn.dreamchase.android.second.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;

import cn.dreamchase.android.second.R;

/**
 * -共享元素效果就是从Activity A过度到 Activity B，可以指定元素过度
 * 给 View 增加 android:transitionName 属性
 */
public class MainActivity_SharedElement extends AppCompatActivity implements View.OnClickListener {

    private View view;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sharedelement);

        view = findViewById(R.id.view_share_one);
        textView = findViewById(R.id.view_share_two);

        findViewById(R.id.rl_root).setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rl_root) {
            Log.i("msg","执行了");
            finish();
        } else if (v.getId() == R.id.view_share_two) {
            Intent intent = new Intent(this, SharedElementActivity.class);

            Pair onePair = new Pair<>(view, ViewCompat.getTransitionName(view));
            Pair twoPair = new Pair<>(textView, ViewCompat.getTransitionName(textView));

            ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, onePair, twoPair);

            ActivityCompat.startActivity(this, intent, activityOptionsCompat.toBundle());
        }
    }
}