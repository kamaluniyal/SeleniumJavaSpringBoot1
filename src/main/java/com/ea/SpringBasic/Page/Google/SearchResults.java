package com.ea.SpringBasic.Page.Google;

import com.ea.SpringBasic.Page.Base;
import com.ea.SpringBasic.Kelvin.annotations.PageFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchResults extends Base {

    @FindBy(css="div")
    private List<WebElement> results;

    public int getCount(){
        return results.size();
    }



    @Override
    public boolean isAt() {
        return this.wait.until((d)-> !this.results.isEmpty());
    }
}
