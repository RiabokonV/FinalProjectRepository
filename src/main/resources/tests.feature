Feature: BBCtests
  As a user
  I want to test news lines and question form of site

  Scenario Outline: Check text of headline
    Given User opens '<homePage>' page
    When User click on news button
    Then User check correct '<text>' at Headline

    Examples:
      | homePage             | text                                               |
      | https://www.bbc.com/ | Anxious wait for news after tsunami cuts off Tonga |

  Scenario Outline: Check text of lines
    Given User opens '<homePage>' page
    When User click on news button
    And User close signInMessage
    Then User check correct text of lines

    Examples:
      | homePage             |
      | https://www.bbc.com/ |

  Scenario Outline: Check search by headline category
    Given User opens '<homePage>' page
    When User click on news button
    And User close signInMessage
    And User make search by category of headline
    Then User check correct '<text>' of first line

    Examples:
      | homePage             | text                |
      | https://www.bbc.com/ | At The Edge of Asia |

  Scenario Outline: Check question error message
    Given User opens '<homePage>' page
    When User click on news button
    And User close signInMessage
    And User click on coronavirus button
    And User click on yourStories button
    And User click on question button
    And User send incorrect values to form
    Then User see question error message

    Examples:
      | homePage             |
      | https://www.bbc.com/ |

  Scenario Outline: Check name error message
    Given User opens '<homePage>' page
    When User click on news button
    And User close signInMessage
    And User click on coronavirus button
    And User click on yourStories button
    And User click on question button
    And User send incorrect values to form
    Then User see name error message

    Examples:
      | homePage             |
      | https://www.bbc.com/ |

  Scenario Outline: Check name error message
    Given User opens '<homePage>' page
    When User click on news button
    And User close signInMessage
    And User click on coronavirus button
    And User click on yourStories button
    And User click on question button
    And User send incorrect values to form
    Then User see email error message

    Examples:
      | homePage             |
      | https://www.bbc.com/ |