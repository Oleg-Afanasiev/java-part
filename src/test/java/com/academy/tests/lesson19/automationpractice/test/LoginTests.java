package com.academy.tests.lesson19.automationpractice.test;

import com.academy.lesson18.manager.PropertyManager;
import com.academy.tests.lesson19.automationpractice.page.AccountPage;
import com.academy.tests.lesson19.automationpractice.page.HomePage;
import com.academy.tests.lesson19.automationpractice.page.LoginPage;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTest {

//  private PropertyManager propertyManager = PropertyManager.getInstance();

  @Test(dataProvider = "authProvider", enabled = false)
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

  @Test(dataProvider = "incorrectLoginProvider")
  public void testAuthIncorrect(String email, String password, String errorMsg) {
    System.out.println(String.format("email: %s, password:%s, errorMsg:%s", email, password, errorMsg));
  }

  @DataProvider(name="authProvider")
  private Object[][] authProvider() {
    return new Object[][]{
            {PropertyManager.getProperty("automation.username"), PropertyManager.getProperty("automation.password")}
    };
  }

  @DataProvider(name = "incorrectLoginProvider")
  public Object[][] provideIncorrectAuthData() {
    String authDataPath = PropertyManager.getProperty("auth.incorrect.data");

    try (XSSFWorkbook workbook = new XSSFWorkbook(authDataPath)) {
      XSSFSheet sheet = workbook.getSheetAt(0);

      Object[][] data = new Object[sheet.getLastRowNum()][3];

      for (int r = 1; r <= sheet.getLastRowNum(); r++) {
        XSSFRow row = sheet.getRow(r);
        String email = row.getCell(0).getStringCellValue();
        String password = row.getCell(1).getStringCellValue();
        String errMsg = row.getCell(2).getStringCellValue();

        data[r-1][0] = email;
        data[r-1][1] = password;
        data[r-1][2] = errMsg;
      }

      return data;

//    return new Object[][]{
//            {"qwer@qwe.qwe","123qwe","Authentication failed."},
//            {"qwer@qwe.qwe","Tnm601982","Authentication failed."},
//            {"yavoric@rambler.ru","123qwe","Authentication failed."},
//            {"","","An email address required."},
//            {"yavoric@rambler.ru","","Password is required."},
//            {"","Tnm601982","An email address required."},
//            {"qwerty","","Invalid email address."}
//    };
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}
