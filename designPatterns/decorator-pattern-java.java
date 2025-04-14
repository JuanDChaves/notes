// Component interface
interface Component {
    String operation();
}

// Concrete component
class ConcreteComponent implements Component {
    @Override
    public String operation() {
        return "ConcreteComponent";
    }
}

// Base decorator class
abstract class Decorator implements Component {
    protected Component component;
    
    public Decorator(Component component) {
        this.component = component;
    }
    
    @Override
    public String operation() {
        return component.operation();
    }
}

// Concrete decorators
class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }
    
    @Override
    public String operation() {
        return "ConcreteDecoratorA(" + super.operation() + ")";
    }
    
    // Additional behavior
    public String additionalOperation() {
        return "Additional functionality from DecoratorA";
    }
}

class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component component) {
        super(component);
    }
    
    @Override
    public String operation() {
        return "ConcreteDecoratorB(" + super.operation() + ")";
    }
}

// Client code demonstrating the pattern
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        // Create a simple component
        Component simple = new ConcreteComponent();
        System.out.println("Simple component: " + simple.operation());
        
        // Decorate the component with ConcreteDecoratorA
        Component decoratorA = new ConcreteDecoratorA(simple);
        System.out.println("Decorated with A: " + decoratorA.operation());
        
        // Decorator A cast to access additional functionality
        ConcreteDecoratorA decoratorACast = (ConcreteDecoratorA) decoratorA;
        System.out.println("Additional functionality: " + decoratorACast.additionalOperation());
        
        // Decorate the component with ConcreteDecoratorB
        Component decoratorB = new ConcreteDecoratorB(simple);
        System.out.println("Decorated with B: " + decoratorB.operation());
        
        // Stack multiple decorators
        Component decoratorAB = new ConcreteDecoratorB(new ConcreteDecoratorA(simple));
        System.out.println("Decorated with A, then B: " + decoratorAB.operation());
        
        Component decoratorBA = new ConcreteDecoratorA(new ConcreteDecoratorB(simple));
        System.out.println("Decorated with B, then A: " + decoratorBA.operation());
    }
}
