package com.ea.SpringBasic.GoogleTests;

import com.ea.SpringBasic.SpringBaseTestNGTest;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.Test;

public class MultiBrowserTest extends SpringBaseTestNGTest {


    @Autowired
    private ApplicationContext ctx;


    @Test
    public void multiBrowserTest(){
        this.ctx.getBean("chromeDriver", WebDriver.class).get("https://google.com");
        this.ctx.getBean("IEDriver", WebDriver.class).get("https://google.com");
    }



}
