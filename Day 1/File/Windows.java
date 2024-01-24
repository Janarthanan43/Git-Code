package FileSystem;

public class Windows {
    public static void main(String[] args) {
        DirectoryFile Documents=new DirectoryFile("Folder");
        DirectoryFile ThisPC=new DirectoryFile("Personal Computer");
        DirectoryFile Pictures=new DirectoryFile("Images");

        File file1=new File("snap1.txt");
        File file2=new File("snap2.txt");
        File file3=new File("snap3.txt");
        File doc=new File("DockerFile");

        Documents.addFiletoDirectory(doc);

        ThisPC.addFiletoDirectory(Pictures);
        ThisPC.addFiletoDirectory(Documents);

        Pictures.addFiletoDirectory(file1);
        Pictures.addFiletoDirectory(file2);
        Pictures.addFiletoDirectory(file3);

        Pictures.removeFileFromDirectory(file3);

        Pictures.structure();

    }
}

