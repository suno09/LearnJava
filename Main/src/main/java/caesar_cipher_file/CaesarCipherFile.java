package caesar_cipher_file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CaesarCipherFile {
    private static final String filePath = "cipher_record_original.wav";
    private static final String crFilePath = "cr_" + filePath + ".wav";
    private static final String deFilePath = "de_" + filePath + ".wav";
    private static final int shift = 200;

    public static void main(String[] args) {
        encryptFile();
        decryptFile();
    }

    private static void encryptFile() {
        FileOutputStream out = null;
        try {
            byte[] audioByte = Util.fileToBytes(filePath);
            byte[] encryptedAudioByte = CaesarCipher.encrypt(audioByte, shift);


            out = new FileOutputStream(crFilePath);
            out.write(encryptedAudioByte);
            out.flush();

            System.out.println("success encryption");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error encryption");
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void decryptFile() {
        FileOutputStream out = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(crFilePath);

            byte[] encryptedAudioByte = Util.fileToBytes(fileInputStream);
            byte[] decryptedAudioByte = CaesarCipher.decrypt(encryptedAudioByte, shift);

            out = new FileOutputStream(deFilePath);
            out.write(decryptedAudioByte);
            out.flush();

            System.out.println("success decryption");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error encryption");
        }
    }
}