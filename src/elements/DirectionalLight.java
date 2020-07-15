package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class DirectionalLight extends Light implements LightSource {

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
}
