package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ContactUsFormPage {
    private WebDriver driver;
    @FindBy(name ="user_first_name" )
    WebElement userName;
    @FindBy(name ="user_last_name" )
    WebElement userLastName;
    @FindBy(name ="user_email" )
    WebElement userEmail;
    @FindBy(name ="user_phone" )
    WebElement userPhone;
    @FindBy(className="checkbox__label")
    List<WebElement> checkBoxes;
    @FindBy(className = "button-ui")
    List<WebElement> buttons;


    public void setUserName(String userName) {
        this.userName.sendKeys(userName);
    }

    public void setUserLastName(String userLastName) {
        this.userLastName.sendKeys(userLastName);
    }

    public void setUserEmail(String userEmail) {
        this.userEmail.sendKeys(userEmail);
    }
    public void setUserPhone(String userPhone) {
        this.userPhone.sendKeys(userPhone);
    }


    public void fillFields(String firstName,String lastName,String email,String phone)
    {
        this.setUserName(firstName);
        this.setUserLastName(lastName);
        this.setUserPhone(phone);
        this.setUserEmail(email);
    }
    public void clickCheckbox()
    {
        WebElement cb = checkBoxes.get(0);
        cb.click();
    }
    public String clickSubmit()
    {
        WebElement submitBtn = buttons.get(1);
        Actions actionProvider = new Actions(driver);
        actionProvider.moveToElement(submitBtn).build().perform();
        submitBtn.click();
        return userName.getCssValue("color");
    }

    public ContactUsFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


}
