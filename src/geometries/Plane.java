package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

public class Plane implements Geometry
{
    private Vector v;
    private Point3D p;

    public Plane(Vector v, Point3D p)
    {
        this.v = v;
        this.p = p;
    }

    public Plane (Plane pl)
    {
        this.p = pl.p;
        this.v = pl.v;
    }

    public Plane (Point3D a, Point3D b, Point3D c)
    {
        this.p = a;
        this.v = a.subtract(b).crossProduct(a.subtract(c)).normalize();
    }

    public Vector getV()
    {
        return v.normalized();
    }

    public void setV(Vector v)
    {
        this.v = v;
    }

    public Point3D getP()
    {
        return p;
    }

    public void setP(Point3D p)
    {
        this.p = p;
    }

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
    public List<Point3D> findIntsersections(Ray ray)
    {
        //if there is an intersection, it will be t * r.vector away from r.point
        double t = -1 * (v.dotProduct(ray.getP().subtract(p)))/(v.dotProduct(ray.getV()));
        //this scalar multiplication will return zero if the point P0 + t*v is on the plane (90 degree angle)
        if(Util.isZero(v.dotProduct(ray.getP().add(ray.getV().scale(t)).subtract(p))))
        {
            List<Point3D> returnList = new ArrayList<Point3D>();
            returnList.add(ray.getP().add(ray.getV().scale(t)));
            return returnList;
        }

        return null;
    }
}
