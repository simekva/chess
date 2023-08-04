package simekva;

public class WhiteKing extends Piece {

    private int x;
    private int y;
    private int[][] path = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1 ,0}, {-1, 1}};
    
    public WhiteKing(int x, int y) {
        this.setPieceName("whiteking");
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public int[][] getPath() {
        return this.path;
    }
}
