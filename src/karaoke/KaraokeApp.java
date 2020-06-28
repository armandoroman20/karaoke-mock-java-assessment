package karaoke;

import java.util.Arrays;
import java.util.Scanner;

public class KaraokeApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String userChoice = null;

        Player musicPlayer = new MusicPLayer("victoria"); // can change the voice
        Player lyricsPlayer = new LyricsPLayer("blue"); // can change the color

//        Album a = new Album("90s Hits", Arrays.asList(
//           new karaoke.Song("Every Day is a Winding Road", "Sheryl Crow", karaoke.Song.parseLyrics("Everyday is a winding road ... I get a little bit closer to feeling fine")),
//           new karaoke.Song("Ready to Go", "Republica", karaoke.Song.parseLyrics("I'm standing on the rooftops shouting out, Baby, I'm ready to go")),
//           new karaoke.Song("Airbag", "Radiohead", karaoke.Song.parseLyrics("In an interstellar burst I am back to save the universe"))
//        ));

        Album b = new Album("Disintegration", Arrays.asList(
                new Song("Pictures of You", "The Cure", Song.parseLyrics("I've been looking so long at these pictures of you, that I almost believe that they're real")),
                new Song("Love Song", "The Cure", Song.parseLyrics("Whenever i'm alone with you, you make me feel like I am home again. Whenever I'm alone with you, you make me feel like I am whole again"))

        ));

        runKaraokeMachine(scanner, userChoice, musicPlayer, lyricsPlayer, b);

    }

    public static void runKaraokeMachine(Scanner scanner, String userChoice, Player musicPlayer, Player lyricsPlayer, karaoke.Album a) {
        System.out.println(a.getAlbumName() + " track listing...");
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
