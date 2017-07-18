package terminal.functionality;

import terminal.functionality.cls.ClsCommand;
import terminal.functionality.exit.ExitCommand;
import terminal.functionality.google.GoogleCommand;
import terminal.functionality.regtabs.RegTabsCommand;
import terminal.functionality.streams.StreamsCommand;
import terminal.functionality.twitch.TwitchCommand;
import terminal.ui.UIController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Greg Mitten on 15/07/2017.
 */
public class Console {
    private static Map<String, Command> commandMappings = new HashMap<>();
    public static final String COMMAND_TO_RUN_OPERA = "\"cd C:\\Program Files\\Opera && launcher.exe";


    public static void submitCommand(String userInput) throws Exception {
        String commandName = userInput.split(" ")[0];
        String parameters = null;

        if (userInput.contains(" "))
            parameters = userInput.substring(commandName.length() + 1, userInput.length());

        Command command = commandMappings.get(commandName);

        if (command == null)
            UIController.commandNotFound(userInput);
        else
            commandMappings.get(commandName).execute(parameters);
    }

    public static void registerCommand(String commandName, Command command) {
        commandMappings.put(commandName.toLowerCase(), command);
    }

    public static void setupCommands() {
        new ClsCommand().setUp();
        new StreamsCommand().setUp();
        new TwitchCommand().setUp();
        new GoogleCommand().setUp();
        new ExitCommand().setUp();
        new RegTabsCommand().setUp();
    }
}
