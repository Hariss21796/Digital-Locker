package com.test;

import java.util.List;
import java.util.Scanner;

import com.test.app.FetchBySite;
import com.test.app.LoginUser;
import com.test.app.ReadCreds;
import com.test.app.Registration;
import com.test.app.StoreCreds;
import com.test.model.Creds;
import com.test.model.User;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("===============================================");
		System.out.println(":::: Welcome to Lockme Digital Locker ::::");
		System.out.println("===============================================");
		System.out.println("--- Please select your option ---");
		System.out.println("===============================================");
		System.out.println("=== 1)Registration,   2)Login, ===");
		int option = sc.nextInt();

		switch (option) {
		case 1:
			User userReg = registerData();
			Registration.register(userReg);
			break;
		case 2:
			User userLog = loginData();
			boolean response = LoginUser.login(userLog);
			if (response) {
				chooseOptionAfterlogin(userLog);
			}
			break;
		default:

		}
	}

	private static User registerData() {
		User user = new User();
		Scanner sc = new Scanner(System.in);
		System.out.println("== Enter Registration Details ==");
		System.out.println("Enter Username: ");
		user.setName(sc.nextLine());
		System.out.println("Enter Email: ");
		user.setEmail(sc.nextLine());
		System.out.println("Enter Password: ");
		user.setPassword(sc.nextLine());
		System.out.println("Confirm Password: ");
		user.setCnfpassword(sc.nextLine());
		return user;

	}

	private static User loginData() {
		User user = new User();
		Scanner sc = new Scanner(System.in);
		System.out.println("== Enter Login Details ==");
		System.out.println("Enter Usename: ");
		user.setName(sc.nextLine());
		System.out.println("Enter Password: ");
		user.setPassword(sc.nextLine());
		return user;
	}

	private static Creds storeCreds() {
		Creds creds = new Creds();
		Scanner sc = new Scanner(System.in);
		System.out.println("Set your ID: ");
		creds.setId(sc.nextLine());
		System.out.println("Enter Site name: ");
		creds.setSiteName(sc.nextLine());
		System.out.println("Enter Site Username: ");
		creds.setUserName(sc.nextLine());
		System.out.println("Enter Site Password: ");
		creds.setPassword(sc.nextLine());
		return creds;
	}

	private static String fetchBySite() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Site Name: ");
		return sc.nextLine();
	}

	private static void chooseOptionAfterlogin(User userLog) {

		Scanner sc = new Scanner(System.in);
		System.out.println("== Please Select... 1)Store creds 2) Fetch Creds ==");
		int option = sc.nextInt();
		switch (option) {
		case 1:
			Creds userCreds = storeCreds();
			StoreCreds.storeCreds(userCreds, userLog);
			break;
		case 2:
			chooseOptionAfterFetch(userLog);

			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}
	}

	private static void chooseOptionAfterFetch(User userLog) {

		Scanner sc = new Scanner(System.in);
		System.out.println("== Please Select... 1)Fetch All 2)Fetch By SiteName ==");
		int option = sc.nextInt();
		switch (option) {
		case 1: {
			ReadCreds.getCreds(userLog);
			break;
		}
		case 2: {
			String sitename = fetchBySite();
			List<Creds> credlist = ReadCreds.getCreds(userLog);
			FetchBySite.fetchBySite(credlist, sitename);
		}
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}
	}
}