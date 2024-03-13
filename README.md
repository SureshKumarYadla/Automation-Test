# Automation-Test

Run command : **mvn clean install -Dbrowser.name=chrome -Durl=QA**
Require git to install
  -Install git to clone, create your local branch from main, commit changes and push your code and leave it with your local branch only
**NOTE: Do not merge your code into main branch**

# Introduction
This is to test TkMaxx application

# FrameWork details

# UI Test 
Features: TkMaxxValidation.feature file covers the UI automation flow for TkMaxx application
StepDefiniton: TkMaxxStepDefinition file has all step implementation of the feature
SeleniumHelpers: It contains common methods which can be reused across all the page classes
PageClasses: Page classes follow the POM pattern, hence each page class is used for locators and action methods

# API Test
APITestClass: It is used to perform the Get() operation to validate the Latitude and Longitude of a Country 

# DB Test
DatabaseClass: Database class establishes connection with SQL service to retrieve tha data





