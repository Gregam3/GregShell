package terminal.functionality.twitch;

import com.sun.deploy.util.StringUtils;
import terminal.Exceptions.InvalidParameterException;
import terminal.functionality.AbstractCommand;
import terminal.functionality.Console;
import terminal.ui.UIController;

import java.io.OutputStream;

/**
 * Created by i7676925 on 16/07/2017.
 */
public class TwitchCommand extends AbstractCommand {

    @Override
    public void execute(String parameters) throws Exception {

        if (parameters.isEmpty() || !parameters.matches("[a-zA-Z0-9]{" + parameters.length() + "}"))
            throw new InvalidParameterException("Invalid parameter(s) for this command");

        Runtime.getRuntime().exec(
                "cmd /c start cmd.exe /K " +
                        Console.COMMAND_TO_RUN_OPERA +
                        " twitch.tv/" + parameters +
                        " && exit\""
        );
    }
}
