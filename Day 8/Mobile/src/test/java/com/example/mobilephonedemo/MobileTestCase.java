package com.example.mobilephonedemo;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
class MobileTestCase {

	@Mock
	private Mobile mockedPhone;

	//@InjectMocks
	//private MobilePhoneService mobilePhoneService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetModel() {
		when(mockedPhone.getModel()).thenReturn("TestModel");

		String result = mockedPhone.getModel();

		assertEquals("TestModel", result);
	}

	@Test
	public void testGetVersion() {
		when(mockedPhone.getVersion()).thenReturn("1.0");

		String result = mockedPhone.getVersion();

		assertEquals("1.0", result);
	}

	@Test
	public void testUpdateSoftware() {
		// Create a spy of the real object to mock only the updateSoftware method
		Mobile spyPhone = spy(new Mobile("AndroidPhone", "1.0"));

		// Define the behavior for the updateSoftware method
		doNothing().when(spyPhone).updateSoftware(anyString());

		// Perform the software update
		String newSoftwareVersion = "2.0";
		spyPhone.updateSoftware(newSoftwareVersion);

		// Verify that the updateSoftware method was called with the correct argument
		verify(spyPhone, times(1)).updateSoftware(eq(newSoftwareVersion));
	}

	@Test
	public void PtestUpdateSoftware() {
		// Create a spy of the real object to mock only the updateSoftware method
		Mobile spyPhone = spy(new Mobile("AndroidPhone", "1.0"));

		// Define the behavior for the updateSoftware method
		doNothing().when(spyPhone).updateSoftware(anyString());

		// Perform the software update
		String newSoftwareVersion = "2.0";
		spyPhone.updateSoftware(newSoftwareVersion);

		// Verify that the updateSoftware method was called with the correct argument
		verify(spyPhone, times(1)).updateSoftware(eq(newSoftwareVersion));
	}
	@Test
	void contextLoads() {
	}

}
