package com.hhstechgroup.util.converters;

import net.serenitybdd.core.Serenity;
import org.apache.commons.lang3.text.StrSubstitutor;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.substringsBetween;

public class StringConverter {

    private static final String PATTERN_SUFFIX = "${";
    private static final String PATTERN_PREFIX = "}";
    private final static String CONVERTIBLE_PATTERN = "[$][{].*}";

    public static String convertString(String templateString) {
        if (isStringConvertible(templateString)) {
            return convertBySessionVariables(templateString);
        }
        return templateString;
    }

    private static String convertBySessionVariables(String templateString) {
        Map<String, String> vars = extractSessionVariables(templateString);
        StrSubstitutor sub = new StrSubstitutor(vars);
        return sub.replace(templateString);
    }

    private static Map<String, String> extractSessionVariables(String variable) {
        Map<String, String> values = new HashMap<>();
        String[] keys = substringsBetween(variable, PATTERN_SUFFIX, PATTERN_PREFIX);
        for (String key : keys) {
            Object value = Serenity.sessionVariableCalled(key);
            if (ofNullable(value).isPresent()) {
                values.put(key, value.toString());
            }
        }

        return values;
    }

    private static boolean isStringConvertible(String value) {
        return Pattern.compile(CONVERTIBLE_PATTERN).matcher(value).find();
    }
}
