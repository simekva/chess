package simekva;

public class Board {

    private Tile[][] board = new Tile[8][8];

    public void initBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Tile tile = new Tile(i, j, null);
                board[i][j] = tile;
            }
        }
    }

    public Tile getTile(int x, int y) {
        return board[x][y];
    }

    public void initNewGame() {
        this.initBoard();

        Piece piece = new Piece("whiterook");
        this.addTileToBoard(piece);

        Piece piece2 = new Piece("whiteknight");
        this.addTileToBoard(piece2);

        Piece piece3 = new Piece("whitebishop");
        this.addTileToBoard(piece3);

        Piece piece4 = new Piece("whitequeen");
        this.addTileToBoard(piece4);

        Piece piece5 = new Piece("whiteking");
        this.addTileToBoard(piece5);

        Piece piece6 = new Piece("whitepawn");
        this.addTileToBoard(piece6);

        Piece piece7 = new Piece("blackrook");
        this.addTileToBoard(piece7);

        Piece piece8 = new Piece("blackknight");
        this.addTileToBoard(piece8);

        Piece piece9 = new Piece("blackbishop");
        this.addTileToBoard(piece9);

        Piece piece10 = new Piece("blackqueen");
        this.addTileToBoard(piece10);

        Piece piece11 = new Piece("blackking");
        this.addTileToBoard(piece11);

        Piece piece12 = new Piece("blackpawn");
        this.addTileToBoard(piece12);

    }

    public void addTileToBoard(Piece piece) {
        for (int i = 0; i < piece.getDefaultX().size(); i++) {
            Tile tile = new Tile(piece.getDefaultX().get(i), 0, piece);
            tile.setPiece(piece);
            board[piece.getDefaultX().get(i)][piece.getDefaultY()] = tile;
        }
    }

    @Override
    public String toString() {

        String outputString = "[";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null) {
                    if (board[j][i].getPiece() != null) {
                        outputString += board[j][i].getPiece().getPieceName();
                        outputString += board[j][i].color;
                    }
                    else {
                        outputString += "null";
                    }
                    if (j != 7) {
                        outputString += ", ";
                    }
                    else {
                        outputString += ", \n";
                    }
                }
            }
        }
        String strNew = outputString.substring(0, outputString.length() - 3);
        strNew += "]";
        return strNew;
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.initNewGame();
        System.out.println(board.getTile(7, 7).getPiece().getPieceName());
        System.out.println(board.toString());
        System.out.println(board.getTile(0, 1).color);
        System.out.println(board.getTile(0, 7).getX());
    }
}