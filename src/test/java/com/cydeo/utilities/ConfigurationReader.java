package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static final Properties properties;



    static {
        try {
            InputStream  inputStream = new FileInputStream("Configuration.properties");
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file!");
        }

    }
    public static String getProperty(String property){
        return properties.getProperty(property);
    }
}
