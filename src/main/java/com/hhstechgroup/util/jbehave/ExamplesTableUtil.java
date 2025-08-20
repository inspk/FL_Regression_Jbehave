package com.hhstechgroup.util.jbehave;

import com.hhstechgroup.util.common.FieldUtils;
import junit.framework.AssertionFailedError;
import org.apache.commons.lang3.StringUtils;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.steps.Parameters;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.beanutils.BeanUtilsBean.getInstance;
import static org.apache.commons.lang3.StringUtils.substringAfter;
import static org.apache.commons.lang3.StringUtils.substringBefore;
import static org.apache.commons.lang3.reflect.FieldUtils.getField;
import static org.unitils.reflectionassert.ReflectionAssert.assertPropertyLenientEquals;


public class ExamplesTableUtil extends FieldUtils {

    private final static String DOT = ".";

    public static List<String> parseTableColumnAsList(final ExamplesTable table, int columnNumber) {
        return table.getRowsAsParameters(true).stream()
                .map(Parameters::values)
                .map(row -> row.get(table.getHeaders().get(columnNumber)))
                .collect(toList());
    }

    public static <T> List<T> parseTableToClass (final ExamplesTable table, final Class<T> type) {
        return table.getRowsAsParameters(true).stream()
                .map(row -> parseTableRowToClass(row, type))
                .collect(toList());
    }

    public static <T> List<T> replaceClassFieldsByHeaders(final List<String> headers, List<T> type) {
        return type.stream().map(el -> replaceByHeaders(headers, el))
                .collect(toList());
    }

    public static void checkResponseByGivenValues(final ExamplesTable table, Object expectedResult, Object actualResult) throws AssertionFailedError {
        table.getHeaders().forEach(header -> assertPropertyLenientEquals(extractHeader(header), readField(expectedResult, extractHeader(header)), actualResult));
    }

    private static String extractHeader(final String originHeader) {
        String header = originHeader;
        if (isNestedField(originHeader)) {
            header = substringBefore(originHeader, DOT);
        }
        return header;
    }

    public static <T> T replaceByHeaders(final List<String> headers, T type) {
        T newClass = (T) createNewInstance(type.getClass());

        headers.forEach(originHeader -> {
            String header = extractHeader(originHeader);
            Object value = readField(type, header);
            if (value == null) {
                value = "";
            }
            writeField(newClass, header, value);
        });

        return newClass;
    }

    public static <T> T parseTableRowToClass(final Parameters table, final Class<T> type) {
        T newClass = createNewInstance(type);
        Map<String, String> row = getParsedValues(newClass, table);
        try {
            getInstance().populate(newClass, row);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return newClass;
    }

    private static Map<String, String> getParsedValues(final Object newClass, final Parameters table) {
        table.values().keySet().stream()
                .filter(ExamplesTableUtil::isNestedField)
                .forEach(element -> initField(newClass, element));
        return table.values().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static void initField(final Object bean, final String fieldPath) {
        if (isNestedField(fieldPath)) {
            final String childFieldName = substringBefore(fieldPath, DOT);
            ofNullable(getField(bean.getClass(), childFieldName, true)).ifPresent(field -> {
                final Object fieldValue = readField(bean, childFieldName);
                if (isList(field.getType())) {
                    ArrayList<Object> list = new ArrayList<>();
                    writeField(bean, childFieldName, list);
                    initField(readField(bean, childFieldName), substringAfter(fieldPath, DOT));
                } else if(isSet(field.getType())) {
                    HashSet<Object> set = new HashSet<>();
                    writeField(bean, childFieldName, set);
                    initField(readField(bean, childFieldName), substringAfter(fieldPath, DOT));
                } else if (isMap(field.getType())) {
                    HashMap<Object, Object> map = new HashMap<>();
                    writeField(bean, childFieldName, map);
                    initField(readField(bean, childFieldName), substringAfter(fieldPath, DOT));
                } else if (field.getType().isEnum()) {
                    setEnumValue(bean, field, substringAfter(fieldPath, DOT));
                } else {
                    if (fieldValue == null) {
                        final Object newDefaultBean = createNewInstance(field.getType());
                        writeField(bean, childFieldName, newDefaultBean);
                    }
                    initField(readField(bean, childFieldName), substringAfter(fieldPath, DOT));
                }
            });
        }
    }

    private static void setEnumValue(final Object bean, final Field field, final String value) {
        try {
            Method m = field.getType().getDeclaredMethod("valueOf", String.class);
            field.set(bean, m.invoke(field.getType(), value));
        } catch ( NoSuchMethodException |IllegalAccessException |InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static boolean isNestedField(final String fieldPath) {
        return StringUtils.contains(fieldPath, DOT);
    }


    private static <T> T createNewInstance(final Class<T> type) {
        try {
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException(format("Failed to create instance of [%s]", type.getName()), e);
        }
    }

    private static <T> boolean isList(final Class<T> type) {
        return type.getName().equals(List.class.getName());
    }

    private static <T> boolean isSet(final Class<T> type) {
        return type.getName().equals(Set.class.getName());
    }

    private static <T> boolean isMap(final Class<T> type) {
        return type.getName().equals(Map.class.getName());
    }
}
