package terminal.functionality.splashpoint;

import terminal.functionality.AbstractCommand;
import terminal.exceptions.CommandNotImplementedException;

/**
 * Created by Greg Mitten on 19/08/2017.
 */
public class SplashpointCommand extends AbstractCommand {

    //fixme Ran into an issue with Webscraping due to JavaScript, may continue in future.
    @Override
    public void execute(String parameters) throws Exception {
        throw new CommandNotImplementedException("This command is not yet implemented");
//
//        String line = null;
//
//        URL SPLASHPOINT_URL = new URL("http://www.southdownsleisure.co.uk/" +
//                "junior-activities/swimming-splashpoint/swimming-timetables/");
//
//        HttpURLConnection readableUrlConnection = (HttpURLConnection) SPLASHPOINT_URL.openConnection();
//        StringBuilder tmp = new StringBuilder();
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(
//                        readableUrlConnection.getInputStream()));
//        while ((line = in.readLine()) != null) {
//            tmp.append(line);
//        }
//
//        System.out.println(tmp.toString());
    }
}
