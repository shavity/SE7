package unittests.TsatNotImpor;

import geometries.Intersectable.GeoPoint;
import geometries.Triangle;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class TriangleTests {
    @Test
    public void testNormal() {
        Triangle triangle = new Triangle(new Point3D(1, 0, 0), new Point3D(0, 1, 0), new Point3D(-1, 0, 0));
        /**
         * chek if get nurmal know if the point is ok (here is not ok)
         * */
        //assertEquals(triangle.getNormal(new Point_3D(1, 1, 1)), new Vector(1, 1, 1));
        /**
         * chek if get nurmal know if the point is ok (here is ok)
         * */
        assertEquals(triangle.getNormal(new Point3D(0, 0, 0)), new Vector(0, 0, 1));
    }

    @Test
    public void findIntersections1() {
        Point3D x = new Point3D(-100, -100, -200);
        Point3D y = new Point3D(100, -100, -200);
        Point3D z = new Point3D(0, 100, -200);
        Triangle t = new Triangle(x, y, z);
        Vector v = new Vector(0, -1, -3);
        Point3D point3D = new Point3D(0, 0, 0);
        Point3D point = t.findIntersections(new Ray(point3D, v)).get(0).point;
        assertEquals(-66.6666, point.getY().get(), 0.01);
    }

    @Test
    public void findIntersections2() {
        Point3D x = new Point3D(10, 10, 50);
        Point3D y = new Point3D(20, 50, -20);
        Point3D z = new Point3D(30, 40, -10);
        Triangle t = new Triangle(x, y, z);
        Vector v = new Vector(1, 5, 0);
        Point3D point3D = new Point3D(0, 0, 0);
        List<GeoPoint> g = t.findIntersections(new Ray(point3D, v));

        boolean flag = false;
        if (g==null)
            flag = true;

        assertEquals(flag, true);
    }

    @Test
    public void findIntersections3() {
        Point3D x = new Point3D(0, 1, -2);
        Point3D y = new Point3D(-1, -1, -2);
        Point3D z = new Point3D(1, -1, -2);
        Triangle t = new Triangle(x, y, z);
        List<GeoPoint> g = t.findIntersections(new Ray(Point3D.ZERO, new Vector(1, 0, 0)));
        boolean flag = true;
        if (g==null)
            flag = false;

        assertEquals(flag, false);
    }
   @Test
    public void findIntersections4() {
        Point3D x = new Point3D(0, 1, 2);
        Point3D y = new Point3D(-1, -1, 2);
        Point3D z = new Point3D(1, -1, 2);
        Triangle t = new Triangle(x, y, z);
        List<GeoPoint> g = t.findIntersections(new Ray(Point3D.ZERO, new Vector(0, 0, -1)));
        boolean flag = true;
        if (g.get(0).point.getZ().get()==2)
            flag = false;

        assertEquals(flag,false);
    }

}
