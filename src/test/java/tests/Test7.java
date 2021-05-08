package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import webpages.ContactUsFormPage;
import webpages.EpamMainPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test7 {
    String path = "./driver/chromedriver.exe";
    WebDriver driver;
    ContactUsFormPage formPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", path);

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.epam.com/about/who-we-are/contact");

    }

    @Test
    public void submitUncompletedForm() throws InterruptedException {
        formPage = new ContactUsFormPage(driver);

        String result = formPage.clickSubmit();
        Assert.assertEquals(result, "rgba(241, 92, 67, 1)");
    }


}