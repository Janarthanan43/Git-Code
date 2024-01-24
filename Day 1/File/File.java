package FileSystem;



public class File implements FileSystem{
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void structure() {
      System.out.println(name);
    }
}
