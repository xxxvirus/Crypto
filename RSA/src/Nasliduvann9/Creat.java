package Nasliduvann9;

import java.math.BigInteger;

public class Creat {

	BigInteger p;
	BigInteger q;
	BigInteger e;
	
	Creat(long a, long b, long ee){
		this.p = BigInteger.valueOf(a);
		this.q = BigInteger.valueOf(b);
		this.e = BigInteger.valueOf(ee);
	}
}
