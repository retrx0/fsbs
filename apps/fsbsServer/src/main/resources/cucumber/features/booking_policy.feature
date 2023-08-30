Feature: Booking Policy
  Policy to allow booking depending on clients requirements

  Scenario: Client is not accepting new booking
    Given There is a client
    When New customers want to book a slot
    Then Deny booking service


  Scenario Outline: Client is accepting new booking with some Id
    Given There is a client
    When New customers want to book a slot
    Then Deny booking service

    Examples: | bookingId1 | bookingId2 |
    | 10         | 11          |