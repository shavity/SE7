package geometries;

import primitives.*;
import java.util.ArrayList;
import static primitives.Util.*;
import java.util.List;

/**
 * class Plane is representing a plane in three-dimensional space
 * of cartesian coordinate system
 */

public class Plane extends Geometry {
    private Vector v;
    private Point3D p;

    /**
     * Plane constructor
     * @param v 90 degrees vector for the plane
     * @param p point on the plane
     */

    public Plane(Vector v, Point3D p)
    {
        this.v = v;
        this.p = p;
    }

    /**
     * constructor
     * @param color
     * @param v
     * @param p
     */

    public Plane(Color color,Vector v, Point3D p)
    {
        this.v = v;
        this.p = p;
        this._emmission=color;
    }

    /**
     * constructor
     * @param _emmission
     * @param _material
     * @param v
     * @param p
     */

    public Plane(Color _emmission, Material _material, Vector v, Point3D p) {
        super(_emmission, _material);
        this.v = v;
        this.p = p;
    }

    /**
     * copy constructor
     * @param pl Plane to copy from
     */

    public Plane (Plane pl)
    {
        this.p = pl.p;
        this.v = pl.v;
    }

    /**
     * constructor by three points on the Plane
     * @param a point that starts two vectors on the Plane, and the point on the plane
     * @param b point that it is the destination of one of the vector
     * @param c point that it is the destination of the other
     */

    public Plane (Point3D a, Point3D b, Point3D c)
    {
        this.p = a;
        this.v = a.subtract(b).crossProduct(a.subtract(c)).normalize();
    }

    /**
     * Vector getter, get the 90 degrees vector of te plane as normal
     * @return normal vector
     */

    public Vector getV()
    {
        return v.normalized();
    }

    public void setV(Vector v)
    {
        this.v = v;
    }

    /**
     * Point_3D getter, get the point that on the plane
     * @return Point_3D
     */

    public Point3D getP()
    {
        return p;
    }

    public void setP(Point3D p)
    {
        this.p = p;
    }

    /**
     *
     * @param p3d no need actually
     * @return 90 degrees vector, len = 1
     */

    @Override
    public Vector getNormal(Point3D p3d)
    {
        return v.normalized();
    }

    /**
     * Finds all the points of intersection of the given ray with the plane
     * @param ray The ray with which the cutting with the plane is calculated
     * @return All the points of intersection of the ray with the plane
     */

    @Override
    public List<GeoPoint> findIntersections(Ray ray)
    {
        Vector vec;
        try
        {
            vec = new Vector(p.subtract(ray.getP()));
        }
        catch (IllegalArgumentException e)
        {
            return null; // ray starts from point Q - no intersections
        }

        double nv = v.dotProduct(ray.getV());

        if (isZero(nv)) // ray is parallel to the plane - no intersections
            return null;

        double s = alignZero(v.dotProduct(vec) / nv);

        if(s <= 0)
        {
            return null;
        }

        return List.of(new GeoPoint(this, ray.get_VP(s)));
    }
}
