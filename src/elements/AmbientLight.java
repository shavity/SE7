package elements;

//import primitives.Color;

import primitives.Color;

import static java.lang.Integer.min;

public class AmbientLight extends Light{

    public AmbientLight(Color color,double ka)
    {
        super(new Color(color.getColor().getRed()*ka > 255 ? 255 : color.getColor().getRed()*ka, color.getColor().getGreen()*ka > 255 ? 255 : color.getColor().getGreen()*ka,color.getColor().getBlue()*ka > 255 ? 255 : color.getColor().getBlue()*ka));
    }
}
