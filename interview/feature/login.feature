Feature: Login functionality

  Scenario Outline: unsuccessfull login with incorrect user id and password
    Given the user is on facebook page
    When the user enters "<username>" and "<password>"
    Then the login should fail

    Examples: 
      | username | password |
      | test1    | test1    |
