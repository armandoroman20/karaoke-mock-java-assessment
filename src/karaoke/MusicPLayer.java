package karaoke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public void sleep(int INTRO_PAUSE){

    }

    @Override
    public void play(Song newSong) {
        Runtime r = Runtime.getRuntime();
        try {
            r.exec("say " + "now playing..." + newSong.getTitle() + " by " + newSong.getArtist());
            sleep(INTRO_PAUSE);
            for (String lyric : newSong.getLyrics()) {
                if (voice.isEmpty()) {
                    r.exec("say " + lyric);
                } else {
                    r.exec("say -v " + voice + " " + lyric);
                }
                sleep(WORD_CADENCE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void play(Album newAlbum) {
        for (Song newSong : newAlbum.getSongs()) {
            play(newSong);
        }
    }

}
