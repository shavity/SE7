package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class PointLight extends Light implements LightSource {

    protected Point3D position;
    protected double kc, kl ,kq;

    /**
     * constructor point light
     * @param _intensity color of light
     * @param position - location
     * @param kc factor kc
     * @param kl factor kl
     * @param kq factor kq
     */

    public PointLight(Color _intensity, Point3D position, double kc, double kl, double kq) {
        super(_intensity);
        this.position = position;
        this.kc = kc;
        this.kl = kl;
        this.kq = kq;
    }

    /**
     * get intensity of the light in some point
     * @param p - the point we check the light in
     * @return - the calculation of the color
     */

    @Override
    public Color getIntensity(Point3D p) {
        double squared = p.distanceSquared(position);
        double d = p.distance(position);

        return (_intensity.reduce(kc + kl * d + kq * squared));
    }

    /**
     * @param p Point3D type
     * @return the length between p to the light source
     */

    @Override
    public double getDistance(Point3D p) { return p.distance(position); }

    /**
     * @param p Point3D type
     * @return the direction of the light
     */

    @Override
    public Vector getL(Point3D p) {
        if (p.equals(position))
            return null;
        return p.subtract(position).normalized();
    }
}
