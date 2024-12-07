@Smoke
  Feature: This is Smoking Test For uploading sheets
    Scenario: Verify Upload EDC.Xsl
      Given open bulk pending account page
      When click on AstraTech Package
      And open import page and upload EDC sheet excel
      And Select account name
      And Select Phone number
      And Select gender
      And Select Date Of Birth
      And Select Subscription
      And Click On Save button
      Then Verify From Response Status Code
      And Verify it redirected to another page to insert data
    Scenario:Verify Upload InvalidDataSheet.Xsl
      Given open bulk pending account page
      When click on AstraTech Package
      And open import page and upload InvalidDataSheet
      And Select account name
      And Select Phone number
      And Select gender
      And Select Date Of Birth
      And Select Subscription
      And Click On Save button
      Then Verify From Response Status Code
      And Verify it redirected to another page to insert data