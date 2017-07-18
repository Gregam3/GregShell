package terminal.functionality;

/**
 * Created by i7676925 on 15/07/2017.
 */
public interface Command  {
    void execute(String parameters) throws Exception;
    void setUp();
    String getCommandName();
}
