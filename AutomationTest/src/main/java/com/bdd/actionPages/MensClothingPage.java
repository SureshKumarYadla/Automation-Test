package com.bdd.actionPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MensClothingPage extends BaseClass {
    public static WebDriver driver;
    SeleniumHelpers helpers = new SeleniumHelpers(driver);
    public MensClothingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public static String brandDropdown="//button[@title='Brand']";
    public static String closeButton="//strong[contains(text(),'Brand')]//following-sibling::button";

    public MensClothingPage clickBrandDropdown(){
        helpers.clickOnElement(brandDropdown);
        return this;
    }
    public  MensClothingPage selectMultipleBrands(String brandNames){
        String[] brands = brandNames.split(",");
        for(String brand :brands){
            driver.findElement(By.xpath("//span[text()='"+brand+"']//preceding::span[1]")).click();
        }
        return this;
    }
    public MensClothingPage clickCloseButton(){
        helpers.clickOnElement(closeButton);
        return this;
    }

    public void selectProduct(String product){
        driver.findElement(By.xpath("//span[contains(text(),'"+product+"')]")).click();
    }
}
