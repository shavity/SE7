package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

import static java.lang.Math.max;


public class SpotLight extends PointLight {
    private Vector direction;

    public SpotLight(Color _intensity, Point3D position,Vector direction, double kc, double kl, double kq) {
        super(_intensity, position, kc, kl, kq);
        this.direction = direction.normalize();
    }
    @Override
    public Color getIntensity(Point3D p) {
        double d=p.distance(position);
        double d2=max(0,direction.dotProduct(p.subtract(position).normalize()));
        double r=(get_intensity().getColor().getRed()*d2)/(kc+kl*d+kq*d*d);
        double g=(get_intensity().getColor().getGreen()*d2)/(kc+kl*d+kq*d*d);
        double b=(get_intensity().getColor().getBlue()*d2)/(kc+kl*d+kq*d*d);
        return new Color(r > 255 ? 255 : r,g > 255 ? 255 : g, b> 255 ? 255 : b);
    }

    @Override
    public Vector getL(Point3D p) {
        return direction;
    }
}
