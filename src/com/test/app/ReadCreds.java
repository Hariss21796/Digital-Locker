package com.test.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;

import com.test.model.Creds;
import com.test.model.User;

public class ReadCreds {

	public static List<Creds> getCreds(User user) {

		List<Creds> credsList = new LinkedList<Creds>();

		try {
			File f = new File(user.getName() + "lockme-db-creds.txt");
			if (f.exists()) {
				FileInputStream file = new FileInputStream(user.getName() + "lockme-db-creds.txt");
				ObjectInputStream input = new ObjectInputStream(file);
				credsList = (List<Creds>) input.readObject();
				System.out.println(credsList);
				input.close();
				file.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return credsList;
	}

}
