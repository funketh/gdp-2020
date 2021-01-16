import java.lang.Math;
import gdp.stdlib.StdDraw;

/**
 * contains static methods for drawing a pythagoras tree up to a certain depth
 *
 * @author Alec Dücker
 * @author Theo Funke
 * @author Mark Shafranov
 * @version 1.0
 */
public class PythagorasTree {

    /**
     * defines scale of canvas and calls recursive function drawTree
     *
     * @param args command line arguments containing recursion depth
     */
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        drawTree(n, 45, 0, 10, 0);
    }

    /**
     * recursive function which draws pythagoras tree depth first
     *
     * @param recursionDepth
     * @param startPointX
     * @param startPointY
     * @param length
     * @param angle
     */
    public static void drawTree(int recursionDepth, double startPointX, double startPointY, double length,
            double angle) {
        // define points for square via rotation around bottom left corner
        double[] bottomLeft = { startPointX, startPointY };
        double[] bottomRight = rotate(bottomLeft, new double[] { startPointX + length, startPointY }, angle);
        double[] topRight = rotate(bottomLeft, new double[] { startPointX + length, startPointY + length }, angle);
        double[] topLeft = rotate(bottomLeft, new double[] { startPointX, startPointY + length }, angle);

        // draw edges of square
        StdDraw.line(bottomLeft[0], bottomLeft[1], bottomRight[0], bottomRight[1]);
        StdDraw.line(bottomRight[0], bottomRight[1], topRight[0], topRight[1]);
        StdDraw.line(topRight[0], topRight[1], topLeft[0], topLeft[1]);
        StdDraw.line(topLeft[0], topLeft[1], bottomLeft[0], bottomLeft[1]);

        // end recursion
        if (recursionDepth == 0) {
            return;
        }

        // generates random angle between 30° and 60°
        double alpha = Math.toRadians(Math.random() * (60 - 30) + 30);

        // calculate length of first edge of triangle
        length = length * Math.cos(alpha);

        // define top corner of triangle
        double[] triangleTop = rotate(topLeft,
                new double[] { topLeft[0] + Math.cos(alpha) * length, topLeft[1] + Math.sin(alpha) * length }, angle);

        // draw edges of triangle
        StdDraw.line(topLeft[0], topLeft[1], triangleTop[0], triangleTop[1]);
        StdDraw.line(triangleTop[0], triangleTop[1], topRight[0], topRight[1]);

        recursionDepth -= 1;

        // recursively draws left side of tree
        drawTree(recursionDepth, topLeft[0], topLeft[1], length, angle + alpha);

        // calculate length of second edge of triangle
        length = length * Math.tan(alpha);

        // recursively draws right side of tree
        drawTree(recursionDepth, triangleTop[0], triangleTop[1], length, angle - (Math.toRadians(90) - alpha));
    }

    /**
     * rotates rotationPoint around rotationCentre by angle and returns rotated
     * rotationPoint
     *
     * @param rotationCentre point to rotate around, array of two doubles
     * @param rotationPoint  point to rotate, array of two doubles
     * @param angle          rotation angle, angle in radians
     * @return rotationPoint after it has been rotated
     */
    public static double[] rotate(double[] rotationCentre, double[] rotationPoint, double angle) {
        // shift point so that it rotates around origin
        rotationPoint = new double[] { rotationPoint[0] - rotationCentre[0], rotationPoint[1] - rotationCentre[1] };
        // rotate point
        rotationPoint = new double[] { rotationPoint[0] * Math.cos(angle) - rotationPoint[1] * Math.sin(angle),
                rotationPoint[0] * Math.sin(angle) + rotationPoint[1] * Math.cos(angle) };
        // shift back
        rotationPoint = new double[] { rotationPoint[0] + rotationCentre[0], rotationPoint[1] + rotationCentre[1] };

        return rotationPoint;
    }
}
