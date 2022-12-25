package com.lao.utilities;
import com.lao.constants.Constants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class CommonUtils {
    public void loadProperties() {

        Properties properties= new Properties();
       try {
           properties.load(getClass().getResourceAsStream("/config.properties"));
       }catch(Exception e){
           e.printStackTrace();
       }

       Constants.APP_URL=properties.getProperty("APP_URL");
       Constants.BROWSER=properties.getProperty("Browser");
       Constants.Username=properties.getProperty("Username");
       Constants.Password=properties.getProperty("Password");

    }
}
