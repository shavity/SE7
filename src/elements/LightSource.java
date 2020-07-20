package elements;

/*
import primitives.Color;
import primitives.Point3D;
import primitives.Vector;
*/

import primitives.*;

/**
 * the interface LightSource is representing a interface between lights of many types
 */

public interface LightSource {

    /**
     * @param p Point3D type
     * @return geometry's color at point p
     */

    public Color getIntensity(Point3D p);

    /**
     * @param p Point3D type
     * @return the length between p to the light source
     */

    public double getDistance(Point3D p);

    /**
     * @param p Point3D type
     * @return the direction of the light
     */

    public Vector getL(Point3D p);
}
