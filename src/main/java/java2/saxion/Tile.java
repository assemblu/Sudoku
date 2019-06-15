package java2.saxion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Tile extends StackPane {

    public Tile(String value){
        var border = new Rectangle(50,50);
        border.setFill(null);
        border.setStroke(Color.BLACK);

        var text = new Text(value);
        text.setFont(Font.font(30));

        setAlignment(Pos.CENTER);
        getChildren().addAll(border, text);
    }
}
