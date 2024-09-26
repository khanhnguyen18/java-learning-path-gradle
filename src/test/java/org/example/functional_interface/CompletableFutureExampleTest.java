package org.example.functional_interface;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import static java.lang.Thread.sleep;
import static org.example.functional_interface.CompletableFutureExample.elapsedSupplier;
import static org.junit.jupiter.api.Assertions.*;

class CompletableFutureExampleTest {

  @Test
  void testing_timeout() throws InterruptedException {
    CompletableFuture completableFuture = CompletableFuture.supplyAsync(elapsedSupplier(this::waiting))
        .orTimeout(200, TimeUnit.MILLISECONDS)
        .exceptionally((throwable) -> {
          System.out.println("ERROR: " + throwable.getMessage());
          return null;
        });
    sleep(2000);
  }

  @SneakyThrows
  Supplier<String> waiting() {
    sleep(1000000);
    return () -> null;
  }

}