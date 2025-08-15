Feature: Post pet
  Me as a quality analyst.
  I wish to use the post-pet service
  To validate the creation of a pet

  Background:
    Given that can consume the service

  @PostPet
  Scenario Outline: Creating a successful pet
    When i carry out the validation of the pet "<pet>"
    Then the service responds with status code 200
    And i can validate the pet's name in the response

    Examples:
      | pet  |
      | pet1 |
