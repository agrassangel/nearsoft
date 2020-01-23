Feature: Test


  Scenario: Search fly
    Given User open system
    When user create a new search
    And system open new page search
    And system show price
    And user sort by "Price (Highest)"
    Then The price are correct sorting














#  Background:
#    Given Initialize
#
#  Scenario: number 1 check array is sorting
#    When system sort
#    Then array is sorting

#  Scenario: number 2
#    When system sort
#    Then array is sorting
#
#  Scenario: number 3
#    When system sort
#    Then array is sorting
#
#  Scenario: number 4
#    When system sort
#    Then array is sorting
#
#  Scenario: number 5
#    When system sort
#    Then array is sorting