package unittests;

import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.Assert.assertEquals;


public class VectorTests {
    @Test
    public void add() {
        Vector v1 = new Vector(new Point3D(1.0,2.0,4));
        Vector v2 = new Vector(new Point3D(0.0,3,2.0));
        Vector v3 = new Vector(v1.add(v2));
        assertEquals("Vector{v=1.0, 5.0, 6.0}",v3.toString());
    }

    @Test
    public void subtract(){

        Vector v1 = new Vector(new Point3D(1.0,2.0,4));
        Vector v2 = new Vector(new Point3D(0.0,3,2.0));
        assertEquals("Vector{v=1.0, -1.0, 2.0}",v1.subtract(v2).toString());

    }

    @Test
    public void scale() {
        Vector v1 = new Vector(new Point3D(1.0,2.0,4));
        v1.scale(5);
        assertEquals("Vector{v=5.0, 10.0, 20.0}",v1.toString());

    }

    @Test
    public void dotProduct() {
        Vector v1 = new Vector(new Point3D(1.0,0.0,0.0));
        Vector v2 = new Vector(new Point3D(0.0,1.0,0.0) );
        double result=v1.dotProduct(v2);
        assertEquals(0.0,result);
        v1 = new Vector(new Point3D(1.0,2.0,4.0));
        v2 = new Vector(new Point3D(2.0,4.0,8.0));
        result = v1.dotProduct(v2);
        assertEquals(42.0,result);
        v1 = new Vector(new Point3D(2.0,2.0,3.0));
        v2 = new Vector(new Point3D(1.0,2.0,3.0));
        result = v1.dotProduct(v2);
        assertEquals(15.0,result);
        v1 = new Vector(new Point3D(1.0,2.0,3.0));
        v2 = new Vector(new Point3D(-1.0,-2.0,-3.0));
        result = v1.dotProduct(v2);
        assertEquals(-14.0,result);
        v1 = new Vector(new Point3D(2.0,2.0,3.0));
        v2 = new Vector(new Point3D(-1.0,1.0,-3.0));
        result = v1.dotProduct(v2);
        assertEquals(-9.0,result);
    }

    @Test
    public void crossProduct() {
        Vector v1 = new Vector(new Point3D(1.0,0.0,0.0));
        Vector v2 = new Vector(new Point3D(0.0,1.0,0.0) );
        Vector v3 = v1.crossProduct(v2);
        v3.normalize();
        assertEquals("Vector{v=0.0, 0.0, 1.0}",v3.toString());
        v1 = new Vector(new Point3D(1.0,2.0,4.0));
        v2 = new Vector(new Point3D(2.0,4.0,8.0));

        v1 = new Vector(new Point3D(1.0,2.0,3.0));
        v2 = new Vector(new Point3D(-1.0,-2.0,-3.0));

        v1 = new Vector(new Point3D(2.0,2.0,3.0));
        v2 = new Vector(new Point3D(-1.0,2.0,-3.0));
        v3 = v1.crossProduct(v2);
        assertEquals("Vector{v=-12.0, 3.0, 6.0}",v3.toString());
        v1 = new Vector(new Point3D(2.0,2.0,3.0));
        v2 = new Vector(new Point3D(1.0,2.0,3.0));
        v3 = v1.crossProduct(v2);
        assertEquals("Vector{v=0.0, -3.0, 2.0}",v3.toString());
    }

    @Test
    public void length() {
        Vector v1 = new Vector(new Point3D(1.0,0.0,0.0));
        assertEquals(1.0,v1.length());
        Vector v2 = new Vector(new Point3D(1,2,3));
        assertEquals(Math.sqrt(14),v2.length());
    }

    @Test
    public void testNormalize() {
        Vector v = new Vector(new Point3D(.5, -5, 10));
        v.normalize();
        assertEquals(1, v.length(), 1e-10);
    }
}
