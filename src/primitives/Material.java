package primitives;

public class Material {
    private double kD;
    private double kS;
    private int nS;

    public Material(double kD, double kS, int nS) {
        this.kD = kD;
        this.kS = kS;
        this.nS = nS;
    }

    public double getkD() {
        return kD;
    }

    public double getkS() {
        return kS;
    }

    public int getnS() {
        return nS;
    }
}
