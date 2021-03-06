# java-json-toolkit

The json-toolkit repository contains the code to the following libraries:
* `json-toolkit-text`: basic library for conversion between textual representations and special Java classes
* `json-toolkit-java` (available soon)

## json-toolkit-text

The json-toolkit-text library can be used to convert textual representations of JSON values into Java objects and to convert those Java objects into textual representations. The conversion into the textual version can use a configurable formatter to create texts that are more easy to read by humans.

### Installation

To use the library in your projects, you have to create the dependency to the library.

Gradle:
```gradle
dependencies {
  implementation 'de.d-coding:json-toolkit-text:1.0.4'
}
```

Maven:
```xml
<dependency>
  <groupId>de.d-coding</groupId>
  <artifactId>json-toolkit-text</artifactId>
  <version>1.0.4</version>
</dependency>
```

### Usage

Sample usage code snippets. 

Parsing JSON texts:
```java
String jsonText = "{\"foo\":{}}";
JSONLLParser parser = new JSONLLParser();
JSONValue jsonValue = parser.parse(stringValue);
```
or
```java
JSONObject object = JSON.decode("{\"foo\":{}}");
```
or
```java
JSONArray array = JSON.decode("[1, 2, null, 3]");
```

Manipulating JSON values:
```java
JSONValue jsonValue = new JSONObject();
jsonValue.put("foo", "bar");
```
or
```java
JSONValue jsonValue = JSON.decode("{\"foo\":{}}");
JSONObject object = (JSONObject)jsonValue.get("foo");
object.put("bar", 42);
```
or
```java
JSONValue jsonValue = JSON.decode("{\"foo\":{}}");
jsonValue.<JSONObject>getAs("foo").put("bar", 42);
```

Convert to unformatted text:
```java
JSONValue jsonValue = new JSONObject();
jsonValue.put("foo", "bar");
String text = jsonValue.toString();
```

Convert to formatted text:
```java
JSONValue jsonValue = new JSONObject();
jsonValue.put("foo", "bar");
JSONFormatter formatter = new JSONFormatter();
String text = formatter.toString(jsonValue);
```
or
```java
JSONValue jsonValue = new JSONObject();
jsonValue.put("foo", "bar");
JSON.encode(jsonValue);
```

Convert to formatted text with indention of 3 spaces:
```java
JSONValue jsonValue = new JSONObject();
jsonValue.put("foo", "bar");
JSONFormatter formatter = new JSONFormatter();
JSONFormatterSettings settings = formatter.getSettings();
settings.setIndentionString("   ");
String text = formatter.toString(jsonValue);
```

## License

json-toolkit is released under the [Apache 2.0 license](LICENSE).

```
Copyright (C) 2022 d-coding GmbH

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
