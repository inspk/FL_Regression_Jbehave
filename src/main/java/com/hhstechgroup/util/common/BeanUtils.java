package com.hhstechgroup.util.common;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class BeanUtils extends FieldUtils {

    private static Logger logger = Logger.getLogger(BeanUtils.class);


    public static void copyProperties(Object destination, Object source) {
        try {
            BeanUtilsBean.getInstance().copyProperties(destination, source);
        } catch (IllegalAccessException e) {
            logger.error(e.getCause());
            throw new IllegalStateException(String.format("Wrong destination %s or source %s is defined", destination.getClass(), source.getClass()));
        } catch (InvocationTargetException e) {
            logger.error(e.getCause());
            throw new IllegalStateException("Unable to set field value");
        }
    }

    public static void copyPropertiesInOrder(Object destination, Object source) {
        List<Field> fields = asList(source.getClass().getDeclaredFields());
        List<String> fieldNames =  fields.stream().map(Field::getName).collect(Collectors.toList());
        fieldNames.forEach(field -> {
                Optional.ofNullable(readField(source, field)).ifPresent(value -> {
                    try {
                        BeanUtilsBean.getInstance().copyProperty(destination, field, value);
                    } catch (IllegalAccessException e) {
                        logger.error(e.getCause());
                        throw new IllegalStateException(String.format("Wrong destination %s or source %s is defined", destination.getClass(), source.getClass()));
                    } catch (InvocationTargetException e) {
                        logger.error(e.getCause());
                        throw new IllegalStateException("Unable to set field value");
                    }
                });
        });
    }
}
