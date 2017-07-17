package terminal.functionality.twitch;

import com.sun.deploy.util.StringUtils;
import terminal.Exceptions.InvalidParameterException;
import terminal.functionality.AbstractCommand;

import java.io.OutputStream;

/**
 * Created by i7676925 on 16/07/2017.
 */
public class Twitch extends AbstractCommand {

    private final String OPERA_PATH = "C:\\Program Files\\Opera";

    @Override
    public void execute(String parameters) throws Exception {

        if (parameters.isEmpty() || !parameters.matches("[a-zA-Z0-9]{" + parameters.length() + "}"))
            throw new InvalidParameterException("Invalid parameter(s) for this command");

        Process child = Runtime.getRuntime().exec(
                "cmd /c start cmd.exe /K \"cd " + OPERA_PATH +
                        " && launcher.exe twitch.tv/" + parameters +
                        " && exit\"");
    }
}
