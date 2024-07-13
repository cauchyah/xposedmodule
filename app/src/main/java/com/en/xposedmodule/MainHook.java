package com.en.xposedmodule;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class MainHook implements IXposedHookLoadPackage {
    public static final String TAG = "Xposed";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        List<String> packageList = new ArrayList<>();
        packageList.add("com.ffbilly.xxwaterm");
        if (packageList.contains(lpparam.packageName)) {
            Log.d(TAG, "package match! start work!");
            // getClassLoaderClassList(lpparam.classLoader);
            //vipFree(lpparam);
            hookJiagu();
//            //while (true){
//                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        vipFree(lpparam);
//
//                    }
//                },15000);
//
//           // }
        }
    }

    private void vipFree(ClassLoader classLoader) {
        XposedHelpers.findAndHookMethod("com.ffbilly.xxwaterm.AppContext.Companion", classLoader,
                "getSAbTestVipAd",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(2);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });
        XposedHelpers.findAndHookMethod("com.ffbilly.xxwaterm.AppContext.Companion", classLoader,
                "getSAbTestWelComePage",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(4);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });
        XposedHelpers.findAndHookMethod("com.gatherad.sdk.GatherAdSDK", classLoader,
                "initKs",
                Context.class,String.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        Log.d(TAG,"initKs:"+param.args[1]+",");
                        param.args[1]="2193023902";
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        //Context context, String str, boolean z, CsjInitCallback csjInitCallback
        XposedHelpers.findAndHookMethod("com.qq.e.comm.managers.GDTAdSdk", classLoader,
                "initWithoutStart",
                Context.class,String.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        Log.d(TAG,"GDTAdSdk#initWithoutStart:"+param.args[1]+",");
                        param.args[1]="232132332";
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });
        XposedHelpers.findAndHookMethod("com.qq.e.comm.managers.GDTAdSdk", classLoader,
                "init",
                Context.class,String.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        Log.d(TAG,"GDTAdSdk#init:"+param.args[1]+",");
                        param.args[1]="232132332";
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });
        /*//Context context, String str, boolean z, CsjInitCallback csjInitCallback
        XposedHelpers.findAndHookMethod("com.gatherad.sdk.GatherAdSDK", classLoader,
                "initCsj",
                Context.class,String.class,boolean.class,"Lcom/gatherad/sdk/source/csj/CsjInitCallback;",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        Log.d(TAG,"initCsj:"+param.args[1]+",");
                        param.args[1]="2193023902";
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });*/
    //free_take_count
        //AdConfigsExtKt.isAdConfigsDisplay$default(str, false, 1, null)  false

        XposedHelpers.findAndHookMethod("com.ffbilly.xxwaterm.ext.AdConfigsExtKt", classLoader,
                "isAdConfigsDisplay$default",
                String.class,boolean.class,int.class,Object.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        if ("free_take_count".equals(param.args[0])){
                            param.setResult(false);
                        }
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });






        XposedHelpers.findAndHookMethod("com.ffbilly.xxwaterm.constants.UserKeyKt", classLoader,
                "isLogin",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(true);
                    }

                    @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
            }
        });
        XposedHelpers.findAndHookMethod("com.ffbilly.xxwaterm.constants.UserKeyKt", classLoader,
                "isVip",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(true);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });
        XposedHelpers.findAndHookMethod("com.ffbilly.xxwaterm.constants.UserKeyKt", classLoader,
                "isForeverVip",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(true);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        // 第一种 填ClassName
        XC_MethodHook.Unhook unhook = XposedHelpers.findAndHookMethod("com.ffbilly.ddmh.ui.CameraGl2Activity",    // className
                classLoader,    // classLoader 使用lpparam.classLoader
                "onResume",             // 要hook的方法
                //Bundle.class,           // 要hook的方法的参数表，如果有多个就用逗号隔开
                new XC_MethodHook() {   // 最后一个填hook的回调
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) {
                        Log.d(TAG, "beforeHookedMethod:" + param.method.getName());
                    } // Hook方法执行前

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) {

                        Log.d(TAG, "afterHookedMethod:" + param.method.getName());
                    } // Hook方法执行后
                });
        // 它返回一个unhook 在你不需要继续hook的时候可以调用它来取消Hook
        //unhook.unhook();    // 取消空的Hook
    }

    boolean isFirst = true;

    private void hookJiagu() {


        XposedHelpers.findAndHookMethod(Application.class, "onCreate", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                if (!isFirst) return;
                isFirst = false;

                Log.i(TAG, "拿到 classLoader");
                ClassLoader real = getLoadedApkClassloader(param);
                Log.i(TAG, "拿到真实classLoader");
                //打印当前class loader的
                //getClassLoaderClassList(real);
                vipFree(real);

            }
        });

    }

    public static ClassLoader getLoadedApkClassloader(XC_MethodHook.MethodHookParam param) {
        ClassLoader currentClassLoader = param.thisObject.getClass().getClassLoader();

        Object currentActivityThread = XposedHelpers.callStaticMethod(
                XposedHelpers.findClass("android.app.ActivityThread", currentClassLoader),
                "currentActivityThread",
                new Class[]{},
                new Object[]{});

        Object mBoundApplication = XposedHelpers.getObjectField(
                currentActivityThread,
                "mBoundApplication");

        Application mInitialApplication = (Application) XposedHelpers.getObjectField(
                currentActivityThread,
                "mInitialApplication");

        Object loadedApkInfo = XposedHelpers.getObjectField(
                mBoundApplication, "info");

        Application mApplication = (Application) XposedHelpers.getObjectField(loadedApkInfo, "mApplication");

        return mApplication.getClassLoader();
    }


    /**
     * 打印当前classload 的 dex
     *
     * @param classLoader
     */
    public static void getClassLoaderClassList(ClassLoader classLoader) {
        //private final DexPathList pathList;
        Log.i(TAG, "start deal with classloader:" + classLoader);
        Object pathListObj = XposedHelpers.getObjectField(classLoader, "pathList");
        //private final Element[] dexElements;
        Object[] dexElementsObj = (Object[]) XposedHelpers.getObjectField(pathListObj, "dexElements");
        for (Object i : dexElementsObj) {
            //private final DexFile dexFile;
            Object dexFileObj = XposedHelpers.getObjectField(i, "dexFile");
            //private Object mCookie;
            Object mCookieObj = XposedHelpers.getObjectField(dexFileObj, "mCookie");
            //private static native String[] getClassNameList(Object cookie);
            Class DexFileClass = XposedHelpers.findClass("dalvik.system.DexFile", classLoader);

            String[] classList = (String[]) XposedHelpers.callStaticMethod(DexFileClass, "getClassNameList", mCookieObj);
            for (String classname : classList) {
                Log.i(TAG, dexFileObj + "---" + classname);
            }
        }
        Log.i(TAG, "end deal with classloader:" + classLoader);

    }
}
