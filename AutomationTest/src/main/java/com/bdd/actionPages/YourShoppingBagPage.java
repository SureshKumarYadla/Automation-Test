package com.bdd.actionPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class YourShoppingBagPage extends  BaseClass{
    public static WebDriver driver;
    SeleniumHelpers helpers = new SeleniumHelpers(driver);
    public YourShoppingBagPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public static String itemDetails= "(//div[@class='item-name'])[2]";
    public static String checkOutButton= "//a[contains(text(),'Checkout')]";
    public static String rrpTextValue= "//div[@class='item-savings']//child::span[contains(text(),'RRP')]";
    public static String saveTextValue= "//div[@class='item-savings']//child::span[contains(text(),'Save')]";

    public List<String> getItemDetails() {
        List<String> details = new ArrayList<String>();
       String item= helpers.getText(itemDetails);
        String[] itemValue= item.split("/n");
        for(String value:itemValue){
            details.add(value);
        }
        details.add(getRrpTextValue());
        details.add(getSaveTextValue());
        return details;
    }
    public String getRrpTextValue(){
        return helpers.getText(rrpTextValue);
    }
    public String getSaveTextValue(){
        return helpers.getText(saveTextValue);
    }
    public void clickCheckOutButton(){
        helpers.clickOnElement(checkOutButton);
    }
}
