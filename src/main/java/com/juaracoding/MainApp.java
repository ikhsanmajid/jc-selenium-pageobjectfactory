package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.RecruitmentPage;
import org.openqa.selenium.WebDriver;

public class MainApp {
    private static WebDriver driver;

    public static void main(String[] args) {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(url);

        LoginPage loginPage = new LoginPage();
        loginPage.login("Admin", "admin123");
        System.out.println(loginPage.getTxtDashboard());
        //loginPage.logout();

        RecruitmentPage recruit = new RecruitmentPage();
        recruit.goToRecruiment();
        recruit.addCandidate();
        recruit.clickVacancy(2);

    }
}
