package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;
import primitives.Util;

import static java.lang.Math.max;


public class SpotLight extends PointLight {

    private Vector direction;

    /**
     * constructor for the spot
     * @param _intensity- the color of light
     * @param position - location
     * @param kc- factor kc
     * @param kl- factor kj
     * @param kq factor kq
     * @param direction direction of the vector
     */

    public SpotLight(Color _intensity, Point3D position,Vector direction, double kc, double kl, double kq) {
        super(_intensity, position, kc, kl, kq);
        this.direction = new Vector(direction).normalize();
    }

    /**
     * get intensity of the light in some point
     * @param p - the point we check the light in
     * @return - the calculation of the color
     */

    @Override
    public Color getIntensity(Point3D p) {
        double dl = direction.dotProduct(getL(p));

        if (Util.isZero(dl)) {
            return Color.BLACK;  //return new Color(0, 0, 0);
        }
        double help = Math.max(0, dl);
        Color pointLightIntensity = super.getIntensity(p);

        return (pointLightIntensity.scale(help));
    }

    /**
     * Get the direction of the light
     * @param p The point
     * @return The direction of the light
     */

    @Override
    public Vector getL(Point3D p) { return super.getL(p); }

    /**
     * @param p the point of the geometry
     * @return the distance between the point and the spotLight
     */

    @Override
    public double getDistance(Point3D p) {
        return super.getDistance(p);
    }
}
