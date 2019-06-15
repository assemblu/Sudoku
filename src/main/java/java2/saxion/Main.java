package java2.saxion;
//
//public class Main {
//
//    public static void main(String[] args) {
//        var game = new TextGameController();
//        var sudoku = new Sudoku(9, 20);
//        game.setGameModel(sudoku);
//        game.run();
//    }
//
//}

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        Parent root = loader.load();

        var controller = (Controller)loader.getController();
        var sudoku = new Sudoku(9, 10 );

        // TODO: bind the model to the controller here
        controller.addGame(sudoku);
        controller.fillGridCells();


        primaryStage.setTitle("Sudoku");
        primaryStage.setScene(new Scene(root, 600, 450));
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            if (AreYouSure.display("Dude?", "You leaving me? :'("))
                primaryStage.close();
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}