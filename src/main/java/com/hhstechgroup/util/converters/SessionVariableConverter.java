package com.hhstechgroup.util.converters;

import org.jbehave.core.steps.ParameterConverters.ParameterConverter;

import java.lang.reflect.Type;

public class SessionVariableConverter implements ParameterConverter {

    @Override
    public boolean accept(Type type) {
        if (type instanceof Class<?>) {
            return String.class.isAssignableFrom((Class<?>) type);
        }
        return false;
    }

    @Override
    public Object convertValue(String value, Type type) {
        return StringConverter.convertString(value);
    }
}
