package com.qapitolHMH.Utility;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyfile {
    private static Properties prop;
    private final static String propertyFilePath="src/test/resources/data.properties";
    private static void loadData() throws IOException {
        try {
            prop = new Properties();
            FileInputStream fileInputStream=new FileInputStream(propertyFilePath);
            prop.load(fileInputStream);
        }catch (IOException e){
            throw new RuntimeException("Failed to load property file: " + e.getMessage());
        }
    }

    public static String getObject(String data) throws IOException {
        loadData();
        return prop.getProperty(data);
    }
}
