package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.List;

/**
 * interface intersecable is the basic of operation to get point on shape where its cut by a line (Ray type)
 */

public interface Intersectable {

    /**
     *
     * @param ray line that cut a shape
     * @return list of Point_3D value, where the line meets the shape
     */
    List<Point3D> findIntersections(Ray ray);
}
