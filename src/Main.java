import java.math.BigInteger;
import java.util.Random;

public class Main {

    public static void main (String[]args){
        int digitNum = 1109;                                            //set the number of digits of the test numbers
        BigInteger a = new BigInteger(digitNum, new Random(14));        // random bigintgeres of length 500 for testing
        BigInteger b = new BigInteger(digitNum, new Random(17));        // random bigintgeres of length 500 for testing
        BigInteger c = new BigInteger(digitNum, new Random(13));        // random bigintgeres of length 500 for testing
        BigInteger d = new BigInteger(digitNum, new Random(10));        // random bigintgeres of length 500 for testing
        BigInteger e = new BigInteger(digitNum, new Random(8));         // random bigintgeres of length 500 for testing
        BigInteger f = new BigInteger(digitNum, new Random(4));         // random bigintgeres of length 500 for testing

        System.out.println("-------------------------------------------------------------------------------------------------");    //GCD Method Testing
        System.out.println("GCD Method                           : ");
        System.out.println("a                                    = " + a);
        System.out.println("b                                    = " + b);
        System.out.println("gcd(a,b) Using the method in         :\n" +
                           "BigInteger class                     = " + a.gcd(b));
        System.out.println("gcd(a,b) Using our method            = " + Util.gcd(a,b));
        System.out.println("Are the twe number the same          ? " + (a.gcd(b)).equals(Util.gcd(a,b)));
        System.out.println("-------------------------------------------------------------------------------------------------\n");  //End of GCD Method Testing

        System.out.println("-------------------------------------------------------------------------------------------------");    //Modular Exponentiation Testing
        System.out.println("Modular Exponentiation Method        : ");
        System.out.println("base                                 = " + a);
        System.out.println("power                                = " + b);
        System.out.println("modulus                              = " + c);
        System.out.println("Using BigInteger method              :\n" +
                           "base^power (mod modulus)             = " + a.modPow(b, c));
        System.out.println("Using our method                     :\n" +
                           "base^power (mod modulus)             = " + Util.modPow(a, b, c));
        System.out.println("Are the twe number the same          ? " + a.modPow(b, c).equals(Util.modPow(a, b, c)));
        System.out.println("-------------------------------------------------------------------------------------------------\n");  //End of Modular Exponentiation Testing

        System.out.println("-------------------------------------------------------------------------------------------------");    //Extended Euclidean Algorithm Testing
        System.out.println("Extended Euclidean Algorithm Method  : ");
        System.out.println("a                                    = " + a);
        System.out.println("b                                    = " + b);
        BigInteger[] result = Util.extendedEA(a, b);
        System.out.println("GCD(a,b) Using BigInteger method     = " + a.gcd(b));
        System.out.println("Using our method                     = " + result[0]);
        System.out.println("Are the twe number the same          ? " + a.gcd(b).equals(result[0]));
        System.out.println("s                                    = " + result[1]);
        System.out.println("t                                    = " + result[2]);
        System.out.println("Check that gcd(a, b) = sa +tb        ? " + result[0].equals((result[1].multiply(a)).add(result[2].multiply(b))));
        System.out.println("-------------------------------------------------------------------------------------------------\n");  //End of Extended Euclidean Algorithm Testing

        System.out.println("-------------------------------------------------------------------------------------------------");    //Modulus Inverse Testing
        System.out.println("Modulus Inverse Using Method         : ");
        System.out.println("a                                    = " + a);
        System.out.println("modulus                              = " + b);
        System.out.println("Inverse Using BigInteger method      = " + a.modInverse(b));
        System.out.println("Using our method                     = " + Util.modInverse(a, b));
        System.out.println("Are the twe number the same          ? " + (a.modInverse(b)).equals(Util.modInverse(a, b)));
        System.out.println("-------------------------------------------------------------------------------------------------\n");  //End of Modulus Inverse Testing

        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Chinese Remainder Theorem Method     : ");
        BigInteger[] s = {a, b, c};
        BigInteger[] moduli = {d, e, f};
        BigInteger x = Util.CRT(s, moduli);                                 //the solution of the liner congruence
        System.out.println("a1                                   = " + a);
        System.out.println("a2                                   = " + b);
        System.out.println("a3                                   = " + c);
        System.out.println("m1                                   = " + d);
        System.out.println("m2                                   = " + e);
        System.out.println("m3                                   = " + f);
        System.out.println("Using our method                     = " + Util.CRT(s, moduli));
        System.out.println("\nCheck the result of CRT method:    \n" +
                           "result mod m1     = a1 mod m1        \n" +
                           "and result mod m2 = a2 mod m2        ? " + ((x.mod(d)).equals(a.mod(d)) && (x.mod(e)).equals(b.mod(e)) && (x.mod(f)).equals(c.mod(f))) + "\n" +
                           "and result mod m3 = a3 mod m3          ");
        System.out.println("-------------------------------------------------------------------------------------------------\n");
    }
}
