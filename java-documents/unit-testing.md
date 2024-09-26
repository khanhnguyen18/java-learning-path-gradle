# Unit Testing

## ParameterizedTest
### Value Source
### Method Source
- Testing for this 
  ```java
  public int order() {
    return isBiocatchTrustEvent ? 3 : 2;
  }
  ```
- Testing code
```java
    @ParameterizedTest
    @MethodSource("orderInputValue")
    void orderMethodeSourceTest(boolean isBiocatchTrustEvent, int expectedValue) {
        assertEquals(expectedValue, unitTesting.order(isBiocatchTrustEvent));
    }
    private static Stream<Arguments> orderInputValue() {
        return Stream.of(
            arguments(true, 3),
            arguments(false, 2)
    );
  }
```
- View the source code
```shell
idea /Users/P836088/project/java-learning-path-gradle
sleep 5s
idea /Users/P836088/project/java-learning-path-gradle/src/test/java/org/example/testing/UnitTestingTest.java
```

