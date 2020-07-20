package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import primitives.Util;

/**
 * class Camera is representing a tool to get a view from
 */

public class Camera {

    // should they by private all the next attributes???

    Point3D center;
    Vector vUp;
    Vector vRight;
    Vector vTo;

    /**
     * Camera constructor
     * @param point_3D to value Camera.center point of camera
     * @param vTo to value Camera.vTo & Camera.vRight, vTo - vector toward of camera
     * @param vUp to value Camera.vUp & Camera.vRight, vUp - vector up of camera
     */

    public Camera(Point3D point_3D, Vector vTo, Vector vUp){
        this.center = point_3D;
        this.vUp = vUp.normalize();
        this.vTo = vTo.normalize();
        if (vTo.dotProduct(vUp) == 0)
        {
            vRight=vTo.crossProduct(vUp);
        }
        else
        {
            // throw new IllegalArgumentException("the vectors must be orthogonal");
            // חשבתי שצריך לעשת THEOW אבל ראיתי בטסטים של המצלמה שלא צריך אז לא יודע
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
        //System.out.println("R= "+ray);
        return ray;

        /*
        if (Util.isZero(screenDistance))
		{
			throw new IllegalArgumentException("distance cannot be 0");
		}

		Point3D Pc = new Point3D(_p0.add(_vTo.scale(screenDistance)));

		double Ry = screenHeight/nY;
		double Rx = screenWidth/nX;

		double yi =  ((i - nY/2d)*Ry + Ry/2);
		double xj=   ((j - nX/2d)*Rx + Rx/2);

		Point3D Pij = new Point3D(Pc);

		if (! Util.isZero(xj))
		{
			Pij = new Point3D(Pij.add(_vRight.scale(xj)));
		}
		if (! Util.isZero(yi))
		{
			Pij = new Point3D(Pij.add(_vUp.scale((-1) * yi)));
		}

		Vector Vij = new Vector(Pij.subtract(_p0));

		return new Ray(_p0,Vij);
         */
    }

    /**
     * Point_3D value getter
     * @return point of camera
     */

    public Point3D getPoint_3D() {
        return center;
    }

    /**
     * Vector value getter
     * @return up vector of camera
     */

    public Vector getvUp() {
        return vUp;
    }

    /**
     * Vector value getter
     * @return right vector of camera
     */

    public Vector getvRight() {
        return vRight;
    }

    /**
     * Vector value getter
     * @return toward vector of camera
     */

    public Vector getvTo() {
        return vTo;
    }
}
