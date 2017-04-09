package RSAeRand;

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

	}

	static int Vvid(int k) {
		while ((k != 1) && (k != 2) && (k != 3)) {
			Scanner sc = new Scanner(System.in);
			System.out
					.println(" 1. Згенерувати ключі \n 2. Зашифрувати \n 3. Дешифрувати");
			k = sc.nextInt();
			if ((k != 1) && (k != 2) && (k != 3))
				System.out.println("Помилка введення");
		}
		return k;
	}

	static void Gen() {
		long a = PVvid();
		long b = QVvid();
		PqPer(a, b);
		BigInteger e = RSAEvvid();
		BigInteger fi = RSAEiler(a, b);
		BigInteger evq = RSAEvq(e, fi);
		BigInteger bi1 = new BigInteger("1");
		RSAPer(evq, bi1, e, fi);
	}
	
	static void PqPer(long a, long b){
		if(a!=b){
			BigInteger p = BigInteger.valueOf(a);
			BigInteger q = BigInteger.valueOf(b);
			BigInteger n = RSAn(p, q);
			System.out.println("Відкритий ключ n = " + n);
		}else{
			PVvid();
			QVvid();
		}
	}
	
	static long PVvid(){
		long a = random(10,99);
		System.out.println("a = "+a);
		return a;
	}
	
	static long QVvid(){
		long b = random(10,99);
		System.out.println("b = "+b);
		return b;
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

	static BigInteger RSAEvvid() {
		long ee = random(1000, 9999);
		System.out.println(ee);
		BigInteger e = BigInteger.valueOf(ee);
		return e;
	}

	static void RSAPerE(BigInteger evq, BigInteger bi1, BigInteger e,
			BigInteger fi) {
		do {
			System.out.println("Wrong");
			e = RSAEvvid();
			evq = RSAEvq(e, fi);
		} while (!evq.equals(bi1));
		RSAPer(evq, bi1, e, fi);
	}

	static void RSAPer(BigInteger evq, BigInteger bi1, BigInteger e,
			BigInteger fi) {
		if (evq.equals(bi1)) {
			BigInteger d = RSADeCh(e, fi);
			System.out.println("Дшифруюче число d = " + d);
		} else {
			RSAPerE(evq, bi1, e, fi);
		}
	}

	static BigInteger RSADeCh(BigInteger e, BigInteger fi) {
		BigInteger d = e.modInverse(fi);
		return d;
	}

	static void Enc() {
		Scanner sc = new Scanner(System.in);
		BigInteger e = RSAEvvid();
		System.out.println("Введіть відкритий ключ n:");
		long nn = sc.nextLong();
		BigInteger n = BigInteger.valueOf(nn);
		EncNumb(e, n);

	}

	static void EncNumb(BigInteger e, BigInteger n) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Введіть число, яке потрібно зашифрувати:");
		long mm = sc.nextLong();
		BigInteger m = BigInteger.valueOf(mm);
		BigInteger c = DecNumbM(m, e, n);
		System.out.println("Зашифроване число = " + c);
	}

	static BigInteger DecNumbC(BigInteger m, BigInteger e, BigInteger n) {
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
		DecNumb(d, n);
	}

	static void DecNumb(BigInteger d, BigInteger n) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Введіть число, яке потрібно дешифрувати:");
		long cc = sc.nextLong();
		BigInteger c = BigInteger.valueOf(cc);
		BigInteger m = DecNumbM(c, d, n);
		System.out.println("Дешифроване число = " + m);
	}

	static BigInteger DecNumbM(BigInteger c, BigInteger d, BigInteger n) {
		BigInteger m = c.modPow(d, n);
		return m;
	}
	
	static int random(int min, int max) {
		return (int) Math.round(Math.random() * (max - min) + min);
	}

}
