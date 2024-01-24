package NotificationServer;

public class Mobile implements Observer{

    private String app;

    public Mobile(String app) {
        this.app = app;
    }

    @Override
    public void update(String msg) {
        System.out.println(app+" receives update "+msg);
    }
}