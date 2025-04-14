// Abstract product interfaces
interface Button {
    void render();
    void onClick();
}

interface Checkbox {
    void render();
    void onCheck();
}

// Concrete products for family A (Light theme)
class LightButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering light button");
    }
    
    @Override
    public void onClick() {
        System.out.println("Light button clicked");
    }
}

class LightCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering light checkbox");
    }
    
    @Override
    public void onCheck() {
        System.out.println("Light checkbox checked");
    }
}

// Concrete products for family B (Dark theme)
class DarkButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering dark button");
    }
    
    @Override
    public void onClick() {
        System.out.println("Dark button clicked");
    }
}

class DarkCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering dark checkbox");
    }
    
    @Override
    public void onCheck() {
        System.out.println("Dark checkbox checked");
    }
}

// Abstract factory interface
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete factories
class LightThemeFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new LightButton();
    }
    
    @Override
    public Checkbox createCheckbox() {
        return new LightCheckbox();
    }
}

class DarkThemeFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new DarkButton();
    }
    
    @Override
    public Checkbox createCheckbox() {
        return new DarkCheckbox();
    }
}

// Client class that uses the factory
class Application {
    private Button button;
    private Checkbox checkbox;
    
    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }
    
    public void createUI() {
        System.out.println("Creating UI components:");
        button.render();
        checkbox.render();
    }
    
    public void clickButton() {
        button.onClick();
    }
    
    public void checkCheckbox() {
        checkbox.onCheck();
    }
}

// Client code demonstrating the pattern
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        // Create the light theme application
        System.out.println("Light Theme Application:");
        GUIFactory lightFactory = new LightThemeFactory();
        Application lightApp = new Application(lightFactory);
        lightApp.createUI();
        lightApp.clickButton();
        lightApp.checkCheckbox();
        
        System.out.println("\n------------------\n");
        
        // Create the dark theme application
        System.out.println("Dark Theme Application:");
        GUIFactory darkFactory = new DarkThemeFactory();
        Application darkApp = new Application(darkFactory);
        darkApp.createUI();
        darkApp.clickButton();
        darkApp.checkCheckbox();
    }
}
