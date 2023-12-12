package programmingtechnology.observer.models;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import programmingtechnology.observer.logics.Observer;
import programmingtechnology.observer.logics.Subject;

import java.io.File;

public class ComponentVideo extends Observer {
    int start;
    File file;
    Media sound;
    MediaPlayer mediaPlayer;
    Boolean state;
    public ComponentVideo(Subject subject, MediaView mediaView) {
        this.state = false;
        this.start = subject.getState();
        this.file = new File("N:\\Student\\3 курс\\5 семестр\\Java\\Observer\\src\\main\\resources\\programmingtechnology\\observer\\video\\OneChance.mp4");
        sound = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaView.setMediaPlayer(mediaPlayer);
        this.subject = subject;
        this.subject.attach(this);
    }
    public void onComp() {
        this.state = true;
        mediaPlayer.play();
        this.start = subject.getState();
    }
    public void offComp() {
        this.state = false;
        mediaPlayer.pause();
    }
    public void delComp(Subject subject) {
        mediaPlayer.stop();
        subject.detach(this);
    }
    @Override
    public void update(Subject st) {
        if(!state){
                mediaPlayer.pause();
        }
    }
}
