package unittests;

import geometries.Tube;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.assertEquals;

public class TubeTests {
    @Test
    public void testNormal()
    {
        Tube tube=new Tube(new Ray(new Point3D(0,0,0), new Vector(1,0,0)),1);
        /**
         * chek if get nurmal know if the point is ok (here is not ok)
         * */
        assertEquals(tube.getNormal(new Point3D(1,1,1)),new Vector(1,1,1));
        /**
         * chek if get nurmal know if the point is ok (here is ok)
         * */
        assertEquals(tube.getNormal(new Point3D(1,0,1)),new Vector(new Point3D(1,0,1).subtract(new Point3D(1,1,0))));
    }
}
