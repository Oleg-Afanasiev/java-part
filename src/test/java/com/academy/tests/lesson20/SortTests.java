package com.academy.tests.lesson20;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SortTests {

    @Test
    public void sortDressByLowestPriceTest() {
        System.out.println("sortDressByLowestPriceTest");
        System.setProperty("webdriver.chrome.driver","d:/distribs/selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a")).click();
        new Select(driver.findElement(By.id("selectProductSort"))).selectByVisibleText("Price: Lowest first");

        // ждем пока прогрузится
        waitUntilScriptComplete(driver);

        // можно делать проверки

        driver.quit();
    }

    private boolean waitUntilScriptComplete(WebDriver driver1) {
        WebDriverWait wait = new WebDriverWait(driver1, 30, 300);

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = driver -> {
            try {
                return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
            }
            catch (Exception e) {
                // no jQuery present
                return true;
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor)driver).executeScript("return document.readyState")
                .toString().equals("complete");

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }
}
