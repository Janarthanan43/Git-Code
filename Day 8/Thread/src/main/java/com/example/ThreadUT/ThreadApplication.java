package com.example.ThreadUT;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThreadApplication {

	public static void main(String[] args) {

		Thread t1=new Thread(()->{
			Logger.getInstance().log("Message from thread1");
		});

		Thread t2=new Thread(()->{
			Logger.getInstance().log("Message from thread2");
		});

		t1.start();
		t2.start();
	}

}
