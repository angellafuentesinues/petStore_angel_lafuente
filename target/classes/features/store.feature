@store
Feature: Store operability
  @store
  Scenario: Validate that the response of the store request is 200
    Given the following get request that brings us a purchase order

  @AddOrder
  Scenario: Validate that the response of the store add an a order
    Given the following post request that add a new order

  @StatusCode
  Scenario: Validate that the response of the store request is 200
    Given the following get request that returns us statusCode

  @deleteOrder
  Scenario: Validate delete order
    Given the next delete that erase an order
    And the response is 200 for the erase