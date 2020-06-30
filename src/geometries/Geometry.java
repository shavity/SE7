package geometries;

import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;

/**
 * interface Geometry is representing all kind of function in the space
 */

public abstract class Geometry implements Intersectable {
    protected Color _emmission;
    protected Material _material;
    public abstract Vector getNormal(Point3D p3d);
    //List<Point_3D> findIntersections(Ray ray);


    public Geometry(Color _emmission, Material _material) {
        this._emmission = _emmission;
        this._material = _material;
    }

    public Geometry() {
        this._material=new Material(0, 0, 0);
        this._emmission = Color.BLACK;
    }
    public Geometry(Color _emmission) {
        this._emmission = _emmission;
    }

    public Color get_emmission() {
        return _emmission;
    }

    public Material get_material() {
        return _material;
    }
}
