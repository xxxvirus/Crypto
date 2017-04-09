package Nasliduvann9;

import java.math.BigInteger;

public class RSAn extends Creat{

	BigInteger n;
	
	RSAn(long a, long b, long ee){
		super(a,b,ee);
	}
	
	void RSAnNumb(BigInteger p, BigInteger q){
		n = p.multiply(q);
		System.out.println("Відкритий ключ n = " + n);
	}
}
