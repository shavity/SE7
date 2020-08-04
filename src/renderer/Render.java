package renderer;

import elements.*;
import elements.LightSource;

import geometries.Intersectable;
import geometries.Intersectable.GeoPoint;
import geometries.Plane;
import geometries.Polygon;
import geometries.Triangle;

import primitives.*;
import static primitives.Util.*;

import scene.Scene;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * the class Render is showing all functions to render the image
 */

public class Render {

    /**
     * permanent for stop condition in recursion
     */

    private static final int MAX_CALC_COLOR_LEVEL = 10;

    /**
     * permanent for stop condition in recursion
     */

    private static final double MIN_CALC_COLOR_K = 0.001;

    /**
     * permanent to move the start of the rays for shadow, reflection and refraction rays
     */

    private static final double DELTA = 0.1;

    private ImageWriter imageWriter;
    private Scene scene;

    /**
     * constructor
     * @param imageWriter as its name
     * @param scene1 scene
     */

    public Render(ImageWriter imageWriter,Scene scene1)
    {
        this.imageWriter=imageWriter;
        this.scene=scene1;
    }

    /**
     * A function that creates the scene given the geometries and shapes into an image file.
     */

    public void renderImage() {
        //Passes each pixel in the image, and checks which color should be put, if it has a cut point - finds using the calColor function. If not - painting with the color of the background.
        for (int i = 0; i < imageWriter.getNx(); i++) {
            for (int j = 0; j < imageWriter.getNy(); j++) {
                Ray ray=scene.get_camera().constructRayThroughPixel(imageWriter.getNx(), imageWriter.getNy(), i, j, scene.get_distance(), imageWriter.getWidth(), imageWriter.getHeight());
                    //Map<Intersectable, List<Point3D>> intersectionPoints = getSceneRayIntersections1(r);
                    // if no intersection Points - put background color
                List<GeoPoint> intersectionPoints=getSceneRayIntersections(ray);
                if (intersectionPoints.isEmpty())
                {
                    imageWriter.writePixel(i,j,scene.get_background().getColor());
                }
                else
                {
                    imageWriter.writePixel(i,j,calcColor(getClosestPoint(intersectionPoints)));
                }
            }
        }
        System.out.println("end");
    }

    public void writeToImage()
    {
        imageWriter.writeToImage();
    }

    /**
     * @param ray by which we look at the scene
     * @return A map that connects cutting points and the geometry of those cut points.
     */
    /*private Map<Intersectable, List<GeoPoint>> getSceneRayIntersections1(Ray ray) {
        List<Intersectable> geometries = scene.get_geometries().getIntersectables();
        Map<Intersectable, List<GeoPoint>> intersectionPoints = new HashMap<Intersectable, List<GeoPoint>>();

        for (Intersectable geometry:geometries) {
            List<GeoPoint> geometryIntersectionPoints = new ArrayList<GeoPoint>(geometry.findIntersections(ray));
            //If there are no cut points - do not insert.
            System.out.println(geometryIntersectionPoints.get(0));
            if(!geometryIntersectionPoints.isEmpty())
                intersectionPoints.put(geometry,geometryIntersectionPoints);
        }
        return intersectionPoints;
    }*/
    private List<GeoPoint> getSceneRayIntersections(Ray ray) {
        List<Intersectable> geometries = scene.get_geometries().getIntersectables();
        List<GeoPoint> intersectionPoints =new ArrayList<GeoPoint>();
        for (Intersectable geometry:geometries) {
            intersectionPoints.addAll(geometry.findIntersections(ray));
        }
        return intersectionPoints;
    }

    public java.awt.Color calcColor(GeoPoint p) {
        Color ambientLight = scene.get_ambientLight().get_intensity();//ambient
        Color emissionLight = p.geometry.get_emmission();//emission

        double r=addColors(ambientLight,emissionLight).getColor().getRed();
        double g=addColors(ambientLight,emissionLight).getColor().getGreen();
        double b=addColors(ambientLight,emissionLight).getColor().getBlue();
        for (LightSource light:scene.get_lights()) {
            Vector L = light.getL(p.point).normalize();
            Vector V = p.point.subtract(scene.get_camera().getPoint_3D()).normalize();
            Vector N = p.geometry.getNormal(p.point).normalize();
            Vector R= L.subtract(N.scale(2*(L.dotProduct(N))));
            //diffuse
            //System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            //System.out.println("L"+light.getIntensity(p.point).getColor());
            //System.out.println("NL"+N.dotProduct(L));
            //System.out.println("r: "+r+" g: "+g+" b: "+b);
            if(N.dotProduct(L)>0) {
                r += N.dotProduct(L) * p.geometry.get_material().getkD() * light.getIntensity(p.point).getColor().getRed();
                g += N.dotProduct(L) * p.geometry.get_material().getkD() * light.getIntensity(p.point).getColor().getGreen();
                b += N.dotProduct(L) * p.geometry.get_material().getkD() * light.getIntensity(p.point).getColor().getBlue();
            }
            //specular
            //System.out.println("r: "+r+" g: "+g+" b: "+b);
            //System.out.println("VR"+V.dotProduct(R));
            if(V.dotProduct(R)>0) {
                double m = Math.pow(V.dotProduct(R), p.geometry.get_material().getnS()) * p.geometry.get_material().getkS();
                //System.out.println("m"+m);
                r += m * light.getIntensity(p.point).getColor().getRed();
                g += m * light.getIntensity(p.point).getColor().getGreen();
                b += m * light.getIntensity(p.point).getColor().getBlue();
            }
            //System.out.println("r: "+r+" g: "+g+" b: "+b);
        }
        //System.out.println("r: "+r+" g: "+g+" b: "+b);
        return  new Color(r > 255 ? 255 : r,g > 255 ? 255 : g, b> 255 ? 255 : b).getColor();
    }
    /**
     * The function returns from the list of points the closest point to the camera point
     * @param points The list of points
     * @return
     */
    public GeoPoint getClosestPoint(List<GeoPoint> points)
    {
        double distance=Double.MAX_VALUE;
        Point3D P0=scene.get_camera().getPoint_3D();
        GeoPoint minDistancePoint=null;

        for(GeoPoint point: points) {
            if (P0.distance(point.point) < distance)           //if it the closest point until now
            {
                minDistancePoint = point;
                distance = P0.distance(minDistancePoint.point);
            }
        }
        return minDistancePoint;
    }

    /**
     * @param light  source
     * @param l  light direction
     * @param n  geometry normal vector
     * @param gp geometry's point
     * @return does the point is unshaded
     */
    private boolean unshaded(LightSource light, Vector l, Vector n, GeoPoint gp) {

        Vector lightDirection = l.scale(-1);
        Vector delta = n.scale(n.dotProduct(lightDirection)>0?DELTA:-DELTA);
        Point3D p = gp.point.add(delta);

        double temp = n.dotProduct(lightDirection);
        double d = DELTA;
        if (temp <= 0)
        {
            d = -d;
        }
        Vector deltaNormal = n.scale(d);

        Point3D point3D = p.add(deltaNormal);

        Ray lightRay = new Ray(point3D, lightDirection.normalize());

        List<GeoPoint> intersections = scene.get_geometries().findIntersections(lightRay);

        if (intersections == null)
        {
            return true;
        }

        double lightDistance = light.getDistance(gp.point);

        for (GeoPoint g : intersections) {
            if (alignZero(g.point.distance(gp.point) - lightDistance) <= 0 /*&& gp._geometry.get_material().get_kT() == 0*/)
                return false;
        }
        return true;

    }

    /**
     *
     * @param point of geometry
     * @param ray that goes towards the geometry
     * @param vec normal vector to the geometry
     * @return the reflection
     */

    private Ray reflectionRay(Point3D point, Ray ray, Vector vec)
    {
        Vector v = ray.getV().normalize();
        double vec1 = v.dotProduct(vec); //(v*vec)

        if (vec1 == 0) return null;

        Vector vec2 = v.subtract(vec.scale(2 * vec1)); //v-2(v*vec)*vec

        double temp = vec.dotProduct(vec2);
        double d = DELTA;
        if (temp <= 0)
        {
            d = -d;
        }
        Vector dNormal = vec.scale(d);

        Point3D p = point.add(dNormal);

        return new Ray(p, vec2.normalize());
    }

    /**
     * @param point of the geometry
     * @param ray that sent towards the geometry
     * @param vec normal vector to the geometry
     * @return refraction ray
     */

    private Ray refractionRay(Point3D point, Ray ray, Vector vec)
    {
        Vector direction = ray.getV();

        double temp = vec.dotProduct(direction);
        double delta = DELTA;
        if (temp <= 0)
            delta *= -1;
        Vector deltaNormal = vec.scale(delta);
        Point3D p = point.add(deltaNormal);

        return new Ray(p,direction.normalize());

    }

    /**
     * @param ray that sent towards the geometry
     * @return GeoPoint with the closest intersection point
     */

    private GeoPoint findClosestIntersection(Ray ray)
    {
        if (ray == null)
        {
            return null;
        }

        GeoPoint closestPoint = null;
        double closestDistance = Double.MAX_VALUE;
        Point3D p = ray.getP();

        List<GeoPoint> intersections = scene.get_geometries().findIntersections(ray);
        if (intersections == null)
        {
            return null;
        }

        for (GeoPoint geoPoint : intersections)
        {
            double distance = p.distance(geoPoint.point);
            if (distance < closestDistance)
            {
                closestPoint = new GeoPoint(geoPoint.geometry, geoPoint.point);
                closestDistance = distance;
            }
        }
        return closestPoint;
    }

    /**
     * A function that draws grid at a certain interval in the image.
     * @param interval between lines
     */
    public void printGrid(int interval, java.awt.Color color) {

        for (int i = 0; i < imageWriter.getNx(); i ++) {
            for (int j = 0; j < imageWriter.getNy(); j++) {
                if (0==i%interval||0==j%interval)
                {
                    imageWriter.writePixel(i, j, color);
                }
            }
        }
        imageWriter.writeToImage();
    }

    public Color addColors(Color ... colors)
    {
        double r=0;
        double g=0;
        double b=0;
        for (Color color:colors) {
            r+=color.getColor().getRed();
            g+=color.getColor().getGreen();
            b+=color.getColor().getBlue();
        }
        return new Color(r > 255 ? 255 : r,g > 255 ? 255 : g, b> 255 ? 255 : b);
    }
}
