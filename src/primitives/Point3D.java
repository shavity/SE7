package primitives;

/**
 * Class 'Point_3D' is representing a dot on three-dimensional plane
 * for Cartesian Coordinate system.
 */

public class Point3D extends Point2D
{
    public static Point3D ZERO = new Point3D(0, 0, 0);

    /**
     * static ZERO to define the first of the hinges (x, y, z) as (0, 0, 0)
     */

    private Coordinate z;

    /**
     * Point_3D constructor two Coordinates values, each for an axis
     * @param x for X axis
     * @param y for Y axis
     * @param z for Z axis
     */

    public Point3D(Coordinate x, Coordinate y, Coordinate z)
    {
        super(x, y);
        this.z = z;
    }

    /**
     * default constructor for Point_3D, the point(dot) will be the first the hinges
     * (0, 0, 0)
     */

    public Point3D()
    {
        super(0d, 0d);
        this.z = new Coordinate(0);
    }

    public Point3D(double x, double y, double z)
    {
        super(x, y);
        this.z = new Coordinate(z);
    }

    /**
     * copy constructor for Point_3D
     * @param p3d
     */

    public Point3D(Point3D p3d)
    {
        super(p3d.getX(), p3d.getY());
        this.z = p3d.z;
    }

    /**
     * Point_3D value getter
     * @return point coordinate on Z axis
     */

    public Coordinate getZ()
    {
        return z;
    }

    public void setZ(Coordinate z)
    {
        this.z = z;
    }

    /**
     * casting the value of Point_3D in to one string to present it
     * @return String
     */

    @Override
    public String toString ()
    {
        return super.toString() + ", " + z.toString();
    }

    /**
     * check two things, first, is 'this' have value
     * second, is the object is just like 'this'
     * @param o an Object type (also may be Point_3D)
     * @return true if they are equal, else false
     */

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Point3D point_3D = (Point3D) o;

        return point_3D.getX().equals(this.getX()) && point_3D.getY().equals(this.getY()) && point_3D.getZ().equals(this.getZ());
    }

    /**
     * subtract calculate the Vector between two points (3D)
     * @param p3d Point_3D
     * @return Vector from p3d to 'this'
     */

    public Vector subtract(Point3D p3d)
    {
        return new Vector(new Point3D((-p3d.getX().get() + this.getX().get()), (-p3d.getY().get() + this.getY().get()), (-p3d.getZ().get() + this.getZ().get())));
    }

    /**
     * add calculate new point from 'this' and going by vector to the point
     * @param vec Vector
     * @return Point_3D from 'this' by vec
     */

    public Point3D add(Vector vec)
    {
        return new Point3D((this.getX().get() + vec.getV().getX().get()), (this.getY().get() + vec.getV().getY().get()), (this.getZ().get() + vec.getV().getZ().get()));
    }

    /**
     * distanceSquared calculating for build up for distance between two points
     * @param p3d Point_3D
     * @return double, the distance power by 2 between two points (3D)
     */

    public double distanceSquared (Point3D p3d)
    {
        return ((this.getX().get() - p3d.getX().get()) * (this.getX().get() - p3d.getX().get())
                +
                ((this.getY().get() - p3d.getY().get()) * (this.getY().get() - p3d.getY().get()))
                +
                ((this.getZ().get() - p3d.getZ().get()) * (this.getZ().get() - p3d.getZ().get())));
    }

    /**
     * distance calculate the distance between two points
     * @param p3d Point_3D
     * @return double, the distance between two points (3D)
     */

    public double distance (Point3D p3d)
    {
        return Math.sqrt(this.distanceSquared(p3d));
    }
}
