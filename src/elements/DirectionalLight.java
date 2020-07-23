package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * the class DirectionalLight is representing
 */

public class DirectionalLight extends Light implements LightSource {

    /**
     * like name like presentation 'direction' = direction
     */

    private Vector direction;

    /**
     * Constructor that gets a direction vector color and creates the DirectionalLight
     * @param _intensity how strong is the color
     * @param vector direction
     */

    public DirectionalLight(Color _intensity,Vector vector) {
        super(_intensity);
        this.direction=vector;
    }

    /**
     * Get the vector direction of the DirectionalLight
     * @return The vector direction of the DirectionalLight
     */

    public Vector getDirection() {
        return direction;
    }

    /**
     * get intensity of the light in some point
     * @param p - the point we check the light in
     * @return - the calculated color
     */

    @Override
    public Color getIntensity(Point3D p)
    {
        return get_intensity();
    }

    /**
     * Get the vector direction of the DirectionalLight
     * @param p - point
     * @return The vector direction of the DirectionalLight
     */

    @Override
    public Vector getL(Point3D p) {
        return direction;
    }

    /**
	 * @param point the point of the geometry
	 * @return the distance between the point and the directionalLight
	 */

    @Override
    public double getDistance(Point3D point) { return Double.POSITIVE_INFINITY; }

}
