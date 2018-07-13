package com.lufeng.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Lufo on 2018/7/13.
 */
public class AnnotationUtil {

    public static void fillData(Object o) throws IllegalAccessException, InvocationTargetException {
        Class<?> aClass = o.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Value annotation = declaredField.getAnnotation(Value.class);
            if (annotation!=null){
                String value = annotation.value();
                declaredField.setAccessible(true);
                declaredField.set(o,value);
            }
        }

        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            Value annotation = declaredMethod.getAnnotation(Value.class);
            if (annotation!=null){
                String value = annotation.value();
                declaredMethod.invoke(o,value);
            }
        }
    }
}
