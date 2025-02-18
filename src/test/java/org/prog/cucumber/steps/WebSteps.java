package org.prog.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WebSteps {

    public static WebDriver driver;

    @Given("I load W3Shcools Page")
    public void loadPage() {
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_images_trulli");
    }

    @When("I accept cookies if present")
    public void acceptCookies() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        WebElement acceptCookiesButton =
                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accept-choices")));
        acceptCookiesButton.click();
    }

    @Then("I can see content of iFrame")
    public void confirmIframe() {
        List<WebElement> imagesEmpty = driver.findElements(By.xpath("//img[@src='pic_trulli.jpg']"));
        Assert.assertTrue(imagesEmpty.isEmpty(),
                "Expected list of images to eb empty because image is in iframe!");
        WebElement iframe = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(iframe);
        List<WebElement> imagesPresent = driver.findElements(By.xpath("//img[@src='pic_trulli.jpg']"));
        Assert.assertFalse(imagesPresent.isEmpty(),
                "Expected list of images to be NOT empty because selenium is INSIDE iframe!");
    }
}
