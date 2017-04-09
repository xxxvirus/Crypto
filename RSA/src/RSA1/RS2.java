package RSA1;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Scanner;

public class RS2 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		BigInteger e = new BigInteger("1021");
		BigInteger n = new BigInteger("3551");
		String in = "Text";
		byte[] en = in.getBytes();
		BigInteger[] m = new BigInteger [en.length];
		BigInteger[] c = new BigInteger [en.length];
		BigInteger[] cc = new BigInteger [en.length];
		char[] t = new char [en.length];
		BigInteger un = new BigInteger("256");
		for (int i = 0; i < en.length; i++) {
			long ab = en[i];
			m[i] = BigInteger.valueOf(ab);
			c[i] = m[i].modPow(e, n);
			cc[i] = c[i].mod(un);
			t[i] = (char) (cc[i].intValue());
			System.out.print(new String(t));
		}
		/*int nnnn = en.length;
		int nnn = in.length();
		BigInteger[] m = new BigInteger [nnn];
		BigInteger[] c = new BigInteger [nnn];
		BigInteger[] cc = new BigInteger [nnn];
		char[] t = new char[nnn] ;
		for (int i = 0; i < nnnn; i++) {
			long ab = en[i];
			m[i] = BigInteger.valueOf(ab);
			c[i] = m[i].modPow(e, n);
			//System.out.println("Зашифроване число = " + c[i]);
			BigInteger un = new BigInteger("100000");
			cc[i] = c[i].mod(un);
			t[i] = (char) (cc[i].intValue());
			System.out.print( new String(t)) ;
			/*char[] ccc = c.toString();
			byte[] aaa = c.toByteArray();
			int cac = aaa[i];
			String str = new String(new char[]{(char) cac});
			System.out.print(str);*/
		

	}

}
