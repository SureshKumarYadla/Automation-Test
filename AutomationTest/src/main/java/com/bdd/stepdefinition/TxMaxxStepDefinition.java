package com.bdd.stepdefinition;

import com.bdd.actionPages.*;

import com.bdd.browser.SeleniumFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.testng.asserts.SoftAssert;
import org.testng.asserts.Assertion;

import java.util.List;

public class TxMaxxStepDefinition extends BaseClass {
    HomePage homePage = new HomePage(driver);
    APITest apiTest = new APITest();
    SoftAssert softAssert = new SoftAssert();

    public TxMaxxStepDefinition(){
        super();
    }

    @Given("The user launches the tkmaxx application")
    public void userLaunchesTheTkMaxxApplication() {

    }

    @Then("The user verifies all the menu tabs")
    public void userVerifiesAllTheMenuTabs() {
        List<String> urls =new HomePage(driver).validateMenuTabsInHomePage();
       softAssert.assertEquals(urls.get(1),"");
       softAssert.assertEquals(urls.get(2),"");
       softAssert.assertEquals(urls.get(3),"");
       softAssert.assertEquals(urls.get(4),"");
       softAssert.assertEquals(urls.get(5),"");
       softAssert.assertEquals(urls.get(6),"");
       softAssert.assertEquals(urls.get(7),"");
       softAssert.assertEquals(urls.get(8),"");
    }

    @When("The user selects Clothing option under Mens tab")
    public void userSelectsClothingOptionUnderMen() {
        new HomePage(driver).clickOnClothingOptionForMen();
    }

    @When("The user clicks on View All link of Clothing section")
    public void clickViewAllLinkUnderClothingSection() {
        new HomePage(driver).clickOnViewAllLink();
    }

    @When("The user selects {string} brands")
    public void userSelectsMultipleBrands(String brands) {
       new MensClothingPage(driver).clickBrandDropdown().selectMultipleBrands(brands).clickCloseButton();
    }

    @When("The user selects {string} product")
    public void userSelectsProduct(String product) {
        new MensClothingPage(driver).selectProduct(product);
    }

    @When("The user clicks the Size Guide link and verifies that Size Guide text is displayed")
    public void verifyTheSizeGuideTitleInNewPage() {
        new ProductPage(driver).clickSizeGuideButton().isSizeGuideTitleDisplayed();

    }

    @When("The user navigates to main window")
    public void userNavigatesBackToHomePage() {
        new ProductPage(driver).switchToParentWindow();
    }

    @When("The user selects size and quantity of the product")
    public void userSelectsSizeAndProduct() {
        new ProductPage(driver).clickSizeLabelOption().selectQuantity();
    }

    @When("The user clicks on Add To Cart button")
    public void clickAddToBadButton() {
        new ProductPage(driver).clickAddToBagButton();
    }

    @Then("The user clicks on View Bag button and verifies the product details")
    public void validateTheProductDetailsInViewBag() {
        new ProductPage(driver).clickViewBagButton();
        List<String> itemDetails =new YourShoppingBagPage(driver).getItemDetails();
        softAssert.assertEquals(itemDetails.get(1),"");
        softAssert.assertEquals(itemDetails.get(2),"");
        softAssert.assertEquals(itemDetails.get(3),"");
        softAssert.assertEquals(itemDetails.get(4),"");
    }

    @When("The user navigates to Checkout page by clicking Checkout button")
    public void navigateToCheckOutPage() {
        new YourShoppingBagPage(driver).clickCheckOutButton();
    }

    @When("The user clicks on Checkout As Guest button")
    public void clickOnCheckOutAsGuest() {
        new SecureCheckOutPage(driver).clickCheckOutAsGuestButton().clickCheckSubmitButton();

    }

    @Then("The user validates the email error message")
    public void the_user_validates_the_email_error_message() {
        Assertion s =new Assertion();
        s.assertEquals(new SecureCheckOutPage(driver).getEmailErrorMessage(),"");
    }


}
