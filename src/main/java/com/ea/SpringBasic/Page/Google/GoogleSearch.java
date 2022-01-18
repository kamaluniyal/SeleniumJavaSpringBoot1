package com.ea.SpringBasic.Page.Google;

import com.ea.SpringBasic.Page.Base;
import com.ea.SpringBasic.Kelvin.annotations.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Page
public class GoogleSearch extends Base {

    @Autowired
    SearchComponent searchComponent;

    @Autowired
    SearchResults searchResults;

    @Value("${application.url}")
    private String url;


    public  void goTo(){
        this.driver.get(url);
    }


    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public SearchResults getSearchResults() {
        return searchResults;
    }

    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }

    public void close(){
        this.driver.close();
    }

    public void quit(){
        this.driver.quit();
    }

}
