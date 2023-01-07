package Echecs.Pieces;
import Echecs.Alliance;
import Echecs.Planche.Board;
import Echecs.Planche.Carre;
import Echecs.Planche.Move;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

public class Cavalier extends Piece{

    private final static int[] COORDONEES_MOVES_CANDIDAT = {-17, -15, -10, -6, 6, 10, 15, 17};

    Cavalier(final int piecePosition, final Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public List<Move> calculeMovesLegaux(Board board) {

        int coordoneDeDestination;
        final List<Move> movesLegaux = new ArrayList<>();

        for (final int candidat : COORDONEES_MOVES_CANDIDAT){
            coordoneDeDestination = this.piecePosition + candidat;
            // si le move est valide
            if (true){
                final Carre carreDeDestination = board.getCarre(coordoneDeDestination);
                // si la destination est vide
                if (!carreDeDestination.estOccupe()){
                    movesLegaux.add(new Move()); // ***
                }
                // s'il y a une piece dans la destination
                else {
                    final Piece pieceDeDestination = carreDeDestination.getPiece();
                    final Alliance pieceAlliance = pieceDeDestination.getPieceAlliance();
                    // si la piece est ennemie
                    if (this.pieceAlliance != pieceAlliance){
                        movesLegaux.add(new Move()); // ***
                    }
                }
            }
        }

        return ImmutableList.copyOf(movesLegaux);
    }
}
