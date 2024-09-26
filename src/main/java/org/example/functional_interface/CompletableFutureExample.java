package org.example.functional_interface;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.util.function.Supplier;

@Slf4j
public class CompletableFutureExample {

  public static <T> Supplier<T> elapsedSupplier(Supplier<T> delegate) {
    return () -> {
        log.info("Current thread: {}", Thread.currentThread().getName());
        return delegate.get();
    };
  }

  public void process(){

  }
}
