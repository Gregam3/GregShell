package terminal.functionality.copyspam;

import terminal.functionality.AbstractCommand;
import terminal.ui.UIController;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Greg Mitten on 20/08/2017.
 */
public class CopySpamCommand extends AbstractCommand {
    @Override
    public void execute(String parameters) throws Exception {
        try {
            //TODO figure out why relative paths aren't working and fix all the absolute paths
            Scanner scanner = new Scanner(
                    new File("C:/Users/i7676925/IdeaProjects/GregShell/src/main/java/terminal/functionality/copyspam/" + parameters + ".txt"));

            StringBuilder spam = new StringBuilder();

            while (scanner.hasNext())
                spam.append(scanner.nextLine());

            StringSelection transferableSpam = new StringSelection(spam.toString());

            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(transferableSpam, null);

            UIController.addToTerminal("Enjoy your ban.");
        } catch (FileNotFoundException e) {
            UIController.addToTerminal("Spam " + parameters + " not recognised.");
        }
    }
}
