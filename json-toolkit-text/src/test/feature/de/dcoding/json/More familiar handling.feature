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

Feature: More familiar JSON handling

  Scenario: Decoding string
    Given the String "{"foo":"bar"}"
    When we decode it
    Then we expect a JSONObject

  Scenario: Encoding string
    Given we have a JSON object
    And we set the property "foo" to value "bar"
    When we encode it
    Then we expect "{"foo":"bar"}"
