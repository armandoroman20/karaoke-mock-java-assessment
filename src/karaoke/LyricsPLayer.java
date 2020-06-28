package karaoke;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class LyricsPLayer extends Player {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    private String textColor = "default";

    public LyricsPLayer() {
    }

    public LyricsPLayer(String textColor) {
        this.textColor = textColor;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    private void displayText(String string) {
        String colorCode = RESET;
        switch (textColor.toLowerCase()) {
            case "red":
                colorCode = RED;
                break;
            case "green":
                colorCode = GREEN;
                break;
            case "yellow":
                colorCode = YELLOW;
                break;
            case "blue":
                colorCode = BLUE;
                break;
            case "purple":
                colorCode = PURPLE;
                break;
            case "cyan":
                colorCode = CYAN;
                break;
        }
        System.out.printf("%s%s", colorCode, string);
    }


    @Override
    public void play(Song newSong) {
        System.out.println(RESET + "\nNow playing... " + newSong.getTitle() + " by " + newSong.getArtist());
        Runtime r = Runtime.getRuntime(); // allows commands to be issued to the terminal
        try {
            r.exec("say " + "now playing..." + newSong.getTitle() + " by " + newSong.getArtist());
            sleep(INTRO_PAUSE); // pauses thread
            for (String lyric : newSong.getLyrics()) {
                System.out.print(lyric + " " );
                sleep(WORD_CADENCE);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void play(Album newAlbum) {
        for (Song newSong : newAlbum.getSongs()) {
            try {
                sleep(NEXT_TRACK);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            play(newSong);
        }
    }
}
