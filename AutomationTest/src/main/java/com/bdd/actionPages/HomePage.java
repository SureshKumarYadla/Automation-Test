package com.bdd.actionPages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class HomePage extends BaseClass {
    public static WebDriver driver;
    SeleniumHelpers helpers = new SeleniumHelpers(driver);
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public static String menuTab= "//ul[@class='nav nav-pills main-navigation-list']//li[@data-categoryparent='Departments']/child::a";
    public static String menTab="(//li[@data-categoryid='MenCategoryLink']/a)[1]";
    public  static  String clothingOption="(//li[@data-categorypath='root|MenTopMMNode']//button[text()='Clothing'])[1]";
    public  static  String viewAllLink="(//li[@data-categoryparentid='MenClothingMMNode']/a[@title='View All'])[1]";

    public List<String> validateMenuTabsInHomePage(){
        List<String> urls= new ArrayList<String>();
        List<WebElement> elements= driver.findElements(By.xpath(menuTab));
        for(WebElement element:elements){
            element.click();
            urls.add(driver.getCurrentUrl());
        }
        return  urls;
    }

    public void moveToMenTab(){
        helpers.mouseOverOnGivenElement(menTab);
    }

    public  void clickOnClothingOptionForMen(){
        moveToMenTab();
        helpers.clickOnElement(clothingOption);
    }
    public  void clickOnViewAllLink(){
        helpers.clickOnElement(viewAllLink);
    }



}


