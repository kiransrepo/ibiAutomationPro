@Sanity
Feature: Inner Circle Page Smoke Test

  Scenario: Creating a Post In Inner Cricle
  Given Login into Ibi webapp
  Then User lands on innercircle page
  And Clicks on Post to inner cricle button
  Then User selects few contents 
  And Clicks on Post to Inner circle 
  Then Verfiy Post Created toast message is displayed
  

  Scenario: Add description,Like and Comment to an Inner cricle Post
  Given Login into Ibi webapp
  When User lands on innercircle page
  Then Click on add description field and enter some random description
  And Click on Save 
  Then Click on Like icon and Verify like is reflected
  Then Click on comments section and add some comments.
  Then Verify entered Comments are reflecting
  Then Edit entered comments and do verify they are reflecting
  And Delete the entered comments
  
   
  Scenario: Add description,Like and Comment to an Inner cricle Post
  Given Login into Ibi webapp
  When User lands on innercircle page
  Then Remove an existing post from innerCircle

  
  
    
