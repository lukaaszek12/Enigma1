package Ciphers;

import ciphers.Cipher;
import implementation.CezarCipher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CezarCipherTest {
    protected final String textWithNoAlphabeticLetters = "112312[]][";
    protected final String TextWithAlphabeticLetters = "abcdd";
    protected final String expectedTextforAlphabeticLetters = "defgg";
    protected final String mixedText = "123ac";
    protected final String expectedTextForMIxedLetters = "123df//";
    protected Cipher cezarCipher = new CezarCipher();
    private String textWithAlphabeticLetters;
    private short expectedTextForAlphabeticLetters;

    @DisplayName("Testing correction of encoding text with no alphabetic letters")
    @Test
    public void testIfOnlyAlphabeticLettersAreEncoded() {
        String decode = cezarCipher.decode(textWithNoAlphabeticLetters);
        Assertions.assertEquals(textWithNoAlphabeticLetters, decode);
    }

    @DisplayName("Testing correction of encoding text with no alphabetic letters")
    @Test
    public void testIfEncodingModifyTextWithAlphabeticChars() {
        String encoded = cezarCipher.encode(textWithAlphabeticLetters);
        Assertions.assertEquals(expectedTextForAlphabeticLetters, encoded);
    }
}