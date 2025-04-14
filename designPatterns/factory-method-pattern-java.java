// Product interface
interface Product {
    void operation();
}

// Concrete products
class ConcreteProductA implements Product {
    @Override
    public void operation() {
        System.out.println("ConcreteProductA operation");
    }
}

class ConcreteProductB implements Product {
    @Override
    public void operation() {
        System.out.println("ConcreteProductB operation");
    }
}

// Creator abstract class
abstract class Creator {
    // Factory method
    public abstract Product createProduct();
    
    // Template method that uses the factory method
    public void anOperation() {
        // Call the factory method to create a Product object
        Product product = createProduct();
        
        // Use the product
        System.out.println("Creator: Working with the product.");
        product.operation();
    }
}

// Concrete creators
class ConcreteCreatorA extends Creator {
    @Override
    public Product createProduct() {
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB extends Creator {
    @Override
    public Product createProduct() {
        return new ConcreteProductB();
    }
}

// Client code demonstrating the pattern
public class FactoryMethodPatternDemo {
    public static void main(String[] args) {
        // Using ConcreteCreatorA
        Creator creatorA = new ConcreteCreatorA();
        System.out.println("Using ConcreteCreatorA:");
        creatorA.anOperation();
        
        // Using ConcreteCreatorB
        Creator creatorB = new ConcreteCreatorB();
        System.out.println("\nUsing ConcreteCreatorB:");
        creatorB.anOperation();
        
        // Direct product creation for demonstration
        System.out.println("\nDirect product creation:");
        Product productA = new ConcreteCreatorA().createProduct();
        productA.operation();
        
        Product productB = new ConcreteCreatorB().createProduct();
        productB.operation();
    }
}
