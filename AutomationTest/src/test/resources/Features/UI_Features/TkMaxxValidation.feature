Feature: Validate TkMaxx application

  @Test
  Scenario: Validate the end to end flow of checking out a product in tkmaxx application
  Given The user launches the tkmaxx application
  Then The user verifies all the menu tabs
  When The user selects Clothing option under Mens tab
  And The user clicks on View All link of Clothing section
  And The user selects "Adidas,Bench" brands
  And The user selects "Black Swim Shorts" product
  And The user clicks the Size Guide link and verifies that Size Guide text is displayed
  And The user navigates to main window
  And The user selects size and quantity of the product
  And The user clicks on Add To Cart button
  Then The user clicks on View Bag button and verifies the product details
  When The user navigates to Checkout page by clicking Checkout button
  And The user clicks on Checkout As Guest button
  Then The user validates the email error message

