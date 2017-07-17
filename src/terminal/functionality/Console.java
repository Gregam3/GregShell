package terminal.functionality;

import terminal.functionality.cls.Cls;
import terminal.functionality.streams.Streams;
import terminal.functionality.twitch.Twitch;
import terminal.ui.UIController;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Greg Mitten on 15/07/2017.
 */
public class Console {
    private static Map<String, Command> commandMappings = new HashMap<>();


    public static void submitCommand(String userInput) throws Exception {

        List<String> userInputSplit = Arrays.asList(userInput.split(" "));

        Command command = commandMappings.get(userInputSplit.get(0));

        if (command == null)
            UIController.commandNotFound(userInput);
        else
            commandMappings.get(userInputSplit.get(0)).execute(userInputSplit.get(0));
    }

    public static void registerCommand(String commandName, Command command) {
        commandMappings.put(commandName.toLowerCase(), command);
    }

    public static void setupCommands() {
        new Cls().setUp();
        new Streams().setUp();
        new Twitch().setUp();
    }
}
