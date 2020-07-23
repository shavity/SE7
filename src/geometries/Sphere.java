package geometries;

import primitives.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.*;

/**
 * class sphere is representing a hollow ball like the atmosphere
 */

public class Sphere extends RadialGeometry
{
    private Point3D center;

    /**
     * Sphere constructor
     * @param r double the radius of the sphere
     * @param p Point_3D the location of the center of the sphere
     */

    public Sphere(double r, Point3D p)
    {
        super(r);
        this.center = p;
        this._material = new Material(0, 0, 0);
    }

    /**
     * constructor
     * @param color of the sphere
     * @param radius of the sphere
     * @param center of the sphere
     */

    public Sphere(Color color, double radius,  Point3D center) {
        super(radius, color);
        this.center = center;
        this._material = new Material(0, 0, 0);
    }

    /*
    public Sphere(double radius, Color color, Point3D center) {
        super(radius, color);
        this.center = center;
    }
    */

    /**
     * constructor
     * @param _emmission the color of the sphere
     * @param _material of the sphere
     * @param radius of the sphere
     * @param center of the sphere
     */

    public Sphere(Color _emmission, Material _material, double radius, Point3D center) {
        super(_emmission, _material, radius);
        this.center = center;
    }

    /**
     * copy constructor
     * @param rg to copy from
     */
    public Sphere(RadialGeometry rg, Point3D center) {
        super(rg);
        this.center = center;
    }

    /**
     * Point_3D getter
     * @return center of the sphere
     */

    public Point3D getCenter()
    {
        return center;
    }

    /**
     * @param p Point3D type
     * @return 90 degrees vector to the sphere from the center of the sphere, vector.len = 1
     */

    @Override
    public Vector getNormal(Point3D p)
    {
         return new Vector(p.subtract(center).normalize());
    }

    /**
     *
     * @param ray that get out of the sphere
     * @return point that intersections
     */

    @Override
    public List<GeoPoint> findIntersections(Ray ray) {
        ArrayList<GeoPoint> arrayList=new ArrayList<>();
        Point3D point_3D;
        //O-P0
        Vector L=new Vector(center.subtract(ray.getP()));
        if((L.dotProduct(ray.getV()))/(L.length()*ray.getV().length())<0)
        {
            return arrayList;
        }
        //tm=L*V
        double tm=L.dotProduct(ray.getV());

        //d=(|L|^2-tm^2)^0.5
        double d = sqrt(pow(L.length(),2)-tm*tm);
        //System.out.println("D="+d);
        double th= sqrt(pow(getRadius(),2)-pow(d,2));
        double t1=tm-th;
        double t2=tm+th;
        if (abs(d)>getRadius())
        {
            return arrayList;
        }
        else if (abs(d)==getRadius() && t1>0)
        {
            point_3D=ray.getP().add(ray.getV().scale(abs(t1)));
            arrayList.add(new GeoPoint(this,point_3D));
            return arrayList;
        }
        else {
            point_3D=ray.getP().add(ray.getV().scale(abs(t1)));
            arrayList.add(new GeoPoint(this,point_3D));
            if (t2 > t1 && L.length()>getRadius()) {
                Point3D point_3D1 = ray.getP().add(ray.getV().scale(t2));
                arrayList.add(new GeoPoint(this,point_3D1));
                return arrayList;
            }
        }
        return arrayList;
    }
}
