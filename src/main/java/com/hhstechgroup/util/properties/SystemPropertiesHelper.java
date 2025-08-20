package com.hhstechgroup.util.properties;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemPropertiesHelper {

    private static final Properties properties = new Properties();
    private static final String ENV_PROPERTY_FILE = "env.property.file";
    private static final String COMMON_PROPERTIES = "common.properties";
    private static final String PROPERTY_FILE_LOCATION = "properties/";

    private static Logger logger = Logger.getLogger(SystemPropertiesHelper.class);

    private SystemPropertiesHelper() {
    }

    private static String getEnvFileName() {
        return System.getProperty(ENV_PROPERTY_FILE);
    }

    public static String getProperty(String propertyName) {
        loadProperties();
        return properties.getProperty(propertyName);
    }

    private static void loadProperties() {
        InputStream propertyFile = SystemPropertiesHelper.class.getClassLoader().getResourceAsStream(PROPERTY_FILE_LOCATION.concat(getEnvFileName()));
        InputStream commonPropertyFile = SystemPropertiesHelper.class.getClassLoader().getResourceAsStream(PROPERTY_FILE_LOCATION.concat(COMMON_PROPERTIES));
        try {
            if (properties.size() == 0) {
                properties.load(propertyFile);
                properties.load(commonPropertyFile);

                //Add all system properties e.g. with Maven -D or with argument in test
                System.getProperties().forEach(properties::put);
            }
        } catch (IOException e) {
            logger.error("Unable to load properties:" + e.getMessage());
            e.printStackTrace();
        }
    }

}
