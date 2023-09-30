Feature: Test the functionality of TextBox Page

  Scenario Outline: User can submit successfully a TextBox form
    Given User navigate to "https://demoqa.com/text-box" page
    When User complete all the fields with data: "<name>", "<email>", "<address>", "<Paddress>"
    And User click on submit button

    Examples:
      | name  | email        | address | Paddress |
      | Name  | tmm@yahh.com | 123abcd | defff123 |
      | name2 | tmm@yahh.com | 456Aaaa | Dashh125 |
