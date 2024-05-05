package net.sta.managers;

import net.sta.event.special.GiveawayLogik;

import java.util.Timer;
import java.util.TimerTask;

public class GiveawayTimeManager extends GiveawayLogik {



    protected void startTimer(String timeString){

        long delay = parseTimeString(timeString);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getWinner();
                timer.cancel();
            }
        }, delay);
    }


private static long parseTimeString(String timeString) {
    long totalMilliseconds = 0;

    // Aufteilen der Zeitangabe in Bestandteile
    String[] parts = timeString.split(",");
    for (String part : parts) {
        char unit = part.charAt(part.length() - 1); // Letzte Zeichen der Teilzeichenfolge

        // Konvertierung der Zeichenfolge in eine Zahl (ohne das letzte Zeichen, das die Einheit angibt)
        int value = Integer.parseInt(part.substring(0, part.length() - 1));

        // Umrechnen der Zeit in Millisekunden
        switch (unit) {
            case 'd':
                totalMilliseconds += value * 24L * 60 * 60 * 1000;
                break;
            case 'h':
                totalMilliseconds += value * 60L * 60 * 1000;
                break;
            case 'm':
                totalMilliseconds += value * 60L * 1000;
                break;
            case 's':
                totalMilliseconds += value * 1000;
                break;
            default:
                throw new IllegalArgumentException("Ungültige Einheit: " + unit);
        }
    }

    return totalMilliseconds;
}
}
