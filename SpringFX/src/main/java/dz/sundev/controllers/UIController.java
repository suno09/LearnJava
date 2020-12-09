package dz.sundev.controllers;

import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class UIController implements Initializable {
    private final HostServices hostServices;

    @FXML
    private Label label;

    @FXML
    private Button btn;

    @FXML
    void btn_set_on_action() {
        label.setText(this.hostServices.getDocumentBase());
    }

    public UIController(HostServices hostServices) {
        this.hostServices = hostServices;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText("ffffffffffffffffff");
    }
}
