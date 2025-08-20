package com.hhstechgroup.util.common;

public class FieldUtils {

    protected static void writeField(final Object target, final String fieldName, final Object value) {
        try {
            org.apache.commons.lang3.reflect.FieldUtils.writeField(target, fieldName, value, true);
        } catch (final IllegalAccessException e) {
            throw new IllegalStateException("Failed to write field.", e);
        }
    }

    public static Object readField(final Object bean, final String fieldName) {
        Object value = null;
        try {
            value = org.apache.commons.lang3.reflect.FieldUtils.readField(bean, fieldName, true);
        } catch (final IllegalAccessException e) {
            throw new IllegalStateException("Failed to read field.", e);
        }
        return value;
    }
}
