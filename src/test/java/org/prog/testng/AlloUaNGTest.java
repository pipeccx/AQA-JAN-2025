package org.prog.testng;


import org.testng.annotations.AfterClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

//TODO: create separate test-ng.xml file with this class only
//TODO: move your selenium test to this class
//TODO: Add assertion that goods name is not null
//TODO: Add assertion that goods name has > 0 length

public class AlloUaNGTest {
    private WebDriver driver;
    private WebDriverWait wait;

//    @BeforeClass
//    public void beforeAllo() {
//        System.out.println(">>>>>>>>>>ALLO.START");
//    }
@BeforeClass
public void setUp(){
    System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.manage().window().maximize();
}
//    @AfterClass
//    public void afterAllo() {
//        System.out.println(">>>>>>>>>>ALLO.END");
//    }
//
//    @BeforeMethod
//    public void beforeMethod() {
//        System.out.println("Test!<<<<<<<<<<<<<<<<<<<<");
//    }
//
//    @AfterMethod
//    public void afterMethod() {
//        System.out.println("Test!<<<<<<<<<<<<<<<<<<<<");
//    }

    @Test
    public void testSearchForPhone() {
    driver.get("https://allo.ua/");
        System.out.println("found");
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("search")));
        searchBox.sendKeys("Xiaomi");
        searchBox.submit();
        WebElement firstPhone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id=\"__layout\"]/div/div[1]/div[2]/div/div[2]/div[2]/div[1]/div/div[3]/a")));
String phoneName = firstPhone.getText();
System.out.println("First phone in search is: " +phoneName);
        Assert.assertNotNull(phoneName, "Should not be NULL");
        Assert.assertTrue(phoneName.length() > 0, "Name should be more than one symbol");
    }
    @AfterClass
    public void tearDown(){
    if (driver != null){
        driver.quit();
    }
    }
}
