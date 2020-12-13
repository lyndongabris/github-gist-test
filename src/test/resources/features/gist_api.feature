Feature: GIST API

#   Test 1 - Create a new GIST
  Scenario: Description is correct for a created GIST
    Given a new GIST is POSTed to the GitHub GIST API
    When performing a GET on the created GIST
    Then the description matches the original value

#  Test 1 - Create a new GIST
  Scenario: Filename is correct for a created GIST
    Given a new GIST is POSTed to the GitHub GIST API
    When performing a GET on the created GIST
    Then the filename matches the original value

#  Test 1 - Create a new GIST
  Scenario: File contents is correct for a created GIST
    Given a new GIST is POSTed to the GitHub GIST API
    When performing a GET on the created GIST
    Then the content matches the original value

#  Test 2 - Get all GISTs for your user
  Scenario: Created GIST is present in list of GISTs for user
    Given a new GIST is POSTed to the GitHub GIST API and verified
    When performing a GET to list all GISTs for a user
    Then the new GIST is present in the list

#   Test 3 - Update an existing GIST
  Scenario: Created GIST can be updated successfully
    Given a new GIST with two files is POSTed to the GitHub GIST API
    When performing a PATCH to update the created GIST
    Then the update has been completed as expected

#   Test 4 - Delete a GIST
  Scenario: A GIST can be deleted successfully
    Given a new GIST is POSTed to the GitHub GIST API
    When performing a DELETE action on the previously created GIST
    Then a 404 is returned when performing a GET for the GIST