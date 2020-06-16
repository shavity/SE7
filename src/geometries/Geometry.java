package geometries;

import primitives.Point3D;
import primitives.Vector;

/**
 * interface Geometry is representing all kind of function in the space
 */

public interface Geometry extends Intersectable {
    public abstract Vector getNormal(Point3D p3d);
    //List<Point_3D> findIntersections(Ray ray);
}
