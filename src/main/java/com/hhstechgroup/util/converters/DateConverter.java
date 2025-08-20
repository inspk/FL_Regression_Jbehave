package com.hhstechgroup.util.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateConverter {

    public static final String SUBMIT_TIME = "submitTime";
    public static final String FILE_GENERATION_DATE_TIME = "fileGenerationDateTime";
    public static final String DATE_TIME_FORMAT = "MM/dd/yyyy";
    private static final String H24_FORMAT = "HH:mm";
    private static final String H12_FORMAT = "h:mm a";
    private static final String DB_DATE_TIME = "E MMM dd HH:mm:ss z yyyy";
    public static final String MESSAGE_DATE_TIME_FORMAT = "M/d/yy, h:mm a";

    public static String convert(LocalDateTime dateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return dateTime.format(formatter);
    }
    //latest
    public static final String DATE_TIME_FORMAT1 = "MM/dd/yyyy h:mm" ;

    public static String convert1(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT1);
        return dateTime.format(formatter);
    }

    public static String convert(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
        return dateTime.format(formatter);
    }

    public static LocalDate toLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
        return LocalDate.parse(date, formatter);
    }

    public static LocalDate toLocalDate1(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT1);
        return LocalDate.parse(date, formatter);
    }


    public static String to24HFormat(String time) {
        return LocalTime.parse(time, DateTimeFormatter.ofPattern(H12_FORMAT)).format(DateTimeFormatter.ofPattern(H24_FORMAT));
    }

    public static String getSubmissionDate() {
        return convert(LocalDateTime.now(Clock.systemUTC()), "HH:mm");
    }

    public static String getFileGenerationDateTime() {
        return convert(LocalDateTime.now(Clock.systemUTC()), MESSAGE_DATE_TIME_FORMAT);
    }

    public static String convertDBDateTime(String dbTime) {
        ZonedDateTime ldt = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DB_DATE_TIME, Locale.US);
            Date in = sdf.parse(dbTime);
            ldt = ZonedDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault()).withZoneSameInstant(ZoneOffset.UTC);

        } catch (ParseException e) {

        }
        return convert(ldt.toLocalDateTime(), MESSAGE_DATE_TIME_FORMAT);
    }

    public static String formatMessageDateTime(Instant dateTime) {
        return convert(LocalDateTime.ofInstant(dateTime, ZoneOffset.UTC), MESSAGE_DATE_TIME_FORMAT);
    }
    //sp23

    public static final String DATE_TIME_FORMAT2 = "yyyy/MM/dd";
    public static String convert2(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT2);
        return dateTime.format(formatter);
    }

}
