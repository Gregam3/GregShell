package terminal.functionality;

import com.jaunt.MultipleFound;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.SearchException;

import java.io.IOException;

/**
 * Created by i7676925 on 15/07/2017.
 */
public interface Command <T> {
    public void execute(T t) throws Exception;
}
