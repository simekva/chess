package simekva;

public abstract class Piece {
    
    private String pieceName;
    private String imagePath;

    public Piece(String name) {
        this.pieceName = name;
        this.imagePath = "images/" + pieceName + ".png";
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
        this.imagePath = "images/" + pieceName + ".png";
    }

    public String getImagePath() {
        return this.imagePath;
    }
}
