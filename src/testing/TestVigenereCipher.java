package testing;
import encryption.ciphers.VigenereCipher;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestVigenereCipher {

    VigenereCipher cipher = new VigenereCipher("test");

    /**
     * test cases for encrypt method of VigenereCipher
     * @return void
     * @param
     */
    @Test
    public void testEncrypt() {
        assertEquals("a", cipher.encrypt("h"));
        assertEquals("bX", cipher.encrypt("in"));
        assertEquals("tVYg]", cipher.encrypt(" land"));
        assertEquals("]e^Z", cipher.encrypt("d fa"));
    }

    /**
     * test cases for decrypt method of VigenereCipher
     * @return void
     * @param
     */
    @Test
    public void testDecrypt() {
        assertEquals("h", cipher.decrypt("a"));
        assertEquals("in", cipher.decrypt("bX"));
        assertEquals(" land", cipher.decrypt("tVYg]"));
        assertEquals("d fa", cipher.decrypt("]e^Z"));
    }
}