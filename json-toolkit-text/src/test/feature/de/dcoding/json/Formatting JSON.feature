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

Feature: Formatting JSON

  Scenario: Add space after empty object begin
    Given the String "{}"
    And we add space after object begin
    When we parse it
    And we convert it to a formatted String
    Then we expect "{ }"

  Scenario: Add space before empty object end
    Given the String "{}"
    And we add space before object end
    When we parse it
    And we convert it to a formatted String
    Then we expect "{ }"

  Scenario: Add spaces after empty object begin and before empty object end
    Given the String "{}"
    And we add space after object begin
    And we add space before object end
    When we parse it
    And we convert it to a formatted String
    Then we expect "{ }"

  Scenario: Add space after object begin
    Given the String "{"alice":"bob"}"
    And we add space after object begin
    When we parse it
    And we convert it to a formatted String
    Then we expect "{ "alice":"bob"}"

  Scenario: Add space before object end
    Given the String "{"alice":"bob"}"
    And we add space before object end
    When we parse it
    And we convert it to a formatted String
    Then we expect "{"alice":"bob" }"

  Scenario: Add spaces after object begin and before object end
    Given the String "{"alice":"bob"}"
    And we add space after object begin
    And we add space before object end
    When we parse it
    And we convert it to a formatted String
    Then we expect "{ "alice":"bob" }"

  Scenario: Add space between name and name value separator
    Given the String "{"alice":"bob"}"
    And we add space before name value separator
    When we parse it
    And we convert it to a formatted String
    Then we expect "{"alice" :"bob"}"

  Scenario: Add space between name value separator and value
    Given the String "{"alice":"bob"}"
    And we add space after name value separator
    When we parse it
    And we convert it to a formatted String
    Then we expect "{"alice": "bob"}"

  Scenario: Add space before member separator
    Given the String "{"alice":"bob","charlie":"david"}"
    And we add space before member separator
    When we parse it
    And we convert it to a formatted String
    Then we expect "{"alice":"bob" ,"charlie":"david"}"

  Scenario: Add space after member separator
    Given the String "{"alice":"bob","charlie":"david"}"
    And we add space after member separator
    When we parse it
    And we convert it to a formatted String
    Then we expect "{"alice":"bob", "charlie":"david"}"

  Scenario: Add newline after object begin
    Given the String "{}"
    And we add newline after object begin
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      {
      }
      """

  Scenario: Add newline before object end
    Given the String "{}"
    And we add newline before object end
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      {
      }
      """

  Scenario: Add newline and space after object begin
    Given the String "{}"
    And we add newline after object begin
    And we add space after object begin
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      {
      }
      """

  Scenario: Add newline and space before object end
    Given the String "{}"
    And we add newline before object end
    And we add space before object end
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      {
      }
      """

  Scenario: Add newline after object begin and space before object end
    Given the String "{}"
    And we add newline after object begin
    And we add space before object end
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      {
      }
      """

  Scenario: Add space after object begin and newline before object end
    Given the String "{}"
    And we add space after object begin
    And we add newline before object end
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      {
      }
      """

  Scenario: Add newline after object begin and space before object end
    Given the String "{}"
    And we add newline after object begin
    And we add space before object end
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      {
      }
      """

  Scenario: Add newline after object begin
    Given the String "{"alice":"bob"}"
    And we add newline after object begin
    And we set indention to 0 spaces
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      {
      "alice":"bob"}
      """

  Scenario: Add newline after object begin and before object end
    Given the String "{"alice":"bob"}"
    And we add newline after object begin
    And we add newline before object end
    And we set indention to 0 spaces
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      {
      "alice":"bob"
      }
      """

  Scenario: Set indention
    Given the String "{"alice":"bob"}"
    And we set indention to 2 spaces
    When we parse it
    And we convert it to a formatted String
    Then we expect "{"alice":"bob"}"

  Scenario: Add newline after object begin and indention
    Given the String "{"alice":"bob"}"
    And we add newline after object begin
    And we set indention to 2 spaces
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      {
        "alice":"bob"}
      """

  Scenario: Add newline after object begin and indention
    Given the String "{"alice":"bob"}"
    And we add newline after object begin
    And we set indention to 4 spaces
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      {
          "alice":"bob"}
      """

  Scenario: Add newline after object begin and member separator
    Given the String "{"alice":"bob","charlie":"david"}"
    And we add newline after object begin
    And we add newline after member separator
    And we set indention to 2 spaces
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      {
        "alice":"bob",
        "charlie":"david"}
      """

  Scenario: Add newline after object begin and before object end and set indention
    Given the String "{"alice":{"bob":"charlie"}}"
    And we add newline after object begin
    And we add newline before object end
    And we set indention to 2 spaces
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      {
        "alice":{
          "bob":"charlie"
        }
      }
      """

  Scenario: Add space after empty array begin
    Given the String "[]"
    And we add space after array begin
    When we parse it
    And we convert it to a formatted String
    Then we expect "[ ]"

  Scenario: Add space before array object end
    Given the String "[]"
    And we add space before array end
    When we parse it
    And we convert it to a formatted String
    Then we expect "[ ]"

  Scenario: Add spaces after empty array begin and before empty array end
    Given the String "[]"
    And we add space after array begin
    And we add space before array end
    When we parse it
    And we convert it to a formatted String
    Then we expect "[ ]"

  Scenario: Add space after array begin
    Given the String "["alice"]"
    And we add space after array begin
    When we parse it
    And we convert it to a formatted String
    Then we expect "[ "alice"]"

  Scenario: Add space before array end
    Given the String "["alice"]"
    And we add space before array end
    When we parse it
    And we convert it to a formatted String
    Then we expect "["alice" ]"

  Scenario: Add spaces after array begin and before array end
    Given the String "["alice"]"
    And we add space after array begin
    And we add space before array end
    When we parse it
    And we convert it to a formatted String
    Then we expect "[ "alice" ]"

  Scenario: Add space before value separator
    Given the String "["alice","bob"]"
    And we add space before value separator
    When we parse it
    And we convert it to a formatted String
    Then we expect "["alice" ,"bob"]"

  Scenario: Add space after value separator
    Given the String "["alice","bob"]"
    And we add space after value separator
    When we parse it
    And we convert it to a formatted String
    Then we expect "["alice", "bob"]"

  Scenario: Add newline after array begin
    Given the String "[]"
    And we add newline after array begin
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      [
      ]
      """

  Scenario: Add newline before array end
    Given the String "[]"
    And we add newline before array end
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      [
      ]
      """

  Scenario: Add newline and space after array begin
    Given the String "[]"
    And we add newline after array begin
    And we add space after array begin
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      [
      ]
      """

  Scenario: Add newline and space before array end
    Given the String "[]"
    And we add newline before array end
    And we add space before array end
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      [
      ]
      """

  Scenario: Add newline after array begin and space before array end
    Given the String "[]"
    And we add newline after array begin
    And we add space before array end
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      [
      ]
      """

  Scenario: Add space after array begin and newline before array end
    Given the String "[]"
    And we add space after array begin
    And we add newline before array end
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      [
      ]
      """

  Scenario: Add newline after array begin and space before array end
    Given the String "[]"
    And we add newline after array begin
    And we add space before array end
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      [
      ]
      """

  Scenario: Add newline after array begin
    Given the String "["alice"]"
    And we add newline after array begin
    And we set indention to 0 spaces
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      [
      "alice"]
      """

  Scenario: Add newline after array begin and before array end
    Given the String "["alice"]"
    And we add newline after array begin
    And we add newline before array end
    And we set indention to 0 spaces
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      [
      "alice"
      ]
      """

  Scenario: Set indention
    Given the String "["alice"]"
    And we set indention to 2 spaces
    When we parse it
    And we convert it to a formatted String
    Then we expect "["alice"]"

  Scenario: Add newline after array begin and indention
    Given the String "["alice"]"
    And we add newline after array begin
    And we set indention to 2 spaces
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      [
        "alice"]
      """

  Scenario: Add newline after array begin and indention
    Given the String "["alice"]"
    And we add newline after array begin
    And we set indention to 4 spaces
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      [
          "alice"]
      """

  Scenario: Add newline after array begin and value separator
    Given the String "["alice","bob"]"
    And we add newline after array begin
    And we add newline after value separator
    And we set indention to 2 spaces
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      [
        "alice",
        "bob"]
      """

  Scenario: Add newline after array begin and before array end and set indention
    Given the String "["alice",["bob"]]"
    And we add newline after array begin
    And we add newline before array end
    And we set indention to 2 spaces
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      [
        "alice",[
          "bob"
        ]
      ]
      """
      
  Scenario: Deep nested objects
    Given the String "{"alice":{"bob":{"charlie":{"david":{"edgar":{"francis":null}}}}}}"
    And we add newline after object begin
    And we add newline before object end
    And we add space after name value separator
    And we set indention to 2 spaces
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      {
        "alice": {
          "bob": {
            "charlie": {
              "david": {
                "edgar": {
                  "francis": null
                }
              }
            }
          }
        }
      }
      """
      
  Scenario: Mixed objects and arrays
    Given the String "{"alice":{"bob":["charlie","david"]},"edgar":null}"
    And we add newline after object begin
    And we add newline before object end
    And we add space after name value separator
    And we add newline after array begin
    And we add newline before array end
    And we add newline after value separator
    And we set indention to 2 spaces
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      {
        "alice": {
          "bob": [
            "charlie",
            "david"
          ]
        },"edgar": null
      }
      """
  
  Scenario: Nested empty object with indention
    Given the String "{"alice":{"bob":{}},"charlie":null}"
    And we add newline after object begin
    And we add newline before object end
    And we add newline after array begin
    And we add newline before array end
    And we set indention to 2 spaces
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      {
        "alice":{
          "bob":{
          }
        },"charlie":null
      }
      """
  
  Scenario: Nested empty array with indention
    Given the String "{"alice":{"bob":[]},"charlie":null}"
    And we add newline after object begin
    And we add newline before object end
    And we add newline after array begin
    And we add newline before array end
    And we set indention to 2 spaces
    When we parse it
    And we convert it to a formatted String
    Then we expect
      """
      {
        "alice":{
          "bob":[
          ]
        },"charlie":null
      }
      """
  
  Scenario: Illegal newline string
    Given the String "{"alice":"bob"}"
    And we set newline to illegal string
    When we parse it
    And we convert it to a formatted String
    Then we expect "{"alice":"bob"}"
  
  Scenario: Illegal indention string
    Given the String "{"alice":"bob"}"
    And we set indention to illegal string
    When we parse it
    And we convert it to a formatted String
    Then we expect "{"alice":"bob"}"
