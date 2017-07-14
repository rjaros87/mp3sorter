package pl.radoslawjaros;

import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

import java.io.File;
import java.io.FileNotFoundException;

public class Mp3Player {
    private BasicPlayer basicPlayer;
    private BasicController basicController;

    public Mp3Player() {
        basicPlayer = new BasicPlayer();
        basicController = basicPlayer;
    }

    public void play(String mp3source) throws FileNotFoundException {
        try {
            File mp3path = new File(mp3source);
            if (!mp3path.exists() || mp3path.isDirectory()){
                throw new FileNotFoundException();
            }
            basicController.open(mp3path);
            basicController.play();
            System.out.println();
        } catch (BasicPlayerException ex) {
            ex.printStackTrace();
        }
    }

    public void setGain(double gain) {
        try {
            basicController.setGain(gain);
        } catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }
}
