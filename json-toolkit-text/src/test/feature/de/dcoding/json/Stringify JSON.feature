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

Feature: Stringify json

  Scenario: Stringify a true value
    Given we have a JSON true
    When we convert it to a String
    Then we expect "true"

  Scenario: Stringify a false value
    Given we have a JSON false
    When we convert it to a String
    Then we expect "false"

  Scenario: Stringify a null value
    Given we have a JSON null
    When we convert it to a String
    Then we expect "null"

  Scenario Outline: Stringify a number value
    Given we have the JSON number <value>
    When we convert it to a String
    Then we expect <expected>

    Examples: 
      | value | expected |
      | 23    | "23"     |
      | 1.0   | "1.0"    |
      | -2.3  | "-2.3"   |
      | 1.2e2 | "1.2e2"  |

  Scenario: Stringify a string value
    Given we have the JSON string "example"
    When we convert it to a String
    Then we expect ""example""
    
  Scenario Outline: Stringify special characters
    Given we have a JSON string representing the code point <code point>
    When we convert it to a String
    Then we expect the length <length>
   
    Examples:
    | code point | length |
    | "U+0022"   | 4      |
    | "U+005C"   | 4      |
    | "U+002F"   | 3      |
    | "U+0008"   | 4      |
    | "U+000C"   | 4      |
    | "U+000A"   | 4      |
    | "U+000D"   | 4      |
    | "U+0009"   | 4      |
    | "U+0000"   | 8      |
    | "U+0001"   | 8      |
    | "U+0010"   | 8      |
    | "U+001F"   | 8      |

  Scenario: Stringify an empty object
    Given we have a JSON object
    When we convert it to a String
    Then we expect "{}"

  Scenario: Stringify an empty array
    Given we have a JSON array
    When we convert it to a String
    Then we expect "[]"

  Scenario: Stringify an object with one string element
    Given we have a JSON object
    And we set the property "foo" to value "bar"
    When we convert it to a String
    Then we expect "{"foo":"bar"}"

  Scenario: Stringify an object with one integer element
    Given we have a JSON object
    And we set the property "foo" to value 23
    When we convert it to a String
    Then we expect "{"foo":23}"

  Scenario: Stringify an object with two string elements
    Given we have a JSON object
    And we set the property "foo" to value "bar"
    And we set the property "foo2" to value 23
    When we convert it to a String
    Then we expect "{"foo":"bar","foo2":23}"

  Scenario: Stringify a nested object
    Given we have a JSON object
    And we set the property "foo" to an empty JSON object
    When we convert it to a String
    Then we expect "{"foo":{}}"

  Scenario: Stringify an with an array
    Given we have a JSON object
    And we set the property "foo" to an empty JSON array
    When we convert it to a String
    Then we expect "{"foo":[]}"

  Scenario: Stringify an array with one number
    Given we have a JSON array
    And we add the number 23
    When we convert it to a String
    Then we expect "[23]"

  Scenario: Stringify an array with two numbers
    Given we have a JSON array
    And we add the number 23
    And we add the number 42
    When we convert it to a String
    Then we expect "[23,42]"

  Scenario: Stringify an array an empty object
    Given we have a JSON array
    And we add an empty JSON object
    When we convert it to a String
    Then we expect "[{}]"

  Scenario: Stringify a nested array
    Given we have a JSON array
    And we add an empty JSON array
    When we convert it to a String
    Then we expect "[[]]"
