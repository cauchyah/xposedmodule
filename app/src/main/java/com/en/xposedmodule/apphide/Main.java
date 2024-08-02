package com.en.xposedmodule.apphide;

import static com.en.xposedmodule.utils.LogUtils.TAG;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.util.Log;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

public class Main {
    public static void start(ClassLoader classLoader, Application application) {

        XposedHelpers.findAndHookMethod("com.heytap.cdo.client.detail.developercomment.DeveloperCommentActivity", classLoader, "onCreate", android.os.Bundle.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                Log.i(TAG, "DeveloperCommentActivity onCreate");
                Activity activity = (Activity) param.thisObject;
                Intent intent = activity.getIntent();
                Log.i(TAG, "intent:" + intent.getSerializableExtra("extra.key.jump.params").toString());
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
            }
        });


        Class<?> clazz=XposedHelpers.findClass("a.a.a.bj6",classLoader);

        XposedHelpers.findAndHookMethod("com.heytap.cdo.client.detail.router.a", classLoader, "Ԯ", clazz, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                Log.i(TAG, "DeveloperCommentActivity UriRequest");
                Log.i(TAG, param.args.toString());
                super.beforeHookedMethod(param);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
            }
        });







      /*  XposedHelpers.findAndHookMethod("t0.m$a", classLoader, "e", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult(true);
                //super.beforeHookedMethod(param);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
            }
        });*/
        /*XposedHelpers.findAndHookMethod("app.icon.gone.payment.LoginManage", classLoader, "isVip", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
               param.setResult(true);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
            }
        });
        XposedHelpers.findAndHookMethod("app.icon.gone.payment.LoginManage", classLoader, "isNeedVipHideFile", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
               param.setResult(false);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
            }
        });

        XposedHelpers.findAndHookMethod("app.icon.gone.payment.LoginManage", classLoader, "isOnline", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult(true);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
            }
        });
        XposedHelpers.findAndHookMethod("com.common.theone.interfaces.common.admodel.AdConfigs", classLoader, "isAdConfigsDisplay",
                java.lang.String.class,
                boolean.class,
                new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                String key= (String) param.args[0];
                if (key.equals("vip")){
                    param.setResult(true);
                }else if(key.equals("hide_file_unlock")){
                    param.setResult(false);
                }else if(key.equals("isShowUnlockDialogAd")){
                    param.setResult(false);
                }else if (key.endsWith("Ad")||key.endsWith("AD")){
                    param.setResult(false);
                }else {
                    super.beforeHookedMethod(param);
                }
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
            }
        });*/
    }
}
