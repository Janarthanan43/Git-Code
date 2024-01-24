package com.example.ThreadUT;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class ThreadApplicationTestcase {
	@Test
	void testSingletonBehavior() {
		// Given
		Logger spyLogger = Mockito.spy(Logger.getInstance());

		// When
		Thread t1 = new Thread(() -> {
			spyLogger.log("Message from thread1");
		});

		// Only one thread logs
		t1.start();

		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Then
		// Verify that log is called only once since only one thread logs
		verify(spyLogger, times(1)).log("Message from thread1");
		verify(spyLogger, times(1)).getInstance();
	}


	@Test
	void testLogOutput() {
		// Given
		Logger logger = Logger.getInstance();
		Thread t1 = new Thread(() -> {
			logger.log("Message from thread1");
		});

		Thread t2 = new Thread(() -> {
			logger.log("Message from thread2");
		});

		// When
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Then
		// It's challenging to directly test the output to System.out, consider using other testing techniques like capturing the output
	}
	@Test
	void contextLoads() {
	}

}
