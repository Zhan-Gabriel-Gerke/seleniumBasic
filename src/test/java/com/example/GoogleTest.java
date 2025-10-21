package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

class GoogleTest {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @Test
    void seleniumTest() {

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.findElement(By.id("my-text-id")).sendKeys("Selenium");
        driver.findElement(By.name("my-password")).sendKeys("1234");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        assertTrue(msg.getText().contains("Received!"));
    }

    @Test
    void titleTetest() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        assertTrue(title.toLowerCase().contains("google"));
        driver.quit();
    }
}