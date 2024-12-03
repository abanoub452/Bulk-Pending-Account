package StepDefinisions;

import Pages.P02_BulkPendingAccound;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static StepDefinisions.Hooks.driver;

public class D02_VerifyDataSheet {
    P02_BulkPendingAccound bulkImport = new P02_BulkPendingAccound();
    @And("open import page and upload Bulk-import_Customer list.xlsx")
    public void ImportSheet(){
        bulkImport.importBtn().sendKeys("C:\\New Project\\Pulk_Pending_Account\\Files_Test\\Bulk-import_Customerlist.xlsx");
    }
    @And("Verify From Names & Phones")
    public void catchValidData(){
        Assert.assertEquals(bulkImport.expectedCustomerAlreadyFound,bulkImport.customerAlreadyFound().getText());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Assert.assertEquals("Abanoub Naser @",bulkImport.accountName().getText());
        Assert.assertEquals("01001001009",bulkImport.mobileNum().getText());
    }




}
