package unittests.TsatNotImpor;

import geometries.Cylinder;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CylinderTests
{
    /*Coordinate xp = new Coordinate(1);
    Coordinate yp = new Coordinate(2);
    Coordinate zp = new Coordinate(3);
    Coordinate xv = new Coordinate(4);
    Coordinate yv = new Coordinate(5);
    Coordinate zv = new Coordinate(6);

    Point_3D p = new Point_3D(xp, yp, zp);
    Vector v = new Vector(xv, yv, zv);

    Ray direction = new Ray(v, p);

    double len = 7;
    double radius = 8;

    Cylinder cylinder = new Cylinder(direction, len, radius);*/
    @Test
    public void tesGetLen() {
        Cylinder cylinder = new Cylinder(new Ray(new Point3D(1,1,1), new Vector(2,3,4)),10,1);
        assertEquals(cylinder.getLen(),10);
    }
    @Test
    public void testNormal()
    {
        Cylinder cylinder=new Cylinder(new Ray(new Point3D(0,0,0), new Vector(1,0,0)),10,1);
        /**
         * chek if get nurmal know if the point is ok (here is not ok)
         * */
        assertEquals(cylinder.getNormal(new Point3D(1,1,1)),new Vector(1,1,1));
        /**
         * chek if get nurmal know if the point is ok (here is ok)
         * */
        assertEquals(cylinder.getNormal(new Point3D(1,0,1)),new Vector(new Point3D(1,0,1).subtract(new Point3D(1,1,0))));
    }
}
