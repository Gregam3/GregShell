package terminal.functionality.google;

import terminal.functionality.AbstractCommand;
import terminal.functionality.Console;

/**
 * Created by Greg Mitten on 18/07/2017.
 */
public class GoogleCommand extends AbstractCommand {

    @Override
    public void execute(String parameters) throws Exception {
        Runtime.getRuntime().exec(
                "cmd /c start cmd.exe /K " +
                        Console.COMMAND_TO_RUN_OPERA +
                        " https://www.google.co.uk/search?client=opera^&q=" +
                        parameters.replace(" ", "+") +
                        " && exit\""
        );
    }
}
