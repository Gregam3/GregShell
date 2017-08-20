package terminal.functionality.streams;

import terminal.functionality.AbstractCommand;

/**
 * Created by i7676925 on 15/07/2017.
 */
//TODO register a callback URI so you can access their API instead
public class StreamsCommand extends AbstractCommand {

    private final String username = "GregShellBot";
    private final String password = "thisisabot";

    //https://api.twitch.tv/kraken/users/GregShellBot/follows/channels?client_id=2oibbr9895k1w9dd6ke5in4l0st6p7


    @Override
    public void execute(String parameters) {
        throw new AssertionError("The Command you are attempting you access is not yet implmented.");


    }
}