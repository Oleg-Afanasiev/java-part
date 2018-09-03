package com.academy.tests.lesson20;


import com.academy.tests.lesson19.automationpractice.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SortTests extends BaseTest {

    @Test
    public void sortDressByLowestPriceTest() {
        System.out.println("sortDressByLowestPriceTest");
        driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a")).click();
        new Select(driver.findElement(By.id("selectProductSort"))).selectByVisibleText("Price: Lowest first");

        // ждем пока прогрузится
        waitUntilScriptComplete(driver);

        // можно делать проверки
    }

}
