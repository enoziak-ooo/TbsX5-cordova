package com.xiangk.xyz;

import android.app.Application;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener;

public class MyApplication extends Application{

    private static final String TAG = "MyApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。

        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.e(TAG, " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }
        };

        QbSdk.setTbsListener(new TbsListener() {
            @Override
            public void onDownloadFinish(int i) {
                Log.e(TAG, "onDownloadFinish: 腾讯X5内核 下载结束" + i);
            }

            @Override
            public void onInstallFinish(int i) {
                Log.e(TAG, "onInstallFinish: 腾讯X5内核 安装完成" + i);
            }

            @Override
            public void onDownloadProgress(int i) {
                Log.e(TAG, "onDownloadProgress: 腾讯X5内核 下载进度:%" + i);
            }
        });
    }
}
