package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import webpages.EpamMainPage;

import java.util.concurrent.TimeUnit;

public class Test5 {
    String path = "./driver/chromedriver.exe";
    WebDriver driver;
    EpamMainPage objPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", path);

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.epam.com");

    }

    @Test
    public void changeRegionAndLanguage() throws InterruptedException {
        objPage = new EpamMainPage(driver);
        objPage.changeLanguage();
        Thread.sleep(5000L);
        Assert.assertTrue(driver.getCurrentUrl().equals("https://careers.epam.ua/"));

    }

}
