package test;

import main.LongerThan8CharCondition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.*;

class LongerThan8CharConditionTest {

  private LongerThan8CharCondition verification = new LongerThan8CharCondition();

  static Stream isNotNull() {
    return Stream.of(
        of(false, null),
        of(false, new String()),
        of(false, "1234567"),
        of(false, "12345678"),
        of(true, "123456789")
    );
  }

  @ParameterizedTest
  @MethodSource("isNotNull")
  void verifyAtLeast3ConditionsAnd4thTrue(boolean expected, String password) {
    boolean actual = verification.verify(password);

    Assertions.assertEquals(expected, actual);
  }


}