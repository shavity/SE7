package elements;

import primitives.Color;

abstract class Light {

    protected Color _intensity;

    /**
     * Constructor that receives color and creates the  Light
     * @param _intensity The color of the Light
     */

    public Light(Color _intensity) {
        this._intensity = _intensity;
    }

    /**
     * Get the color of the Light
     * @return color of light
     */

    public Color get_intensity() {
        return _intensity;
    }
}
