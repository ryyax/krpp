package Interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {
    @FXML
    private Button exitButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void initialize() {
        exitButton.setOnAction(Event -> {
            System.exit(0);
        });
    }

    public void openGatherTroopToAttack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Interface/gatherTroopToAttack-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void openGatherKnightsToRebels(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Interface/gatherKnightsToRebels-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void openMakeKnight(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Interface/makeKnight-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void openEquippKnight(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Interface/equippKnight-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void openChangeKnightTitle(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Interface/changeKnightsTitle-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void openExecuteKnight(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Interface/executeKnight-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}