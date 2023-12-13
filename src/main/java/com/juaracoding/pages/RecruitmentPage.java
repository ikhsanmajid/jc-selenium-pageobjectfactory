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

    @FindBy(xpath = "//input[@class='oxd-file-input', @type='file']")
    WebElement resume;

    @FindBy(xpath = "//input[@placeholder='Enter comma seperated words...']")
    WebElement keywords;

    @FindBy(xpath = "//input[@placeholder='yyyy-mm-dd']")
    WebElement date;

    @FindBy(xpath = "//textarea[@placeholder='Type here']")
    WebElement notes;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;

    @FindBy(xpath = "//h6[normalize-space()='Application Stage']")
    WebElement textAfterSubmit;

    public void goToRecruiment(){
        RecruitmentPage.click();
    }

    public void addCandidate(){
        addButton.click();
    }

    public void setFirstName(String firstName){
        this.firstName.sendKeys(firstName);
    }

    public void setMiddleName(String middleName){
        this.middleName.sendKeys(middleName);
    }

    public void setLastName(String lastName){
        this.lastName.sendKeys(lastName);
    }

    public void clickVacancy(int position){
        action.moveToElement(vacancy).click().perform();
        delay(2);
        List<WebElement> vacancyItems = vacancy.findElements(By.xpath("//div[@role='listbox']/div[@role='option']"));
        vacancyItems.get(position).click();
    }

    public void setEmail(String email){
        this.email.sendKeys(email);
    }

    public void setContactNumber(String contactNumber){
        this.contactNumber.sendKeys(contactNumber);
    }

//    public void clickUpload(){
//        resume.sendKeys(upload);
//    }

    public void setKeywords(String keywords){
        this.keywords.sendKeys(keywords);
    }

//    public void setDate(String date){
//        this.date.sendKeys(date);
//    }

    public void setNotes(String notes){
        this.notes.sendKeys(notes);
    }

    public void submit(){
        submit.click();
    }

    public String getTextAfterSubmit(){
        return this.textAfterSubmit.getText();
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
