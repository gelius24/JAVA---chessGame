package Echecs.Pieces;

import Echecs.Alliance;
import Echecs.Planche.Board;
import Echecs.Planche.Move;

import java.util.List;

public abstract class Piece {

    protected final int piecePosition;
    protected final Alliance pieceAlliance;

    Piece(final int piecePosition, final Alliance pieceAlliance){
        this.piecePosition = piecePosition;
        this.pieceAlliance = pieceAlliance;
    }

    public abstract List<Move> calculeMovesLegaux(final Board board);

    public Alliance getPieceAlliance(){ return pieceAlliance; }
}
