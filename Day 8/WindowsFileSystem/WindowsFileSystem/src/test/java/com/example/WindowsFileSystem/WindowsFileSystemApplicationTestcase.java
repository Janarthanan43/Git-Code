package com.example.WindowsFileSystem;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest
class WindowsFileSystemApplicationTestcase {

	/*@Test
	void testFileShowDetails() {
		// Given
		FileSystemApplication.File file = new FileSystemApplication.File("testFile.txt");

		// When
		file.showDetails();

		// Then
		// You can use Mockito to verify that the showDetails method is called
		verify(System.out).println("File: testFile.txt");
	}
   */
	@Test
	void testDirectoryShowDetails() {
		// Given
		FileWindowsApplication.Directory directory = new FileWindowsApplication.Directory("testDirectory");

		// Mock components
		FileWindowsApplication.FileSystemComponent mockFile = Mockito.mock(FileWindowsApplication.FileSystemComponent.class);
		Mockito.when(mockFile.toString()).thenReturn("MockFile");

		// Add the mock file to the directory
		directory.addComponent(mockFile);

		// When
		directory.showDetails();

		// Then
		// Verify that the showDetails method of the mock file is called
		verify(mockFile).showDetails();
		// You can also use Mockito to verify that the println statement is called, but it's more complex due to the recursive nature of showDetails
	}

	@Test
	void testWindowsFileSystemApplication() {
		// Given
		FileWindowsApplication.File document = new FileWindowsApplication.File("Application.txt");
		FileWindowsApplication.File image = new FileWindowsApplication.File("photo.jpg");

		FileWindowsApplication.Directory root = new FileWindowsApplication.Directory("user");
		FileWindowsApplication.Directory documents = new FileWindowsApplication.Directory("Applications");

		documents.addComponent(document);
		documents.addComponent(image);

		root.addComponent(documents);

		// When
		root.showDetails();

		// Then
		// You can use Mockito to verify that the showDetails methods are called for each component, but it's more complex due to the recursive nature
	}
	@Test
	void contextLoads() {
	}

}
