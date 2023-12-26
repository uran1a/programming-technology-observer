package programmingtechnology.observer.models;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import programmingtechnology.observer.logics.*;

import java.io.File;

public class ComponentSlider extends Observer {
    boolean state;
    ImageView imageView1;
    Timeline timeline;
    public ComponentSlider(Subject subject, ImageView imageView) {
        var dir = new File("C:\\Users\\voron\\Desktop\\memes");
        var conaggr = new ConcreteAggregate(dir);
        var iter = conaggr.getIterator();

        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                var meme = new Meme.Builder(iter, imageView).build();
                imageView1 = meme.getMeme();
            }
        }));
    }

    @Override
    public void update() {
        if(state)
            timeline.play();
        else
            timeline.pause();
    }

    public void delComp() {
        timeline.stop();
        subject.detach(this);
    }

    public void onComp() {
        state = true;
        timeline.play();
    }

    public void offComp() {
        state = false;
        timeline.stop();
    }
}
