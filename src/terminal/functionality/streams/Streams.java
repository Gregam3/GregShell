package terminal.functionality.streams;

import com.jaunt.*;
import com.jaunt.component.Form;
import terminal.functionality.AbstractCommand;
import terminal.functionality.Command;
import terminal.functionality.Console;
import terminal.ui.UIController;

/**
 * Created by i7676925 on 15/07/2017.
 */
//TODO register a callback URI so you can access their API instead
public class Streams extends AbstractCommand {

    private final String username = "GregShellBot";
    private final String password = "thisisabot";


    @Override
    public void execute(String parameters) throws ResponseException, SearchException {
        UserAgent userAgent = new UserAgent();
        userAgent.visit("http://twitch.tv/login");

        Form loginForm = userAgent.doc.getForm(0);

        loginForm.fillout("username", username);
        loginForm.fillout("password", password);
        loginForm.submit();
        System.out.println();
    }

    @Override
    public void setUp() {
        Console.registerCommand(this.getClass().getSimpleName(), this);
    }
}