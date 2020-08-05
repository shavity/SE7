package primitives;

import static primitives.Util.*;

/**
 * the class 'Ray' is representing a ray that have direction and point that place it in the magnitude
 */

public class Ray
{
    private Vector v;
    private Point3D p;

    /**
     * permanent from Render class
     */

    private static final double DELTA = 0.1;

    /**
     * @param point3D ray point
     * @param vector ray direction
     * @param normal as its name
     */
    public Ray(Point3D point3D, Vector vector, Vector normal)
    {
        double temp = normal.dotProduct(vector);
        double delta = DELTA;
        if (temp <= 0)
        {
            delta = -delta;
        }
        Vector deltaNormal = normal.scale(delta);

        p = point3D.add(deltaNormal);
        v = new Vector(vector).normalize();
    }

    /**
     * Vector for direction and Point_3D to place it
     * @param p Point_3D, place
     * @param v direction Vector
     */

    public Ray(Point3D p, Vector v)
    {
        this.v = v.normalize();
        this.p = p;
    }

    /**
     * copy constructor
     * @param r Ray to copy from
     */

    public Ray (Ray r)
    {
        this.p = r.p;
        this.v = r.v;
    }

    /**
     * a direction only getter
     * @return Vector, direction of Ray
     */

    public Vector getV()
    {
        return v.normalized();
    }

    public void setV(Vector v)
    {
        this.v = v.normalize();
    }

    /**
     * a Point_3D getter only
     * @return Point_3D, place of Ray
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
     * @param scalar to multiply and add it to our point
     * @return new point = p + v.scale(scalar)
     */

    public Point3D get_VP(double scalar)
    {
        if(isZero(scalar))
        {
            return this.p;
        }
        else
        {
            return new Point3D(p.add(v.scale(scalar)));
        }
    }

    /**
     * casting the value of Ray in to one string to present it
     * @return String
     */

    @Override
    public String toString()
    {
        return v.toString() + ' ' + p.toString();
    }

    /**
     * check if the object we got is equal to this Ray
     * @param o Object (also may be Ray)
     * @return true if equals, else false
     */

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Ray ray = (Ray) o;

        return this.v.equals(ray.v) && this.p.equals(ray.p);
    }
}
