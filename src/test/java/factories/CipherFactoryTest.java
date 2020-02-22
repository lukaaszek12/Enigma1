package factories;

import ciphers.Cipher;
import ciphers.implementation.CesarCipher;
import ciphers.implementation.Root13Cipher;
import exceptions.CipherNotFoundException;
import factories.impl.CipherFactoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CipherFactoryTest {
    private static final String MESSAGE = "Type of cipher is not recognized : ";
    private CipherFactory factory = new CipherFactoryImpl();

    @Test
    protected void ifCesarInstanceReturnedWithCesarTypeTest() {
        Cipher cipher = factory.create(CipherFactoryImpl.CESAR);
        Assertions.assertTrue(cipher instanceof CesarCipher);
    }
    @Test
    protected void ifRoot13CipherInstanceReturnedWithCesarTypeTest() {
        Cipher cipher = factory.create(CipherFactoryImpl.ROOT13);
        Assertions.assertTrue(cipher instanceof Root13Cipher);
    }

    @Test
    protected void shouldThrowExceptionWithGivenUnknownType() {
        String unknown = "unknown";
        Assertions.assertThrows(CipherNotFoundException.class, () -> factory.create(unknown),
                MESSAGE + unknown);

    }
}