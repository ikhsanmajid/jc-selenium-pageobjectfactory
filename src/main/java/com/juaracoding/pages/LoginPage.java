package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);

    }

    // Locator use Page Factory
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement username;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;
    @FindBy(xpath = "//button[contains(@class, 'orangehrm-login-button')]")
    WebElement btnLogin;

    @FindBy(xpath = "//h6[contains(@class, 'topbar-header')]")
    WebElement txtDashboard;

    @FindBy(xpath = "//div[contains(@class, 'oxd-topbar-header-userarea')]/ul/li/span")
    WebElement profileBtn;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement invalidText;

    @FindBy(xpath = "//div/div[2]/div[2]/form/div[1]/div/span[contains(@class, 'oxd-input-field-error-message')]")
    WebElement requiredText;

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnLogin.click();
    }

    public void clearFormLogin(){
        this.username.sendKeys(Keys.CONTROL+"A"+Keys.DELETE);
        this.password.sendKeys(Keys.CONTROL+"A"+Keys.DELETE);
    }

    public String getTxtDashboard(){
        return txtDashboard.getText();
    }

    public String getTxtInvalid(){ return invalidText.getText(); }

    public String getTxtRequired(){ return requiredText.getText(); }

    public void logout(){
        Actions action = new Actions(driver);
        action.moveToElement(profileBtn).click().perform();
        profileBtn.findElement(By.xpath("//a[@href='/web/index.php/auth/logout']")).click();
    }


}
