Feature: Get users

  Scenario: Get all users
    Given Sergey is the marketing director
    When he asks for all the clients registered
    Then he should see all the clients registered