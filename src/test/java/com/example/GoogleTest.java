package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class GoogleTest {
    WebDriver driver = new ChromeDriver();
    WebDriver wait = new WebDriverWait(driver, duration.ofSeconds(5));

    @Test
    void seleniumTest() {

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.findElement(By.id("my-text-id")).sendKeys("Selenium");
        driver.findElement(By.name("my-password")).sendKeys("1234");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebDriver msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        assertTrue(msg.getText().containt("Received!"));
    }

    @Test
    void titleTetest() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        assertTrue(title.toLowerCase().contains("google"));
        driver.quit();
    }
}