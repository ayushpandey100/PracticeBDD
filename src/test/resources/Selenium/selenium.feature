Feature:Seleium Home Page

  Background:A browser is launched with Home Page URL
    Given I launch the base url

@quickSearch
    Scenario: Running a quick check on Documentation link
      When I navigate to the Home page page and click on Documentation link on Home Page
      Then I verify the header information of Downloads page

    Scenario: Running a search context
      When i enter "Selenium" in search field
      Then click on search button to verify results

  Scenario: Running a search using Data table example
    When i enter search data in search field
    |Selenium|
    Then click on search button to verify results

  Scenario Outline: Running a search using Outline example
    When i enter "<Search>" in search field
    Then click on search button to verify results
    Examples:
    |Search|
    |Selenium|
    |TestNg  |
    |Sample  |