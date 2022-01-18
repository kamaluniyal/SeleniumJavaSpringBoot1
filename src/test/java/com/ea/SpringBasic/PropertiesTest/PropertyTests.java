package com.ea.SpringBasic.PropertiesTest;

import com.ea.SpringBasic.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class PropertyTests extends SpringBaseTestNGTest {

    @Autowired
    private ResourceLoader loader ;

    @Test
    public void propertyTest() throws IOException {
        Properties properties = PropertiesLoaderUtils.loadProperties(loader.getResource("data/additional.properties"));
        System.out.println(properties);
    }



}
