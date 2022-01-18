package com.ea.SpringBasic.Kelvin.Config;

import com.ea.SpringBasic.Kelvin.annotations.LazyConfiguration;
import com.ea.SpringBasic.Kelvin.annotations.ThreadScopeBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.*;

@LazyConfiguration
@Profile("!remote")
public class WebDriverConfig {

    //@Bean
    //@Primary
    //@Scope("prototype")
    //@Scope("browserScope")
    @ThreadScopeBean
    public WebDriver chromeDriver(){
        //WebDriverManager.chromedriver().version("").setup();
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();

    }

    //@Bean
    //@ConditionalOnProperty(name="Browser",havingValue="ie")
    //When running from commandline or jenkins/teamcity use command like -
    // mvn clean test -Dbrowser=ie
    // this has higher prefence than property file
    // similarly for profiles use command -
    // mvn clean test -Dspring.profiles.active=qa -Dbrowser=chrome
//    public WebDriver IEDriver(){
//        //WebDriverManager.chromedriver().version("").setup();
//        WebDriverManager.iedriver().setup();
//        return new InternetExplorerDriver();
//    }


    //@Bean
    //@ConditionalOnExpression("${car.speed}<70")
    //public WebDriver testonly(){
        // another way of getting unique bean
        //WebDriverManager.iedriver().setup();
        //return new InternetExplorerDriver();
    //}



}
