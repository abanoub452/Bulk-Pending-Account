package StepDefinisions;

import Pages.P02_BulkPendingAccound;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.openqa.selenium.By;
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
    public void verifyData(){
        for (int i = 1; i <= 4; i++) {
            System.out.println("Invalid Data");
            WebElement inavalidData = driver.findElement(By.xpath("//*[@id='medicinesfull']/tbody/tr[" + i + "]"));
            System.out.println(inavalidData.getText());
        }

        Assert.assertEquals(bulkImport.customerAlreadyUsed,bulkImport.customerAlreadyUsed().getText());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        for (int i = 1; i <= 4; i++) {
            System.out.println("Insert New Data");
            WebElement validData = driver.findElement(By.xpath("//*[@id=\"data-table\"]/tbody/tr["+i+"]"));
            System.out.println(validData.getText());
        }
        Assert.assertEquals("Abanoub Naser @",bulkImport.accountName().getText());
        Assert.assertEquals("01001001009",bulkImport.phoneNum().getText());

    }
}
