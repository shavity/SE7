package unittests.TsatNotImpor;

import geometries.Intersectable;

import geometries.Intersectable.GeoPoint;
import geometries.Sphere;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SphereTests {
    @Test
    public void testNormal() {
        Sphere sphere = new Sphere(10, new Point3D(0, 0, 0));
        /**
         * chek if get nurmal know if the point is ok (here is not ok)
         * */
        //assertEquals(sphere.getNormal(new Point_3D(1, 1, 1)), new Vector(1, 1, 1));
        /**
         * chek if get nurmal know if the point is ok (here is ok)
         * */
        assertEquals(sphere.getNormal(new Point3D(10, 0, 0)), new Vector(new Point3D(10, 0, 0).subtract(new Point3D(0, 0, 0))));
    }
    @Test
    public void testFindIntsersections1()
    {
        Sphere sphere=new Sphere(1, new Point3D(0,0,3));
        Ray ray=new Ray(new Point3D(0,0,0), new Vector(0,0,1));
        ArrayList<Point3D> arrayList = new ArrayList<>();
        arrayList.add(new Point3D(0,0,2));
        arrayList.add(new Point3D(0,0,4));
        assertEquals(sphere.findIntersections(ray),arrayList);
    }

    @Test
    public void testFindIntsersections2() {
        Sphere s=new Sphere(10, new Point3D(20,20,0));
        Ray ray=new Ray(new Point3D(0,0,0), new Vector(1,1,0));
        List<GeoPoint> g=s.findIntersections(ray);
        if(g.isEmpty())
            System.out.println("is empty!");

        System.out.println(g.get(0));
        System.out.println(g.get(1));

        assertEquals(12.93,g.get(0).point.getX().get(),0.01);
        assertEquals(27.07,g.get(1).point.getX().get(),0.01);
    }

    @Test
    public void testFindIntsersections3() {
        Sphere s=new Sphere(10, new Point3D(0,0,0));
        Ray ray=new Ray(new Point3D(0,0,0), new Vector(1,1,0));
        List<GeoPoint> g=s.findIntersections(ray);
        if(g.isEmpty())
            System.out.println("is empty!");

        System.out.println(g.get(0));

        assertEquals(7.07,g.get(0).point.getX().get(),0.01);
    }

    @Test
    public void testFindIntsersections4() {
        Sphere s=new Sphere(10, new Point3D(20,20,0));
        Ray ray=new Ray(new Point3D(0,0,0), new Vector(10,1,0));
        List<GeoPoint> g;
        if(s.findIntersections(ray)!=null)
            g=s.findIntersections(ray);
        else
            g=new ArrayList<>();
        String a = new String();
        if(g.isEmpty()) {
            a = new String("is empty!");
        }

        assertEquals(a,"is empty!");
    }
    @Test
    public void testFindIntsersections5() {
        Sphere sphere = new Sphere(1d, new Point3D(1, 0, 0));
        // ============ Equivalence Partitions Tests ==============
        // TC01: Ray's line is outside the sphere (0 points)
        assertEquals("Ray's line out of sphere", new ArrayList<Point3D>(), sphere.findIntersections(new Ray(new Point3D(-1, 0, 0), new Vector(1, 1, 0))));
        // TC02: Ray starts before and crosses the sphere (2 points)
        Point3D p1 = new Point3D(0.0651530771650466, 0.355051025721682, 0);
        Point3D p2 = new Point3D(1.53484692283495, 0.844948974278318, 0);
        List<GeoPoint> result = sphere.findIntersections(new Ray(new Point3D(-1, 0, 0), new Vector(3, 1, 0)));
        assertEquals("Wrong number of points", 2, result.size());
        if (result.get(0).point.getX().get() > result.get(1).point.getX().get())
            result = List.of(result.get(1), result.get(0));
        assertEquals("Ray crosses sphere", List.of(p1, p2), result);
    }

}