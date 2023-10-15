Feature: Test the functionality of YouTube Page


  Scenario: User can interact successfully with YouTube page
    Given User navigate to "https://www.youtube.com/" page
    And User click on YouTube dialog box
    And User type "test json" in the search box
    And User click on search box
    And User click on second page

