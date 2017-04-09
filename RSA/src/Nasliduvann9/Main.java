package Nasliduvann9;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("¬вед≥ть перше число p:");
		long a = sc.nextLong();
		System.out.println("¬вед≥ть друге число q:");
		long b = sc.nextLong();
		System.out.println("¬вед≥ть в≥дкритий ключ e:");
		long ee = sc.nextLong();
		Creat gen = new Creat(a, b, ee);
		
		RSAn nn = new RSAn(a,b,ee);
		nn.RSAnNumb(nn.p, nn.q);

	}

}
