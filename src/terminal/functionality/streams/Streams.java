package terminal.functionality.streams;

import terminal.functionality.Command;
import terminal.functionality.Console;

/**
 * Created by i7676925 on 15/07/2017.
 */
//TODO register a callback URI so you can access their API instead
public class Streams implements Command {

    @Override
    public void execute() {

    }

    @Override
    public void setUp() {
        Console.registerCommand(this.getClass().getSimpleName(), this);
    }
}
//user GregShellBot
//password thisisabot