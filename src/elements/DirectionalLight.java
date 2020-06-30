package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class DirectionalLight extends Light implements LightSource {
    private Vector direction;

    public DirectionalLight(Color _intensity,Vector vector) {
        super(_intensity);
        this.direction=vector;
    }

    public Vector getDirection() {
        return direction;
    }

    @Override
    public Color getIntensity(Point3D p)
    {
        return get_intensity();
    }

    @Override
    public Vector getL(Point3D p) {
        return direction;
    }
}
