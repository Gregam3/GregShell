package terminal.functionality.streams;

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

    private final String CLIENT_ID = "2oibbr9895k1w9dd6ke5in4l0st6p7";
    private final String USERNAME = "GregShellBot";
    private final String PASSWORD = "thisisabot";

    //https://api.twitch.tv/kraken/users/GregShellBot/follows/channels?client_id=2oibbr9895k1w9dd6ke5in4l0st6p7


    @Override
    public void execute(String parameters) throws IOException, UnirestException {


        HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest.get("https://api.twitch.tv/kraken/streams/followed")
                .header("Accept", "application/vnd.twitchtv.v5+json")
                .header("Client-Id", CLIENT_ID)
                .header("Authorization", "OAuth"+)
                .asJson();
        System.out.println();
    }

    private String getAuthToken() {

    }
}