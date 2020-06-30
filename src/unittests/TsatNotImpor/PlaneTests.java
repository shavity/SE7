package unittests.TsatNotImpor;

import geometries.Plane;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PlaneTests {

    @Test
    public void testNormal()
    {
        //check if get nurmal give the vector (because he was מנורמל)
        Plane testPlane = new Plane(new Vector(1, -2, 4), new Point3D(0, 4, -1));
        assertEquals(testPlane.getNormal(new Point3D(0, 4, -1)), new Vector(1, -2, 4).normalize());
    }
    @Test
    public void testFindIntsersections1()
    {
        Plane plane = new Plane(new Vector(1,0,0),new Point3D(1,0,0));
        Ray ray=new Ray(new Point3D(0,0,0), new Vector(1,0,0));
        ArrayList<Point3D> arrayList=new ArrayList<>();
        arrayList.add(new Point3D(1,0,0));
        assertEquals(plane.findIntersections(ray),arrayList);
    }

    @Test
    public void testFindIntsersections2()
    {
        Plane plane = new Plane(new Vector(1,1,0),new Point3D(1,0,0));
        Ray ray=new Ray(new Point3D(0,0,0), new Vector(1,1,0));
        ArrayList<Point3D> arrayList=new ArrayList<>();
        arrayList.add(new Point3D(0.5,0.5,0));
        assertEquals(plane.findIntersections(ray),arrayList);
    }
}

