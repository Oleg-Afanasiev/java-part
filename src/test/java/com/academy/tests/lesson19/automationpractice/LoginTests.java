package com.academy.tests.lesson19.automationpractice;

import com.academy.lesson18.manager.PropertyManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class LoginTests extends BaseTest{

//  private PropertyManager propertyManager = PropertyManager.getInstance();

  @Test(dataProvider = "authProvider")
  public void testAuthCorrect(String userName, String password) throws Exception {
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys(userName);
    driver.findElement(By.id("passwd")).clear();
    driver.findElement(By.id("passwd")).sendKeys(password);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Forgot your password?'])[1]/following::span[1]")).click();
    try {
      assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sign out'])[1]/preceding::span[1]")).getText(), "Oleg Afanasiev");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("Sign out")).click();
  }

  @Test(enabled = false)
  public void testAuthIncorrect() {

  }

  @DataProvider(name="authProvider")
  private Object[][] authProvider() {
    return new Object[][]{
            {PropertyManager.getProperty("automation.username"), PropertyManager.getProperty("automation.password")}
    };
  }

}
