package org.openjfx;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {
    @FXML
    private TextArea messageArea;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//inicializa vista

    }

    @FXML
    private  void handleButtonClick(ActionEvent e) {
        TyperTask tt = TyperTask.getInstance();
        if (!tt.isRunning()) {
            tt.setText(messageArea.getText());
            Task task = tt;
            new Thread(task).start();
        }
    }
}