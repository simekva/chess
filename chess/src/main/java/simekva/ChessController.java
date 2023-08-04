package simekva;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class ChessController {

    Board board;
    Tile tile;
    Tile selectedTile;
    int x;
    int y;

    @FXML GridPane grid;

    @FXML
    public void initialize() {
        board = new Board();
        board.initBoard();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Tile currentTile = board.getTile(i, j);
                grid.add(board.getTile(i, j), i, j);
                currentTile.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {


                        if (currentTile.getPiece() != null) {
                            selectedTile = currentTile;
                        } else if (selectedTile != null) {
                            int destX = currentTile.getX();
                            int destY = currentTile.getY();
                            board.movePiece(selectedTile.getX(), selectedTile.getY(), destX, destY);
                            selectedTile.setGraphic(null);
                            selectedTile = null;
                            board.getTile(destX, destY).placeImage();
                        }
                    }
                });
            }
        }
    }

    public static void main(String[] args) {
        Platform.startup(() -> {
        ChessController chessController = new ChessController();
        chessController.initialize();
        });
    }
}
