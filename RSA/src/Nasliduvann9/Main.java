package Nasliduvann9;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ ����� ����� p:");
		long a = sc.nextLong();
		System.out.println("������ ����� ����� q:");
		long b = sc.nextLong();
		System.out.println("������ �������� ���� e:");
		long ee = sc.nextLong();
		Creat gen = new Creat(a, b, ee);
		
		RSAn nn = new RSAn(a,b,ee);
		nn.RSAnNumb(nn.p, nn.q);

	}

}
