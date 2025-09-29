# Unit Tests

## Tests Added

* [sonar-core FileUtil][file-util] - [FileUtilsTest][file-util-test]
  
  > `FileUtil.humanReadableByteCountSI` prints and the converts the size of a file into a
  human-readable format. That is `1,000 bytes` is converted to `1 kB`.

  * `humanReadableByteCountSI_returns_negative_byte_values` The existing tests only accounted for
   valid positive numbers, while the implementation also works with negative numbers. The range of
   values that work for positive numbers should work with negative numbers, but at least a single
   test case.
  * `humanReadableByteCountSI_returns_gbs` The existing cases test `bytes`, `kB`, `MB`, and `TB`.
   Add support for implementations `GB` case.
  * `humanReadableByteCountSI_returns_pbs` Add support for implementations `PB` case.
  * `humanReadableByteCountSI_returns_ebs`  Add support for implementations `EB` case.

* [sonar-core Slug][slug] - [SlugTest][slug-test]
  
  > `Slug.slugify` converts a string into a URL-safe format.

  * `slugify_collapses_multiple_dashes` The `Slug.slugify` method internally implements more
   behavior than is accounted for the existing tests. The function strips all prefixed and
   appended `-` characters, as well as collapses multiple dashes into a single character.
  * `slugify_handles_empty_strings` Add support for empty strings and strings that collapse to
   empty strings.
  * `slugify_handles_numbers` Add support for numbers (integers and decimals).
  * `slugify_handles_special_characters` Add support for special characters.

* [sonar-core UtcDateUtils][utc-date-utils] - [UtcDateUtilsTest][utc-date-utils-test]

  > `UtcDateUtils.parseDateTime` parses a string into a `Date` object.

  * `parseDateTime_throws_exception_for_invalid_formats` The existing tests only accounted for
   one type of invalid date-time string. The implementation throws an `IllegalArgumentException`
   for any invalid formats. This test adds a variety of invalid date-time string
   formats to ensure the exception is thrown.
  * `parseDateTime_handles_empty_input` Add support for empty strings and `null` input.

[file-util]: /sonar-core/src/main/java/org/sonar/core/util/FileUtils.java
[file-util-test]: /sonar-core/src/test/java/org/sonar/core/util/FileUtilsTest.java

[slug]: /sonar-core/src/main/java/org/sonar/core/util/Slug.java
[slug-test]: /sonar-core/src/test/java/org/sonar/core/util/SlugTest.java

[utc-date-utils]: /sonar-core/src/main/java/org/sonar/core/util/UtcDateUtils.java
[utc-date-utils-test]: /sonar-core/src/test/java/org/sonar/core/util/UtcDateUtilsTest.java

## Impact

Given the size and longevity of the `sonarqube` repository, many of the core classes
 already have substantial coverage. The classes chosen for this project were selected because they had
 a variety of testable edge cases and were utility classes that could be tested in isolation.

While the tests do not add a significant amount of coverage,
 they do add value by testing edge cases that were not previously tested.
