package simekva;

public class WhiteKnight extends Piece {

    private int x;
    private int y;
    private int[][] path = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

    public WhiteKnight(int x, int y) {
        this.setPieceName("whiteknight");
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
