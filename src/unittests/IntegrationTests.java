package unittests;

import elements.Camera;
import geometries.Plane;
import geometries.Sphere;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IntegrationTests {
    @Test
    public void intsersectionsFromCamera1S()
    {
        Camera camera = new Camera(Point3D.ZERO, new Vector(0, 0, 1), new Vector(0, 1, 0));
        Sphere s=new Sphere(new Point3D(0,0,3),1);
        List<Ray> ray=new ArrayList<>();
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++) {
                ray.add(camera.constructRayThroughPixel(3, 3, j, i, 1, 3, 3));
            }
        List<Point3D> g=new ArrayList<>();
        for (Ray r:ray) {
            for (Point3D point3D:s.findIntsersections(r)) {
                g.add(point3D);
            }
        }
        assertEquals(2,g.size());
    }
    @Test
    public void intsersectionsFromCamera2S()
    {
        Camera camera = new Camera(new Point3D(0,0,-0.5), new Vector(0, 0, 1), new Vector(0, 1, 0));
        Sphere s=new Sphere(new Point3D(0,0,2.5),2.5);
        List<Ray> rays=new ArrayList<>();
        Ray ray;
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++) {
                ray=camera.constructRayThroughPixel(3, 3, j, i, 1, 3, 3);
                rays.add(ray);
            }
        List<Point3D> g=new ArrayList<>();
        for (Ray r:rays) {
            for (Point3D point3D:s.findIntsersections(r)) {
                g.add(point3D);
            }
        }
        assertEquals(18,g.size());
    }
    @Test
    public void intsersectionsFromCamera3S()
    {
        Camera camera = new Camera(new Point3D(0,0,-0.5), new Vector(0, 0, 1), new Vector(0, 1, 0));
        Sphere s=new Sphere(new Point3D(0,0,2),4);
        List<Ray> rays=new ArrayList<>();
        Ray ray;
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++) {
                ray=camera.constructRayThroughPixel(3, 3, j, i, 1, 3, 3);
                rays.add(ray);
            }
        List<Point3D> g=new ArrayList<>();
        for (Ray r:rays) {
            for (Point3D point3D:s.findIntsersections(r)) {
                g.add(point3D);
            }
        }
        assertEquals(9,g.size());
    }
    @Test
    public void intsersectionsFromCamera4S()
    {
        Camera camera = new Camera(new Point3D(0,0,-0.5), new Vector(0, 0, 1), new Vector(0, 1, 0));
        Sphere s=new Sphere(new Point3D(0,0,-1),0.5);
        List<Ray> rays=new ArrayList<>();
        Ray ray;
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++) {
                ray=camera.constructRayThroughPixel(3, 3, j, i, 1, 3, 3);
                rays.add(ray);
            }
        List<Point3D> g=new ArrayList<>();
        for (Ray r:rays) {
            for (Point3D point3D:s.findIntsersections(r)) {
                g.add(point3D);
            }
        }
        assertEquals(0,g.size());
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
            if(plane.findIntsersections(r)!=null)
            for (Point3D point3D:plane.findIntsersections(r)) {
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
            if(plane.findIntsersections(r)!=null)
                for (Point3D point3D:plane.findIntsersections(r)) {
                g.add(point3D);
            }
        }
        assertEquals(9,g.size());
    }
    @Test
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
            if(plane.findIntsersections(r)!=null) {
                System.out.println(r);
                System.out.println(plane.findIntsersections(r));
                for (Point3D point3D : plane.findIntsersections(r)) {
                    g.add(point3D);
                }
            }
        }
        assertEquals(6,g.size());
    }
    @Test
    public void intsersectionsFromCamera4P()//לא עובד
    {
        Camera camera = new Camera(new Point3D(0,0,-0.5), new Vector(0, 0, 1), new Vector(0, 1, 0));
        Plane plane=new Plane(new Point3D(0,1,2),new Point3D(0,0,0.5),new Point3D(0,2,2));
        List<Ray> rays=new ArrayList<>();
        Ray ray;
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++) {
                ray=camera.constructRayThroughPixel(3, 3, j, i, 1, 3, 3);
                rays.add(ray);
            }
        List<Point3D> g=new ArrayList<>();
        for (Ray r:rays) {
            if(plane.findIntsersections(r)!=null) {
                System.out.println(r);
                System.out.println(plane.findIntsersections(r));
                for (Point3D point3D : plane.findIntsersections(r)) {
                    g.add(point3D);
                }
            }
        }
        assertEquals(6,g.size());
    }
    @Test
    public void intsersectionsFromCamera5P()//לא עובד
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
            if(plane.findIntsersections(r)!=null) {
                System.out.println(r);
                System.out.println(plane.findIntsersections(r));
                for (Point3D point3D : plane.findIntsersections(r)) {
                    g.add(point3D);
                }
            }
        }
        assertEquals(6,g.size());
    }
}
