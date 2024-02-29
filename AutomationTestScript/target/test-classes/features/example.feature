Feature: Login Feature

  Scenario Outline: Login
    Given I am on the login page
    When I enter "<username type>" username : "<username_Or_email>"  and "<password type>" password : "<password>"
    And I click the login button
    Then I should be "<loginResult>"

    Examples:
      | username_Or_email        | password | username type | password type | loginResult   |
      | usercombi                | 1        | valid         | valid         | logged-In     |
      | usercombi@mailinator.com | 1        | valid         | valid         | logged-In     |
      | usercombi@mailinator.com | 123467   | valid         | invalid       | not logged-In |
      | Xyz@1234                 | 1        | invalid       | valid         | not logged-In |
      | usercombi                | 123@Xyyz | valid         | invalid       | not logged-In |
      | Xyz@123                  | Xyz@123  | invalid       | invalid       | not logged-In |
      | usercombi@mailinator.com |          | valid         | invalid       | not logged-In |
      |                          | 1        | invalid       | valid         | not logged-In |
      |                          |          | invalid       | invalid       | not logged-In |
      | usercombi                |          | valid         | invalid       | not logged-In |


  Scenario: printFinalResults
    Given print the result


