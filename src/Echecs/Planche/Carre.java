package Echecs.Planche;
import Echecs.Pieces.Piece;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

public abstract class Carre {
    protected final int coordone; // set once in the constructor.
    private static final Map<Integer, CarreVide> CARRES_VIDE_CACHE = creeLesCasesVidesPossibles();

    private static Map<Integer,CarreVide> creeLesCasesVidesPossibles() {
        final Map<Integer, CarreVide> carreVideMap = new HashMap<>();

        for (int i = 0; i < 64; i++){
            carreVideMap.put(i, new CarreVide(i));
        }
        //return Collections.unmodifiableMap(carreVideMap);
        return ImmutableMap.copyOf(carreVideMap);
    }

    private Carre(int coordone){
        this.coordone = coordone;
    }

    public static Carre creerCarre(final int coordone, final Piece piece) {
        return piece != null ? new CarreOccupe(coordone, piece) : CARRES_VIDE_CACHE.get(coordone);
    }

    public abstract boolean estOccupe();
    public abstract Piece getPiece();

    /**
     * CARRE VIDE
     */
    public static final class CarreVide extends Carre{
        private CarreVide(final int coordone){
            super(coordone);
        }

        @Override
        public boolean estOccupe(){ return false; }

        @Override
        public Piece getPiece() {
            return null;
        }
    }

    /**
     * CARRE occupée d'une piece
     */
    public static final class CarreOccupe extends Carre {

        private final Piece pieceDuCarre;

        private CarreOccupe(int coordone, Piece piece){
            super(coordone);
            pieceDuCarre = piece;
        }

        @Override
        public boolean estOccupe() {
            return true;
        }

        @Override
        public Piece getPiece() {
            return pieceDuCarre;
        }
    }
}
