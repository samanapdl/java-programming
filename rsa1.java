
package rsa;
import java.lang.Math;
import java.security.SecureRandom;
import java.util.Random;
import java.math.BigInteger; 



public class rsa1 {
	
	//Check if the number is prime or not
	public static boolean isPrime(long num) {
       boolean result = true; 
       if(num < 2)
            result = false; 
       else if(num == 2)
            result = true; 
       else if(num % 2 == 0)
            result = false; 
       else {
            int ubound = (int)Math.sqrt(num);
            for(int k=3; k<=ubound && result; k+=2) {
                if (num % k == 0)
                    result = false; }}
       return result;
		
	}
	
	//Generate prime number
	public static long prime(long upperbound, long lowerbound ) {
		long num = (long)(Math.random() * ((upperbound - lowerbound) + 1))+lowerbound;
		if(num % 2== 0 ) {
			num--;}
		while(!isPrime(num)) {
			num-=2;}
		return num;
	}

	

//	public static BigInteger gcd(BigInteger m, BigInteger n) {
//		BigInteger  gcd= m.gcd(n);
//        return gcd;
//	}
		
	
// Coprime of f(n), Carmichael's totient function
	public static BigInteger coPrime(BigInteger nlamda) {
		Random rand = new SecureRandom();
		BigInteger e;
		do  e = new BigInteger(nlamda.bitLength(), rand);
		while (e.compareTo(BigInteger.ONE) <= 0
		    || e.compareTo(nlamda) >= 0
		    || !e.gcd(nlamda).equals(BigInteger.ONE));
		return e;
	}
	
	//Modular Multiplicative Inverse; determining d as d ≡ e−1 (mod nLambda)
	public static BigInteger inverse(BigInteger e, BigInteger nLamda) {
		BigInteger d= e.modInverse(nLamda);
		return d;
				
	}

	// Computes the modular power number {@code base}^{@code power} % {@code mod} (m,k,c)
	public static BigInteger pow(BigInteger msg, BigInteger key, BigInteger n) {
		 BigInteger pow = msg.modPow(key, n);
		 return pow;

	}
	


	public static void main(String[] args) {
		//For RSA, the bigger the prime is, the harder to crack (for regular
		//computers)
		long x = 0; //lower bound of 1st picked prime number
		long y = 10000000; //lower bound of 2nd picked prime number
		long z = 999999999 ; // upper bound for the prime numbers
		String msg= "RSA";
		
		//BigInteger msg = new BigInteger("51645445645511123");
				
		System.out.println("PlainText : " + msg);
		
		BigInteger m = new BigInteger(msg.getBytes());
		System.out.println("As number (m): " + m);
		
		long a = prime(x,z); //1st Prime number
		long b = prime(y,z); //2nd Prime number
		
		
		BigInteger p = BigInteger.valueOf(a);
		BigInteger q = BigInteger.valueOf(b);

		System.out.println("\np: " + p);
		System.out.println("q: " + q);
		
		BigInteger n = p.multiply(q); //modulus
		System.out.println("n: " + n);
		
		BigInteger nLambda =p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));// calculating Carmichaels'totient function	
		System.out.println("nLambda: " + nLambda);
	
		// finding e coprime to f(n)and 1<e<f(n
		BigInteger e =coPrime(nLambda); 
		System.out.println("e: " + e);

		//Multiplicative inverse:d = e^-1 mod (f(n))
		BigInteger d=inverse(e,nLambda);
		System.out.println("d: " + d);
		
		//print out plain text, public key and private key
		System.out.println("\nPub-key(n,e):" + "(" + n + "," + e + ")");
		System.out.println("Pri-key(n,d):" + "(" + n + "," + d + ")");
		
		//Encryption: C=M^e(mod n)
		BigInteger enc = pow(m,e,n);
		System.out.println("\nEncryption: Cipher Text number = " + enc);
		String encodedText =new String(enc.toByteArray());
		System.out.println("Encryption: Cipher Text = " + encodedText);
		
		//Decryption: M=C^d(mod n)
		BigInteger dec = pow(enc,d,n); 
		System.out.println("\nDecryption: Pain Text number = " + dec);
	    String decodedPlainText =new String(dec.toByteArray());
		System.out.println("Decryption: Pain Text = " + decodedPlainText );


	}
}

	
