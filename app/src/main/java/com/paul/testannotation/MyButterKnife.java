package com.paul.testannotation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;

public class MyButterKnife {
    public static void bind(Activity activity) {
        Bundle bundle =  activity.getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        Field[] fields = activity.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(AutoWire.class)) {
                AutoWire autoWire = field.getAnnotation(AutoWire.class);
                String key = TextUtils.isEmpty(autoWire.value()) ? field.getName() : autoWire.value();
                if(bundle.containsKey(key)){
                    Object object=  bundle.get(key);
                    //  如果没有以下几句在调field.set的时候会报：field com.paul.testannotation.MainActivity.personsPer has type com.paul.testannotation.PersonPer[], got android.os.Parcelable[]
                    //  因为这时候的object是Parcelable[],不能强制转换成子类PersonPer[]，所以这里把Parcelable[]的field抽出来，通过Arrays.copyOf转换成指定的PersonPer[]，就可以set了
                    Class<?> classes = field.getType().getComponentType();
                    if(field.getType().isArray()&& Parcelable.class.isAssignableFrom(classes)){
                        Object[] objects = (Object[]) object;
                        Log.e("===","===========field.getType()==="+field.getType());
                        object = Arrays.copyOf(objects,objects.length, (Class<? extends Object[]>) field.getType());
                    }


                    field.setAccessible(true);
                    try {
                        field.set(activity,object);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
