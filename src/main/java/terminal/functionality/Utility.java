package terminal.functionality;

import java.util.Date;

/**
 * Created by Greg Mitten on 21/08/2017.
 */
public class Utility {
    public static String getTimeOfDayIntroduction() {
        int hours = new Date().getHours();
        int minutes = new Date().getMinutes();

        if (hours > 7 && hours < 12) return "Good Morning Greg, it's " + hours + ":" + minutes+".";
        else if (hours > 12 && hours < 17) return "Good Afternoon Greg, it's " + hours + ":" + minutes+".";
        else if (hours > 17 && hours < 21) return "Good Evening Greg, it's " + hours + ":" + minutes+".";
        else if (hours > 21 && (hours < 23 && minutes < 59)) return "It's getting late Greg, it's " + hours + ":" + minutes+".";
        else return "Shouldn't you be in bed, it's fucking " + hours + ":" + minutes+".";
    }
}
