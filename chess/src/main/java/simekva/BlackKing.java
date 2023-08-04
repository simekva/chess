package simekva;
public class BlackKing extends Piece {

    private int x;
    private int y;
    private int[][] path = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1 ,0}, {-1, 1}};
    
    public BlackKing(int x, int y) {
        this.setPieceName("blackking");
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