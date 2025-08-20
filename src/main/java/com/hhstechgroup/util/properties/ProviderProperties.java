package com.hhstechgroup.util.properties;

import com.github.rjeschke.txtmark.Run;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ProviderProperties {

    public static void save(String key, String value) {
        try {
            String filename = "ProviderData.properties";
            if (!Files.exists(Paths.get(filename))) {

                Files.createFile(Paths.get(filename));
            }
            Properties properties = new Properties();
            properties.load(new FileInputStream(filename));
            properties.put(key, value);
            properties.store(new FileOutputStream(filename), null);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static String getData(String key) {
        try {
            String filename = "ProviderData.properties";
            if (!Files.exists(Paths.get(filename))) {
                throw new RuntimeException("Data properties file is not found");
            }
            Properties properties = new Properties();
            properties.load(new FileInputStream(filename));
            return properties.get(key).toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void save1(String key, String value, String index, String status) {
        try {
            String filename = "ProviderData.properties";
            if (!Files.exists(Paths.get(filename))) {

                Files.createFile(Paths.get(filename));
            }
            Properties properties = new Properties();
            properties.load(new FileInputStream(filename));
            key = String.format("%s.%s.%s", status, key, index);
            properties.put(key, value);
            properties.store(new FileOutputStream(filename), null);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static String getData1(String key, String index, String status) {
        try {
            String filename = "ProviderData.properties";
            if (!Files.exists(Paths.get(filename))) {
                throw new RuntimeException("Data properties file is not found");
            }
            Properties properties = new Properties();
            properties.load(new FileInputStream(filename));
            key = String.format("%s.%s.%s", status, key, index);
            String value = properties.get(key).toString();
            if(value == null){
                new RuntimeException("Cannot find " + key);
            }
            return value;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void save(String key, String value, String index, String status) {
        try {
            String filename = "ProviderData.properties";
            if (!Files.exists(Paths.get(filename))) {

                Files.createFile(Paths.get(filename));
            }
            Properties properties = new Properties();
            properties.load(new FileInputStream(filename));
            key = String.format("%s.%s.%s", status, key, index);
            properties.put(key, value);
            properties.store(new FileOutputStream(filename), null);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static String getData(String key, String index, String status) {
        try {
            String filename = "ProviderData.properties";
            if (!Files.exists(Paths.get(filename))) {
                throw new RuntimeException("Data properties file is not found");
            }
            Properties properties = new Properties();
            properties.load(new FileInputStream(filename));
            key = String.format("%s.%s.%s", status, key, index);
            String value = properties.get(key).toString();
            if(value == null){
                new RuntimeException("Cannot find " + key);
            }
            return value;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
