package renderer;

import geometries.Geometry;
import geometries.Intersectable;
import primitives.Point3D;
import primitives.Ray;
import scene.Scene;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Render {
    private ImageWriter imageWriter;
    private Scene scene;

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
                Ray ray=scene.get_camera().constructRayThroughPixel(imageWriter.getNx(), imageWriter.getNy()
                        , i, j, scene.get_distance(), imageWriter.getWidth(), imageWriter.getHeight());
                    //Map<Intersectable, List<Point3D>> intersectionPoints = getSceneRayIntersections1(r);
                    // if no intersection Points - put background color
                List<Point3D> intersectionPoints=getSceneRayIntersections(ray);
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
        System.out.println("endddddddddddddddddddddddddddddddddddddddddddd");
        imageWriter.writeToImage();
    }


    /**
     * @param ray by which we look at the scene
     * @return A map that connects cutting points and the geometry of those cut points.
     */
    private Map<Intersectable, List<Point3D>> getSceneRayIntersections1(Ray ray) {
        List<Intersectable> geometries = scene.get_geometries().getIntersectables();
        Map<Intersectable, List<Point3D>> intersectionPoints = new HashMap<Intersectable, List<Point3D>>();

        for (Intersectable geometry:geometries) {
            List<Point3D> geometryIntersectionPoints = new ArrayList<Point3D>(geometry.findIntersections(ray));
            //If there are no cut points - do not insert.
            if(!geometryIntersectionPoints.isEmpty())
                intersectionPoints.put(geometry,geometryIntersectionPoints);
        }
        return intersectionPoints;
    }
    private List<Point3D> getSceneRayIntersections(Ray ray) {
        List<Intersectable> geometries = scene.get_geometries().getIntersectables();
        List<Point3D> intersectionPoints =new ArrayList<Point3D>();
        for (Intersectable geometry:geometries) {
            intersectionPoints.addAll(geometry.findIntersections(ray));
        }
        return intersectionPoints;
    }

    public Color calcColor(Point3D p)
    {
        return scene.get_ambientLight().GetIntensity().getColor();
    }
    /**
     * The function returns from the list of points the closest point to the camera point
     * @param points The list of points
     * @return
     */
    public Point3D getClosestPoint(List<Point3D> points)
    {
        double distance=Double.MAX_VALUE;
        Point3D P0=scene.get_camera().getPoint_3D();
        Point3D minDistancePoint=null;

        for(Point3D point: points)
            if(P0.distance(point)<distance)           //if it the closest point until now
            {
                minDistancePoint=point;
                distance=P0.distance(minDistancePoint);
            }
        return minDistancePoint;
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
}
