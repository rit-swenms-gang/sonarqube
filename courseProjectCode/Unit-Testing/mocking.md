# Mocking Tests

## Unit Tests

* [sonar-core LanguagesProvider][languages-provider] - [LanguagesProviderTest][languages-provider-test]
  
  > `LanguagesProvider` provides access to the languages configured in SonarQube.

  * `should_preserve_language_order` The order of languages returned by the `LanguagesProvider`
   should match the order provided by the `Languages` instance.

[languages-provider]: /sonar-core/src/main/java/org/sonar/core/language/LanguagesProvider.java
[languages-provider-test]: /sonar-core/src/test/java/org/sonar/core/language/LanguagesProviderTest.java

* [sonar-core CoreExtension][core-extension] - [CoreExtensionTest][core-extension-test]
  
  > `CoreExtension` is a SonarQube extension that provides core functionalities.

  * `context_addExtensions_with_varargs_calls_individual_methods` When adding multiple extensions
   using variable arguments, the `addExtensions` method should call the individual `addExtension`
   method for each extension.

[core-extension]: /sonar-core/src/main/java/org/sonar/core/extension/CoreExtension.java
[core-extension-test]: /sonar-core/src/test/java/org/sonar/core/extension/CoreExtensionTest.java

## Impact

The `LanguagesProvider` class depends on the `Languages` interface, which is part of the SonarQube API.
 This makes it a good candidate for mocking, as it allows us to isolate the `LanguagesProvider` class
 and test its behavior without relying on the actual implementation of the `Languages` interface.

The `CoreExtension` class does not have any direct dependencies on other classes or interfaces.
  However, it includes an internal `Context` interface that can be mocked.
  Mocking the context allows us to verify that the `addExtensions` method
  behaves as expected when adding multiple extensions.
  This also improves the coverage of the `CoreExtension` file, which previously only had 25% coverage.
