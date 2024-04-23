package com.cydeo.tests;

import com.cydeo.pages.CalculatorPage;
import com.cydeo.utilities.MobileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class TC03_CalculatorPOM_Test {

    CalculatorPage calculatorPage = new CalculatorPage();

    @Test
    public void multiplyTest() {

        //4 * 5 equals 20

        MobileUtils.wait(3);
        calculatorPage.clickSingleDigit(4);

        WebElement multiplyButton = calculatorPage.multiplyButton;

        multiplyButton.click();

        calculatorPage.clickSingleDigit(5);

        calculatorPage.equalButton.click();

        String resultText = calculatorPage.numberResult.getText();

        int expectedText = 20;

        Assertions.assertEquals(expectedText, Integer.parseInt(resultText));


    }
}
