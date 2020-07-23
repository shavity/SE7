package elements;

import primitives.Color;

/**
 * the class Light is representing light
 * you have to admit, you didn't see that coming
 */

abstract class Light {

    /**
     * light's intensity
     */

    protected Color _intensity;

    /**
     * Constructor that receives color and creates the  Light
     * @param _intensity The color of the Light
     */

    public Light(Color _intensity) {
        this._intensity = new Color(_intensity);
    }

    /**
     * Get the color of the Light
     * @return color of light
     */

    public Color get_intensity() { return new Color(_intensity); }    // because its *protected* and we don't want that it will be change
}
