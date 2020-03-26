Feature: Test operations with tasks

  Background:

    * url apiBasePath

  Scenario: get tasks should return 200 and list with tasks

    Given path 'projects/1/tasks'
    When method GET
    Then status 200
    Then match each $ contains { taskId: '#number' }
    * def taskId = $[1].taskId
    * print taskId

    Given path 'projects/1/tasks/' + taskId
    When method GET
    Then status 200