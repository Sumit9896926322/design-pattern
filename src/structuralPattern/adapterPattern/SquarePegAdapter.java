package structuralPattern.adapterPattern;

public class SquarePegAdapter extends RoundPeg {
    SquarePeg squarePeg;

    SquarePegAdapter(SquarePeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    //Radius of squarePeg with maximum side(s) is sqrt(2)s/2
    public double getRadius() {
        return Math.sqrt(squarePeg.getSide()) / 2;
    }
}
