Feature: Login di https://www.saucedemo.com/

  @Test
  Scenario: Success Login
    Given halaman login saucedemo
    When input username
    And input password
    And user click button login
    Then user redirect to swag labs page

  @Test
  Scenario: Failed Login
    Given halaman login saucedemo
    When input username
    And input invalid password
    And user click button login
    Then user get error message

