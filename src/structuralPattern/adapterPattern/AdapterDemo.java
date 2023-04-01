package structuralPattern.adapterPattern;

public class AdapterDemo {
    public static void main(String[] args) {
        RoundHole roundHole = new RoundHole();
        roundHole.setRadius(5);

        RoundPeg roundPeg = new RoundPeg();
        roundPeg.setRadius(4);

        SquarePeg squarePeg = new SquarePeg(10);
        SquarePeg squarePeg1 = new SquarePeg(100);
        //roundHole.fits(squarePeg) won't compiler mismatched types
        SquarePegAdapter sqPegAdapter = new SquarePegAdapter(squarePeg);
        SquarePegAdapter sqPegAdapter1 = new SquarePegAdapter(squarePeg1);

        System.out.println(roundHole.fits(roundPeg));
        System.out.println(roundHole.fits(sqPegAdapter));
        System.out.println(roundHole.fits(sqPegAdapter1));
    }
}
