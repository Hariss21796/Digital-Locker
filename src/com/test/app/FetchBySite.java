package com.test.app;

import java.util.List;

import com.test.model.Creds;

public class FetchBySite {

	public static void fetchBySite(List<Creds> credsList, String sitename) {

		try {
			int match = 0;
			for (Creds userCreds : credsList) {

				if (userCreds.getSiteName().equals(sitename)) {
					System.out.println("Site Name: " + userCreds.getSiteName());
					System.out.println("Site Username: " + userCreds.getUserName());
					System.out.println("Site Password: " + userCreds.getPassword());
					match++;
				}
				if (match == 0) {
					System.out.println("Site name does not match please try again!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
