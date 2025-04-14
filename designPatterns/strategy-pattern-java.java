// Interface defining the strategy
interface Strategy {
    void execute();
}

// Concrete strategy implementations
class ConcreteStrategyA implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing strategy A");
    }
}

class ConcreteStrategyB implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing strategy B");
    }
}

class ConcreteStrategyC implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing strategy C");
    }
}

// Context class that uses a strategy
class Context {
    private Strategy strategy;
    
    // Strategy can be set at runtime
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    
    // Delegates the algorithm execution to the strategy object
    public void executeStrategy() {
        if (strategy == null) {
            System.out.println("No strategy set");
            return;
        }
        strategy.execute();
    }
}

// Client code demonstrating the pattern
public class StrategyPatternDemo {
    public static void main(String[] args) {
        // Create context
        Context context = new Context();
        
        // Create strategies
        Strategy strategyA = new ConcreteStrategyA();
        Strategy strategyB = new ConcreteStrategyB();
        Strategy strategyC = new ConcreteStrategyC();
        
        // Change strategy and execute
        context.setStrategy(strategyA);
        context.executeStrategy();
        
        context.setStrategy(strategyB);
        context.executeStrategy();
        
        context.setStrategy(strategyC);
        context.executeStrategy();
    }
}
