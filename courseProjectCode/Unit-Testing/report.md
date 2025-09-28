# Unit Tests

## Tests Added

* sonar-core/src/main/util/FileUtil - FileUtilsTest
  
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
