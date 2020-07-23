package elements;

import primitives.Color;

import static java.lang.Integer.min;

/**
 * Ambient light is a source of ambient light and represents constant intensity and a constant color light source that affects all the objects in the scene equally.
 *
 */

public class AmbientLight extends Light{

    /**
     *A constructor that receives color and an attenuation coefficient k and from which creates the AmbientLight
     * @param color The color of the AmbientLight
     * @param ka The attenuation coefficient k
     */

    public AmbientLight(Color color,double ka)
    {
        //super(new Color(color.scale(ka)));    --- נכון לעשות ככה???
        super(new Color(color.getColor().getRed()*ka > 255 ? 255 : color.getColor().getRed()*ka, color.getColor().getGreen()*ka > 255 ? 255 : color.getColor().getGreen()*ka,color.getColor().getBlue()*ka > 255 ? 255 : color.getColor().getBlue()*ka));
    }
}
