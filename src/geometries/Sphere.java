

package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

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
     * @param p Point_3D the location of the center of the sphere
     * @param r double the radius of the sphere
     */

    public Sphere (Point3D p, double r)
    {
        super(r);
        this.center = p;
    }

    /**
     * Point_3D getter
     * @return center of the sphere
     */

    public Point3D getCenter()
    {
        return center;
    }

    @Override
    public Vector getNormal(Point3D p)
    {
        /**
         * בעיקון לא צריך לעשות בדיקה שהנקודה תקינה
         */
         return new Vector(p.subtract(center));
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        ArrayList<Point3D> arrayList=new ArrayList<>();
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
        System.out.println("D="+d);
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
            arrayList.add(point_3D);
            return arrayList;
        }
        else {
            point_3D=ray.getP().add(ray.getV().scale(abs(t1)));
            arrayList.add(point_3D);
            if (t2 > t1 && L.length()>getRadius()) {
                Point3D point_3D1 = ray.getP().add(ray.getV().scale(t2));
                arrayList.add(point_3D1);
                return arrayList;
            }
        }
        return arrayList;
    }
}
