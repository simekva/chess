package simekva;

import java.util.ArrayList;
import java.util.List;

public class Piece {
    
    private String pieceName;
    private String imagePath;
    private List<Integer> defaultX = new ArrayList<Integer>();
    private int defaultY;

    public Piece(String name) {
        this.pieceName = name;
        this.imagePath = "images/" + pieceName + ".png";
        if (pieceName.contains("rook")) {
            this.defaultX.add(0);
            this.defaultX.add(7);
        }
        else if (pieceName.contains("knight")) {
            this.defaultX.add(1);
            this.defaultX.add(6);
        }
        else if (pieceName.contains("bishop")) {
            this.defaultX.add(2);
            this.defaultX.add(5);
        }
        else if (pieceName.contains("queen")) {
            this.defaultX.add(3);
        }
        else if (pieceName.contains("king")) {
            this.defaultX.add(4);
        }
        if (pieceName == "whitepawn") {
            this.defaultY = 6;
            for (int i = 0; i < 8; i++) {
                this.defaultX.add(i);
            }
        }
        else if (pieceName == "blackpawn") {
            this.defaultY = 1;
            for (int i = 0; i < 8; i++) {
                this.defaultX.add(i);
            }
        }
        else if (pieceName.contains("white")) {
            this.defaultY = 7;
        }
        else if (pieceName.contains("black")) {
            this.defaultY = 0;
        }
    }

    public Piece() {
        this.pieceName = null;
        this.imagePath = null;
    }

    public String getPieceName() {
        return pieceName;
    }

    public void setPieceName(String name) {
        this.pieceName = name;
        this.imagePath = ".../resources/images/" + pieceName + ".png";
    }

    public List<Integer> getDefaultX() {
        return defaultX;
    }

    public int getDefaultY() {
        return defaultY;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public static void main(String[] args) {
        Piece piece = new Piece("blackbishop");
        System.out.println(piece.pieceName);
        System.out.println(piece.imagePath);
        System.out.println(piece.getDefaultX());
    }
}
