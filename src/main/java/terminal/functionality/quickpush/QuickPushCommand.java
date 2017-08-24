package terminal.functionality.quickpush;

import terminal.functionality.AbstractCommand;
import terminal.functionality.Console;

/**
 * Created by Greg Mitten on 24/08/2017.
 */
public class QuickPushCommand extends AbstractCommand {
    @Override
    public void execute(String parameters) throws Exception {
        Runtime.getRuntime().exec(
                "cmd /c start cmd.exe /K " +
                        "\"cd C:/Users/i7676925/IdeaProjects/GregShell && " +
                        "git add -A && " +
                        "git commit -m \"" + parameters +"\" && " +
                        "git push \""
        );
    }
}
