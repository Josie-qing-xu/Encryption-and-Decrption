package testing;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({TestCaesarCipher.class, TestVigenereCipher.class})
public class TestSuite {

}