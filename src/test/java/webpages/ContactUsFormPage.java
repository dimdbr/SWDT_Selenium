package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactUsFormPage {
    private WebDriver driver;
    By userNameL = By.name("user_first_name");
    By userLastNameL = By.name("user_last_name");
    By userEmailL = By.name("user_email");
    By userPhoneL = By.name("user_phone");
    By checkBoxes = By.className("checkbox__label");
    By buttons = By.className("button-ui");


    public void setUserName(String userName) {
        driver.findElement(userNameL).sendKeys(userName);
    }

    public void setUserLastName(String userLastName) {
        driver.findElement(userLastNameL).sendKeys(userLastName);
    }

    public void setUserEmail(String userEmail) {
        driver.findElement(userEmailL).sendKeys(userEmail);
    }

    public void setUserPhone(String userPhone) {

        driver.findElement(userPhoneL).sendKeys(userPhone);
    }


    public void fillFields(String firstName, String lastName, String email, String phone) {
        this.setUserName(firstName);
        this.setUserLastName(lastName);
        this.setUserPhone(phone);
        this.setUserEmail(email);
    }

    public void clickCheckbox() {
        WebElement cb = driver.findElements(checkBoxes).get(0);
        cb.click();
    }
    public boolean isSubmitClickable()
    {
        return isClickable(driver.findElements(buttons).get(1));
    }
    public void clickSubmit() {
        WebElement submitBtn = driver.findElements(buttons).get(1);
        Actions actionProvider = new Actions(driver);
        actionProvider.moveToElement(submitBtn).build().perform();
        submitBtn.click();
//        return driver.findElement(userNameL).getCssValue("color");
    }

    public ContactUsFormPage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
//        wait for loading page
        this.driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
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

}
