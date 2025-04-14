// Basic Singleton implementation
class BasicSingleton {
    // Private static instance variable
    private static BasicSingleton instance;
    
    // Private constructor prevents instantiation from other classes
    private BasicSingleton() {
        System.out.println("BasicSingleton instance created");
    }
    
    // Public static method to get the instance
    public static BasicSingleton getInstance() {
        if (instance == null) {
            instance = new BasicSingleton();
        }
        return instance;
    }
    
    public void doSomething() {
        System.out.println("BasicSingleton is doing something");
    }
}

// Thread-safe Singleton with eager initialization
class EagerSingleton {
    // Private static instance is created at class loading time
    private static final EagerSingleton INSTANCE = new EagerSingleton();
    
    private EagerSingleton() {
        System.out.println("EagerSingleton instance created");
    }
    
    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
    
    public void doSomething() {
        System.out.println("EagerSingleton is doing something");
    }
}

// Thread-safe Singleton with lazy initialization (double-checked locking)
class ThreadSafeSingleton {
    // Volatile ensures visibility across threads
    private static volatile ThreadSafeSingleton instance;
    
    private ThreadSafeSingleton() {
        System.out.println("ThreadSafeSingleton instance created");
    }
    
    public static ThreadSafeSingleton getInstance() {
        // First check (no locking)
        if (instance == null) {
            // Lock only when instance might be null
            synchronized (ThreadSafeSingleton.class) {
                // Second check (with locking)
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
    
    public void doSomething() {
        System.out.println("ThreadSafeSingleton is doing something");
    }
}

// Enum Singleton (Java 5+) - concise and handles serialization
enum EnumSingleton {
    INSTANCE;
    
    EnumSingleton() {
        System.out.println("EnumSingleton instance created");
    }
    
    public void doSomething() {
        System.out.println("EnumSingleton is doing something");
    }
}

// Static holder Singleton - thread-safe with lazy initialization
class StaticHolderSingleton {
    // Private constructor
    private StaticHolderSingleton() {
        System.out.println("StaticHolderSingleton instance created");
    }
    
    // Static holder class responsible for holding the singleton instance
    private static class SingletonHolder {
        private static final StaticHolderSingleton INSTANCE = new StaticHolderSingleton();
    }
    
    // Public static method to get the instance
    public static StaticHolderSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
    
    public void doSomething() {
        System.out.println("StaticHolderSingleton is doing something");
    }
}

// Client code demonstrating the pattern
public class SingletonPatternDemo {
    public static void main(String[] args) {
        System.out.println("Demonstrating BasicSingleton:");
        BasicSingleton basicSingleton1 = BasicSingleton.getInstance();
        BasicSingleton basicSingleton2 = BasicSingleton.getInstance();
        basicSingleton1.doSomething();
        System.out.println("Same instance? " + (basicSingleton1 == basicSingleton2));
        
        System.out.println("\nDemonstrating EagerSingleton:");
        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
        EagerSingleton eagerSingleton2 = EagerSingleton.getInstance();
        eagerSingleton1.doSomething();
        System.out.println("Same instance? " + (eagerSingleton1 == eagerSingleton2));
        
        System.out.println("\nDemonstrating ThreadSafeSingleton:");
        ThreadSafeSingleton threadSafeSingleton1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton threadSafeSingleton2 = ThreadSafeSingleton.getInstance();
        threadSafeSingleton1.doSomething();
        System.out.println("Same instance? " + (threadSafeSingleton1 == threadSafeSingleton2));
        
        System.out.println("\nDemonstrating EnumSingleton:");
        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE;
        EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE;
        enumSingleton1.doSomething();
        System.out.println("Same instance? " + (enumSingleton1 == enumSingleton2));
        
        System.out.println("\nDemonstrating StaticHolderSingleton:");
        StaticHolderSingleton staticHolderSingleton1 = StaticHolderSingleton.getInstance();
        StaticHolderSingleton staticHolderSingleton2 = StaticHolderSingleton.getInstance();
        staticHolderSingleton1.doSomething();
        System.out.println("Same instance? " + (staticHolderSingleton1 == staticHolderSingleton2));
    }
}
