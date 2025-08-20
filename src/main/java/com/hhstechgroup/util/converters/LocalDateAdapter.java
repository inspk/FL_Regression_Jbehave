package com.hhstechgroup.util.converters;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter implements JsonDeserializer<LocalDate> {
    @Override
    public LocalDate deserialize(JsonElement date, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String dateString = date.getAsString();
        return LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
    }
}