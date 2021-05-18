package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EpamMainPage {
    private WebDriver driver;
    By redirectLink = By.xpath("//*[text()='Services']");
    By consultBtn = By.xpath("//*[text()='Consult']");
    By rolloverTile = By.className("rollover-tiles__description");
    By listOfSliderDot = By.className("slider__dot");
    By slider = By.className("button-ui");
    By locationSelectorBtn = By.className("location-selector__button");
    By selectorPanel = By.className("location-selector__panel");
    By ukranianLanguageBtn = By.className("location-selector__link");
    By searchBtn = By.className("header-search__button");
    By searchBar = By.id("new_form_search");
    By findBtn = By.className("header-search__submit");
    By responseMessage = By.className("search-results__exception-message");


    public void clickServices() {
        driver.findElement(redirectLink).click();
    }

    public void mouseOverConsultBtn() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(consultBtn));

        action.moveToElement(driver.findElements(rolloverTile).get(0)).build().perform();

    }

    public boolean isVisible() {
        return driver.findElements(rolloverTile).get(0).isDisplayed();
    }

    public void clickSlider() {
        //System.out.println(listOfSliderDots.size());
        //System.out.println(slider.size());
        //System.out.println(isClickable(slider.get(6)));
        driver.findElements(listOfSliderDot).get(3).click();
    }

    public boolean isSliderClickable() {
        return isClickable(driver.findElements(slider).get(6));
    }

    public void clickLanguageSelector() {
        driver.findElement(locationSelectorBtn).click();


    }

    public boolean isPanelVisible() {
        return driver.findElement(selectorPanel).isDisplayed();
    }

    public void changeLanguage() {
        driver.findElement(locationSelectorBtn).click();
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElements(ukranianLanguageBtn).get(7)).build().perform();
        driver.findElements(ukranianLanguageBtn).get(7).click();

    }

    public EpamMainPage(WebDriver driver) {

        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

//        wait for loading page
        this.driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

//         wait for an asynchronous script to finish execution
//        this.driver.manage().timeouts().setScriptTimeout(5000, TimeUnit.MILLISECONDS);
    }

    public boolean isClickable(WebElement webe) {
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, 4);
            wait.until(ExpectedConditions.elementToBeClickable(webe));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickSearchBtn() {
        driver.findElement(searchBtn).click();
    }

    public void setSearchBar(String request) {
        driver.findElement(searchBar).sendKeys(request);
    }

    public void clickToFind() {
        driver.findElement(findBtn).click();
    }
    public String getResponse()
    {
        return driver.findElements(responseMessage).get(0).getText();
    }
}
