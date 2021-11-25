package com.test.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;

import com.test.model.Creds;

public class FetchCreds {

	public static List<Creds> fetchCreds(Creds creds) {

		List<Creds> credsList = new LinkedList<Creds>();

		try {
			File f = new File(creds.getUserName() + "lockme-db-creds.txt");
			if (f.exists()) {
				FileInputStream file = new FileInputStream(creds.getUserName() + "lockme-db-creds.txt");
				ObjectInputStream input = new ObjectInputStream(file);
				credsList = (List<Creds>) input.readObject();

				int match = 0;
				for (Creds userCreds : credsList) {
					System.out.println(userCreds);
					System.out.println("Site Name: " + userCreds.getSiteName());
					System.out.println("Site Username: " + userCreds.getUserName());
					System.out.println("Site Password: " + userCreds.getPassword());

					match++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return credsList;
	}

}
