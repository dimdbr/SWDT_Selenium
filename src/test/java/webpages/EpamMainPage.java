package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class EpamMainPage {
    private WebDriver driver;
    @FindBy(xpath = "//*[text()='Services']")
    WebElement redirectLink;
    @FindBy(xpath = "//*[text()='Consult']")
    WebElement consultBtn;
    @FindBy(className = "rollover-tiles__description")
    List<WebElement> rolloverTile;
    @FindBy(className = "slider__dot")
    List<WebElement> listOfSliderDots;
    @FindBy(className = "button-ui")
    List<WebElement> slider;
    @FindBy(className = "location-selector__button")
    WebElement locationSelectorBtn;
    @FindBy(className = "location-selector__panel")
    WebElement selectorPanel;
    @FindBy(className = "location-selector__link")
    List<WebElement> ukranianLanguageBtn;
    @FindBy(className = "header-search__button")
    WebElement searchBtn;
    @FindBy(id = "new_form_search")
    WebElement searchBar;
    @FindBy(className ="header-search__submit" )
    WebElement findBtn;


    public void clickServices() {
        redirectLink.click();
    }

    public void mouseOverConsultBtn() {
        Actions action = new Actions(driver);
        action.moveToElement(consultBtn);
        action.moveToElement(rolloverTile.get(0)).build().perform();

    }

    public boolean isVisible() {
        return rolloverTile.get(0).isDisplayed();
    }

    public boolean clickSlider() {
        //System.out.println(listOfSliderDots.size());
        //System.out.println(slider.size());
        //System.out.println(isClickable(slider.get(6)));
        listOfSliderDots.get(3).click();
        return isClickable(slider.get(6));
    }

    public boolean popUpAfterClick() {
        locationSelectorBtn.click();
        System.out.println(selectorPanel.isDisplayed());
        return selectorPanel.isDisplayed();
    }

    public void changeLanguage() {
        locationSelectorBtn.click();
        Actions action = new Actions(driver);
        action.moveToElement(ukranianLanguageBtn.get(7)).build().perform();
        ukranianLanguageBtn.get(7).click();
    }

    public EpamMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isClickable(WebElement webe) {
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(webe));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickSearchBtn() {
        searchBtn.click();
    }

    public void setSearchBar(String request)
    {
        this.searchBar.sendKeys(request);
    }
    public void clickToFind()
    {
        findBtn.click();
    }
}
