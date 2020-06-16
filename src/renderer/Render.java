package renderer;

import geometries.Geometry;
import geometries.Intersectable;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import scene.Scene;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Render {
    private ImageWriter imageWriter;
    private Scene scene;

    public Render(ImageWriter imageWriter,Scene scene)
    {
        this.imageWriter=imageWriter;
        this.scene=scene;
    }

    /**
     * A function that creates the scene given the geometries and shapes into an image file.
     */
    public void renderImage() {
        //Passes each pixel in the image, and checks which color should be put, if it has a cut point - finds using the calColor function. If not - painting with the color of the background.
        /*for (int i = 0; i < imageWriter.getNx(); i++) {
            for (int j = 0; j < imageWriter.getNy(); j++) {
                List<Ray> rays = new ArrayList<Ray>();
                rays.add(scene.get_camera().constructRayThroughPixel(imageWriter.getNx(), imageWriter.getNy(), i, j, scene.get_distance(), imageWriter.getWidth(), imageWriter.getHeight()));
                List<Color> listColor = new ArrayList<Color>();
                for(Ray r : rays)
                {
                    Map<Intersectable, List<Point3D>> intersectionPoints = getSceneRayIntersections(r);
                    // if no intersection Points - put background color
                    if (intersectionPoints.isEmpty())
                    {
                        listColor.add(scene.get_background());
                    }
                    else
                    {
                    }
                }
                int r=0,g=0,b=0;
                for(Color c : listColor)
                {
                    r+=c.getColor().getRed();
                    g+=c.getColor().getGreen();
                    b+=c.getColor().getBlue();
                }
                imageWriter.writePixel(i, j,new java.awt.Color(r,g,b));
                imageWriter.writeToImage();
            }
        }
        */

        imageWriter.writeToImage();
    }


    /**
     * @param ray by which we look at the scene
     * @return A map that connects cutting points and the geometry of those cut points.
     */
    private Map<Intersectable, List<Point3D>> getSceneRayIntersections(Ray ray) {
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
    public void calcColor(Point3D p)
    {

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
        for (int i = 0; i < imageWriter.getWidth(); i += interval) {
            for (int j = 0; j < imageWriter.getHeight(); j++) {
                imageWriter.writePixel(i, j, color);
            }
        }
    }
}
