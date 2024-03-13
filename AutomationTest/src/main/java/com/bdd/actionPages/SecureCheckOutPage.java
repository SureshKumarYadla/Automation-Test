package com.bdd.actionPages;

import org.openqa.selenium.WebDriver;

public class SecureCheckOutPage extends BaseClass {
    WebDriver driver;
    SeleniumHelpers helpers = new SeleniumHelpers(driver);
    public SecureCheckOutPage(WebDriver driver){
        this.driver= driver;
    }

    public static String checkOutAsGuestButton="//a//span[text()='Checkout as guest']";
    public static String emailTextBox="//input[@id='j_username']";
    public static String checkOutSubmitButton="//button[@id='checkoutLoginSubmit']";
    public static String emailErrorMessage="//span[@id='j_username.errors']";

    public SecureCheckOutPage clickCheckOutAsGuestButton(){
        helpers.clickOnElement(checkOutAsGuestButton);
        return this;
    }
    public SecureCheckOutPage clickCheckSubmitButton(){
        helpers.clickOnElement(checkOutAsGuestButton);
        return this;
    }

    public String getEmailErrorMessage(){
        return helpers.getText(emailErrorMessage);
    }

}
