import java.math.BigInteger;
import java.util.Random;
import java.io.*;
public class rsa1 {
    private BigInteger p, q, N, phi, e, d;
    private int bitlength = 1024;
    private Random r = new Random();
    public rsa1() {
        p = BigInteger.probablePrime(bitlength / 2, r);
        q = BigInteger.probablePrime(bitlength / 2, r);
        N = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(bitlength / 2, r);
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0) e = e.add(BigInteger.ONE);
        d = e.modInverse(phi);
    }

    public byte[] encrypt(byte[] message) {
        return new BigInteger(message).modPow(e, N).toByteArray();
    }

    public byte[] decrypt(byte[] message) {
        return new BigInteger(message).modPow(d, N).toByteArray();
    }

    public static void main(String[] args) throws IOException {
        rsa1 rsa = new rsa1();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter text:");
        String input = reader.readLine();

        byte[] encrypted = rsa.encrypt(input.getBytes());
        byte[] decrypted = rsa.decrypt(encrypted);

        System.out.println("Encrypted: " + new BigInteger(encrypted));
        System.out.println("Decrypted: " + new String(decrypted));
    }
}
