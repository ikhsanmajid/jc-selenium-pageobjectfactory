package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.RecruitmentPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RecruitmentTest {

    private WebDriver driver;
    private RecruitmentPage recruit;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(url);
        recruit = new RecruitmentPage();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void goToRecruitment(){
        recruit.goToRecruiment();
        recruit.addCandidate();
    }

    @Test(priority = 2)
    public void fillForms(){
        recruit.setFirstName("Test");
        recruit.setMiddleName("Middle");
        recruit.setLastName("Last");
        recruit.clickVacancy(3);
        recruit.setEmail("testing@orange.com");
        recruit.setContactNumber("2133312312");
        recruit.setKeywords("TestNg");
//        recruit.setDate();
        recruit.setNotes("Testing Saja");

    }

    @Test(priority = 3)
    public void submitForm(){
        recruit.submit();
        Assert.assertEquals(recruit.getTextAfterSubmit(), "Application Stage");
    }
}
