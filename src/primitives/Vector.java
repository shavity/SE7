package primitives;

/**
 * class Vector is represent a vector between two Point_3D, one any Point_3D, second (0, 0, 0)
 */

public class Vector
{
    private Point3D v;

    /**
     * one point is enough because its from (0, 0, 0)
     * @param v Point_3D destination of the vector
     */

    public Vector(Point3D v)
    {
        if(v.equals(Point3D.ZERO))
        {
            throw new IllegalArgumentException("Error - Vector 0");
        }

        this.v = new Point3D(v);
    }

    /**
     * copy constructor
     * @param vec av vector to copy from
     */

    public Vector(Vector vec)
    {
        this.v = vec.getV();
    }

    /**
     * Vector constructor three Coordinate values
     * @param x for axis x
     * @param y for axis y
     * @param z for axis z
     */

    public Vector(Coordinate x, Coordinate y, Coordinate z)
    {
        if(x.equals(0d) && y.equals(0d) && z.equals(0d)) // check for valuable vector
        {
            throw new IllegalArgumentException("Error - Vector 0");
        }

        this.v = new Point3D(x, y, z);
    }

    /**
     * Vector constructor three double values
     * @param x for axis x
     * @param y for axis y
     * @param z for axis z
     */

    public Vector(double x, double y, double z)
    {
        if(x == 0d && y == 0d && z == 0d) // check for valuable vector
        {
            throw new IllegalArgumentException("Error - Vector 0");
        }
        this.v = new Point3D(x,y,z);
    }

    /**
     * Point_3D value getter
     * @return destination of vector
     */

    public Point3D getV()
    {
        return this.v;
    }

    public void setV(Point3D v)
    {
        this.v = v;
    }

    /**
     * check two things, first, is 'this' have value
     * second, is the object is just like 'this'
     * @param o an Object type (also may be Vector)
     * @return true if they are equal, else false
     */

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Vector vector = (Vector) o;

        return v.equals(vector.getV());
    }

    /**
     * calculate new Vector to combine two Vectors as one
     * @param vec second vector to add it to ours
     * @return the sum of this two vectors (Vector)
     */

    public Vector add(Vector vec)
    {
        return new Vector(this.v.add(vec));
    }

    /**
     * calculate the differance between two Vectors
     * @param vec secod vector to calc the differane
     * @return differance (Vector)
     */

    public Vector subtract(Vector vec)
    {
        return new Vector(this.v.subtract(vec.v));
    }

    /**
     * calculate the multiplication between Vector and a scale (number)+
     * @param c the scale to multiply with
     * @return multiplication (Vector)
     */
    public Vector scale (double c)
    {
        Coordinate x = new Coordinate(this.v.getX().get() * c);
        Coordinate y = new Coordinate(this.v.getY().get() * c);
        Coordinate z = new Coordinate(this.v.getZ().get() * c);

        Point3D p = new Point3D(x, y, z);

        return new Vector(p);
    }

    /**
     * calculate a number out of two vectors to get the value that comes out of '*' multiplication
     * @param vec Vector to multiply with
     * @return the multiplication (double)
     */

    public double dotProduct (Vector vec)
    {
        return this.v.getX().get() * vec.v.getX().get()
                +
                this.v.getY().get() * vec.v.getY().get()
                +
                this.v.getZ().get() * vec.v.getZ().get();
    }

    /**
     * calculate a number out of two vectors to get the value that comes out of 'X' multiplication
     * @param vec Vector to multiply with
     * @return the multiplication (Vector)
     */

    public Vector crossProduct (Vector vec)
    {
        return new Vector((this.v.getY().get() * vec.v.getZ().get()) - (this.v.getZ().get() * vec.v.getY().get()),
                (this.v.getZ().get() * vec.v.getX().get()) - (this.v.getX().get() * vec.v.getZ().get()),
                (this.v.getX().get() * vec.v.getY().get()) - (this.v.getY().get() * vec.v.getX().get()));
    }

    /**
     * a build up function to calculate the length of a vector
     * @return double (length of vector) ^ (2)
     */

    public double lengthSquared()
    {
        return this.v.distanceSquared(Point3D.ZERO);
    }

    /**
     * calculate the length of a vector
     * @return double length
     */

    public double length()
    {
        return Math.sqrt(this.lengthSquared());
    }

    /**
     * calculate and change the vector in to a normalize vector
     * @return Vector as normal
     */

    public Vector normalize()
    {
        this.v = new Point3D((new Coordinate(this.v.getX().get() / this.length())), (new Coordinate(this.v.getY().get() / this.length())), (new Coordinate(this.v.getZ().get() / this.length())));

        return this;
    }

    /**
     * calculate a new vector that will be the normal vector of 'this' Vector
     * @return normal form of the vector
     */

    public Vector normalized()
    {
        return  new Vector(new Point3D(new Coordinate(this.v.getX().get() / this.length()),
                new Coordinate(this.v.getY().get() / this.length()),
                new Coordinate(this.v.getZ().get() / this.length())));
    }

    /**
     * casting the value of Vector to a String to represent it as a String
     * @return String of a vector
     */

    @Override
    public String toString() {
        return "Vector{" +
                "v=" + v.toString() +
                '}';
    }
}