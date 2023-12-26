package programmingtechnology.observer.models;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import programmingtechnology.observer.logics.ConcreteAggregate;
import programmingtechnology.observer.logics.Meme;
import programmingtechnology.observer.logics.Observer;
import programmingtechnology.observer.logics.Subject;

import java.io.File;

public class ComponentProgress extends Observer {
    ProgressBar progressBar;
    Subject subject;
    Boolean state;
    double progress = 0;
    public ComponentProgress(Subject subject, ProgressBar progressBar) {
        this.progressBar = progressBar;
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        if(state){
            progress = (progress + 1) % 10;
            progressBar.setProgress(progress / 10.0);
        }
    }

    public void delComp() {
        subject.detach(this);
    }

    public void onComp() {
        state = true;
    }

    public void offComp() {
        state = false;
    }
}
