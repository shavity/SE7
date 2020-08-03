package geometries;

import primitives.*;

import java.util.List;

import static primitives.Util.*;

/**
 * class Tube is representing an endless tube in the space
 */

public class Tube extends RadialGeometry
{
    private Ray center;

    /**
     * Tube constructor
     * @param r the center of the tube and its direction
     * @param d the radius of the tube
     */

    public Tube(Ray r, double d)
    {
        super(d);
        this.center = r;
    }

    /**
     * Ray value getter
     * @return center of the tube
     */

    public Ray getCenter()
    {
        return center;
    }

    /**
     * @param point Point3D type
     * @return vertical vector to the tube at point
     */

    @Override
    public Vector getNormal(Point3D point) {
        Point3D p0 = center.getP();
        Vector v = center.getV();

        //t = v (p � p0)

        double t = point.subtract(p0).dotProduct(v);

        // p1 = p0 + tv.

        Point3D p1;
        if (isZero(t))// if it's close to 0, we'll get ZERO vector exception
        {
            throw new IllegalArgumentException("ERROR: Tube.getNormal: t is zero");
        }
        p1 = p0.add(v.scale(t));
        Vector n = point.subtract(p1).normalize();
        return n;
    }

    /**
     * @return the tube fields values
     */

    @Override
    public String toString() {
        return "[ " + super.toString() + "Tube [_axisRay=" + center + "]]";
    }



    @Override
    public List<GeoPoint> findIntersections(Ray ray) {
        return null;
    }
}
