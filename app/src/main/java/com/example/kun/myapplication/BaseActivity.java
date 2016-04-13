package com.example.kun.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * BaseActivity的封装
 */
public abstract class BaseActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "BaseActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: >>>>>>>");
        showTitleBar();
        initContentView(savedInstanceState);
        init();
    }

    //初始化UI布局
    protected abstract void initContentView(Bundle savedInstanceState);

    protected abstract void init();

    //标题是否显示
    protected void showTitleBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    //设置全屏
    public void setFullScreen() {
        //去除标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }


    /*
     * 界面切换方法
     */

    public void forward(Class<?> classObj) {

        Intent intent = new Intent();

        intent.setClass(this, classObj);

        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        this.startActivity(intent);

        //this.finish();
    }

    /*
     * 界面切换方法（带数据）
     */
    public void forward(Class<?> classObj, Bundle params) {

        Intent intent = new Intent();

        intent.setClass(this, classObj);

        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        intent.putExtras(intent);

        //this.finish();
    }


    /*
    * toast()提示信息
    */
    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    public void loadingProgressDialog() {
        ProgressDialog dialog = ProgressDialog.show(this, "", "正在加载数据，请稍等...", true);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: >>>>>>>");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: >>>>>>>");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: >>>>>>>");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: >>>>>>>");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: >>>>>>>");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: >>>>>>>");
    }
}
