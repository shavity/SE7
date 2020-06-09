package primitives;

/**
 * Class 'Point_2D' is representing a dot on two-dimensional plane
 * for Cartesian Coordinate system.
 */
public class Point2D
{
    private Coordinate x;
    private Coordinate y;

    /**
     * Point_2D constructor two Coordinates values, each for an axis
     * @param x for X axis
     * @param y for Y axis
     */

    public Point2D(Coordinate x, Coordinate y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * default constructor for Point_2D, the point(dot) will be the first the hinges
     * (0, 0)
     */

    public Point2D()
    {
        this.x = new Coordinate(0);
        this.y = new Coordinate(0);
    }

    /**
     * Point_2D constructor two double values, each for an axis
     * @param x for X axis
     * @param y for Y axis
     */

    public Point2D(double x, double y)
    {
        this.x = new Coordinate(x);
        this.y = new Coordinate(y);
    }

    /**
     * copy constructor for Point_2D
     * @param p2d
     */

    public Point2D(Point2D p2d)
    {
        this.x = p2d.x;
        this.y = p2d.y;
    }

    /**
     * Point_2D value getter
     * @return point coordinate
     */

    public Coordinate getX()
    {
        return x;
    }

    public void setX(Coordinate x)
    {
        this.x = x;
    }

    /**
     * Point_2D value getter
     * @return point coordinate
     */

    public Coordinate getY()
    {
        return y;
    }

    public void setY(Coordinate y)
    {
        this.y = y;
    }

    /**
     * casting the value of Point_2D in to one string to present it
     * @return String
     */

    @Override
    public String toString()
    {
        return x.toString() + ", " + y.toString();
    }

    /**
     * check two things, first, is 'this' have value
     * second, is the object is just like 'this'
     * @param o an Object type (also may be Point_2D)
     * @return true if they are equal, else false
     */

    @Override
    public boolean equals(Object o)
    {
        if (this == o) // self
        {
            return true;
        }

        if (o == null || getClass() != o.getClass()) // type || null
        {
            return false;
        }
        Point2D point_2D = (Point2D) o;
        return x.equals(point_2D.x) && x.equals(point_2D.y);
    }
}
