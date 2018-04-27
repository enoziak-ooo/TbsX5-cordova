package com.xiangk.xyz;

import android.os.Bundle;

import org.apache.cordova.CordovaActivity;

public class TBSX5CordovaActivity extends CordovaActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        launchUrl = "http://x5.tencent.com/";
        loadUrl(launchUrl);
    }
}
