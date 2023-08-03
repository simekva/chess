package simekva;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class ChessController {

    @FXML GridPane grid;

    @FXML
    public void initialize() {
        Board board = new Board();
        board.initNewGame();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid.add(board.getTile(i, j), i, j);
            }
        }
    }
    
    public static void main(String[] args) {
        Board board = new Board();
        board.initNewGame();
        System.out.println(board.toString());
    }
}
