package cn.dreamchase.android.second.activity;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import java.util.Stack;

/**
 * -销毁所有的Activity ,需手动实现
 */
public class MyApplication extends Application {

    private static Stack<Activity> activityStack; // Activity 栈

    /**
     * -添加 Activity 到堆栈
     * @param activity
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }

        if (!activityStack.contains(activity)) {
            Log.i("cn.dreamchase.android","添加 Activity :" + activity.getLocalClassName());

            activityStack.add(activity);
        }
    }

    /**
     * -获取当前 Activity （堆栈中最后一个压入栈）
     * @return
     */
    public Activity currentActivity() {
        return activityStack.lastElement();
    }

    public void removeActivity(Activity activity) {
        if (activity != null && activityStack.contains(activity)) {
            Log.i("cn.dreamchase.android","删除 Activity :" + activity.getLocalClassName());
            activityStack.remove(activity);
        }
    }

    /**
     * -结束所有 Activity
     */
    public void finishAllActivity() {
        for (int i = 0,size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }

        activityStack.clear();
        Log.i("cn.dreamchase.android","结束所有 Activity :");
    }
}
