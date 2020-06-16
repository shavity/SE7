package scene;

import elements.AmbientLight;
import elements.Camera;
import geometries.Geometries;
import geometries.Intersectable;
import primitives.Color;

public class Scene {
    private String _name;
    private Color _background;
    private AmbientLight _ambientLight;
    private Geometries _geometries;
    private Camera _camera;
    private double _distance;

    public Scene(String _Name) {
        this._name = _Name;
        this._geometries=new Geometries();
    }

    public void addGeometries(Intersectable ... geometries) {
        for (Intersectable intersectable:geometries) {
            _geometries.add(intersectable);
        }
    }
    public void setName(String _Name) {
        this._name = _Name;
    }

    public void setBackground(Color _beckground) {
        this._background = _beckground;
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

    public String get_Name() {
        return _name;
    }

    public Color get_background() {
        return _background;
    }

    public AmbientLight get_ambientLight() {
        return _ambientLight;
    }

    public Geometries get_geometries() {
        return _geometries;
    }

    public Camera get_camera() {
        return _camera;
    }

    public double get_distance() {
        return _distance;
    }

    @Override
    public String toString() {
        return "Scene{" +
                "_geometries=" + _geometries +
                '}';
    }
}
