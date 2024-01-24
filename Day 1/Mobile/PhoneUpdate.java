package NotificationServer;


import java.util.ArrayList;
import java.util.List;

public class PhoneUpdate {
    private List<Observer> observers = new ArrayList<>();

    public void AddObserver(Observer observer) {
        observers.add(observer);
    }

    public void RemoveObserver(Observer observer) {
        observers.remove(observer);
    }

    public void Notify(String msg) {
        for (Observer observer : observers)
        {
            observer.update(msg);
        }
    }
}
