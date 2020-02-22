import ciphers.Cipher;
import ciphers.implementation.CesarCipher;

public class Test1 {
    public static void main(String[] args) {
        Cipher cezarCipher = new CesarCipher();
        String example = cezarCipher.encode("");
        System.out.println(example);
        String decoded = cezarCipher.decode("rdvkrlkdlILSZKHINQYSMTH90213X40912X31923");
        System.out.println(decoded);
    }
}

