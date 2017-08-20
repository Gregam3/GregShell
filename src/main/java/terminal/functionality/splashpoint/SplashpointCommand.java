package terminal.functionality.splashpoint;

import com.gargoylesoftware.htmlunit.WebClient;
import terminal.functionality.AbstractCommand;

/**
 * Created by Greg Mitten on 19/08/2017.
 */
public class SplashpointCommand extends AbstractCommand {

    @Override
    public void execute(String parameters) throws Exception {
        WebClient webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);

        final String SPLASHPOINT_URL = "http://www.southdownsleisure.co.uk/" +
                "junior-activities/swimming-splashpoint/swimming-timetables/";

        webClient.getPage(SPLASHPOINT_URL);
        System.out.println(webClient.toString());

    }
}
