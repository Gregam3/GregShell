package terminal.functionality;

import terminal.functionality.cls.Cls;
import terminal.functionality.streams.Streams;
import terminal.functionality.twitch.Twitch;
import terminal.ui.UIController;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Greg Mitten on 15/07/2017.
 */
public class Console {
    private static Map<String, Command> commandMappings = new HashMap<>();

    private static final Pattern commandPattern = Pattern.compile("([^ ]) (.*)");


    public static void submitCommand(String commandName) throws Exception {
        Matcher matcher = commandPattern.matcher(commandName);

        //Necessary to be called for regex searching
        matcher.find();

        Command command = commandMappings.get(matcher.group(1));
        if (command == null)
            UIController.addToTerminal("Command \"" + commandName + "\" is not a recognised command.");
        else
            commandMappings.get(commandName).execute(matcher.group(2));
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
