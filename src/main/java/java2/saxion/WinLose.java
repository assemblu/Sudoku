package java2.saxion;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class WinLose {

    public static void display(String title, String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        window.setMinHeight(30);
        var label = new Label();
        label.setText(message);


        var layout = new HBox();
        layout.getChildren().addAll(label);
        var scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
