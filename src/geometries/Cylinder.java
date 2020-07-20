package geometries;

import primitives.*;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 * Class Cylinder is representing a cylinder on three-dimensional plane for cartesian coordinate
 */

public class Cylinder extends Tube
{
    private double len;

    /**
     * Cylinder constructor Ray and two doubles
     * @param c Ray of direction and place (the center of it)
     * @param l length of cylinder
     * @param r radius of cylinder
     */

    public Cylinder (Ray c,double l, double r)
    {
        super(c, r);
        this.len = l;
    }

    /**
     * Cylinder's length getter
     * @return length of cylinder
     */

    public double getLen()
    {
        return len;
    }

    @Override
    public Vector getNormal(Point3D p)
    {
        Point3D p1 = this.getCenter().getP();
        Vector v = this.getCenter().getV();

        // projection of P-O on the ray:
        double t;
        try {
            t = alignZero(p.subtract(p1).dotProduct(v));
        } catch (IllegalArgumentException e) { // P = O
            return v;
        }

        // if the point is at a base
        if (t == 0 || isZero(len - t)) // if it's close to 0, we'll get ZERO vector exception
            return v;

        p1 = p1.add(v.scale(t));
        return p.subtract(p1).normalize();
    }
}
