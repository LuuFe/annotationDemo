package com.lufeng.annotation;


import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Lufo on 2018/7/13.
 */
public class User {

    @Value("xiaoerke")
    private String name;

    @Value("123")
    private String password;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    private String username;

    public String getUsername() {
        return username;
    }

    @Value("dxyyyyy")
    public void setUsername(String username) {
        this.username = username;
    }

    public String toString(){
        Class<? extends User> aClass = this.getClass();
        Field[] fields = aClass.getDeclaredFields();
        StringBuffer stringBuffer = new StringBuffer();
        for (Field field : fields) {

            String name = field.getName();
            stringBuffer.append(name);
            stringBuffer.append(":=");

            try {
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(name, aClass);
                Method readMethod = propertyDescriptor.getReadMethod();
                if (readMethod!=null){
                    try {
                        Object invoke = readMethod.invoke(this);
                        stringBuffer.append(invoke==null?null:invoke.toString());
                        stringBuffer.append(" ");

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }


            } catch (IntrospectionException e) {
                e.printStackTrace();
            }


        }
    return stringBuffer.toString();
    }
}
