package com.en.xposedmodule.utils;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class MethodUtil {
    public static void printStaticMethod(Class<?> clazz){
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            //if (Modifier.isStatic(method.getModifiers())) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    LogUtils.d(method.getName()+":"+getMethodSignature(method));
                }
            //}
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getMethodSignature(Method method) {
        StringBuilder signature = new StringBuilder();
        signature.append(method.getReturnType().getName()).append(" ").append(method.getName()).append("(");

        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            signature.append(parameters[i].getType().getName());
            if (i < parameters.length - 1) {
                signature.append(", ");
            }
        }

        signature.append(")");
        return signature.toString();
    }
}
