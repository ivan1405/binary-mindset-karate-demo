Feature: Test operations with projects

  Background:

    * url apiBasePath

  Scenario: get projects should return 200 and list with projects

    Given path 'projects'
    When method GET
    Then status 200
    Then match each $ contains { projectId: '#number' }
    And assert response.length == 2
    * def projectId = response[0].projectId
    * print projectId

    Given path 'projects/' + projectId
    When method GET
    Then status 200