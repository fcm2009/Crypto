import java.math.BigInteger;

public class Util {
	
	// THE GCD(a,b) METHOD
	public static BigInteger gcd(BigInteger a , BigInteger b){
		while(!b.equals(new BigInteger("0"))){				// loop to check if the remainder is 0
			BigInteger r = a.mod(b);		// remainder of the first number divided by the second
			a = b;									// first number = second number
			b = r;									// second number = the remainder
		}																		
		return a;
	}
	// End of the GCD Method
	
	// MODULAR EXPONENTIATION METHOD
	public static BigInteger modPow(BigInteger b , BigInteger e , BigInteger m ){		
		BigInteger x = new BigInteger("1");							// variable contains the result
		BigInteger power = b.mod(m);								// the p
		int nBits = e.bitLength();									// to get the number of bits which is the number of iterations
		for(int i=0;i<nBits;i++){									// loop to check when to multiply x by p
			if(e.testBit(i))
				x = (x.multiply(power)).mod(m);						// x= x.p mod m if the bit =1
			power=(power.multiply(power)).mod(m);					// p = p^2 mod m
			
		}
		return x;													// return the result
	}
    // End of The MODULAR EXPONENTIATION Method

    // The Extended Euclidean Algorithm Method
    public static BigInteger[] extendedEA(BigInteger a, BigInteger b) {
        BigInteger s0 = new BigInteger("1");  BigInteger s = new BigInteger("0");       // the value of s
        BigInteger t0 = new BigInteger("0");  BigInteger t = new BigInteger("1");       // the value of t
        BigInteger r0 = a;                    BigInteger r = b;
        BigInteger q;                         BigInteger tmp;                           //temporary variable to store data wile swapping

        while(!r.equals(new BigInteger("0"))) {
            q = r0.divide(r);

            tmp = s0;   s0 = s;
            s = tmp.subtract(s.multiply(q));

            tmp = t0;   t0 = t;
            t = tmp.subtract(t.multiply(q));

            tmp = r0;   r0 = r;
            r = tmp.subtract(r.multiply(q));
        }

        return new BigInteger[] {r0, s0, t0};
    }
    // End of The Extended Euclidean Algorithm Method

    // The Inverse of a number mod m Method
    public static BigInteger modInverse(BigInteger a, BigInteger m) {
        BigInteger[] tmp = extendedEA(a, m);        // get the Extended Euclidean Algorithm
        if(tmp[0].equals(new BigInteger("1")))      // check that a and m are co-prime
            return tmp[1].mod(m);                          // return s
        else
            return null;                            // return null because the aren't co-prime
    }
    // End of The Inverse Method

    // Chinese Remainder Theorem Method
    public static BigInteger CRT(BigInteger[] a, BigInteger[] m) {
        BigInteger x = new BigInteger("0");         // variable to store the result
        BigInteger product = new BigInteger("1");   // the product of all moduli
        for(int i = 0; i < m.length; i++)           //calculating the product
            product = product.multiply(m[i]);
        for(int i = 0; i < a.length; i++) {
            x = x.add((a[i].multiply(product.divide(m[i]))).multiply(modInverse(product.divide(m[i]), m[i])));   // x = a * M * i    (where M = m / product)
        }
        return x.mod(product);
    }
    // End of Chinese Remainder Theorem Method
}
