package key_serial;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EncryptToInteger {
    private static final byte[] key_file = "gFKZ^mwog!S&{T,k".getBytes();
    private static final String algo_file = "AES";

    private static String diskdrive = "";
    private static String cpu = "";
    private static String motherboard = "";

    private static String algo1 = "AES";
    private static String algo2 = "RC4";
    private static String algo3 = "RC2";
    private static String algo4 = "ARCFOUR";
    private static String algo5 = "PBEWithHmacSHA256AndAES_128";

    private static String key1 = "5xe";
    private static String key2 = "TjjDbCPjsXEnMPJy";
    private static String key3 = "VJiT6Lqr0ffFz73u";
    private static String key4 = "mEuGaDUzyXdwmWVg";


    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
        List<BigInteger> hash = new ArrayList<>();

        IntStream.range(1, 1100)
                .forEach(index -> {
                    hash.add(encrypt(algo4, BigInteger.valueOf(index), key4));
                    BigInteger encrypted = encrypt(algo4, BigInteger.valueOf(index), key4);
                    BigInteger decrypted = decrypt(algo4, encrypted, key4);
                    System.out.printf("%-5s => %s => %s\n", String.valueOf(index), encrypted, decrypted);
                });
        System.out.println("=====> " + hash.parallelStream()
                .filter(s -> Collections.frequency(hash, s) > 1)
                .collect(Collectors.toSet()));
    }

    private static BigInteger encrypt(String algo, BigInteger word, String key) {
        try {
            Key algo_key = new SecretKeySpec(key.getBytes(), algo);
            Cipher cipher = Cipher.getInstance(algo);
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, algo_key);
            byte[] encrypted = cipher.doFinal(word.toByteArray());
            return new BigInteger(1, encrypted);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException |
                BadPaddingException | IllegalBlockSizeException |
                InvalidKeyException e) {
            e.printStackTrace();
        }
        return BigInteger.valueOf(-1);
    }

    public static BigInteger decrypt(String algo, BigInteger word, String key) {
        try {
            Key algo_key = new SecretKeySpec(key.getBytes(), algo);
            Cipher cipher = Cipher.getInstance(algo);
            // encrypt the text
            cipher.init(Cipher.DECRYPT_MODE, algo_key);
            BigInteger decrypted = new BigInteger(cipher.doFinal(
                    Arrays.copyOfRange(word.toByteArray(), 1, word.toByteArray().length)
            ));
            return decrypted;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return BigInteger.valueOf(-1);
    }
}
