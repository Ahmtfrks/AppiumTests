package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



public class CalculatorPage {

    public CalculatorPage() {

        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver("calculatorPlatform")), this); //driver object
    }

    @AndroidFindBy(accessibility = "plus")
    public WebElement plusButton;

    @AndroidFindBy(accessibility = "equals")
    public WebElement equalButton;

    @AndroidFindBy(accessibility = "multiply")
    public WebElement multiplyButton;
    @AndroidFindBy(id= "com.google.android.calculator:id/result_final")
    public WebElement numberResult;

    //create a method that will click single digit
    public void clickSingleDigit(int number){

        String numberLoc="com.google.android.calculator:id/digit_"+number;

        WebElement numberLocWebElement= Driver.getDriver("calculatorPlatform").findElement(By.id(numberLoc));

        numberLocWebElement.click();
    }
    // create a method that will click on single digit
    public void clickSingleDigit1(int digit){
        String idLocator = "com.google.android.calculator:id/digit_" + digit;
        WebElement number = Driver.getDriver("calculatorPlatform").findElement(By.id(idLocator));
        number.click();
    }
}
