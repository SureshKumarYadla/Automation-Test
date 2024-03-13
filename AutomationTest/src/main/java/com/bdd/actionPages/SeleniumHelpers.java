package com.bdd.actionPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class SeleniumHelpers extends  BaseClass{
    public SeleniumHelpers(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    // This common method helps to move over on the provided element
    public void mouseOverOnGivenElement(String element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(element))).perform();
    }
    // This common method helps to click the element
    public void clickOnElement(String element){
        driver.findElement(By.xpath(element)).click();
    }
    // This common method helps to get Text from the given element
    public String getText(String element){
        return driver.findElement(By.xpath(element)).getText();
    }
    // This common method returns true if the element is displayed
    public boolean isElementDisplayed(String element){
        return driver.findElement(By.xpath(element)).isDisplayed();
    }
    // This common method is used to enter text in the element
    public void enterText(String element, String textTobeEntered){
        driver.findElement(By.xpath(element)).sendKeys(textTobeEntered);
    }

}
