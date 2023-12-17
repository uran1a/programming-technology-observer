package programmingtechnology.observer.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import programmingtechnology.observer.logics.Subject;
import programmingtechnology.observer.models.*;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button startButton, stopButton;
    @FXML
    private ImageView imageView;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private TextField timerTextField;
    private Subject subject = new Subject();
    private ComponentText ct;
    ComponentProgress cp;
    private ComponentSlider cs;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addObs();
        this.startButton.setOnMouseClicked(this::startHandler);
        this.stopButton.setOnMouseClicked(this::stopHandler);
    }

    private void stopHandler(MouseEvent event) {
        subject.stop();
        ct.offComp();
        cp.offComp();
        cs.offComp();
    }

    private void startHandler(MouseEvent event) {
        subject.start(1, 1);
        ct.onComp();
        cp.onComp();
        cs.onComp();
    }
    private void addObs(){
        ct = new ComponentText(subject, timerTextField);
        cp = new ComponentProgress(subject, progressBar);
        cs = new ComponentSlider(subject, imageView);
    }
    private void delObs(){
        ct.delComp(subject);
        cp.delComp(subject);
        cs.delComp(subject);
    }
}
