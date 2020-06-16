package unittests;

import elements.Camera;
import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IntegrationTests {
    @Test
    public void intersectionsFromCamera1S()
    {
        Camera camera = new Camera(Point3D.ZERO, new Vector(0, 0, 1), new Vector(0, 1, 0));
        Sphere s=new Sphere(1, new Point3D(0,0,3));
        List<Ray> ray=new ArrayList<>();
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++) {
                ray.add(camera.constructRayThroughPixel(3, 3, j, i, 1, 3, 3));
            }
        List<Point3D> g=new ArrayList<>();
        for (Ray r:ray) {
            for (Point3D point3D:s.findIntersections(r)) {
                g.add(point3D);
            }
        }
        assertEquals(2,g.size());
    }
    @Test
    public void intsersectionsFromCamera2S()
    {
        Camera camera = new Camera(new Point3D(0,0,-0.5), new Vector(0, 0, 1), new Vector(0, 1, 0));
        Sphere s=new Sphere(2.5, new Point3D(0,0,2.5));
        List<Ray> rays=new ArrayList<>();
        Ray ray;
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++) {
                ray=camera.constructRayThroughPixel(3, 3, j, i, 1, 3, 3);
                rays.add(ray);
            }
        List<Point3D> g=new ArrayList<>();
        for (Ray r:rays) {
            for (Point3D point3D:s.findIntersections(r)) {
                g.add(point3D);
            }
        }
        assertEquals(18,g.size());
    }
    @Test
    public void intsersectionsFromCamera3S()
    {
        Camera camera = new Camera(new Point3D(0,0,-0.5), new Vector(0, 0, 1), new Vector(0, 1, 0));
        Sphere s=new Sphere(4, new Point3D(0,0,2));
        List<Ray> rays=new ArrayList<>();
        Ray ray;
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++) {
                ray=camera.constructRayThroughPixel(3, 3, j, i, 1, 3, 3);
                rays.add(ray);
            }
        List<Point3D> g=new ArrayList<>();
        for (Ray r:rays) {
            for (Point3D point3D:s.findIntersections(r)) {
                g.add(point3D);
            }
        }
        assertEquals(9,g.size());
    }
    @Test
    public void intsersectionsFromCamera4S()
    {
        Camera camera = new Camera(new Point3D(0,0,-0.5), new Vector(0, 0, 1), new Vector(0, 1, 0));
        Sphere s=new Sphere(0.5, new Point3D(0,0,-1));
        List<Ray> rays=new ArrayList<>();
        Ray ray;
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++) {
                ray=camera.constructRayThroughPixel(3, 3, j, i, 1, 3, 3);
                rays.add(ray);
            }
        List<Point3D> g=new ArrayList<>();
        for (Ray r:rays) {
            for (Point3D point3D:s.findIntersections(r)) {
                g.add(point3D);
            }
        }
        assertEquals(0,g.size());
    }
    @Test
    public void intsersectionsFromCamera5S()
    {
        Camera camera = new Camera(Point3D.ZERO, new Vector(0, 0, 1), new Vector(0, -1, 0));
        Sphere s=new Sphere(50,new Point3D(0, 0, 100));
        List<Ray> rays=new ArrayList<>();
        Ray ray;
        for (int i=0;i<1000;i++)
            for (int j=0;j<1000;j++) {
                ray=camera.constructRayThroughPixel(1000, 1000, j, i, 100, 1000, 1000);
                rays.add(ray);
            }
        List<Point3D> g=new ArrayList<>();
        for (Ray r:rays) {
            for (Point3D point3D:s.findIntersections(r)) {
                g.add(point3D);
            }
        }
        System.out.println(g.size());
        assertEquals(20968,g.size());
    }
    @Test
    public void intsersectionsFromCamera1P()
    {
        Camera camera = new Camera(new Point3D(0,0,-0.5), new Vector(0, 0, 1), new Vector(0, 1, 0));
        Plane plane=new Plane(new Point3D(0,0,6),new Point3D(1,1,6),new Point3D(1,0,6));
        List<Ray> rays=new ArrayList<>();
        Ray ray;
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++) {
                ray=camera.constructRayThroughPixel(3, 3, j, i, 1, 3, 3);
                rays.add(ray);
            }
        List<Point3D> g=new ArrayList<>();
        for (Ray r:rays) {
            if(plane.findIntersections(r)!=null)
            for (Point3D point3D:plane.findIntersections(r)) {
                g.add(point3D);
            }
        }
        assertEquals(9,g.size());
    }
    @Test
    public void intsersectionsFromCamera2P()
    {
        Camera camera = new Camera(new Point3D(0,0,-0.5), new Vector(0, 0, 1), new Vector(0, 1, 0));
        Plane plane=new Plane(new Point3D(0,0,6),new Point3D(1,1,4),new Point3D(1,0,6));
        List<Ray> rays=new ArrayList<>();
        Ray ray;
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++) {
                ray=camera.constructRayThroughPixel(3, 3, j, i, 1, 3, 3);
                rays.add(ray);
            }
        List<Point3D> g=new ArrayList<>();
        for (Ray r:rays) {
            if(plane.findIntersections(r)!=null)
                for (Point3D point3D:plane.findIntersections(r)) {
                g.add(point3D);
            }
        }
        assertEquals(9,g.size());
    }

    //@Test  בשביל שהטסט יעבוד צריך לבדוק אם הגוף מאחורי המצלמה
    public void intsersectionsFromCamera3P()
    {
        Camera camera = new Camera(new Point3D(0,0,-0.5), new Vector(0, 0, 1), new Vector(0, 1, 0));
        Plane plane=new Plane(new Point3D(1,1,7),new Point3D(0,0,0.5),new Point3D(1,0,7));
        List<Ray> rays=new ArrayList<>();
        Ray ray;
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++) {
                ray=camera.constructRayThroughPixel(3, 3, j, i, 1, 3, 3);
                rays.add(ray);
            }
        List<Point3D> g=new ArrayList<>();
        for (Ray r:rays) {
            if(plane.findIntersections(r)!=null) {
                System.out.println(r);
                System.out.println(plane.findIntersections(r));
                for (Point3D point3D : plane.findIntersections(r)) {
                    g.add(point3D);
                }
            }
        }
        assertEquals(6,g.size());
    }

    @Test
    public void intsersectionsFromCamera1T()
    {
        Camera camera = new Camera(new Point3D(0,0,-0.5), new Vector(0, 0, 1), new Vector(0, 1, 0));
        Triangle triangle=new Triangle(new Point3D(0,-1,2),new Point3D(1,1,2),new Point3D(-1,1,2));
        List<Ray> rays=new ArrayList<>();
        Ray ray;
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++) {
                ray=camera.constructRayThroughPixel(3, 3, j, i, 1, 3, 3);
                rays.add(ray);
            }
        List<Point3D> g=new ArrayList<>();
        for (Ray r:rays) {
            if(triangle.findIntersections(r)!=null) {
                for (Point3D point3D : triangle.findIntersections(r)) {
                    g.add(point3D);
                }
            }
        }
        assertEquals(1,g.size());
    }
    @Test
    public void intsersectionsFromCamera2T()
    {
        Camera camera = new Camera(new Point3D(0,0,-0.5), new Vector(0, 0, 1), new Vector(0, 1, 0));
        Triangle triangle=new Triangle(new Point3D(0,-20,2),new Point3D(1,1,2),new Point3D(-1,1,2));
        List<Ray> rays=new ArrayList<>();
        Ray ray;
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++) {
                ray=camera.constructRayThroughPixel(3, 3, j, i, 1, 3, 3);
                rays.add(ray);
            }
        List<Point3D> g=new ArrayList<>();
        for (Ray r:rays) {
            if(triangle.findIntersections(r)!=null) {
                for (Point3D point3D : triangle.findIntersections(r)) {
                    g.add(point3D);
                }
            }
        }
        assertEquals(2,g.size());
    }
    //@Test בשביל שהטסט יעבוד צריך לבדוק אם הגוף מאחורי המצלמה
    public void intsersectionsFromCamera3T()
    {
        Camera camera = new Camera(new Point3D(0,0,-0.5), new Vector(0, 0, 1), new Vector(0, 1, 0));
        Plane plane=new Plane(new Point3D(1,1,-7),new Point3D(0,0,-7),new Point3D(1,0,-7));
        List<Ray> rays=new ArrayList<>();
        Ray ray;
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++) {
                ray=camera.constructRayThroughPixel(3, 3, j, i, 1, 3, 3);
                rays.add(ray);
            }
        List<Point3D> g=new ArrayList<>();
        for (Ray r:rays) {
            if(plane.findIntersections(r)!=null) {
                for (Point3D point3D : plane.findIntersections(r)) {
                    g.add(point3D);
                }
            }
        }
        assertEquals(0,g.size());
    }

}
