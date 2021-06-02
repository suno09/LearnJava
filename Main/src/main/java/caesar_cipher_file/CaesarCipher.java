package caesar_cipher_file;

public class CaesarCipher {
    public static byte[] encrypt(byte[] bytes, int shift) {
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) ((bytes[i] + shift) % 256);
        }

        return bytes;
    }

    public static byte[] decrypt(byte[] bytes, int shift) {
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) ((bytes[i] < shift ? 256 : 0) + (bytes[i] - shift) % 256);
        }

        return bytes;
    }

}
