package terminal.functionality.cls;

import org.junit.Test;
import terminal.ui.UIController;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Greg Mitten on 21/08/2017.
 */
class ClsCommandTest {

    @Test
    void testClsCommand() throws Exception {
        UIController.addToTerminal("Test");

        assertEquals(2, UIController.getSubmittedCommands().size());

        new ClsCommand().execute("");

        assertEquals(0, UIController.getSubmittedCommands().size());
    }
}