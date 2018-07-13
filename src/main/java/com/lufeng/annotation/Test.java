package com.lufeng.annotation;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Lufo on 2018/7/13.
 */
public class Test {

    @org.junit.Test
    public void test() throws InvocationTargetException, IllegalAccessException {


        User user = new User();
        AnnotationUtil.fillData(user);
        System.out.println(user);

    }
}
