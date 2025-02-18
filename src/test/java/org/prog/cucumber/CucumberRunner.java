package org.prog.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.cucumber.steps.SqlSteps;
import org.prog.cucumber.steps.WebSteps;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.sql.DriverManager;
import java.sql.SQLException;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.prog.cucumber.steps"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void setUp() throws ClassNotFoundException, SQLException {
        WebSteps.driver = new ChromeDriver();
        Class.forName("com.mysql.cj.jdbc.Driver");
        SqlSteps.connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");
    }

    @AfterSuite
    public void tearDown() throws SQLException {
        SqlSteps.connection.close();
        if (WebSteps.driver != null) {
            WebSteps.driver.quit();
        }
    }
}