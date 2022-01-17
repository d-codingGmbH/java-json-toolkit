#
# Copyright (C) 2022 d-coding GmbH
# 
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
# 
#      http://www.apache.org/licenses/LICENSE-2.0
# 
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
# 

Feature: Parse JSON

  Scenario: Parse an empty String
    Given the String ""
    When we parse it
    Then we expect a null

  Scenario: Parse an whitespace String
    Given the String " "
    When we parse it
    Then we expect a null

  Scenario: Parse a true value
    Given the String "true"
    When we parse it
    Then we expect a JSONTrue

  Scenario: Parse a true value with whitespaces
    Given the String " true "
    When we parse it
    Then we expect a JSONTrue

  Scenario: Parse a false value
    Given the String "false"
    When we parse it
    Then we expect a JSONFalse

  Scenario: Parse a null value
    Given the String "null"
    When we parse it
    Then we expect a JSONNull

  Scenario: Parse a string values
    Given the String ""example""
    When we parse it
    Then we expect a JSONString
  
  Scenario Outline: Parse a string with escaped character
    Given a String containing the escaped character <character>
    When we parse it
    Then we expect a JSONString
    And it should have the length of <length>
    
    Examples:
    | character             | length |
    | quotation mark        | 15     |
    | reverse solidus       | 15     |
    | solidus               | 15     |
    | backspace             | 15     | 
    | form feed             | 15     |
    | line feed             | 15     |
    | carriage return       | 15     |
    | character tabulation  | 15     |
    | upper case code point | 15     |
    | lower case code point | 15     |
  
  Scenario Outline: Parse number values
    Format of numbers (see RFC 7159)
    number = /^-?(0|[1-9][0-9]*)(\.[0-9]+)?([eE][+-]?[0-9]+)?$/

    Given the String <input>
    When we parse it
    Then we expect a JSONNumber
    
    Examples:
    | input     |
    | "23"      |
    | "-1"      |
    | "1.0"     |
    | "-2.3"    |
    | "1.2e2"   |
    | "3.1e+3"  |
    | "-0.3E-4" |

  Scenario: Parse an empty object
    Given the String "{}"
    When we parse it
    Then we expect a JSONObject
    And we expect 0 members

  Scenario: Parse an empty array
    Given the String "[]"
    When we parse it
    Then we expect a JSONArray
    And we expect 0 elements

  Scenario: Parse an object with one string member
    Given the String "{"foo":"bar"}"
    When we parse it
    Then we expect a JSONObject
    And we expect 1 members
    And we expect the member "foo" exists
    And we expect the member "foo" is a JSONString

  Scenario: Parse an object with two string members
    Given the String "{"foo":"bar","fu":"baz"}"
    When we parse it
    Then we expect a JSONObject
    And we expect 2 members
    And we expect the member "foo" exists
    And we expect the member "fu" exists
    And we expect the member "foo" is a JSONString
    And we expect the member "fu" is a JSONString

  Scenario: Parse an array with one string member
    Given the String "["foo"]"
    When we parse it
    Then we expect a JSONArray
    And we expect 1 elements
    And we expect the value 1 is a JSONString

  Scenario: Parse an array with two string members
    Given the String "["foo","bar"]"
    When we parse it
    Then we expect a JSONArray
    And we expect 2 elements
    And we expect the value 1 is a JSONString
    And we expect the value 2 is a JSONString

  Scenario: Parse an array with three mixed members
    Given the String "["foo",23,"bar"]"
    When we parse it
    Then we expect a JSONArray
    And we expect 3 elements
    And we expect the value 1 is a JSONString
    And we expect the value 2 is a JSONNumber
    And we expect the value 3 is a JSONString

  Scenario: Parse an object in an object
    Given the String "{"foo":{}}"
    When we parse it
    Then we expect a JSONObject
    And we expect 1 members
    And we expect the member "foo" exists
    And we expect the member "foo" is a JSONObject

  Scenario: Parse an array in an object
    Given the String "{"foo":[]}"
    When we parse it
    Then we expect a JSONObject
    And we expect 1 members
    And we expect the member "foo" exists
    And we expect the member "foo" is a JSONArray

  Scenario: Parse an object in an array
    Given the String "[{}]"
    When we parse it
    Then we expect a JSONArray
    And we expect 1 elements
    And we expect the value 1 is a JSONObject

  Scenario: Parse an invalid number
    Given we expect an exception
    And the String "23.0.0"
    When we parse it
    Then we expect the exception to be of type ParserException

  Scenario: Parse an invalid array
    Given we expect an exception
    And the String "[,23]"
    When we parse it
    Then we expect the exception to be of type ParserException

  Scenario: Parse an object with no member name
    Given we expect an exception
    And the String "{:"bar"}"
    When we parse it
    Then we expect the exception to be of type ParserException

  Scenario: Parse an object with no member value
    Given we expect an exception
    And the String "{"foo":}"
    When we parse it
    Then we expect the exception to be of type ParserException

  Scenario: Parse an object with no name value separator
    Given we expect an exception
    And the String "{"foo""bar"}"
    When we parse it
    Then we expect the exception to be of type ParserException

  Scenario: Parse an object with element seperator
    Given we expect an exception
    And the String "{"foo","bar"}"
    When we parse it
    Then we expect the exception to be of type ParserException

  Scenario: Parse an object with non-string member name
    Given we expect an exception
    And the String "{true:null}"
    When we parse it
    Then we expect the exception to be of type ParserException

  Scenario: Parse an object with an non-lowercase literal
    Given we expect an exception
    And the String <input>
    When we parse it
    Then we expect the exception to be of type ParserException
    
    Examples:
    | input    |
    | "Null"   |
    | "NULL"   |
    | "True"   |
    | "TRUE"   |
    | "False"  |
    | "FALSE"  |
