package fr.redxil.api.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavaUtils {

    public static Object getDeclaredField(Object object, String fieldString) {

        try {
            Field field = object.getClass().getDeclaredField(fieldString);
            field.setAccessible(true);
            return field.get(object);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
        }

        return null;

    }

    public static boolean setDeclaredField(Object object, String fieldString, Object value) {

        try {
            Field field = object.getClass().getDeclaredField(fieldString);
            field.setAccessible(true);
            field.set(object, value);
            return true;
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
        }

        return false;

    }

    public static Object getField(Object object, String fieldString) {

        try {
            Field field = object.getClass().getField(fieldString);
            field.setAccessible(true);
            return field.get(object);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
        }

        return null;

    }

    public static boolean setField(Object object, String fieldString, Object value) {

        try {
            Field field = object.getClass().getField(fieldString);
            field.setAccessible(true);
            field.set(object, value);
            return true;
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
        }

        return false;

    }

    public static Object getDeclaredMethod(Object object, String fieldString) {

        try {
            Method field = object.getClass().getDeclaredMethod(fieldString, (Class<?>[]) null);
            field.setAccessible(true);
            return field.invoke(object);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ignored) {
        }

        return null;

    }

    public static Object getMethod(Object object, String fieldString) {

        try {
            Method field = object.getClass().getMethod(fieldString, (Class<?>[]) null);
            field.setAccessible(true);
            return field.invoke(object);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ignored) {
        }

        return null;

    }

}
