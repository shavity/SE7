package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

/**
 * class Tube is representing an endless tube in the space
 */

public class Tube extends RadialGeometry
{
    private Ray center;

    /**
     * Tube constructor
     * @param r the center of the tube and its direction
     * @param d the radius of the tube
     */

    public Tube(Ray r, double d)
    {
        super(d);
        this.center = r;
    }

    /**
     * Ray value getter
     * @return center of the tube
     */

    public Ray getCenter()
    {
        return center;
    }

    @Override
    public Vector getNormal(Point3D point) {
        /**
         * בעיקון לא צריך לעשות בדיקה שהנקודה תקינה
         *מסובך מדי נשלים בהמשך
         *  */
        return null;
    }


    @Override
    public List<Point3D> findIntersections(Ray ray) {
        return null;
    }
}
