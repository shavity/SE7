package geometries;

import primitives.*;

import java.util.ArrayList;
import java.util.List;

import static primitives.Util.isZero;

/**
 * class Triangle is representing how surprising a triangle in the space
 */

public class Triangle extends Polygon
{

    /**
     * Triangle constructor
     * @param p1 first vertex
     * @param p2 second vertex
     * @param p3 third vertex
     */

    public Triangle(Point3D p1, Point3D p2, Point3D p3)
    {
        super(p1, p2, p3);
    }
    public Triangle(Color color,Point3D p1, Point3D p2, Point3D p3)
    {
        super(color,p1, p2, p3);
    }
    public Triangle(Color color, Material material, Point3D point3D, Point3D point3D1, Point3D point3D2) {
        super(color,material,point3D,point3D1,point3D2);
    }

    public Triangle(Point3D... vertices) {
        super(vertices);
    }

    public Triangle(Color color, Point3D... vertices) {
        super(color, vertices);
    }

    public Triangle(Color color,Material material, Point3D... vertices) {
        super(color,material,vertices);
    }



    /**
     * list of Point_3D getter of the three vertices of the Triangle
     * @return vertices
     */

    public ArrayList<Point3D> getPoints()
    {
        ArrayList<Point3D> list= new ArrayList<>(); // <Point3D>
        list.add(this._vertices.get(0));
        list.add(this._vertices.get(1));
        list.add(this._vertices.get(2));
        return list;
    }

    /**
     * Calculating the normal vector in some point on the Triangle
     * @param point The point
     * @return The normal vector in the point
     */

    @Override
    public Vector getNormal(Point3D point) {

        //there is no need of checking after the point

        Vector v1 = this._vertices.get(1).subtract(this._vertices.get(0));
        Vector v2 = this._vertices.get(2).subtract(this._vertices.get(0));
        return (v1.crossProduct(v2).normalize());
    }

    /**
     * Finds all the points of intersection of the given ray with the Triangle
     * @param ray The ray with which the cutting with the Triangle is calculated
     * @return All the points of intersection of the ray with the Triangle
     */

    @Override
    public List<GeoPoint> findIntersections(Ray ray)
    {        List<GeoPoint> intersections = _plane.findIntersections(ray);

        if (intersections == null) return null;

        Point3D p0 = new Point3D(ray.getP());
        Vector v = new Vector(ray.getV()).normalize();

        Vector v1 = new Vector(_vertices.get(0).subtract(p0)).normalize();
        Vector v2 = new Vector(_vertices.get(1).subtract(p0)).normalize();
        Vector v3 = new Vector(_vertices.get(2).subtract(p0)).normalize();

        double s1 = v.dotProduct(v1.crossProduct(v2));
        if (Util.isZero(s1)) return null;
        double s2 = v.dotProduct(v2.crossProduct(v3));
        if (Util.isZero(s2)) return null;
        double s3 = v.dotProduct(v3.crossProduct(v1));
        if (Util.isZero(s3)) return null;

        intersections.get(0).geometry = this;

        return ((s1 > 0 && s2 > 0 && s3 > 0) || (s1 < 0 && s2 < 0 && s3 < 0)) ? intersections : null;
    }                  //returns intersection points with the triangle
}
