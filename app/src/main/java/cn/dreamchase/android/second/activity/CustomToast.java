package cn.dreamchase.android.second.activity;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.dreamchase.android.second.R;

public class CustomToast {
    private static CustomToast instance = null;

    private Toast toast = null;

    private final int MARGIN_DP = 50;

    private CustomToast() {

    }

    public static CustomToast getInstance() {
        if (instance == null) {
            instance = new CustomToast();
        }

        return instance;
    }

    public void cancel() {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }
    }

    public void showToastCustom(Context context, String msg, int gravity) {
        showToastCustom(context, msg, R.layout.toast_msg, R.id.txt_toast_message, gravity);
    }

    public void showToastCustom(Context context, String msg, int layoutResId, int txtResId, int gravity) {
        cancel(); // 显示之前取消上次显示，这样每次都能显示最新的
        try {
            if (TextUtils.isEmpty(msg)) {
                return;
            }


            View layout = View.inflate(context, layoutResId, null);
            TextView txtMsg = layout.findViewById(txtResId);
            txtMsg.setText(msg);

            toast = new Toast(context);

            toast.setDuration(Toast.LENGTH_SHORT);

            if (gravity == Gravity.TOP) {
                int marginVertical = (int) dip2px(context,MARGIN_DP);
                toast.setGravity(gravity,0,marginVertical);
            }else if (gravity == Gravity.BOTTOM) {
                int marginVertical = (int) dip2px(context,MARGIN_DP);
                toast.setGravity(gravity,0,marginVertical);
            }else {
                toast.setGravity(gravity,0,0);
            }
            toast.setView(layout);
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static float dip2px(Context context,float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;

        return dpValue * scale * 0.5f;
    }
}
