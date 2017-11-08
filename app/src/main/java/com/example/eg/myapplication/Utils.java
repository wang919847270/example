package com.example.eg.myapplication;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by EG on 2017/10/30.
 */

public class Utils {

    public static final String TAG = "WHEG";

    public static String getSystemConfig() {
        String result = "";
        Properties properties = new Properties();
        try {
            FileInputStream is = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            properties.load(is);
            result = (String) properties.getProperty("ro.build.tpw.ver","xx");
            Log.d(TAG,"根目录"+Environment.getRootDirectory());
            is.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;

    }
}
