public class IdGen {
    private static IdGen instance;
    private static int count=0;

    private IdGen() {
    }

    public static synchronized IdGen  getInstance() {
        if (instance == null) {
            instance = new IdGen();
        }
        return instance;
    }

    public synchronized int generateId() {
        return count++;
    }

    public static void main(String[] args){
        IdGen generator= IdGen.getInstance();
        int id1=generator.generateId();
        int id2=generator.generateId();
        System.out.println("The new id is:" + id1);
        System.out.println("The new id is:" + id2);

    }

}