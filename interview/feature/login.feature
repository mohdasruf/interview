Feature: Booking functionality

  Scenario Outline: Create Booking functionality verification
    Given the user is on booking page
    When the user enters "<firstname>" , "<surname>" , "<price>","<deposit>" and the checkin dates
    Then the corresponding details should be created as a record visible in the page with a delete button

    Examples: 
      | firstname | surname | price | deposit |
      | test1     | test1   | 100   | true    |

  Scenario: Verify delete functionality
    Given the user is on booking page 
    When the user clicks on the delete button if a record exists
    Then the record should be deleted from the page
