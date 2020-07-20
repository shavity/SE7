package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

/**
 * class Geometries is representing all kind of function in the space
 */

//יכול להיות שצריך לרשת מinstersection לא בטוח קיצר
public class Geometries extends Geometry implements Intersectable {

    private List<Intersectable> intersectables;

    @Override
    public Vector getNormal(Point3D p3d) {
        return null;
    }

    /**
     * default constructor
     */

    public Geometries() {
        this.intersectables = new ArrayList<Intersectable>();
    }

    /**
     * Geometries constructor
     * @param geometries list of shapes
     */

    public Geometries(Intersectable ... geometries)
    {
        for (Intersectable item:geometries) {
            intersectables.add(item);
        }
    }

    /**
     * add function to add new shape to the business
     * @param geometries list of shapes
     */

    public void add(Intersectable ... geometries)
    {
        for (Intersectable i:geometries) {
            intersectables.add(i);
        }
    }

    /**
     * function of interface Intersectable
     * @param ray a line that might meet a shape in the space
     * @return list of points where the line cut the shape
     */

    @Override
    public List<GeoPoint> findIntersections(Ray ray) {
        List<GeoPoint> intersections = null;

        for (Intersectable i : intersectables) {
            List<GeoPoint> tempIntersections = i.findIntersections(ray);
            if (tempIntersections != null) {
                if (intersections == null)
                    intersections = new ArrayList<GeoPoint>();
                intersections.addAll(tempIntersections);
            }
        }
        return intersections;
    }

    /**
     * intersectable getter function
     * @return intersectable
     */

    public List<Intersectable> getIntersectables() {
        return intersectables;
    }

    /**
     * representing as a string
     * @return string of intersectable
     */

    @Override
    public String toString() {
        return "Geometries{" +
                "intersectables = " + intersectables +
                '}';
    }
}
