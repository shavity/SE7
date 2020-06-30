package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.List;
import java.util.Objects;

/**
 * interface intersecable is the basic of operation to get point on shape where its cut by a line (Ray type)
 */

public interface Intersectable {



    /**
     *
     * @param ray line that cut a shape
     * @return list of Point_3D value, where the line meets the shape
     */
    List<GeoPoint> findIntersections(Ray ray);



    public static class GeoPoint {
        public Geometry geometry;
        public Point3D point;

        public GeoPoint(Geometry geometry, Point3D point) {
            this.geometry = geometry;
            this.point = point;
        }
        //לא בטוח שככה עושים לא סגור על זה
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GeoPoint geoPoint = (GeoPoint) o;
            return Objects.equals(geometry, geoPoint.geometry) && Objects.equals(point, geoPoint.point);
        }
    }

}
