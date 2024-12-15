@Smoke
Feature: This is Smoking Test For verifying in data validation
  Scenario: Verify From Valid Data
    Given open bulk pending account page
    When click on AstraTech Package
    And open import page and upload Bulk-import_Customer list.xlsx
    And Select account name
    And Select Phone number
    And Select gender
    And Select Subscription
    And Select National Id
    And Click On Save button
    Then Verify From Response Status Code
    And Verify it redirected to another page to insert data
    And Verify From Names & Phones
