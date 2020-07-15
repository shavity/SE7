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
    {
        Point3D t1 = this._vertices.get(0);
        Point3D t2 = this._vertices.get(1);
        Point3D t3 = this._vertices.get(2);
        Point3D p0 = ray.getP();
        Vector v11 = t1.subtract(p0);                                       //triangle number 1
        Vector v12 = t2.subtract(p0);                                       //triangle number 1

        Vector v21 = t2.subtract(p0);                                       //triangle number 2
        Vector v22 = t3.subtract(p0);                                       //triangle number 2

        Vector v31 = t3.subtract(p0);                                       //triangle number 3
        Vector v32 = t1.subtract(p0);                                       //triangle number 3

        Vector n1 = v12.crossProduct(v11).normalize();
        //n1.scale((1 / (n1.length())));                                            //normal triangle 1
        //n1=n1.normalize();
        Vector n2 = v22.crossProduct(v21).normalize();
        //n2.scale((1 / (n2.length())));                                            //normal triangle 2
        Vector n3 = v32.crossProduct(v31).normalize();
        //n3.scale((1 / (n3.length())));                                            //normal triangle 3
        List<GeoPoint> list; // = new ArrayList<GeoPoint>();
        Plane p1 = new Plane(this._emmission,this._material,this._plane.getV(),this._plane.getP());
        list = p1.findIntersections(ray);                                   //intersections of plane

        if(list==null)
            return new ArrayList<>();  //<GeoPoint>

        Point3D p = list.get(0).point;
        double i1 = (p.subtract(p0)).dotProduct(n1);
        double i2 = (p.subtract(p0)).dotProduct(n2);
        double i3 = (p.subtract(p0)).dotProduct(n3);
        //boolean f1 = !isZero(i1);
        //boolean f2 = !isZero(i2);
        //boolean f3 = !isZero(i3);

        if((i1>0 && i2>0 && i3>0) || (i1<0 && i2<0 && i3<0))                                //if it is inside the triangle
        {
            return list;
        }
        return new ArrayList<>();  //<GeoPoint>
    }                  //returns intersection points with the triangle
}
