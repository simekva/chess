package simekva;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tile extends Button {
    
    private int x;
    private int y;
    private Piece piece;
    public String color;

    public Tile(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;

        if (piece != null && piece.getPieceName() == "blackpawn") {
            this.y = 1;
        }
        else if (piece != null && piece.getPieceName() == "whitepawn") {
            this.y = 6;
        }
        else if (piece != null && piece.getPieceName().contains("black")) {
            this.y = 0;
        }
        else if (piece != null && piece.getPieceName().contains("white")) {
            this.y = 7;
        }
        if ((this.x + this.y) % 2 == 0) {
            this.setStyle("-fx-color: rgba(240,217,181,255)");
        }
        else {
            this.setStyle("-fx-color: rgba(181,136,99,255)");
        }
        this.setPrefSize(100, 100);

        if ((this.x + this.y) % 2 == 0) {
            this.color = "white";
        }
        else {
            this.color = "green";
        }

        if (piece != null) {
        Image img = new Image(piece.getImagePath());
        ImageView view = new ImageView(img);
        view.setFitHeight(80);
        view.setPreserveRatio(true);
        this.setGraphic(view);
        }
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public static void main(String[] args) {
        
    }

}
