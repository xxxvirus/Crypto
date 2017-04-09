package RSA2cl;

public class Main {

	public static void main(String[] args) {
		long a = 53;
		long b = 67;
		long ee = 1021;
		Zmin z = new Zmin(a, b, ee);
		System.out.println("Відкритий ключ n = " + z.n);
		System.out.println("Function Eiler fi = " + z.RSAEiler(a, b));
		System.out.println("НСД = " + z.RSAEvq(z.e, z.fi));
		System.out.println("Dec numb = " + z.RSADeCh(z.e, z.fi));
	}

}
