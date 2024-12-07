package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static StepDefinisions.Hooks.driver;
public class P01_login {
  public WebElement email(){
    By email = By.id("email");
    WebElement enterEmail = driver.findElement(email);
    return enterEmail;
  }
  public WebElement password(){
    By pass = By.id("password");
    WebElement enterPass = driver.findElement(pass);
    return enterPass;
  }
  public WebElement loginBtn(){return driver.findElement(By.xpath("//button[contains(text(),'Login')]"));}
  //login Functions
  public void loginStep(String email , String password){
    email().sendKeys(email);
    password().sendKeys(password);
    loginBtn().click();
  }
}

