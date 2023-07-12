Feature: Consult user

  @successfulQuery
  Scenario: Query user by id
    #Given I can query the users api "dev"
    When Querying user with id 2
    Then The service answers me status code 200

  @v2
  Scenario Outline: Query user by id version2 with id <id> and statusCode <statusCode>
    #Given I can query the users api "dev"
    When Querying user with id <id>
    Then The service answers me status code <statusCode>

    Examples:
      | id   | statusCode |
      | 2    | 200        |
      | 3    | 202        |
      | 4    | 200        |
      | 5    | 200        |
      | 1000 | 404        |

