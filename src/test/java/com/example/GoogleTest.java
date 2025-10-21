package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class GoogleTest {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @BeforeEach
    public void setup() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @AfterEach
    void finish() {
        driver.close();
        driver.quit();
    }

    @Test
    void seleniumTest() {


        driver.findElement(By.id("my-text-id")).sendKeys("Selenium");
        driver.findElement(By.name("my-password")).sendKeys("1234");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        assertTrue(msg.getText().contains("Received!"));
    }

    @Test
    void selectDropdown_setValue(){
        Select select = new Select(driver.findElement(By.name("my-select")));
        select.selectByVisibleText("Two");
        assertEquals("2", select.getFirstSelectedOption().getAttribute("value"));
    }

    @Test
    void radio_choseOne(){
        WebElement r1 = driver.findElement(By.id("my-radio-1"));
        WebElement r2 = driver.findElement(By.id("my-radio-2"));
        r2.click();
        assertTrue(r2.isSelected());
        assertFalse(r1.isSelected());
    }

    @Test
    void range(){
        WebElement range = driver.findElement(By.name("my-range"));
        range.sendKeys(Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT);
        String v = range.getAttribute("value");
        assertNotNull(v);
        assertTrue(Integer.parseInt(v)>0);
    }

    /*@Test
    void titleTetest() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        assertTrue(title.toLowerCase().contains("google"));
        driver.quit();
    }*/
}