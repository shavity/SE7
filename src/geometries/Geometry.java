package geometries;

import primitives.Point3D;
import primitives.Vector;

public interface Geometry extends Intersectable {
    public abstract Vector getNormal(Point3D p3d);
    //List<Point_3D> findIntsersections(Ray ray);
}
