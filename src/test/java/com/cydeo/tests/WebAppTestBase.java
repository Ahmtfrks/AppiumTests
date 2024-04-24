package com.cydeo.tests;

import com.cydeo.utilities.MobileUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileBrowserType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WebAppTestBase {

    protected AndroidDriver driver;

    @BeforeEach
    public void setUpTest() {

        UiAutomator2Options options = new UiAutomator2Options();

        //options.setApp("https://cybertek-appium.s3.amazonaws.com/calculator.apk");
        //before we test native app calculator
        //now we automating browser thatwhy we use different parameter
        //I want to tell my UiAutomator2 driver for open a browser

        options.withBrowserName(MobileBrowserType.CHROME);


//        try {
//            driver = new AndroidDriver(new URL("http://172.27.240.1:4723/"), options);
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
        URL url;
        try {
            url = new URL("http://localhost:4723/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver = new AndroidDriver(url, options);

        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
