package login.main;

import java.util.Scanner;

import login.service.LoginServicImpl;
import login.service.LoginService;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LoginService ls = new LoginServicImpl();
		System.out.print("1. 선택\n2. 없음\n>>> : ");
		int func = sc.nextInt();
		switch (func) {
		case 1:
			ls.display();
			break;
		case 2:
			break;
		default:
			break;
		}
	}
}
