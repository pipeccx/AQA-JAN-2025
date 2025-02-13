package org.prog.sql;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;

public class PhoneSql {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        try {
            driver.get("https://allo.ua/");
            WebElement searchBox = driver.findElement(By.xpath("//input[@name='search']"));
            searchBox.sendKeys("iPhone");
            searchBox.sendKeys(Keys.RETURN);
            Thread.sleep(5000);

            WebElement phoneNameElement = driver.findElement(By.xpath("//div[@class='product-card__content']/a[@class='product-card__title']"));
            WebElement phonePriceElement = driver.findElement(By.xpath("//div[@class='v-pb__cur discount']/span[@class='sum']"));

            String phoneName = phoneNameElement.getText().trim();
            String phonePrice = phonePriceElement.getText().replaceAll("[^0-9.]","").trim();

            System.out.println("telefon: " + phoneName);
            System.out.println("cena: " + phonePrice);

            saveToDatabase(phoneName, phonePrice);
            System.out.println("estj v DBeaver");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static void saveToDatabase(String phoneName, String phonePrice) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("price error: " + phonePrice);
            e.printStackTrace();
        }
    }
}

