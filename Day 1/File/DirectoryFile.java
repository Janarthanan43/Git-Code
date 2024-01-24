package FileSystem;

import java.util.ArrayList;
import java.util.List;

public class DirectoryFile implements FileSystem {
    private String name;
    private List<FileSystem> files;

    public DirectoryFile(String name) {
        this.name = name;
        this.files = new ArrayList<>();
    }

    public void addFiletoDirectory(FileSystem file) {
        files.add(file);
    }

    public void removeFileFromDirectory(File file)
    {
        files.remove(file);
    }

    @Override
    public void structure() {
     System.out.println(name);
     for(FileSystem file:files)
     {
         file.structure();
     }
    }
}
