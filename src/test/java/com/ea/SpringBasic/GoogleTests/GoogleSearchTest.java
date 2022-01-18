package com.ea.SpringBasic.GoogleTests;

import com.ea.SpringBasic.Kelvin.annotations.LazyAutoWired;
import com.ea.SpringBasic.Page.Google.GoogleSearch;
import com.ea.SpringBasic.SpringBaseTestNGTest;
import com.ea.SpringBasic.Kelvin.Service.ScreenshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoogleSearchTest extends SpringBaseTestNGTest {

    @LazyAutoWired
    private GoogleSearch googleSearch;

    @LazyAutoWired
    private ScreenshotService screenshotService;

    @Test
    public void GoogleTest() throws IOException {
        this.googleSearch.goTo();
        Assert.assertTrue(this.googleSearch.isAt());
        googleSearch.getSearchComponent().search("Spring boot");
        Assert.assertTrue(this.googleSearch.getSearchResults().isAt());
        Assert.assertTrue(this.googleSearch.getSearchResults().getCount()>2);
        screenshotService.takescreenshot("googleSearch.png");
        this.googleSearch.quit();

    }


}
