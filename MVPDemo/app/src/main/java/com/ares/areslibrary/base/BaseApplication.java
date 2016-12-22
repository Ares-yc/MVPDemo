package com.ares.areslibrary.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import java.util.Stack;

/**
 * Application 基类
 * Created by Ares on 2016/12/22/022.
 */

public class BaseApplication extends Application {

    private static Context context;
    private static Stack<Activity> activityStack;

    @Override
    public void onCreate() {
        super.onCreate();
        this.context = getApplicationContext();
        this.activityStack = new Stack<>();
        initConfig();
    }

    /**
     * 初始化操作
     */
    private void initConfig() {

    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext对象
     */
    public static Context getContext() {
        return context;
    }

    /**
     * Activiity 入栈
     *
     * @param activity Activiity对象
     */
    public static void addActivity(Activity activity) {
        if (activity != null) {
            activityStack.add(activity);
        }
    }

    /**
     * Activity 出栈
     *
     * @param activity Activiity对象
     */
    public static void removeActivity(Activity activity) {
        if (activity == null) return;
        for (Activity act : activityStack) {
            if (act.getClass().getSimpleName().equals(activity.getClass().getSimpleName())) {
                activityStack.remove(activity);
            }
        }
    }

    /**
     * 清空Activity栈
     */
    public static void finishAllActivity() {
        for (Activity act : activityStack) {
            act.finish();
        }
        activityStack.clear();
    }

    /**
     * 完全退出
     */
    public void exit() {
        finishAllActivity();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
