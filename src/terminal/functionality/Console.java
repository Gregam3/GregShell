package terminal.functionality;

import terminal.functionality.cls.Cls;
import terminal.functionality.streams.Streams;
import terminal.ui.UIController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by i7676925 on 15/07/2017.
 */
public class Console {
    private static Map<String, Command> commandMappings = new HashMap<>();

    public static void submitCommand(String commandName) {
        Command command = commandMappings.get(commandName);
        if(command == null)
            UIController.addToTerminal("Command \""+commandName +"\" is not a recognised command.");
        else
            commandMappings.get(commandName).execute();
    }

    public static void registerCommand(String commandName, Command command) {
        commandMappings.put(commandName.toLowerCase(), command);
    }

    public static void setupCommands() {
        new Cls().setUp();
        new Streams().setUp();
    }
}
