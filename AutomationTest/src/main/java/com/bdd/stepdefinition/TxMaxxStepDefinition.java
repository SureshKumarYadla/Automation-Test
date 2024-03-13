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
    List<String> productDetails=null;

    public TxMaxxStepDefinition(){
        super();
    }

    @Given("The user launches the tkmaxx application")
    public void userLaunchesTheTkMaxxApplication() {

    }

    @Then("The user verifies all the menu tabs")
    public void userVerifiesAllTheMenuTabs() {
        List<String> urls =new HomePage(driver).validateMenuTabsInHomePage();
       softAssert.assertTrue(urls.get(1).contains("new-in"));
       softAssert.assertTrue(urls.get(2).contains("women"));
       softAssert.assertTrue(urls.get(3).contains("men"));
       softAssert.assertTrue(urls.get(4).contains("kids+toys"));
       softAssert.assertTrue(urls.get(5).contains("home"));
       softAssert.assertTrue(urls.get(6).contains("beauty"));
       softAssert.assertTrue(urls.get(7).contains("gifts"));
       softAssert.assertTrue(urls.get(8).contains("clearance"));

       softAssert.assertAll();
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
        productDetails= new ProductPage(driver).getProductDetails();
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
        softAssert.assertEquals("Item details are not same" + itemDetails,productDetails);

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
    public void validateEmailErrorMessage() {
        Assertion s =new Assertion();
        s.assertEquals(new SecureCheckOutPage(driver).getEmailErrorMessage(),"Please enter an email address");
    }


}
