package terminal.functionality;

import com.jaunt.ResponseException;
import com.jaunt.SearchException;

import java.io.IOException;

/**
 * Created by i7676925 on 16/07/2017.
 */
public abstract class AbstractCommand<T> implements Command<T> {
    public void setUp() {
        Console.registerCommand(this.getClass().getSimpleName(), this);
    }
}
