Feature: Iam doing automation of add skills in OrangeHRM

Background: Common Steps
Given User opens chrome browser
Then  User opens URL"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

Scenario: Add Skills
Given User entres Username as "Admin" and Password as "admin123"
When User creates Skills record
  |Skill007|Skill007 desc|
  |Skill008|Skill008 desc|
Then User close browser