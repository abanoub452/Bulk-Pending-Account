package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static StepDefinisions.Hooks.driver;
public class P02_BulkPendingAccound {
    public P02_BulkPendingAccound(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public WebElement astraTechPackage(){return driver.findElement(By.xpath("//*[@id=\"71\"]/td[8]/div/a[2]"));}
    public WebElement importBtn(){return driver.findElement(By.id("importFile"));}
    public WebElement selectAccountName(){return driver.findElement(By.id("select_account_name"));}
    public WebElement selectPhoneNum(){return driver.findElement(By.id("select_phone"));}
    public WebElement selectGender(){return driver.findElement(By.id("select_gender"));}
    public WebElement selectBirthDate(){return driver.findElement(By.id("select_birth_date"));}
    public WebElement selectPassportId(){return driver.findElement(By.id("select_passport_id"));}
    public WebElement selectNationalId(){return driver.findElement(By.id("select_nationality_id"));}
    public WebElement selectSubscription(){return driver.findElement(By.id("select_is_subscribed"));}
    public WebElement selectAddress(){return driver.findElement(By.id("select_address"));}
    //***************************submitForm*****************************************
    public WebElement submitForm(){return driver.findElement(By.id("submitForm"));}
    //******************************Expected Data***************************
    public String expectedUrlResult="https://admin.carelite.app/dashboard/customer_lists/import/getdata";
    public int expectedStatusCode=200;
}
