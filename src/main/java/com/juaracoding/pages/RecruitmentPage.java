package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RecruitmentPage {
    private WebDriver driver;
    private Actions action;
    public RecruitmentPage(){
        this.driver = DriverSingleton.getDriver();
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Recruitment']")
    WebElement RecruitmentPage;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addButton;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Middle Name']")
    WebElement middleName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    @FindBy(xpath = "//div[@class='oxd-select-wrapper']")
    WebElement vacancy;

    @FindBy(xpath = "//div[3]//div[1]//div[1]//div[1]//div[2]//input[1]")
    WebElement email;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--focus']")
    WebElement contactNumber;

    @FindBy(xpath = "//div[@class='oxd-file-input-div']")
    WebElement resume;

    @FindBy(xpath = "//input[@placeholder='Enter comma seperated words...']")
    WebElement keywords;

    @FindBy(xpath = "//input[@placeholder='yyyy-mm-dd']")
    WebElement date;

    @FindBy(xpath = "//textarea[@placeholder='Type here']")
    WebElement notes;

    public void goToRecruiment(){
        RecruitmentPage.click();
    }

    public void addCandidate(){
        addButton.click();
    }

    public void clickVacancy(){

        action.moveToElement(vacancy).click().perform();
        delay(2);
        List<WebElement> vacancyItems = vacancy.findElements(By.xpath("//div[@role='listbox']/div[@role='option']"));
        System.out.println(vacancyItems.get(0).getText());

    }

    public void delay(long s){
        try{
            Thread.sleep(s*1000);
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }








    // step action


    // step validation

}
