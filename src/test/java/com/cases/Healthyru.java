package com.cases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.actions.Actions;
import com.base.Base;
import com.codoid.products.exception.FilloException;
import com.pageObjects.AppointmentConfPage;
import com.pageObjects.BookAppointmentPage;
import com.pageObjects.HomePage;
import com.pageObjects.LoginPage;
import com.utils.Utils;

public class Healthyru extends Base {

    public WebDriver driver;
    public Actions actions;

    private Logger log = LogManager.getLogger(BookAppointment.class.getName());
    private HashMap<String, String> data;

    @BeforeTest
    public void initialize() throws IOException, FilloException {

        driver = initializeDriver();
        log.info("Driver is initialized.");
        data = new Utils().getTestData("TC2");
        actions = new Actions(driver);

    }

    @Test
    public void Login() {

        HomePage hp = new HomePage(driver);
        LoginPage lp = new LoginPage(driver);
        BookAppointmentPage ba = new BookAppointmentPage(driver);
        AppointmentConfPage ac = new AppointmentConfPage(driver);

        actions.navigateTo("https://healthyru-nh.farziengineer.co/");
        actions.click(driver.findElement(By.xpath("//header/nav[@id='header']/div[2]/div[2]/ul[1]/li[3]/div[1]/span[1]")));
        actions.click(driver.findElement(By.xpath("//li[contains(text(),'Login / Register')]")));
        actions.enterText(driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/input[1]")), "9654888767");
        actions.click(driver.findElement(By.xpath("//span[contains(text(),'Login')]")));
        actions.enterText(driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/input[1]")), "965477");
        actions.click(driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[2]/span[1]")));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        actions.click(driver.findElement(By.xpath("//div[contains(text(),'Resend OTP')]")));
        actions.click(driver.findElement(By.xpath("//span[contains(text(),'Verify')]")));
        actions.click(driver.findElement(By.xpath("//span[contains(text(),'Please provide valid otp.')]")));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        actions.click(driver.findElement(By.xpath("//span[contains(text(),'Verify')]")));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

  /*      actions.click(hp.getLogin());
        actions.enterText(lp.getPassword(), data.get("Password"));
        actions.click(lp.getLoginBtn());
        //add a wait function
        actions.selectFromDropdown(ba.getFacilityDD(), data.get("Facility"));
        actions.click(ba.getReadmission());
        actions.click(ba.getMedicaid());
        actions.enterText(ba.getVisitDate(), data.get("Visit Date"));
        actions.enterText(ba.getComment(), data.get("Comment"));
        actions.click(ba.getBookBtn());

        Assert.assertTrue(ac.getTitle().isDisplayed());*/

    }


    @AfterTest
    public void teardown() {
        driver.close();
        log.info("Driver is closed");
    }
}