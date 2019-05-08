package test;

import main.PasswordVerifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class PasswordVerifierTest {

  private PasswordVerifier verification = new PasswordVerifier();

  static Stream verifyCases() {
    return Stream.of(
        of(false, null),
        of(false, ""),
        of(false, "123456789"),
        of(false, "Aa34567"), //less than 8 chars
        of(false, "A123456789"),   //no lowercase
        of(true, "a123456789"),   // no uppercase
        of(true, "ABCDabcd$"),    // no number
        of(true, "Aa1Bb2Cc3"),    // all conditions
        of(true, "Aa1@#$%^9")      // all conditions
    );
  }

  @ParameterizedTest
  @MethodSource("verifyCases")
  void verifyAllCondition(boolean expected, String password) {
    boolean actual = verification.verify(password);

    Assertions.assertEquals(expected, actual);
  }
}