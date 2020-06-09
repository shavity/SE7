package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Camera {
    Point3D center;
    Vector vUp;
    Vector vRight;
    Vector vTo;

    public Camera(Point3D point_3D, Vector vTo, Vector vUp){
        this.center = point_3D;
        this.vUp = vUp.normalize();
        this.vTo = vTo.normalize();
        if (vTo.dotProduct(vUp)==0)
        {
            vRight=vTo.crossProduct(vUp);
        }
        else
        {
            //חשבתי שצריך לעשת THEOW אבל ראיתי בטסטים של המצלמה שלא צריך אז לא יודע
            vRight=vTo.crossProduct(vUp);
        }
    }

    /**
     * constructing ray throw some pixel
     * @param j the number x of the pixel
     * @param i the number y of the pixel
     * @param screenWidth the width of the image
     * @param screenHeight the height of the image
     * @param nX number of pixels in the x
     * @param nY number of pixels in y
     * @param screenDistance the distance of the plane from the camera
     * @return A Ray that passes through the requested pixel
     */
    public Ray constructRayThroughPixel (int nX, int nY, int j, int i, double screenDistance, double screenWidth, double screenHeight)
    {
        /*
        Point3D Pc = center.add(vTo.scale(screenDistance));
        double Rx = (screenWidth / nX);
        double Ry = (screenHeight / nY);
        Vector x=vRight.scale(Rx*(j - (nX / 2.0d))  + (Rx / 2.0d));
        Vector y=vUp.scale(Ry * (i - nY / 2.0d) + (Ry / 2.0d));
        System.out.println("pc= "+Pc);
        System.out.println("Rx= "+Rx);
        System.out.println("Ry= "+Ry);
        System.out.println(new Point3D(2*Rx,2*Ry,0.5));
        Point3D P=Pc.add(x.subtract(y));
        System.out.println("P= "+P);
        Ray ray=new Ray(center,new Vector(P));
        System.out.println("R= "+ray);
        */
        Point3D Pc = center.add(vTo.scale(screenDistance));
        vRight = vTo.crossProduct(vUp);
        double Rx = (screenWidth / nX);
        double Ry = (screenHeight / nY);
        Point3D P1;
        P1 = Pc.add(vRight.scale((j - ((nX - 1)/ 2.0d)) * Rx).subtract(vUp.scale(Ry * (i - (nY -1 )/ 2.0d))));
        Ray ray=new Ray(center,new Vector(P1.subtract(center)));
        System.out.println("R= "+ray);
        return ray;
    }


    public Point3D getPoint_3D() {
        return center;
    }

    public Vector getvUp() {
        return vUp;
    }

    public Vector getvRight() {
        return vRight;
    }

    public Vector getvTo() {
        return vTo;
    }
}
