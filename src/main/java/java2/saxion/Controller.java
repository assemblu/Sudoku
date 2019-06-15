package java2.saxion;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;



public class Controller {

    private Sudoku sudoku;
    private int cells[][];

    @FXML
    private GridPane gridPane;

    public Controller(){
        cells = null;
    }

    public void addGame(Sudoku sudokuGame){
        sudoku = sudokuGame;
    }

    public void solve(){
        if(AreYouSure.display("Dude?", "Are you sure you want to cheat?")) {
            sudoku.solve();
            fillGridCells();
        }

    }

    public void fillGridCells(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(sudoku.getValue(i, j) != 0){
                    TextField field = new TextField(String.valueOf(sudoku.getValue(i, j)));
                    field.setEditable(false);
                    field.setPrefSize(50, 50);
                    gridPane.setHalignment(field, HPos.CENTER);
                    gridPane.add(field, i, j);;
                }else{
                    var field = new TextField();
                    field.setText("X");
                    field.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
                    field.setPrefSize(50, 50);
                    gridPane.add(field, i, j);
                }
            }
        }
    }
}
