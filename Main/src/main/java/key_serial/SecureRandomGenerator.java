package key_serial;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.stream.IntStream;

public class SecureRandomGenerator {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
        SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG", "SUN");

        // Get 128 random bytes
        byte[] randomBytes = new byte[128];
        secureRandomGenerator.nextBytes(randomBytes);

        //Get random integer
        int r = secureRandomGenerator.nextInt();

        //Get random integer in range
        int randInRange = secureRandomGenerator.nextInt(999999);

        IntStream.range(0, 100000).forEach(i -> System.out.println(secureRandomGenerator.nextInt(8999999) + 1000000));

//        System.out.println(randInRange);
    }
}
