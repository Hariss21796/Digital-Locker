package com.test.app;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import com.test.model.Creds;
import com.test.model.User;

public class StoreCreds {

	public static boolean storeCreds(Creds creds, User user) {

		List<Creds> credsList = ReadCreds.getCreds(user);
		if (!credsList.isEmpty()) {
			credsList = ReadCreds.getCreds(user);

		} else {
			credsList = new LinkedList<Creds>();
			System.out.println(" First Creds Stored");
		}
		credsList.add(creds);

		try {
			FileOutputStream file = new FileOutputStream(user.getName() + "lockme-db-creds.txt");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(credsList);
			out.close();
			file.close();
			System.out.println("Creds Stored Successfully!");
		} catch (Exception e) {
			System.out.println("Failed to store creds!");
		}
		return true;
	}

}
