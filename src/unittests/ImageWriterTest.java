package unittests;
import geometries.Cylinder;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import renderer.ImageWriter;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ImageWriterTest {
    @Test
    public void simpleImage()
    {
        ImageWriter imageWriter=new ImageWriter("image1",1000,1600,10,16);
        imageWriter.writeToImage();
    }
}
