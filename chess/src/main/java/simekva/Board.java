package simekva;

import javafx.application.Platform;

public class Board {

    private Tile[][] board = new Tile[8][8];

    public void initBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Tile tile = new Tile(i, j, null);
                board[i][j] = tile;
            }
        }
        this.addTilesToNewBoard();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.getTile(i, j).placeImage();
            }
        }
    }

    public Tile getTile(int x, int y) {
        return board[x][y];
    }

    public void addTilesToNewBoard() {
        BlackRook blackRookOne = new BlackRook(0, 0);
        this.getTile(0, 0).setPiece(blackRookOne);

        BlackKnight blackKnightOne = new BlackKnight(1, 0);
        this.getTile(1, 0).setPiece(blackKnightOne);

        BlackBishop blackBishopOne = new BlackBishop(2, 0);
        this.getTile(2, 0).setPiece(blackBishopOne);

        BlackQueen blackQueen = new BlackQueen(3, 0);
        this.getTile(3, 0).setPiece(blackQueen);

        BlackKing blackKing = new BlackKing(4, 0);
        this.getTile(4, 0).setPiece(blackKing);

        BlackBishop blackBishopTwo = new BlackBishop(5, 0);
        this.getTile(5, 0).setPiece(blackBishopTwo);

        BlackKnight blackKnightTwo = new BlackKnight(6, 0);
        this.getTile(6, 0).setPiece(blackKnightTwo);

        BlackRook blackRookTwo = new BlackRook(7, 0);
        this.getTile(7, 0).setPiece(blackRookTwo);

        for (int i = 0; i < 8; i++) {
            BlackPawn blackPawn = new BlackPawn(i, 1);
            this.getTile(i, 1).setPiece(blackPawn);
        }

        WhiteRook whiteRookOne = new WhiteRook(0, 7);
        this.getTile(0, 7).setPiece(whiteRookOne);

        WhiteKnight whiteKnightOne = new WhiteKnight(1, 7);
        this.getTile(1, 7).setPiece(whiteKnightOne);

        WhiteBishop whiteBishopOne = new WhiteBishop(2, 7);
        this.getTile(2, 7).setPiece(whiteBishopOne);

        WhiteQueen whiteQueen = new WhiteQueen(3, 7);
        this.getTile(3, 7).setPiece(whiteQueen);

        WhiteKing whiteKing = new WhiteKing(4, 7);
        this.getTile(4, 7).setPiece(whiteKing);

        WhiteBishop whiteBishopTwo = new WhiteBishop(5, 7);
        this.getTile(5, 7).setPiece(whiteBishopTwo);

        WhiteKnight whiteKnightTwo = new WhiteKnight(6, 7);
        this.getTile(6, 7).setPiece(whiteKnightTwo);

        WhiteRook whiteRookTwo = new WhiteRook(7, 7);
        this.getTile(7, 7).setPiece(whiteRookTwo);

        for (int i = 0; i < 8; i++) {
            WhitePawn whitePawn = new WhitePawn(i, 6);
            this.getTile(i, 6).setPiece(whitePawn);
        }
    }

    public int[][] getPath(Piece piece) {
        if (piece.getPieceName() == "blackrook") {
            return ((BlackRook) piece).getPath();
        }
        if (piece.getPieceName() == "blackknight") {
            return ((BlackKnight) piece).getPath();
        }
        if (piece.getPieceName() == "blackbishop") {
            return ((BlackBishop) piece).getPath();
        }
        if (piece.getPieceName() == "blackqueen") {
            return ((BlackQueen) piece).getPath();
        }
        if (piece.getPieceName() == "blackking") {
            return ((BlackKing) piece).getPath();
        }
        if (piece.getPieceName() == "blackpawn") {
            return ((BlackPawn) piece).getPath();
        }
        if (piece.getPieceName() == "whiterook") {
            return ((WhiteRook) piece).getPath();
        }
        if (piece.getPieceName() == "whiteknight") {
            return ((WhiteKnight) piece).getPath();
        }
        if (piece.getPieceName() == "whitebishop") {
            return ((WhiteBishop) piece).getPath();
        }
        if (piece.getPieceName() == "whitequeen") {
            return ((WhiteQueen) piece).getPath();
        }
        if (piece.getPieceName() == "whiteking") {
            return ((WhiteKing) piece).getPath();
        }
        if (piece.getPieceName() == "whitepawn") {
            return ((WhitePawn) piece).getPath();
        }
        else {
            return null;
        }
     }

    public boolean isLegalMove(int sourceX, int sourceY, int destX, int destY) {
        Piece piece = getTile(sourceX, sourceY).getPiece();

        if (piece == null) {
            return false;
        }

        if (destX < 0 || destX > 8 || destY < 0 || destY > 8) {
            return false;
        }

        int[][] possibleMoves = this.getPath(piece);

        for (int[] move : possibleMoves) {
            int newX = sourceX + move[0];
            int newY = sourceY + move[1];

            if (newX == destX && newY == destY) {

                Tile destTile = getTile(destX, destY);
                Piece destPiece = destTile.getPiece();
                if (destPiece != null) {
                    if ((piece.getPieceName().contains("white") && destPiece.getPieceName().contains("black"))) {
                        return true;
                    }
                }
                else {
                        return true;
                }
                if ((piece.getPieceName().contains("black") && destPiece.getPieceName().contains("white"))) {
                    return true;
                }
            }
        }
        return false;
    }

    public void movePiece(int sourceX, int sourceY, int destX, int destY) {
        if (isLegalMove(sourceX, sourceY, destX, destY)) {
            Piece piece = this.getTile(sourceX, sourceY).getPiece();
            this.getTile(destX, destY).setPiece(piece);
            this.getTile(sourceX, sourceY).setPiece(null);
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
        Platform.startup(() -> {
            Board board = new Board();
            board.initBoard();
            System.out.println(board.isLegalMove(0, 1, 0, 3));
        });
    }
}