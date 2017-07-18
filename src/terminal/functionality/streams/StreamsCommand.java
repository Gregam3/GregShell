package terminal.functionality.streams;

import com.jaunt.ResponseException;
import com.jaunt.SearchException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import terminal.functionality.AbstractCommand;
import terminal.functionality.Console;

import java.io.IOException;

/**
 * Created by i7676925 on 15/07/2017.
 */
//TODO register a callback URI so you can access their API instead
public class StreamsCommand extends AbstractCommand {

    private final String username = "GregShellBot";
    private final String password = "thisisabot";

    //https://api.twitch.tv/kraken/users/GregShellBot/follows/channels?client_id=2oibbr9895k1w9dd6ke5in4l0st6p7


    @Override
    public void execute(String parameters) throws ResponseException, SearchException, IOException, UnirestException {
        HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest.get("https://api.twitch.tv/kraken/streams/followed")
                .header("Accept", "application/vnd.twitchtv.v5+json")
                .header("Client-Id", "2oibbr9895k1w9dd6ke5in4l0st6p7")
                .header("Authorization", "oauth:u224dzzeqn66yvawjs6jl8e4muru7o")
                .asJson();
        System.out.println();


    }
}