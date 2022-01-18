package com.ea.SpringBasic.Page.Google;

import com.ea.SpringBasic.Page.Base;
import com.ea.SpringBasic.Kelvin.annotations.PageFragment;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchComponent extends Base {

    @FindBy(name="q")
    private WebElement searchBox;

    @FindBy(name="btnK")
    private List<WebElement> searchBtns;

    public void search(String keyword){
        this.searchBox.sendKeys(keyword);
        //this.searchBox.click();
        this.searchBox.sendKeys(Keys.TAB);
        this.searchBtns.stream()
            .filter(e->e.isDisplayed()&&e.isEnabled())
            .findFirst()
            .ifPresent(WebElement::click);
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d)->this.searchBox.isDisplayed());
    }
}
