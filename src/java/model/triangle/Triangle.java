
package model.triangle;

/**
 *
 * @author Jamie
 */
public class Triangle {
    private int x;
    private int y;
    private int z;
    
    public Triangle(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public String evalTriangle() {
        if (!checkTriangle()) {
            return "Non-";
        }
        if ( (x == y) & (y == z) & (x == z) ) {
            return "Equilateral";
        }
        if ( (x == y) || (y == z) || (x == z) ) {
            return "Isosceles";
        }
        return "Scalene";
    }
    
    public boolean checkTriangle() {
        if ( (x+y <= z) || (y+z <= x) || (x+z <= y) ) {
            return false;
        }
        return true;
    }
}
