package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import webpages.ContactUsFormPage;
import webpages.EpamMainPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test6 {
    String path = "./driver/chromedriver.exe";
    WebDriver driver;
    ContactUsFormPage formPage;
    @Before
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver",path);

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.epam.com/about/who-we-are/contact");

    }
    @Test
    public void fillForm() throws InterruptedException {
        formPage=new ContactUsFormPage(driver);
        formPage.fillFields("AAA","BBB","CCC@gmail.com","380994932426");
        Thread.sleep(3000);
        formPage.clickCheckbox();
//        Thread.sleep(5000L);
        //Assert.assertTrue(driver.getCurrentUrl().equals("https://careers.epam.ua/"));
         List<WebElement> selector = driver.findElements(By.className("select2-selection__arrow"));
         System.out.println(selector.size());
        Thread.sleep(3000);
        WebElement needed= selector.get(5);
        needed.click();
        Actions actionProvider = new Actions(driver);
        actionProvider.moveToElement(needed).moveByOffset(0,40).click().build().perform();

    }



}