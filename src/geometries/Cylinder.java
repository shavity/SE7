package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * Class Cylinder is representing a cylinder on three-dimensional plane for
 * cartesian coordinate
 */

public class Cylinder extends Tube
{
    private double len;

    /**
     * Cylinder constructor Ray and two doubles
     * @param c Ray of direction and place (the center of it)
     * @param l length of cylinder
     * @param r radius of cylinder
     */

    public Cylinder (Ray c,double l, double r)
    {
        super(c, r);
        this.len = l;
    }

    /**
     * Cylinder's length getter
     * @return length of cylinder
     */

    public double getLen()
    {
        return len;
    }

    @Override
    public Vector getNormal(Point3D p)
    {
        /**
         * בעיקון לא צריך לעשות בדיקה שהנקודה תקינה
         *מסובך מדי נשלים בהמשך
         *  */
        return null;
    }
}
