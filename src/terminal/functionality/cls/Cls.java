package terminal.functionality.cls;

import terminal.functionality.Command;
import terminal.functionality.Console;
import terminal.ui.UIController;

/**
 * Created by i7676925 on 15/07/2017.
 */
public class Cls implements Command{

    @Override
    public void execute() {
        UIController.clearCommands();
    }

    @Override
    public void setUp() {
        Console.registerCommand(this.getClass().getSimpleName(), this);
    }
}
