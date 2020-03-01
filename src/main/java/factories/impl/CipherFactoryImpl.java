package factories.impl;

import ciphers.Cipher;
import ciphers.implementation.CesarCipher;
import ciphers.implementation.Root13Cipher;
import ciphers.implementation.VigenereCipher;
import exceptions.CipherNotFoundException;

public class CipherFactoryImpl implements factories.CipherFactory {
    public static final String CESAR = "Cesar";
    public static final String ROOT13 = "Root";
    public static final String VIGENERE = "Vigenere";

    @Override
    public Cipher create(String type) {
        if (type.equals(CESAR)) {
            return new CesarCipher();
        }
        if (type.equals(ROOT13)) {
            return new Root13Cipher();
        }
        if(type.equals(VIGENERE)) {
            return new VigenereCipher();
        }
        throw new CipherNotFoundException(type);
    }
}

