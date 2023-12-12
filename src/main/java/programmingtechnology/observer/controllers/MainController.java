package programmingtechnology.observer.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import programmingtechnology.observer.logics.Subject;
import programmingtechnology.observer.models.ComponentSlider;
import programmingtechnology.observer.models.ComponentText;
import programmingtechnology.observer.models.ComponentVideo;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button startButton, stopButton, cleanButton;
    @FXML
    private ImageView imageView;
    @FXML
    private MediaView mediaView;
    @FXML
    private TextField timerTextField;
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;
    private Subject subject = new Subject();
    private ComponentText ct;
    private ComponentVideo cv;
    private ComponentSlider cs;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addObs();
        this.startButton.setOnMouseClicked(this::startHandler);
        this.stopButton.setOnMouseClicked(this::stopHandler);
    }

    private void stopHandler(MouseEvent event) {
        ct.offComp();
        cv.offComp();
        cs.offComp();
    }

    private void startHandler(MouseEvent event) {
        subject.start(1, 1);
        ct.onComp();
        cv.onComp();
        cs.onComp();
    }
    private void addObs(){
        ct = new ComponentText(subject, timerTextField);
        cv = new ComponentVideo(subject, mediaView);
        cs = new ComponentSlider(subject, imageView);
    }
    private void delObs(){
        ct.delComp(subject);
        cv.delComp(subject);
        cs.delComp(subject);
    }
}
