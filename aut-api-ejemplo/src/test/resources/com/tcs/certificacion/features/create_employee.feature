Feature: Create employee

  @createv1 @lessEfficient
  Scenario Outline: Create an employee another form
    #Given I can query the users api "dev"
    When When i create the employee with the data name "<name>" and "<job>"
    Then The service answers me status code <statusCode>
    And Return and validate the name "<name>" of employee

    Examples:
      | name       | job       | statusCode |
      | Juan Pablo | Analyst   | 201        |
      | Sebastian  | Tech Lead | 201        |

  @createv2
  Scenario Outline: Create an employee
    Given Upload the data test
      | name   | job   | statusCode   |
      | <name> | <job> | <statusCode> |
    When I create the employee
    Then The service answers me status code <statusCode>

    Examples:
      | name | job        | statusCode |
      | juan | qa analyst | 201        |

  @createv3
  Scenario Outline: Create an employee
    #Given I can query the users api "dev"
    When I create the employee with the data
      | name   | job   |
      | <name> | <job> |
    Then The service answers me status code <statusCode>
    And Return and validate the name "<name>" of employee

    Examples:
      | name | job | statusCode |
      | Juan | QA  | 201        |