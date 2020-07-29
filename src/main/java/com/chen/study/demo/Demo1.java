package com.chen.study.demo;


import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class Demo1 {

    public Properties getProp() {
        InputStream inputStream = Demo1.class.getClassLoader()
                .getResourceAsStream("config.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }
}
