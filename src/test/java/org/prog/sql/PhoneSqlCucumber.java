package org.prog.sql;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.Duration;
import java.sql.SQLException;

public class PhoneSqlCucumber {
    private WebDriver driver;
    private String phoneName;
    private String phonePrice;

    @Given("I open the browser and navigate to {string}")
    public void openBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);
    }

    @When("I search for {string}")
    public void searchFor(String searchTerm) throws InterruptedException {
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='search']"));
        searchBox.sendKeys(searchTerm);
        searchBox.sendKeys(Keys.RETURN);
        Thread.sleep(5000);
    }

    @Then("I extract phone name and price")
    public void extractPhoneData() {
        WebElement phoneNameElement = driver.findElement(By.xpath("//div[@class='product-card__content']/a[@class='product-card__title']"));
        WebElement phonePriceElement = driver.findElement(By.xpath("//div[@class='v-pb__cur discount']/span[@class='sum']"));

        phoneName = phoneNameElement.getText().trim();
        phonePrice = phonePriceElement.getText().replaceAll("[^0-9.]", "").trim();
    }

    @And("I save phone name and price to the database")
    public void saveToDatabase() {
        String url = "jdbc:mysql://localhost:3306/db";
        String user = "user";
        String password = "password";

        String query = "INSERT INTO Phones(PhoneName, PhonePrice) VALUES(?,?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            double phonePriceDouble = Double.parseDouble(phonePrice);

            stmt.setString(1, phoneName);
            stmt.setDouble(2, phonePriceDouble);
            stmt.executeUpdate();
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @And("I print the phone details to the console")
    public void printToConsole() {
        System.out.println("Telefon : " + phoneName);
        System.out.println("Cena : " + phonePrice);
        driver.quit();
    }
}

