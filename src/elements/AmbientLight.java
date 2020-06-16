package elements;

import primitives.Color;

import static java.lang.Integer.min;

public class AmbientLight {
    private Color _intensity;

    public AmbientLight(Color color,double ka)
    {
        _intensity=color;
        double r=min((int)(color.getColor().getRed()*ka),255);
        double g=min((int)(color.getColor().getGreen()*ka),255);
        double b=min((int)(color.getColor().getBlue()*ka),255);
        _intensity.setColor(r,g,b);
    }
    public Color GetIntensity()
    {
        return _intensity;
    }
}
