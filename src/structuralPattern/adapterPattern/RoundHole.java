package structuralPattern.adapterPattern;

public class RoundHole {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public boolean fits(RoundPeg roundPeg) {
        return this.radius > roundPeg.getRadius();
    }
}
