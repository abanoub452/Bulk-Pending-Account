package StepDefinisions;

import Pages.P01_login;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver;
    P01_login login =new P01_login();
    @Before
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Navigate
        driver.navigate().to("https://admin.carelite.app/login");
        login.loginStep("admin@gmail.com","admin");
    }

    @After
    public void quitDriver() throws InterruptedException {
        Thread.sleep(1000);
        //quit driver
        driver.quit();
    }
}
