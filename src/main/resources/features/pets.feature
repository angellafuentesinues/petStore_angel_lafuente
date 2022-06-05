Feature: Pets operability

#  @pets
#  Scenario: Validate that the response of the pets request is 200
#    Given the following get request that brings us the pets
#    And the response is 200





  @AddPet
  Scenario: Validate that the response of the pets add a pet
    Given the following get request that add a new pet
    And the response is 200

  @FindpetByID
  Scenario: Validate that the response of the pets request is 200
    Given the following get request that find a pet by ID
    And the response is 200

  @UpdatePet
  Scenario: Validate that the response of the pets update a pet
    Given the next put request that update a pet
    And the response is 200

  @deletePet
  Scenario: Validate delete a pet
    Given the following delete that erase a pet
    And the response is 200 for the delete