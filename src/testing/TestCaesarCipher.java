package testing;
import encryption.ciphers.CaesarCipher;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCaesarCipher {

    CaesarCipher cipher = new CaesarCipher(3);

    /**
     * test cases for encrypt method of CaesarCipher
     * @return void
     * @param
     */
    @Test
    public void testEncrypt() {
        assertEquals("khoor", cipher.encrypt("hello"));
        assertEquals("de", cipher.encrypt("ab"));
        assertEquals("efg", cipher.encrypt("bcd"));
        assertEquals("456", cipher.encrypt("123"));
    }

    /**
     * test cases for decrypt method of CaesarCipher
     * @return void
     * @param
     */
    @Test
    public void testDecrypt() {
        assertEquals("hello", cipher.decrypt("khoor"));
        assertEquals("ab", cipher.decrypt("de"));
        assertEquals("bcd", cipher.decrypt("efg"));
        assertEquals("123", cipher.decrypt("456"));
    }
}

