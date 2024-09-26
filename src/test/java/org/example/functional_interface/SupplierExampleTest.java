package org.example.functional_interface;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;


@Slf4j
class SupplierExampleTest {

  @Test
  void test() {
    Supplier<Double> generate = Math::random;
    log.info(generate.get().toString());
  }

}