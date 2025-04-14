import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(String message);
}

// Concrete observers
class ConcreteObserverA implements Observer {
    private String name;
    
    public ConcreteObserverA(String name) {
        this.name = name;
    }
    
    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}

class ConcreteObserverB implements Observer {
    private String name;
    
    public ConcreteObserverB(String name) {
        this.name = name;
    }
    
    @Override
    public void update(String message) {
        System.out.println(name + " received update: " + message);
        System.out.println(name + " is taking action based on this update.");
    }
}

// Subject (Observable)
class Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;
    
    public void setState(String state) {
        this.state = state;
        notifyAllObservers();
    }
    
    public String getState() {
        return state;
    }
    
    public void attach(Observer observer) {
        observers.add(observer);
    }
    
    public void detach(Observer observer) {
        observers.remove(observer);
    }
    
    private void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}

// Client code demonstrating the pattern
public class ObserverPatternDemo {
    public static void main(String[] args) {
        // Create subject
        Subject subject = new Subject();
        
        // Create observers
        Observer observerA1 = new ConcreteObserverA("Observer A1");
        Observer observerA2 = new ConcreteObserverA("Observer A2");
        Observer observerB = new ConcreteObserverB("Observer B");
        
        // Register observers to the subject
        subject.attach(observerA1);
        subject.attach(observerA2);
        subject.attach(observerB);
        
        // Change subject state
        System.out.println("First state change: ");
        subject.setState("First state change");
        
        // Detach an observer
        subject.detach(observerA2);
        
        System.out.println("\nSecond state change: ");
        subject.setState("Second state change");
    }
}
