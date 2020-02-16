package ciphers;

import implementation.CezarCipher;

public class Test1 {
    public static void main(String[] args) {
        Cipher cezarCipher = new CezarCipher();
        String example = cezarCipher.encode("");
        System.out.println(example);
        String decoded = cezarCipher.decode("rdvkrlkdlILSZKHINQYSMTH90213X40912X31923");
        System.out.println(decoded);
    }
}

