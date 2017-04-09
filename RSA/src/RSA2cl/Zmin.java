package RSA2cl;

import java.math.BigInteger;

public class Zmin {

	BigInteger p;
	BigInteger q;
	BigInteger e;
	BigInteger n;
	BigInteger fi;
	
	Zmin(long a, long b, long ee) {
		this.p = BigInteger.valueOf(a);
		this.q = BigInteger.valueOf(b);
		this.e = BigInteger.valueOf(ee);
		this.n = p.multiply(q);
	}
	
	BigInteger RSAn(BigInteger p, BigInteger q) {
		BigInteger n = p.multiply(q);
		return n;
	}
	
	BigInteger RSAEiler(long a, long b) {
		long f = (a - 1) * (b - 1);
		this.fi = BigInteger.valueOf(f);
		return fi;
	}
	
	BigInteger RSAEvq(BigInteger e, BigInteger fi) {
		BigInteger evq = e.gcd(fi);
		return evq;
	}
	
	BigInteger RSADeCh(BigInteger e, BigInteger fi) {
		BigInteger d = e.modInverse(fi);
		return d;
	}
}
