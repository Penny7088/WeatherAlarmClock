/*
 * Copyright (c) 2016. Kaku咖枯 Inc. All rights reserved.
 */
package com.kaku.weac.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.kaku.weac.LeakCanaryApplication;
import com.kaku.weac.util.LogUtil;
import com.squareup.leakcanary.RefWatcher;

//TODO 未使用

/**
 * Activity管理类
 *
 * @author 咖枯
 * @version 1.0 2015
 */
public class BaseActivity extends Activity {

    /**
     * Log tag ：BaseActivity
     */
    private static final String LOG_TAG = "BaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        LogUtil.i(LOG_TAG, getClass().getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = LeakCanaryApplication.getRefWatcher(this);
        refWatcher.watch(this);
    }
}
