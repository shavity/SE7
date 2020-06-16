package elements;

//import primitives.Color;

import primitives.Color;

import static java.lang.Integer.min;

public class AmbientLight {
    private Color _intensity;

    public AmbientLight(Color color,double ka)
    {
        _intensity=color;
        double r=color.getColor().getRed();
        double g=color.getColor().getGreen()*ka;
        double b=color.getColor().getBlue()*ka;
        _intensity.setColor(r > 255 ? 255 : r, g > 255 ? 255 : g, b > 255 ? 255 : b);
    }
    public Color GetIntensity()
    {
        return _intensity;
    }
}
