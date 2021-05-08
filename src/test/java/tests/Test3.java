package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import webpages.EpamMainPage;

public class Test3 {
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
    public void sliderTest() {
        objPage = new EpamMainPage(driver);
        boolean result = objPage.clickSlider();
        Assert.assertEquals(true, result);
    }

}
