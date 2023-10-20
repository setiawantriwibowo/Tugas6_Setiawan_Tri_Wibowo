Feature: Logout
  @Test
  Scenario: Logout dari homepage
    Given User sudah dihomepage
    When user click burger menu
    And User klik logout button
    Then redirect loginpage