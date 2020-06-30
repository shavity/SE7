package unittests.TsatNotImpor;
import geometries.Cylinder;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import renderer.ImageWriter;

import java.awt.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ImageWriterTest {
    @Test
    public void simpleImage()
    {
        ImageWriter imageWriter=new ImageWriter("image1",10,16,1000,1600);
        for (int i=0;i<1000;i++)
        {
            for (int j=0;j<1600;j++)
            {
                if(i%40==0||j%40==0)
                {
                    imageWriter.writePixel(i,j,new Color(0,0,0));
                }
                else
                {
                    imageWriter.writePixel(i,j,new Color(0,0,255));
                }
            }

        }
        imageWriter.writeToImage();
    }
}
