package RSA1;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int k = Vvid(0);
		if (k == 1) {
			Gen();
		}
		if (k == 2) {
			Enc();
		}
		if (k == 3) {
			Dec();
		}
		if (k == 4) {
			EncSt();
		}

	}

	static int Vvid(int k) {
		while ((k != 1) && (k != 2) && (k != 3) && (k != 4)) {
			Scanner sc = new Scanner(System.in);
			System.out
					.println(" 1. Згенерувати ключі \n 2. Зашифрувати \n 3. Дешифрувати \n 4. String");
			k = sc.nextInt();
			if ((k != 1) && (k != 2) && (k != 3) && (k != 4))
				System.out.println("Помилка введення");
		}
		return k;
	}

	static void Gen() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Введіть перше число p:");
		long a = sc.nextLong();
		System.out.println("Введіть друге число q:");
		long b = sc.nextLong();
		System.out.println("Введіть відкритий ключ e:");
		long ee = sc.nextLong();
		BigInteger p = BigInteger.valueOf(a);
		BigInteger q = BigInteger.valueOf(b);
		BigInteger n = RSAn(p, q);
		System.out.println("Відкритий ключ n = " + n);
		BigInteger e = BigInteger.valueOf(ee);
		BigInteger fi = RSAEiler(a, b);
		BigInteger evq = RSAEvq(e, fi);
		BigInteger bi1 = new BigInteger("1");
		RSAPer(evq, bi1, e, fi);
	}

	static BigInteger RSAEiler(long a, long b) {
		long f = (a - 1) * (b - 1);
		BigInteger fi = BigInteger.valueOf(f);
		return fi;
	}

	static BigInteger RSAn(BigInteger p, BigInteger q) {
		BigInteger n = p.multiply(q);
		return n;
	}

	static BigInteger RSAEvq(BigInteger e, BigInteger fi) {
		BigInteger evq = e.gcd(fi);
		System.out.println("НСД = " + evq);
		return evq;
	}

	static void RSAPer(BigInteger evq, BigInteger bi1, BigInteger e,
			BigInteger fi) {
		if (evq.equals(bi1)) {
			BigInteger d = RSADeCh(e, fi);
			System.out.println("Дшифруюче число d = " + d);
		} else {
			System.out.println("Wrong");
		}

	}

	static BigInteger RSADeCh(BigInteger e, BigInteger fi) {
		BigInteger d = e.modInverse(fi);
		return d;
	}

	static void Enc() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Введіть відкритий ключ e:");
		long ee = sc.nextLong();
		System.out.println("Введіть відкритий ключ n:");
		long nn = sc.nextLong();
		BigInteger e = BigInteger.valueOf(ee);
		BigInteger n = BigInteger.valueOf(nn);
		BigInteger c = EncNumb(e, n);
		System.out.println("Зашифроване число = " + c);
	}

	static BigInteger EncNumb(BigInteger e, BigInteger n) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Введіть число, яке потрібно зашифрувати:");
		long mm = sc.nextLong();
		BigInteger m = BigInteger.valueOf(mm);
		BigInteger c = m.modPow(e, n);
		return c;
	}

	static void Dec() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Введіть закритий ключ d:");
		long dd = sc.nextLong();
		System.out.println("Введіть відкритий ключ n:");
		long nn = sc.nextLong();
		BigInteger d = BigInteger.valueOf(dd);
		BigInteger n = BigInteger.valueOf(nn);
		BigInteger m = DecNumb(d, n);
		System.out.println("Дешифроване число = " + m);
	}

	static BigInteger DecNumb(BigInteger d, BigInteger n) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Введіть число, яке потрібно дешифрувати:");
		long cc = sc.nextLong();
		BigInteger c = BigInteger.valueOf(cc);
		BigInteger m = c.modPow(d, n);
		return m;
	}

	static void EncSt() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Введіть відкритий ключ e:");
		long ee = sc.nextLong();
		System.out.println("Введіть відкритий ключ n:");
		long nn = sc.nextLong();
		BigInteger e = BigInteger.valueOf(ee);
		BigInteger n = BigInteger.valueOf(nn);
		String in = "Text";
		BigInteger asc = new BigInteger("256");
		int nnn = in.length();
		for (int i = 0; i < nnn; i++) {
			long en = in.codePointAt(i);
			BigInteger m = BigInteger.valueOf(en);
			BigInteger c = m.modPow(e, n);
			System.out.println("Зашифроване число = " + c);
			BigInteger w = c.mod(asc);
			System.out.println(w);
		}
	}

}
