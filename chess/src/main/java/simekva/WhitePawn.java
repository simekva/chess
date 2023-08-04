package simekva;

public class WhitePawn extends Piece {

    private int x;
    private int y;
    private int[][] path = {{0, -1}, {0, -2}, {1, -1}, {-1, -1}};
    
    public WhitePawn(int x, int y) {
        this.setPieceName("whitepawn");
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

    public static void main(String[] args) {
        WhitePawn pawn = new WhitePawn(0, 0);
        System.out.println(pawn.getImagePath());
    }
}
