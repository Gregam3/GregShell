package terminal.functionality.cls;

import terminal.functionality.AbstractCommand;
import terminal.ui.UIController;

/**
 * Created by i7676925 on 15/07/2017.
 */
public class Cls extends AbstractCommand {

    @Override
    public void execute(String parameters) throws Exception {
        UIController.clearCommands();
    }
}
