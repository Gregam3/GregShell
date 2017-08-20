package terminal.functionality;

/**
 * Created by i7676925 on 16/07/2017.
 */
public abstract class AbstractCommand implements Command {
    public void setUp() {
        Console.registerCommand(getCommandName(), this);
    }

    public String getCommandName() {
        return this.getClass().getSimpleName().replace("Command", "");
    }
}
