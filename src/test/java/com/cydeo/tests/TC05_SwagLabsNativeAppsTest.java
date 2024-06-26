package com.cydeo.tests;

import com.cydeo.pages.SwagLabNativeAppPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.MobileUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;



public class TC05_SwagLabsNativeAppsTest {

    String username = ConfigurationReader.getProperty("userName");
    String password = ConfigurationReader.getProperty("password");
    @Test
    public void SignInTest() {

        MobileUtils.wait(4);
        AppiumDriver driver = Driver.getDriver(("local-swaglabsPlatform"));


        MobileUtils.wait(3);
        driver.findElement(new AppiumBy.ByAccessibilityId("test-Username")).sendKeys(username);

        driver.findElement(new AppiumBy.ByAccessibilityId("test-Password")).sendKeys(password);

        driver.findElement(new AppiumBy.ByAccessibilityId("test-LOGIN")).click();

        MobileUtils.wait(5);

        // System.out.println(((AndroidDriver) driver).getDeviceTime());


        WebElement aSampleUnit = driver.findElement(By.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]"));

        Assertions.assertTrue(aSampleUnit.getText().contains("Sauce"));

        System.out.println(((AndroidDriver)driver).getDeviceTime());

        //driver.close();
    }
    @Test
    public void SignInTestWithPOM() {

        MobileUtils.wait(3);

        SwagLabNativeAppPage swagLabNativeAppPage = new SwagLabNativeAppPage("local-swaglabsPlatform");



        MobileUtils.wait(3);
        swagLabNativeAppPage.username.sendKeys(ConfigurationReader.getProperty("userName"));
        swagLabNativeAppPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        swagLabNativeAppPage.loginButton.click();


        MobileUtils.wait(5);

        // System.out.println(((AndroidDriver) driver).getDeviceTime());
        String actualSauceLabBackPackItemText = swagLabNativeAppPage.sauceLabBackPackItem.getText();
        String expectedResult = "Sauce Labs Backpack";

        Assertions.assertEquals(expectedResult, actualSauceLabBackPackItemText);

        Driver.closeDriver();

    }
    }
