package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Cylinder extends Tube
{
    private double len;

    public Cylinder (Ray c,double l, double r)
    {
        super(c, r);
        this.len = l;
    }

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
