package test;

import main.PasswordVerifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class PasswordVerifierTest {

  private PasswordVerifier verification = new PasswordVerifier();

  static Stream hasAllConditions() {
    return Stream.of(
        of(false, null),
        of(false, new String()),
        of(false, "123456789"),
        of(false, "Aa34567"), //less than 8 chars
        of(false, "A123456789"),   //no lowercase
        of(false, "a123456789"),   // no uppercase
        of(false, "ABCDabcd$"),    // no number
        of(true, "Aa1Bb2Cc3"),    // all conditions
        of(true, "Aa1@#$%^")      // all conditions
    );
  }

  static Stream verify3True() {
    return Stream.of(
        of(false, null),
        of(false, new String()),
        of(true, "Aa34567"), //less than 8 chars
        of(true, "A12345678"),   //no lowercase
        of(true, "a12345678"),   // no uppercase
        of(true, "ABCDabcd"),    // no number
        of(true, "Aa1Bb2Cc3"),    // all conditions
        of(true, "12345678"),
        of(true, "AaBbCc"),
        of(true, "Aa1@#$%^")      // all conditions
    );
  }

  static Stream verify3TrueAndLowercaseTrue() {
    return Stream.of(
        of(false, null),
        of(false, new String()),
        of(true, "Aa34567"), //less than 8 chars
        of(false, "A12345678"),   //no lowercase
        of(true, "a12345678"),   // no uppercase
        of(true, "ABCDabcd"),    // no number
        of(true, "Aa1Bb2Cc3"),    // all conditions
        of(false, "12345678"),
        of(true, "AaBbCc"),
        of(true, "Aa1@#$%^")      // all conditions
    );
  }

  @ParameterizedTest
  @MethodSource("hasAllConditions")
  void verifyAllCondition(boolean expected, String password) {
    boolean actual = verification.verifyAllCOnditionsTrue(password);

    Assertions.assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("verify3True")
  void verify3TrueConditions(boolean expected, String password) {
    boolean actual = verification.verify3TrueConditions(password);

    Assertions.assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("verify3TrueAndLowercaseTrue")
  void verify3TrueConditionsAndLowercase(boolean expected, String password) {
    boolean actual = verification.verify3TrueConditionsAndOneLowercaseChar(password);

    Assertions.assertEquals(expected, actual);
  }
}