package com.academy.tests.lesson20.dumok;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FilterTests {

    private WebDriver driver;
    private String baseUrl = "http://dumok.com.ua";
    private Actions actions;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
    }

    @Test
    @Ignore
    public void filterHookahInputPrice() {
        int from = 1000;
        int to = 3000;

        driver.get(baseUrl);

        driver.findElement(By.cssSelector("#page > div:nth-child(2) > div > div.n-cats.row > div.col-md-4.col-sm-6 > a")).click();
        WebElement elFrom = driver.findElement(By.id("range-from1"));
        WebElement elTo = driver.findElement(By.id("range-to1"));
        elFrom.clear();
        elFrom.sendKeys(Integer.toString(from));
        elTo.clear();
        elTo.sendKeys(Integer.toString(to));

        driver.findElement(By.cssSelector("#collapse_price > button")).click();
    }


    @Test
    @Ignore
    public void filterHookahMovePrice() {
        int from = 1000;
        int to = 3000;

        driver.get(baseUrl);

        driver.findElement(By.cssSelector("#page > div:nth-child(2) > div > div.n-cats.row > div.col-md-4.col-sm-6 > a")).click();

        WebElement elFromRange = driver.findElement(By.cssSelector("#slider-range > span:nth-child(2)"));
        WebElement elToRange = driver.findElement(By.cssSelector("#slider-range > span:nth-child(3)"));

        WebElement elFromInput = driver.findElement(By.id("range-from1"));
        WebElement elToInput = driver.findElement(By.id("range-to1"));

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(10))
                .ignoring(NumberFormatException.class)
                .until(driver->{
                    String valueJsFrom = (String)((JavascriptExecutor)driver).executeScript("return document.getElementById('range-from1').value");
                    actions
                            .dragAndDropBy(elFromRange, 3, 0)
                            .build()
                            .perform();

                    System.out.println("until-> " + valueJsFrom);

                    return Integer.parseInt(valueJsFrom) >= from;
                });

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NumberFormatException.class)
                .until(driver->{
                    String valueJsTo = (String)((JavascriptExecutor)driver).executeScript("return document.getElementById('range-to1').value");
                    actions
                            .dragAndDropBy(elToRange,-1, 0)
                            .build()
                            .perform();

                    System.out.println("until-> " + valueJsTo);

                    return Integer.parseInt(valueJsTo) <= to;
                });

        driver.findElement(By.cssSelector("#collapse_price > button")).click();
    }

    @Test
    @Ignore
    public void filterHookahMoveByKeysPrice() {
        int from = 1000;
        int to = 3000;

        driver.get(baseUrl);

        driver.findElement(By.cssSelector("#page > div:nth-child(2) > div > div.n-cats.row > div.col-md-4.col-sm-6 > a")).click();

        WebElement elFromRange = driver.findElement(By.cssSelector("#slider-range > span:nth-child(2)"));
        WebElement elToRange = driver.findElement(By.cssSelector("#slider-range > span:nth-child(3)"));

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(10))
                .ignoring(NumberFormatException.class)
                .until(driver->{
                    String valueJsFrom = (String)((JavascriptExecutor)driver).executeScript("return document.getElementById('range-from1').value");
                    actions
                            .click(elFromRange)
                            .sendKeys(Keys.ARROW_RIGHT)
                            .build()
                            .perform();

                    System.out.println("until-> " + valueJsFrom);

                    return Integer.parseInt(valueJsFrom) >= from;
                });

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NumberFormatException.class)
                .until(driver->{
                    String valueJsTo = (String)((JavascriptExecutor)driver).executeScript("return document.getElementById('range-to1').value");
                    actions
                            .click(elToRange)
                            .sendKeys(Keys.ARROW_LEFT)
                            .build()
                            .perform();

                    System.out.println("until-> " + valueJsTo);

                    return Integer.parseInt(valueJsTo) <= to;
                });

        driver.findElement(By.cssSelector("#collapse_price > button")).click();
    }

    @Test
    public void filterExactHookahPrice() {
        int from = 1000;
        int to = 3000;

        driver.get(baseUrl);

        driver.findElement(By.cssSelector("#page > div:nth-child(2) > div > div.n-cats.row > div.col-md-4.col-sm-6 > a")).click();

        WebElement elFromRange = driver.findElement(By.cssSelector("#slider-range > span:nth-child(2)"));
        WebElement elToRange = driver.findElement(By.cssSelector("#slider-range > span:nth-child(3)"));

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NumberFormatException.class)
                .until(driver->{
                    String valueJsTo = (String)((JavascriptExecutor)driver).executeScript("return document.getElementById('range-to1').value");
                    if (Integer.parseInt(valueJsTo) < to)
                        return true;

                    actions
                            .dragAndDropBy(elToRange, -1, 0)
                            .build()
                            .perform();

                    System.out.println("until-> " + valueJsTo);

                    return false;
                });

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(180))
                .pollingEvery(Duration.ofMillis(1))
                .ignoring(NumberFormatException.class)
                .until(driver->{
                    String valueJsTo = (String)((JavascriptExecutor)driver).executeScript("return document.getElementById('range-to1').value");
                    if (Integer.parseInt(valueJsTo) >= to)
                        return true;

                    actions
                            .click(elToRange)
                            .sendKeys(Keys.RIGHT)
                            .build()
                            .perform();

                    System.out.println("until-> " + valueJsTo);

                    return false;
                });

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NumberFormatException.class)
                .until(driver->{
                    String valueJsFrom = (String)((JavascriptExecutor)driver).executeScript("return document.getElementById('range-from1').value");
                    if (Integer.parseInt(valueJsFrom) > from)
                        return true;

                    actions
                            .dragAndDropBy(elFromRange, 3, 0)
                            .build()
                            .perform();

                    System.out.println("until-> " + valueJsFrom);

                    return false;
                });

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(1))
                .ignoring(NumberFormatException.class)
                .until(driver->{
                    String valueJsFrom = (String)((JavascriptExecutor)driver).executeScript("return document.getElementById('range-from1').value");
                    if (Integer.parseInt(valueJsFrom) <= from)
                        return true;

                    actions
                            .click(elFromRange)
                            .sendKeys(Keys.LEFT)
                            .build()
                            .perform();

                    System.out.println("until-> " + valueJsFrom);

                    return false;
                });

        driver.findElement(By.cssSelector("#collapse_price > button")).click();
    }

    @AfterClass
    public void setDown() {
//        driver.quit();
    }
}
