package terminal.functionality;

import terminal.functionality.cls.ClsCommand;
import terminal.functionality.copyspam.CopySpamCommand;
import terminal.functionality.exit.ExitCommand;
import terminal.functionality.google.GoogleCommand;
import terminal.functionality.regtabs.RegTabsCommand;
import terminal.functionality.splashpoint.SplashpointCommand;
import terminal.functionality.streams.StreamsCommand;
import terminal.functionality.twitch.TwitchCommand;
import terminal.ui.UIController;

import java.util.*;

/**
 * Created by Greg Mitten on 15/07/2017.
 */
public class Console {
    public static final String COMMAND_DELIMITER = " ";
    private static List<String> enteredCommandQueue = new LinkedList<>();
    private static Map<String, Command> commandMappings = new HashMap<>();
    public static final String COMMAND_TO_RUN_OPERA = "\"cd C:/Program Files/Opera && launcher.exe";
    private static int commandIndex = -1;


    public static void submitCommand(String userInput) throws Exception {
        enteredCommandQueue.add(0, userInput);
        userInput = userInput.toLowerCase();

        //Split input into command name
        String commandName = userInput.split(" ")[0];

        //^ and into parameters
        String parameters = null;

        if (userInput.contains(COMMAND_DELIMITER))
            parameters = userInput.substring(commandName.length() + 1, userInput.length());

        if (commandMappings.get(commandName) == null)
            UIController.outputCommandNotFound(userInput);
        else
            commandMappings.get(commandName).execute(parameters);
    }

    static void registerCommand(String commandName, Command command) {
        commandMappings.put(commandName.toLowerCase(), command);
    }

    //FIXME up and down arrows always go to the extremities of the list
    public static String getPreviousCommand() {
        return (commandIndex < enteredCommandQueue.size() - 1) ?
                enteredCommandQueue.get(++commandIndex) :
                enteredCommandQueue.get(enteredCommandQueue.size() - 1);
    }

    public static String getNextCommand() {
        return (commandIndex <= 0) ?
                enteredCommandQueue.get(--commandIndex) :
                enteredCommandQueue.get(0);
    }

    //TODO Look into finding a better solution
    public static void setupCommands() {
        new ClsCommand().setUp();
        new StreamsCommand().setUp();
        new TwitchCommand().setUp();
        new GoogleCommand().setUp();
        new ExitCommand().setUp();
        new RegTabsCommand().setUp();
        new SplashpointCommand().setUp();
        new CopySpamCommand().setUp();
    }
}
