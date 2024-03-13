package com.bdd.actionPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends  BaseClass{
    public static WebDriver driver;
    SeleniumHelpers helpers = new SeleniumHelpers(driver);
    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public static String productDetails ="//div[@class='product-details'])";
    public static String rrpText ="//div[@class='product-rrp']";
    public static String saveProceText ="//div[contains(@class,'product-save-price')]";
    public static String sizeGuideButton ="//button[text()='Size guide']";
    public static String sizeLabel ="//label[text()='M']";
    public static String quantityDropdown ="//div[@id='pdp-quantity_button']/child::b";
    public static String dropdownValues ="//ul[@aria-label='Quantity']/child::li[1]";
    public static String addToBagButton ="//a[contains(text(),'View bag')]";
    public static String viewBagButton ="//a[contains(text(),'View bag')]";
    public static String sizeGuideTitle ="//h1[text()=\"Size Guide\"]";


    public List<String> getProductDetails() {
        List<String> details = new ArrayList<String>();
        List<WebElement> webeElementList = driver.findElements(By.xpath(productDetails));
        for (WebElement element : webeElementList) {
            details.add(element.getText());
        }
        details.add(getRrpText());
        details.add(getSaveProceTextText());
        return details;
    }
    public String getRrpText(){
        return helpers.getText(rrpText);
    }
    public String getSaveProceTextText(){
        return helpers.getText(saveProceText);
    }
    public ProductPage clickSizeLabelOption(){
        helpers.clickOnElement(sizeLabel);
        return this;
    }
    public ProductPage selectQuantity(){
        helpers.clickOnElement(quantityDropdown);
        helpers.clickOnElement(dropdownValues);
        return this;
    }
    public void clickAddToBagButton(){
        helpers.clickOnElement(addToBagButton);
    }
    public void  clickViewBagButton(){
        helpers.clickOnElement(viewBagButton);
    }
    public ProductPage clickSizeGuideButton(){
        helpers.clickOnElement(sizeGuideButton);
        return this;
    }

    public boolean isSizeGuideTitleDisplayed(){
        return helpers.isElementDisplayed(sizeGuideTitle);
    }
    public void switchToParentWindow(){
        List<String> windows = (List<String>) driver.getWindowHandles();
        driver.switchTo().window(windows.get(0));
    }

}
