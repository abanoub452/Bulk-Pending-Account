package StepDefinisions;
import Pages.P02_BulkPendingAccound;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static StepDefinisions.Hooks.driver;

public class D01_UploadValidSheets {
    P02_BulkPendingAccound bulkImport = new P02_BulkPendingAccound();
    @Given("open bulk pending account page")
    public void openPulkBendingPage(){
        driver.navigate().to("https://admin.carelite.app/dashboard/customer_lists/import/group_packages");
    }
   @When("click on AstraTech Package")
    public void enterAstraTechPackage(){
        bulkImport.astraTechPackage().click();
   }
   @And("open import page and upload EDC sheet excel")
    public void ImportSheet(){
        bulkImport.importBtn().sendKeys("C:\\New Project\\Pulk_Pending_Account\\Files_Test\\EBC.xlsx");
   }
   @And("Select account name")
    public void selectAccountName(){
       Select accuntname = new Select(bulkImport.selectAccountName());
       accuntname.selectByVisibleText("full_name");
   }
   @And("Select Phone number")
    public void selectPhoneNum(){
       Select phone = new Select(bulkImport.selectPhoneNum());
       phone.selectByVisibleText("mobile");
   }
   @And("Select gender")
    public void selectGender(){
       Select gender = new Select(bulkImport.selectGender());
       gender.selectByVisibleText("gender");
   }
   @And("Select Date Of Birth")
    public void selectBirthOfDate(){
       Select BOD = new Select(bulkImport.selectBirthDate());
       BOD.selectByVisibleText("date_of_birth");
   }
   @And("Select Subscription")
    public void selectSubscription(){
       Select subscription = new Select(bulkImport.selectSubscription());
       subscription.selectByVisibleText("subscription");
   }
  @And("Select National Id")
    public void selectNationalId(){
       Select nationalId = new Select(bulkImport.selectNationalId());
       nationalId.selectByVisibleText("national_id");
   }
   @And("Click On Save button")
    public void clickOnSaveBtn() throws InterruptedException {
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,1000)");
       bulkImport.submitForm().click();
   }
   @Then("Verify From Response Status Code")
    public void statusCode(){
       String url = "https://admin.carelite.app/dashboard/customer_lists/import/match_columns_update";
       int responseCode = RestAssured.get(url).statusCode();
       System.out.println("HTTP Response Code: " + responseCode);
       Assert.assertEquals(bulkImport.expectedStatusCode,responseCode);
   }
   @And("Verify it redirected to another page to insert data")
    public void insertingDataPage() {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
       boolean isUrlCorrect = wait.until(ExpectedConditions.urlToBe(bulkImport.expectedUrlResult));
       String url= driver.getCurrentUrl();
       int urlStatusCode =RestAssured.get(url).statusCode();
       Assert.assertTrue("The page was not redirected to the expected URL.", isUrlCorrect);
       Assert.assertEquals(bulkImport.expectedStatusCode,urlStatusCode);
   }
   //Scenario 2
   @And("open import page and upload InvalidDataSheet")
   public void importInvalidDataSheet(){
       bulkImport.importBtn().sendKeys("C:\\New Project\\Pulk_Pending_Account\\Files_Test\\InvalidDataSheet.xlsx");
   }
}
