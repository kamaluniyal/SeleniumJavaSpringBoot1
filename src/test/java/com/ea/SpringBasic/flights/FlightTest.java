package com.ea.SpringBasic.flights;

import com.ea.SpringBasic.Page.flights.FlightPage;
import com.ea.SpringBasic.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightTest extends SpringBaseTestNGTest {

    @Autowired
    private FlightPage flightPage;

    @Autowired
    private FlightAppDetails appDetails;

    @Test
    public void flightTest() throws InterruptedException {
        this.flightPage.goTo(this.appDetails.getUrl());
        //Assert.assertTrue(this.flightPage.isAt());
        Thread.sleep(60000);

        Assert.assertEquals(this.flightPage.getLabels(), this.appDetails.getLabels());
    }


}
