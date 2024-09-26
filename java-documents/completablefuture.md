# CompletableFuture



## Timeout
- https://www.baeldung.com/java-completablefuture-timeout

## Test 1
```java
  @Test
  @SneakyThrows
  void testSupplier() {
    CompletableFuture.supplyAsync(elapsedSupplier(this::testing))
        .orTimeout(200, TimeUnit.MILLISECONDS)
        .exceptionally((throwable) -> {
          System.out.println("ERROR: " + throwable.getMessage());
          return null;
        });
    sleep(2000);
  }


  @SneakyThrows
  Supplier<String> testing() {
    sleep(1000000);
    return () -> null;
  }
```