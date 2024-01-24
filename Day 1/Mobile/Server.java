package NotificationServer;

public class Server {
    public static void main(String[] args) {
        PhoneUpdate notificationService=new PhoneUpdate();
        Mobile mobile=new Mobile("Telegram");
        Mobile mobile1=new Mobile("Prime");
        Mobile mobile2=new Mobile("Flipkart");

        notificationService.AddObserver(mobile);
        notificationService.AddObserver(mobile1);
        notificationService.AddObserver(mobile2);

        notificationService.Notify("Security Update");
    }
}
