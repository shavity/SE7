package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.ArrayList;
import java.util.List;

public class Geometries implements Intersectable {

    private List<Intersectable> intersectables;

    public Geometries() {
        this.intersectables = new ArrayList<>();
    }

    public Geometries(Intersectable ... geometries)
    {
        for (Intersectable item:geometries) {
            intersectables.add(item);
        }
    }
    public void add(Intersectable ... geometries)
    {

    }
    @Override
    public List<Point3D> findIntsersections(Ray ray) {
        return null;
    }

}
