package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

public abstract class RadialGeometry implements Geometry
{
    private double radius;

    public RadialGeometry(double radius)
    {
        this.radius = radius;
    }

    public RadialGeometry(RadialGeometry rg)
    {
        this.radius = rg.radius;
    }

    public double getRadius()
    {
        return radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    @Override
    public String toString()
    {
        return "RadialGeometry{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        RadialGeometry that = (RadialGeometry) o;

        return Double.compare(that.radius, radius) == 0;
    }

    @Override
    public abstract Vector getNormal(Point3D p);

    @Override
    public abstract List<Point3D> findIntsersections(Ray ray);

}
