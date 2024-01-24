package com.example.WindowsFileSystem;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WindowsFileSystemApplication {

	public static void main(String[] args) {

		FileWindowsApplication.File document = new FileWindowsApplication.File("Application.txt");
		FileWindowsApplication.File image = new FileWindowsApplication.File("photo.jpg");


		FileWindowsApplication.Directory root = new FileWindowsApplication.Directory("user");
		FileWindowsApplication.Directory documents = new FileWindowsApplication.Directory("Appliactions");


		documents.addComponent(document);
		documents.addComponent(image);


		root.addComponent(documents);


		root.showDetails();
	}
}
