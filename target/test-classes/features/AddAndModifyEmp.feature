#Author: your.mahady@syntax.com

Feature: AddAndModifyEmployee

@AddnModifyEmp

Scenario: Admin should able to add and modify employe

Given user is logged with valid admin credentials
    And user navigates to AddEmployeePage
    When user enters employees "John" and "Rayhan"
    And user clicks save button
    Then "John Rayhan" is added successfully
    And Click on Edit button    
    
    |First Name|Middle Name|Last Name|License Expiry Date|SSN Number|Gender|Marital Status|Date of Birth|Smoker|
    |Mahady|H|Rayhan|2022-Aug-03|345-434-43433|Male|Married|1965-Aug-23|click|
    And click the save button
    Then Mahdy Hasan Rayhan is added successfully
    


