// Command interface
interface Command {
    void execute();
    void undo();
}

// Receiver classes
class Light {
    private String location;
    
    public Light(String location) {
        this.location = location;
    }
    
    public void turnOn() {
        System.out.println(location + " light turned ON");
    }
    
    public void turnOff() {
        System.out.println(location + " light turned OFF");
    }
}

class Fan {
    private String location;
    private int speed = 0;
    
    public Fan(String location) {
        this.location = location;
    }
    
    public void turnOn() {
        speed = 1;
        System.out.println(location + " fan turned ON to speed " + speed);
    }
    
    public void turnOff() {
        speed = 0;
        System.out.println(location + " fan turned OFF");
    }
    
    public void increaseSpeed() {
        if (speed < 3) {
            speed++;
            System.out.println(location + " fan speed increased to " + speed);
        }
    }
    
    public void decreaseSpeed() {
        if (speed > 0) {
            speed--;
            if (speed == 0) {
                System.out.println(location + " fan turned OFF");
            } else {
                System.out.println(location + " fan speed decreased to " + speed);
            }
        }
    }
    
    public int getSpeed() {
        return speed;
    }
}

// Concrete command implementations
class LightOnCommand implements Command {
    private Light light;
    
    public LightOnCommand(Light light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.turnOn();
    }
    
    @Override
    public void undo() {
        light.turnOff();
    }
}

class LightOffCommand implements Command {
    private Light light;
    
    public LightOffCommand(Light light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.turnOff();
    }
    
    @Override
    public void undo() {
        light.turnOn();
    }
}

class FanOnCommand implements Command {
    private Fan fan;
    private int prevSpeed;
    
    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }
    
    @Override
    public void execute() {
        prevSpeed = fan.getSpeed();
        fan.turnOn();
    }
    
    @Override
    public void undo() {
        if (prevSpeed == 0) {
            fan.turnOff();
        } else {
            // This is simplified - in a real implementation you might
            // want to restore the exact previous speed
            fan.turnOn();
        }
    }
}

class FanOffCommand implements Command {
    private Fan fan;
    private int prevSpeed;
    
    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }
    
    @Override
    public void execute() {
        prevSpeed = fan.getSpeed();
        fan.turnOff();
    }
    
    @Override
    public void undo() {
        if (prevSpeed > 0) {
            fan.turnOn();
            for (int i = 1; i < prevSpeed; i++) {
                fan.increaseSpeed();
            }
        }
    }
}

class FanIncreaseSpeedCommand implements Command {
    private Fan fan;
    
    public FanIncreaseSpeedCommand(Fan fan) {
        this.fan = fan;
    }
    
    @Override
    public void execute() {
        fan.increaseSpeed();
    }
    
    @Override
    public void undo() {
        fan.decreaseSpeed();
    }
}

// Null Object pattern - a command that does nothing
class NoCommand implements Command {
    @Override
    public void execute() {
        // Do nothing
    }
    
    @Override
    public void undo() {
        // Do nothing
    }
}

// Macro command - executes multiple commands
class MacroCommand implements Command {
    private Command[] commands;
    
    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }
    
    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }
    
    @Override
    public void undo() {
        // Undo commands in reverse order
        for (int i = commands.length - 1; i >= 0; i--) {
            commands[i].undo();
        }
    }
}

// Invoker
class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    private Command undoCommand;
    
    public RemoteControl(int slots) {
        onCommands = new Command[slots];
        offCommands = new Command[slots];
        
        Command noCommand = new NoCommand();
        for (int i = 0; i < slots; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }
    
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }
    
    public void onButtonPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }
    
    public void offButtonPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }
    
    public void undoButtonPushed() {
        undoCommand.undo();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n------ Remote Control ------\n");
        for (int i = 0; i < onCommands.length; i++) {
            sb.append("[slot " + i + "] " + onCommands[i].getClass().getSimpleName() + "    " 
                      + offCommands[i].getClass().getSimpleName() + "\n");
        }
        sb.append("[undo] " + undoCommand.getClass().getSimpleName() + "\n");
        return sb.toString();
    }
}

// Client code demonstrating the pattern
public class CommandPatternDemo {
    public static void main(String[] args) {
        // Create receivers
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        Fan livingRoomFan = new Fan("Living Room");
        
        // Create commands
        Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff = new LightOffCommand(livingRoomLight);
        Command kitchenLightOn = new LightOnCommand(kitchenLight);
        Command kitchenLightOff = new LightOffCommand(kitchenLight);
        Command livingRoomFanOn = new FanOnCommand(livingRoomFan);
        Command livingRoomFanOff = new FanOffCommand(livingRoomFan);
        Command livingRoomFanIncrease = new FanIncreaseSpeedCommand(livingRoomFan);
        
        // Create macro command
        Command[] partyOn = { livingRoomLightOn, kitchenLightOn, livingRoomFanOn };
        Command[] partyOff = { livingRoomLightOff, kitchenLightOff, livingRoomFanOff };
        Command partyOnMacro = new MacroCommand(partyOn);
        Command partyOffMacro = new MacroCommand(partyOff);
        
        // Create invoker
        RemoteControl remote = new RemoteControl(5);
        
        // Set commands
        remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remote.setCommand(1, kitchenLightOn, kitchenLightOff);
        remote.setCommand(2, livingRoomFanOn, livingRoomFanOff);
        remote.setCommand(3, livingRoomFanIncrease, new NoCommand());
        remote.setCommand(4, partyOnMacro, partyOffMacro);
        
        // Show remote setup
        System.out.println(remote);
        
        // Execute commands
        System.out.println("--- Executing commands ---");
        remote.onButtonPushed(0);  // Turn on living room light
        remote.onButtonPushed(2);  // Turn on living room fan
        remote.onButtonPushed(3);  // Increase fan speed
        remote.onButtonPushed(3);  // Increase fan speed again
        remote.undoButtonPushed(); // Undo (decrease fan speed)
        remote.offButtonPushed(0); // Turn off living room light
        remote.undoButtonPushed(); // Undo (turn on living room light)
        
        System.out.println("\n--- Using macro command ---");
        remote.onButtonPushed(4);  // Party on!
        remote.offButtonPushed(4); // Party over!
        
        System.out.println("\n--- Undoing macro command ---");
        remote.onButtonPushed(4);  // Party on!
        remote.undoButtonPushed(); // Undo (turn everything off)
    }
}
