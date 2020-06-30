package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class PointLight extends Light implements LightSource {

    protected Point3D position;
    protected double kc, kl ,kq;

    public PointLight(Color _intensity, Point3D position, double kc, double kl, double kq) {
        super(_intensity);
        this.position = position;
        this.kc = kc;
        this.kl = kl;
        this.kq = kq;
    }

    @Override
    public Color getIntensity(Point3D p) {
        double d=p.distance(position);
        double r=get_intensity().getColor().getRed()/(kc+kl*d+kq*d*d);
        double g=get_intensity().getColor().getGreen()/(kc+kl*d+kq*d*d);
        double b=get_intensity().getColor().getBlue()/(kc+kl*d+kq*d*d);

        return new Color(r > 255 ? 255 : r,g > 255 ? 255 : g, b> 255 ? 255 : b);
    }

    @Override
    public Vector getL(Point3D p) {
        return p.subtract(position);
    }
}
