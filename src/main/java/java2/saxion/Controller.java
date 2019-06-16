package java2.saxion;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.w3c.dom.Text;


public class Controller {

    private Sudoku sudoku;
    private TextField[][] cells;
    private boolean proceed;

    @FXML
    private GridPane gridPane;

    public Controller(){
        cells = new TextField[9][9];
    }


    public void addGame(Sudoku sudokuGame){
        sudoku = sudokuGame;
    }

    public void fillGridCells(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(sudoku.getValue(i, j) != 0){
                    TextField field = new TextField(String.valueOf(sudoku.getValue(i, j)));
                    field.setEditable(false);
                    field.setPrefSize(50, 50);
                    //field.setStyle("-fx-background-color:transparent;");
                    gridPane.setHalignment(field, HPos.CENTER);
                    GridPane.setConstraints(field, i, j);
                    gridPane.getChildren().add(field);
                    cells[i][j] = field;
                }else{
                    var field = new TextField();
                    field.setText("X");
                    field.setStyle("-fx-text-fill: red; -fx-font-size: 16px; ");
                    field.setPrefSize(50, 50);
                    gridPane.add(field, i, j);
                    cells[i][j] = field;
                }
            }
        }
    }

    public void mapGridToCells(){
        int index = 1;

        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Node node = gridPane.getChildren().get(index);
                if(node instanceof TextField){
                    cells[i][j] = ((TextField) node);
                }
                index++;
            }
        }
    }

    public void submit(){
        mapGridToCells();
        var maxCount = 0;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                try {
                    var value = Integer.parseInt(cells[i][j].getText());

                    if (sudoku.isValueSuitableToPutThere(i, j, value)) {
                        sudoku.setValue(i, j, value);
                        cells[i][j].setStyle("-fx-text-fill: green; -fx-font-size: 16px; ");
                        System.out.println("Correct!");
                    }
                }catch(Exception e){
//                    if(maxCount == 0) WinLose.display("Dude?" , "FIRST FINISH THE GAME MY DUDE!");
//                    maxCount++;
                    proceed = false;
                }
            }
        }

        if(sudoku.checkIfFinished()){
            WinLose.display("YOU WON", "YOU WON MY DUDE!");
        }
    }

    public void solve(){
        if(AreYouSure.display("Dude?", "Are you sure you want to cheat?")) {
            sudoku.solve();
            fillGridCells();
        }

    }
}
