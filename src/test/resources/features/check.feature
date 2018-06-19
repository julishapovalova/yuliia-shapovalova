@login
Feature: feature name
  As a [role]
  I want [feature]
  So that [benefit/business reason]

  Scenario: Initiate instance for test
    Given In "CHROME" browser in session '001'
    When I login as "Yuliia"
    Then HomePage avaliable

#    Scenario:i sent email for myself
#      Given I login as "Yuliia"
#      When I send mail "Hello, world" for 'Yuliia'
#      Then I see current email INBOX