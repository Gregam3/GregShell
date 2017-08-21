package terminal.functionality.regtabs;

import terminal.functionality.AbstractCommand;
import terminal.functionality.Console;
import terminal.ui.UIController;

/**
 * Created by Greg Mitten on 18/07/2017.
 */
public class RegTabsCommand extends AbstractCommand {
    @Override
    public void execute(String parameters) throws Exception {
        Runtime.getRuntime().exec(
                "cmd /c start cmd.exe /K " +
                        Console.COMMAND_TO_RUN_OPERA +
                        " https://www.youtube.com/feed/subscriptions " +
                        " && launcher.exe https://www.twitch.tv/directory/following/live " +
                        " && launcher.exe https://twitter.com/?lang=en-gb" +
                        " && exit\""
        );

        UIController.addToTerminal("Tabs opened with opera.");
    }
}
