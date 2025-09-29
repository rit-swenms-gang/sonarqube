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
  
  > `Slug.slugify` appears to convert a string into URL-safe format.

  * `slugify_collapses_multiple_dashes` The `Slug.slugify` method internally implements more
   behavior than is accounted for the existing tests. The function strips all prefixed and
   appended `-` characters, as well as collapses multiple dashes into a single character.
  * `slugify_handles_empty_strings` Add support for empty strings and strings that collapse to
   empty strings.
  * `slugify_handles_numbers` Add support for numbers (integers and decimals).
  * `slugify_handles_special_characters` Add support for special characters.

[file-util]: /sonar-core/src/main/java/org/sonar/core/util/FileUtils.java
[file-util-test]: /sonar-core/src/test/java/org/sonar/core/util/FileUtilsTest.java

[slug]: /sonar-core/src/main/java/org/sonar/core/util/Slug.java
[slug-test]: /sonar-core/src/test/java/org/sonar/core/util/SlugTest.java
