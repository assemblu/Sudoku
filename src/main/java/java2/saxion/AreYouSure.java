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

public class AreYouSure {

    static boolean answer;

    public static boolean display(String title, String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        var label = new Label();
        label.setText(message);

        var yesButton = new Button("Yes");
        var maybeButton = new Button("Maybe");
        var noButton = new Button("No");


        yesButton.setOnAction(e ->{
            answer = true;
            window.close();
        });

        maybeButton.setOnAction(e ->{
            var random = new Random();
            answer = random.nextBoolean();
            window.close();
        });

        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });


        var flowPane = new FlowPane();
        flowPane.setPadding(new Insets(5, 5, 5, 5));
        flowPane.setVgap(5);
        flowPane.setHgap(4);

        flowPane.getChildren().addAll(label, yesButton, maybeButton, noButton);

        var scene = new Scene(flowPane);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}
