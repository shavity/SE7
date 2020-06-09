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
            //מוזר מאוד
            //throw new IllegalArgumentException("Error - Vector 0");
        }

        this.v = new Point3D(v);
    }

    public Vector(Vector vec)
    {
        this.v = vec.getV();
    }

    public Vector(Coordinate x, Coordinate y, Coordinate z)
    {
        if(x.equals(0d) && y.equals(0d) && z.equals(0d))
        {
            throw new IllegalArgumentException("Error - Vector 0");
        }

        this.v = new Point3D(x, y, z);
    }

    public Vector(double x, double y, double z)
    {
        if(x == 0d && y == 0d && z == 0d)
        {
            throw new IllegalArgumentException("Error - Vector 0");
        }
        this.v = new Point3D(x,y,z);
    }

    public Point3D getV()
    {
        return this.v;
    }

    public void setV(Point3D v)
    {
        this.v = v;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Vector vector = (Vector) o;

        return v.equals(vector.getV());
    }

    public Vector add(Vector vec)
    {
        return new Vector(this.v.add(vec));
    }

    public Vector subtract(Vector vec)
    {
        return new Vector(this.v.subtract(vec.v));
    }

    public Vector scale (double c)
    {
        Coordinate x = new Coordinate(this.v.getX().get() * c);
        Coordinate y = new Coordinate(this.v.getY().get() * c);
        Coordinate z = new Coordinate(this.v.getZ().get() * c);

        Point3D p = new Point3D(x, y, z);

        return new Vector(p);
    }

    public double dotProduct (Vector vec)
    {
        return this.v.getX().get() * vec.v.getX().get()
                +
                this.v.getY().get() * vec.v.getY().get()
                +
                this.v.getZ().get() * vec.v.getZ().get();
    }

    public Vector crossProduct (Vector vec)
    {
        return new Vector((this.v.getY().get() * vec.v.getZ().get()) - (this.v.getZ().get() * vec.v.getY().get()),
                (this.v.getZ().get() * vec.v.getX().get()) - (this.v.getX().get() * vec.v.getZ().get()),
                (this.v.getX().get() * vec.v.getY().get()) - (this.v.getY().get() * vec.v.getX().get()));
    }

    public double lengthSquared()
    {
        return this.v.distanceSquared(Point3D.ZERO);
    }

    public double length()
    {
        return Math.sqrt(this.lengthSquared());
    }

    public Vector normalize()
    {
        this.v = new Point3D((new Coordinate(this.v.getX().get() / this.length())), (new Coordinate(this.v.getY().get() / this.length())), (new Coordinate(this.v.getZ().get() / this.length())));

        return this;
    }

    public Vector normalized()
    {
        return  new Vector(new Point3D(new Coordinate(this.v.getX().get() / this.length()),
                new Coordinate(this.v.getY().get() / this.length()),
                new Coordinate(this.v.getZ().get() / this.length())));
    }

    @Override
    public String toString() {
        return "Vector{" +
                "v=" + v.toString() +
                '}';
    }
}