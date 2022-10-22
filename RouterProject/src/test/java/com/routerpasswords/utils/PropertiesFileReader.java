package com.routerpasswords.utils;

import java.io.*;
import java.util.Properties;

public class PropertiesFileReader {

    private static PropertiesFileReader propertiesFileReader = null;
    private static final String propertiesFilePath = "./src/test/resources/testdata.properties";
    private Properties properties;
    public static PropertiesFileReader getInstance() throws Exception {
        if(propertiesFileReader == null){
            propertiesFileReader = new PropertiesFileReader();
        }
        return propertiesFileReader;
    }

    private PropertiesFileReader() throws Exception {
        try{
            this.properties = new Properties();
            File propertiesFile = new File(propertiesFilePath);
            if(propertiesFile.exists()){
                FileInputStream propertiesFileInputStream = new FileInputStream(propertiesFile);
                InputStreamReader reader = new InputStreamReader(propertiesFileInputStream);
                this.properties.load(reader);
            } else {
                throw new Exception("Support data file is not available");
            }
        }catch(IOException ioe){
            throw new Exception(ioe.getMessage());
        }
    }

    public String getProperty(String key){
        return this.properties.getProperty(key);
    }
}
