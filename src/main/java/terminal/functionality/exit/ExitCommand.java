package terminal.functionality.exit;

import terminal.functionality.AbstractCommand;

/**
 * Created by Greg Mitten on 18/07/2017.
 */
public class ExitCommand extends AbstractCommand {
    @Override
    public void execute(String parameters) throws Exception {
        System.exit(0);
    }
}
