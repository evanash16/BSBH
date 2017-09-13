package music;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public final class MusicPlayer {

    public static Clip loadClip(String clipPath){
        try {
            final InputStream inputStream = MusicPlayer.class.getResourceAsStream(clipPath);
            final AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputStream);
            final AudioFormat audioFormat = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioInputStream);
            return clip;
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        return null;
    }
}
