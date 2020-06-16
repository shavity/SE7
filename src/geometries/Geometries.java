package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.ArrayList;
import java.util.List;

/**
 * class Geometries is representing all kind of function in the space
 */


public class Geometries implements Intersectable {

    private List<Intersectable> intersectables;

    /**
     * default constructor
     */

    public Geometries() {
        this.intersectables = new ArrayList<>();
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

    }

    /**
     * function of interface Intersectable
     * @param ray a line that might meet a shape in the space
     * @return list of points where the line cut the shape
     */

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        return null;
    }

}
