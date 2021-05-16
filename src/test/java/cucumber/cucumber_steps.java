package cucumber;

import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webpages.ContactUsFormPage;
import webpages.EpamMainPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class cucumber_steps {
    String path = "./driver/chromedriver.exe";
    WebDriver driver;
    EpamMainPage objPage;
    ContactUsFormPage contactUsFormPage;


    @Given("^main page of epam.com$")
    public void EnteringMainPage() {
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.epam.com");

    }

    @When("^click on button on header with SERVICES text$")
    public void clickServices() {
        objPage = new EpamMainPage(driver);
        objPage.clickServices();
    }

    @Then("^redirecting to services webpage$")
    public void redirectServices() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.epam.com/services"));
    }

    @When("^finding web element with class rollover_tiles__image and bulb picture and hover mouse on it$")
    public void mouseOverConsult() {
        objPage = new EpamMainPage(driver);
        objPage.mouseOverConsultBtn();
        Assert.assertEquals(true, objPage.isVisible());
    }

    @Then("^pop-up element with class rollover_tiles__description and text CONSULT$")
    public void tileIsVisible() {
        objPage = new EpamMainPage(driver);
        Assert.assertEquals(true, objPage.isVisible());
    }

    @When("^find on page slider block and click on web element on slider block with class slider__dot$")
    public void clickingOnSlider() {
        objPage = new EpamMainPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)");
        objPage.clickSlider();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
    }

    @Then("^slider content is clickable$")
    public void isSliderClickable() {
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        objPage = new EpamMainPage(driver);
        boolean result = objPage.isSliderClickable();
        Assert.assertEquals(true, result);
    }

    @When("^find element on header with class location_selector__button and click on found element$")
    public void clickLanguageSelector() {
        objPage = new EpamMainPage(driver);
        objPage.clickLanguageSelector();
    }

    @Then("^element with class location_selector_panel pop-up$")
    public void isPanelVisible() {
        boolean result = objPage.isPanelVisible();
        Assert.assertEquals(true, result);
    }

    @When("^click on button with text Ukraine Українська$")
    public void changeLanguage() {
        objPage = new EpamMainPage(driver);
        objPage.changeLanguage();

    }

    @Then("^redirect to careers.epam.ua$")
    public void redirectToUkr() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.titleContains("EPAM Ukraine - найбільша ІТ-компанія в Україні | Вакансії"));
        Assert.assertTrue(driver.getCurrentUrl().equals("https://careers.epam.ua/"));
    }

    @Given("^page epam.com/about/who-we-are/contact$")
    public void enteringForPage() {
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.epam.com/about/who-we-are/contact");

    }

    @When("^fill all required fields and select checkboxes and press submit button$")
    public void fillForm() {
        contactUsFormPage = new ContactUsFormPage(driver);
        contactUsFormPage.fillFields("AAA", "BBB", "CCC@gmail.com", "380994932426");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");
        contactUsFormPage.clickCheckbox();
        List<WebElement> selector = driver.findElements(By.className("select2-selection__arrow"));
        WebElement needed = selector.get(5);
        needed.click();
        Actions actionProvider = new Actions(driver);
        actionProvider.moveToElement(needed).moveByOffset(0, 40).click().build().perform();
    }

    @When("^form will be successfully submitted$")
    public void isSubmitClickable() {
        boolean result = contactUsFormPage.isSubmitClickable();
        Assert.assertEquals(true, result);
    }

    @When("^dont complete form$")
    public void submitUncompletedForm() {
        contactUsFormPage = new ContactUsFormPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1200)");
        contactUsFormPage.clickSubmit();

    }

    @Then("^field borders become red and appear hints to complete required fields$")
    public void checkBorderColor() {
        String result = driver.findElement(By.name("user_first_name")).getCssValue("color");
        Assert.assertEquals(result, "rgba(241, 92, 67, 1)");
    }

    @When("^click on button with magnifier glass icon on it and fill text box with \"qwertyuiop\" and make a request$")
    public void madeAQuery() {
        objPage = new EpamMainPage(driver);
        objPage.clickSearchBtn();
        objPage.setSearchBar("qwertyuiop");
        objPage.clickToFind();

    }

    @Then("^expect line with text \"Sorry, but your search returned no results. Please tray another query\"$")
    public void checkResponse() {
        String expect = "Sorry, but your search returned no results. Please try another query.";
        String result = driver.findElements(By.className("search-results__exception-message")).get(0).getText();
        Assert.assertEquals(result, expect);
    }


}
