@users
Feature: Users operability

  @users
  Scenario: Validate that the response of the user request is 200
    Given the next get request that brings us the users
    #And the response is 200


  @AddUser
  Scenario: Validate that the response of the post add an user
    Given the following post request that add a new user
    #And the response is 200 for the addPost


  @UpdateUser
  Scenario: Validate that the response of the put update an user
    Given the next put request that update an user
    # And the response is 200

  @DeleteUser
  Scenario: Validate that the response of the delete request is 200
    Given the next delete request that erase an user




