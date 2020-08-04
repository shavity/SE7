package scene;

import elements.AmbientLight;
import elements.Camera;
import elements.LightSource;
import geometries.Geometries;
import geometries.Intersectable;
import primitives.Color;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * the class Scene representing scene with geo, light and so on
 */

public class Scene {
    private String _name;
    private Color _background;
    private AmbientLight _ambientLight;
    private Geometries _geometries;
    private Camera _camera;
    private double _distance;
    private List<LightSource> _lights;

    /**
     * constructor
     * @param _Name of scene
     */

    public Scene(String _Name) {
        this._name = _Name;
        this._geometries=new Geometries();
        this._lights=new LinkedList<LightSource>();
    }

    /**
     * add the param to scene's geo list
     * @param geometries group of geo
     */

    public void addGeometries(Intersectable ... geometries) {
        for (Intersectable intersectable:geometries) {
            _geometries.add(intersectable);
        }
    }

    /**
     * add lights to scene's lights list
     * @param lights to insert
     */

    public void addLights(LightSource... lights) {
        _lights.addAll(Arrays.asList(lights));
    }

    /**
     * getter
     * @return list of lights
     */

    public List<LightSource> get_lights() {
        return new LinkedList<LightSource>(_lights);
    }

    public void setName(String _Name) {
        this._name = _Name;
    }

    public void setBackground(Color _background) {
        this._background = _background;
    }

    public void setAmbientLight(AmbientLight _ambientLight) {
        this._ambientLight = _ambientLight;
    }

    public void setGeometries(Geometries _geometries) {
        this._geometries = _geometries;
    }

    public void setCamera(Camera _camera) {
        this._camera = _camera;
    }

    public void setDistance(double _distance) {
        this._distance = _distance;
    }

    /**
     * getter
     * @return name of scene
     */

    public String get_Name() {
        return _name;
    }

    /**
     * getter
     * @return background color
     */

    public Color get_background() {
        return _background;
    }

    /**
     * getter
     * @return ambient light of scene
     */

    public AmbientLight get_ambientLight() {
        return new AmbientLight(_ambientLight.get_intensity(), 1);
    }

    /**
     * getter
     * @return list of geometries that introduces in the scene
     */

    public Geometries get_geometries() {
        return _geometries;
    }

    /**
     * getter
     * @return camera
     */

    public Camera get_camera() {
        return new Camera(_camera.getPoint_3D(), _camera.getvTo(), _camera.getvUp());
    }

    /**
     * getter
     * @return distance between camera and scene's screen
     */

    public double get_distance() {
        return _distance;
    }

    /**
     * print all geometries of scene
     * @return all geometries of scene as one long string
     */

    @Override
    public String toString() {
        return "Scene{" +
                "_geometries = " + _geometries +
                '}';
    }
}
