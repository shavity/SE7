package primitives;

/**
 * the class Material is representing different kinds of materials
 * that geometries are made of
 */

public class Material {

    private double kT;
    private double kR;
    private double kD;
    private double kS;
    private int nS;

    /**
     * constructor
     * @param kD diffuse coefficient
     * @param kS specular coefficient
     * @param nS Shininess coefficient
     * @param kR reflection coefficient
     * @param kT transparency coefficient
     */

    public Material(double kD, double kS, int nS, double kR, double kT) {
        this.kD = kD;
        this.kS = kS;
        this.nS = nS;
        this.kR = kR;
        this.kT = kT;
    }

    /**
     * constructor
     * @param kD diffuse coefficient
     * @param kS specular coefficient
     * @param nS Shininess coefficient
     */

    public Material(double kD, double kS, int nS)
    {
        this(kD, kS, nS, 0, 0);
    }

    /**
     * copy constructor
     * @param m material to copy from
     */

    public Material(Material m)
    {
        this(m.kD, m.kS, m.nS, m.kR, m.kT);
    }

    /**
     * double value getter
     * @return diffuse coefficient
     */

    public double getkD() {
        return kD;
    }

    /**
     * double value getter
     * @return specular coefficient
     */

    public double getkS() {
        return kS;
    }

    /**
     * double value getter
     * @return Shininess coefficient
     */

    public int getnS() {
        return nS;
    }

    /**
     * double value getter
     * @return reflection coefficient
     */

    public double getkR() {
        return kR;
    }

    /**
     * double value getter
     * @return transparency coefficient
     */

    public double getkT() {
        return kT;
    }
}
