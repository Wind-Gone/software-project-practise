package com.example.g5project.tools;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName EntityUtils.java
 * @Description TODO
 * @createTime 2022年03月26日 22:56:00
 */
public class EntityUtils {
    private static String[] getNullPropertyNames(Object source) {
        Class<?> clz = source.getClass();
        Field[] fields = clz.getDeclaredFields();
        List<String> propertyNames = new ArrayList<>();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (null == field.get(source))
                    propertyNames.add(field.getName());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return propertyNames.toArray(new String[]{});
    }

    public static <T> T copyProperties(T src, T target, boolean ignoreNull) {
        if (ignoreNull) {
            BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
        } else {
            BeanUtils.copyProperties(src, target);
        }
        return target;
    }
}
