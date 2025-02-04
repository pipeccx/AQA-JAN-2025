package org.prog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

//TODO: go to allo.ua
//TODO: search for ANY PHONE
//TODO: print phone name for 1st phone in search
//TODO: For example: Apple iPhone 16 Pro Max 256GB Desert Titanium (MYWX3)
public class SeleniumHomeWork {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
            driver.get("https://allo.ua/");

            WebElement searchBox = driver.findElement(By.name("search"));
            searchBox.sendKeys("Nokia");
            searchBox.submit();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement firstPhone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id=\"__layout\"]/div/div[1]/div[2]/div/div[2]/div[2]/div[1]/div/div[3]/a")));
System.out.println("First phone in search: " + firstPhone.getText());

        driver.quit();
                    }

        }

        