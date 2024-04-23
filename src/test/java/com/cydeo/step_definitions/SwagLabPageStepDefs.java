package com.cydeo.step_definitions;

import com.cydeo.pages.SwagLabNativeAppPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.MobileUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SwagLabPageStepDefs {


    SwagLabNativeAppPage swagLabNativeAppPage;

    @When("User navigates to login page of swaglabs native application on {string}")
    public void user_navigates_to_login_page_of_swaglabs_native_application_on(String env) {
        MobileUtils.wait(3);

        swagLabNativeAppPage = new SwagLabNativeAppPage(env+"-swaglabsPlatform");
//local-swaglabsPlatform
        MobileUtils.wait(6);

    }

    @When("User logins with valid username and password")
    public void user_logins_with_valid_username_and_password() {

        swagLabNativeAppPage.username.sendKeys(ConfigurationReader.getProperty("userName"));
        swagLabNativeAppPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        swagLabNativeAppPage.loginButton.click();


        MobileUtils.wait(5);
    }

    @Then("Verifies user can see a sample product item on the homepage")
    public void verifies_user_can_see_a_sample_product_item_on_the_homepage() {
        // System.out.println(((AndroidDriver) driver).getDeviceTime());
        String actualSauceLabBackPackItemText = swagLabNativeAppPage.sauceLabBackPackItem.getText();
        String expectedResult = "Sauce Labs Backpack";

        Assertions.assertEquals(expectedResult, actualSauceLabBackPackItemText);

        Driver.closeDriver();
    }
}
