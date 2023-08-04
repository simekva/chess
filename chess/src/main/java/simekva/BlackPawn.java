package simekva;

public class BlackPawn extends Piece {

    private int x;
    private int y;
    private int[][] path = {{0, 1}, {0, 2}, {1, 1}, {1, 1}, {-1, 1}};
    
    public BlackPawn(int x, int y) {
        this.setPieceName("blackpawn");
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
