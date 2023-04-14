Feature: User
  As an admin
  I want to see list of user
  So that I can create new user

  Scenario: Get As admin I have be able to get detail data
    Given I set GET endpoints
    When I send GET HTTP request
    Then I receive valid HTTP response code 200
    And I receive valid data for detail user

    Scenario: POST As admin I have be able to create new data
      Given I set POST api endpoints
      When I send POST HTTP request
      Then I receive valid HTTP response code 201
      And I receive valid data for new user

      Scenario: PUT As admin I have be able to update existing data
          Given I set PUT api endpoints
          When I send PUT HTTP request
          Then I receive valid HTTP response code 200
          And I receive valid data for update user

          Scenario: DELETE As admin I have be able to delete existing data
            Given I set DELETE api endpoints
            When I send DELETE HTTP request
            Then I receive valid HTTP response code 200


