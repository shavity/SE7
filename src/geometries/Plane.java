package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

/**
 * class Plane is representing a plane in three-dimensional space
 * of cartesian coordinate system
 */

public class Plane implements Geometry
{
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
    public List<Point3D> findIntersections(Ray ray)
    {

        //מנסה לבדוק עם המשטח מאוחורי או לא אבל עוד לא עובד
        if((v.dotProduct(ray.getV()))/(v.length()*ray.getV().length())<0)
        {
         //   return null;
        }

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
