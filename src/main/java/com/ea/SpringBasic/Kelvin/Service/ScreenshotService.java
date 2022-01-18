package com.ea.SpringBasic.Kelvin.Service;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;


@Service
@Lazy
public class ScreenshotService {

    // shows error but works fine 
    //@Autowired
    //protected TakesScreenshot driver ;

    @Autowired
    private ApplicationContext ctx;

    //@Autowired
    //protected WebDriver driver ;

    //@Autowired
    //private JavascriptExecutor js ;

   // @Value("${screenshot.path}/img.png")
    //private Path path ;

    @Value("${screenshot.path}")
    private Path path ;

    public void takescreenshot(String imgName) throws IOException {
        File sourceFile = this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(sourceFile,this.path.resolve(imgName).toFile());

    }
    public void takeScreenShot() throws IOException {
        File sourceFile = this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(sourceFile, this.path.resolve("screenshot.png").toFile());
    }


}
