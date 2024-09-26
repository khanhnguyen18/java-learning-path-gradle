package org.example.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@ExtendWith(MockitoExtension.class)
class UnitTestingTest {

  @InjectMocks
  UnitTesting unitTesting;

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

}