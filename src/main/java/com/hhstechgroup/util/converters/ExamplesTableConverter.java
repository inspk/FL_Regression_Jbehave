package com.hhstechgroup.util.converters;

import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.steps.ParameterConverters;

import java.lang.reflect.Type;

public class ExamplesTableConverter extends ParameterConverters.ExamplesTableConverter {

    public ExamplesTableConverter(ExamplesTableFactory factory) {
        super(factory);
    }

    @Override
    public boolean accept(Type type) {
        if (type instanceof Class<?>) {
            return ExamplesTable.class.isAssignableFrom((Class<?>) type);
        }
        return false;
    }

    @Override
    public ExamplesTable convertValue(String value, Type type) {
        return super.convertValue(StringConverter.convertString(value), type);
    }
}
