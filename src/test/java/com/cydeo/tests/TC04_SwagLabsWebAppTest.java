package com.cydeo.tests;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.MobileUtils;


import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import java.util.List;

import static org.junit.Assert.assertTrue;

public class TC04_SwagLabsWebAppTest extends WebAppTestBase {

    //appium --allow-insecure chromedriver_autodownload
    // sudo spctl --master-disable  :  to disable security for macos so chrome executable operation is allowed


    @Test
    public void loginTest() {


        // Navigate to https://www.saucedemo.com/v1/
        //driver.get("https://www.saucedemo.com/v1/inventory.html");
        driver.get("https://www.saucedemo.com/v1/index.html");

        //log into application//TODO ask here I can not write username why--opencmd(line22)after run
        MobileUtils.wait(2);
        WebElement userNameBox = driver.findElement(By.id("user-name"));
        System.out.println(userNameBox.getAttribute("text"));
       // userNameBox.click();
        userNameBox.sendKeys(ConfigurationReader.getProperty("userName"));

        WebElement passwordBox = driver.findElement(By.id("password"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("password") + Keys.ENTER);
       // WebElement loginButton = driver.findElement(new AppiumBy.ByAccessibilityId("test-LOGIN"));





        MobileUtils.wait(3);

        //List<WebElement> productList = driver.findElements(By.className("inventory_item"));
        List<WebElement> productList = driver.findElements(By.cssSelector(".inventory_item_name"));
//        List<WebElement> productList = driver.findElements(By.className("inventory_item_name"));

        for (WebElement eachProduct : productList) {
            System.out.println("eachProduct = " + eachProduct.getText());
        }
//if productName is include test check contains t-shirt
        for (WebElement eachProduct : productList) {
            if (eachProduct.getText().contains("Test")){
                Assertions.assertTrue(eachProduct.getText().toLowerCase().contains("t-shirt"));
            }
        }
        // lets scroll down to the last product, locator is : (//div[@class='inventory_item_name'])[6]

        Actions actions = new Actions(driver);

//        actions.moveToElement(driver.findElement(By.xpath("//div[@class='inventory_item'][6]"))).perform();
        actions.moveToElement(driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[6]"))).perform();

        MobileUtils.wait(3);

        //I am doing front testing automating mobile test app.
        // native and web mobile app test
    }
}
