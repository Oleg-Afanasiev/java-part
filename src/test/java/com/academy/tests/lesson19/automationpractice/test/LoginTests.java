package com.academy.tests.lesson19.automationpractice.test;

import com.academy.lesson18.manager.PropertyManager;
import com.academy.tests.lesson19.automationpractice.page.AccountPage;
import com.academy.tests.lesson19.automationpractice.page.HomePage;
import com.academy.tests.lesson19.automationpractice.page.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTest {

//  private PropertyManager propertyManager = PropertyManager.getInstance();

  @Test(dataProvider = "authProvider")
  public void testAuthCorrect(String email, String password) throws Exception {
    System.out.println("Start LoginTest using PageObject pattern");
    // 1 Способ - не круто
//    HomePage homePage = new HomePage(driver);
//    LoginPage loginPage = homePage.clickSingIn();
//    loginPage.inputEmail(email);
//    loginPage.inputPassword(password);
//    AccountPage accountPage = loginPage.clickSingIn();

    // 2 Способ - пока круто
    AccountPage accountPage =
            new HomePage(driver)
                    .clickSingIn()
                    .inputEmail(email)
                    .inputPassword(password)
                    .clickSingIn();

    String userNameLinkText = accountPage.getUserNameLinkText();
    assertEquals(userNameLinkText, "Oleg Afanasiev");
    accountPage.clickSignOut();
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
