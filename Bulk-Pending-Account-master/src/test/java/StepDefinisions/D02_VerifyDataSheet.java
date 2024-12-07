package StepDefinisions;

import Pages.P02_BulkPendingAccound;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static StepDefinisions.Hooks.driver;

public class D02_VerifyDataSheet {
    P02_BulkPendingAccound bulkImport = new P02_BulkPendingAccound();
    @And("open import page and upload Bulk-import_Customer list.xlsx")
    public void uploadBulkImportSheet(){
        bulkImport.importBtn().sendKeys("C:\\Users\\classic\\IdeaProjects\\Bulk-Pending-Account-master\\Files_Test\\Bulk-import_Customerlist.xlsx");
    }
    @And("Select National Id")
    public void selectNationalId(){
        Select nationalId = new Select(bulkImport.selectNationalId());
        nationalId.selectByVisibleText("national_id");
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
