package karaoke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class MusicPLayer extends Player{

    private String voice = "";

    public MusicPLayer(){

    }

    public MusicPLayer(String newVoice) {
        this.voice = newVoice;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    @Override
    public void play(Song newSong) {
        Runtime r = Runtime.getRuntime(); // allows commands to be issued to the terminal
        try {
            r.exec("say " + "now playing..." + newSong.getTitle() + " by " + newSong.getArtist());
            sleep(INTRO_PAUSE); // pauses thread
            for (String lyric : newSong.getLyrics()) {
                if (voice.isEmpty()) {
                    r.exec("say " + lyric);
                } else {
                    r.exec("say -v " + voice + " " + lyric);
                }
                sleep(WORD_CADENCE);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // needed help on this
    @Override
    public void play(Album newAlbum) {
        for (Song newSong : newAlbum.getSongs()) {
            play(newSong);
        }
    }

}
