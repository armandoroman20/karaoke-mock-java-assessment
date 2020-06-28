package karaoke;

import java.util.Arrays;
import java.util.Scanner;

public class KaraokeApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String userChoice = null;

        Player musicPlayer = new MusicPLayer("victoria"); // can change the voice
        Player lyricsPlayer = new LyricsPLayer("blue"); // can change the color

        karaoke.Album a = new karaoke.Album("90s Hits", Arrays.asList(
           new karaoke.Song("Every Day is a Winding Road", "Sheryl Crow", karaoke.Song.parseLyrics("Everyday is a winding road ... I get a little bit closer to feeling fine")),
           new karaoke.Song("Ready to Go", "Republica", karaoke.Song.parseLyrics("I'm standing on the rooftops shouting out, Baby, I'm ready to go")),
           new karaoke.Song("Airbag", "Radiohead", karaoke.Song.parseLyrics("In an interstellar burst I am back to save the universe"))
        ));

        runKaraokeMachine(scanner, userChoice, musicPlayer, lyricsPlayer, a);

    }

    public static void runKaraokeMachine(Scanner scanner, String userChoice, Player musicPlayer, Player lyricsPlayer, karaoke.Album a) {
        a.printTrackListings();

        System.out.println("\nWould you like to listen to this album (type 's') or sing karaoke with it (type 'k')? [s/k]");
        do {
            userChoice = scanner.next();
            if (!userChoice.equalsIgnoreCase("k") && !userChoice.equalsIgnoreCase("s")) {
                System.out.println("Must select either 's' or 'k'");
            }
        }
        while (!userChoice.equalsIgnoreCase("k") && !userChoice.equalsIgnoreCase("s"));

        if (userChoice.equalsIgnoreCase("k")) {
            lyricsPlayer.play(a);
        } else {
            musicPlayer.play(a);
        }
    }

}
