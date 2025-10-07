# Mocking Tests

## Unit Tests

* [sonar-core LanguagesProvider][languages-provider] - [LanguagesProviderTest][languages-provider-test]
  
  > `LanguagesProvider` provides access to the languages configured in SonarQube.

  * `should_preserve_language_order` The order of languages returned by the `LanguagesProvider`
   should match the order provided by the `Languages` instance.

[languages-provider]: /sonar-core/src/main/java/org/sonar/core/language/LanguagesProvider.java
[languages-provider-test]: /sonar-core/src/test/java/org/sonar/core/language/LanguagesProviderTest.java

## Impact

The `LanguagesProvider` class depends on the `Languages` interface, which is part of the SonarQube API.
 This makes it a good candidate for mocking, as it allows us to isolate the `LanguagesProvider` class
 and test its behavior without relying on the actual implementation of the `Languages` interface.
