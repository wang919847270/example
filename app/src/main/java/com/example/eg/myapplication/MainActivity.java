package com.example.eg.myapplication;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import org.w3c.dom.Comment;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    /**
     * 获取厂商信息
     *
     * @return
     */
    public String getBrand() {
        String brand = "";
        try {
            brand = Build.BRAND;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return brand;
    }

    public String getModel() {
        String model = "";
        try {
            model = Build.MODEL;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                addShortcut("入口");
                break;
            case  R.id.btn2:
                Intent intent = new Intent();
                //ComponentName name = new ComponentName("com.example.eg.myapplication","com.example.eg.myapplication.MainActivity");

                ComponentName name = new ComponentName("com.ptns.da.fz.vend","com.ptns.da.ui.Hellzyctivityhi");
                intent.setComponent(name);
                startActivity(intent);
                break;
        }
    }

    private void addShortcut(String name) {

        // 设置关联程序
        Intent intent = new Intent();
        intent.setClass(this, Main2Activity.class);
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        Intent shortcut = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        // 不允许重复创建
        shortcut.putExtra("duplicate", false);// 经测试不是根据快捷方式的名字判断重复的
        // 应该是根据快链的Intent来判断是否重复的,即Intent.EXTRA_SHORTCUT_INTENT字段的value
        // 但是名称不同时，虽然有的手机系统会显示Toast提示重复，仍然会建立快链
        // 屏幕上没有空间时会提示
        // 注意：重复创建的行为MIUI和三星手机上不太一样，小米上似乎不能重复创建快捷方式
        // 名字
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, name);
        // 图标
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,R.mipmap.ic_launcher);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent);

        // 发送广播
        sendBroadcast(shortcut);
    }


    public static final String ACTION_REMOVE_SHORTCUT = "com.android.launcher.action.UNINSTALL_SHORTCUT";

    private void removeShortcut(String name) {

        Intent intent = new Intent();
        intent.setClass(this, Main2Activity.class);
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        // remove shortcut的方法在小米系统上不管用，在三星上可以移除
        Intent shortcut = new Intent(ACTION_REMOVE_SHORTCUT);
        // 名字
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, name);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT,intent);
        // 发送广播
        sendBroadcast(shortcut);
    }
}
