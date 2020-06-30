package geometries;

import primitives.*;

import java.util.List;

/**
 * abstract class RadialGeometry is representing
 * a radial function in three-dimensional cartesian coordinate system
 */

public abstract class RadialGeometry extends Geometry {
    private double radius;

    /**
     * RadialGeometry constructor
     * @param radius of the function
     */

    public RadialGeometry(double radius)
    {
        this.radius = radius;
    }

    public RadialGeometry(Color _emmission, double radius) {
        super(_emmission);
        this.radius = radius;
    }

    public RadialGeometry(double radius, Color color)
    {
        this.radius = radius;
        this._emmission=color;
    }

    public RadialGeometry(Color _emmission, Material _material, double radius) {
        super(_emmission, _material);
        this.radius = radius;
    }

    /**
     * copy constructor
     * @param rg to copy from
     */

    public RadialGeometry(RadialGeometry rg)
    {
        this.radius = rg.radius;
    }

    /**
     * double value getter
     * @return the radius of the function
     */

    public double getRadius()
    {
        return radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    /**
     * casting RadialGeometry's value in to a String to represent it in a string
     * @return String
     */

    @Override
    public String toString()
    {
        return "RadialGeometry{" +
                "radius=" + radius +
                '}';
    }

    /**
     * check if the object we got is equal to this RadialGeometry
     * @param o an Object (also may be RadialGeometry)
     * @return true if equals, else false
     */

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
    public abstract List<GeoPoint> findIntersections(Ray ray);

}
